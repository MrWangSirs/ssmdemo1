package com.cdtu.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cdtu.bean.Employee;
import com.cdtu.bean.Msg;
import com.cdtu.cache.GetCache;
import com.cdtu.service.EmployeeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

@Controller
public class EmployeeController {

	@Autowired EmployeeService employeeService;
	
	@ApiOperation(value = "��ѯÿҳ��Ϣ", notes = "��ѯ��Ϣ", httpMethod = "GET")
	@RequestMapping(value="/emps",method=RequestMethod.GET)
	public String getEmps(Employee employee,@RequestParam(value = "pn", defaultValue = "1") Integer pn,
			Model model){
		
	
		PageHelper.startPage(pn, 10);
		List<Employee> emps = employeeService.getSome(employee);
	
		@SuppressWarnings({ "rawtypes", "unchecked" })
		PageInfo page = new PageInfo(emps, 5);
	
		model.addAttribute("queryParam",employee);
		model.addAttribute("pageInfo", page);

		return "list";
		
	}
	
	/**
	 * ����jackson����
	 * @param pn
	 * @return
	 */
	@ApiIgnore
	@RequestMapping("/allemps")
	@ResponseBody
	@GetCache(name="allemps",value="pn")
	public Msg getEmpsWithJson(
			@RequestParam(value = "pn", defaultValue = "1") Integer pn,@RequestParam(value="empname",defaultValue="") String empname
			,@RequestParam(value="empemail",defaultValue="") String empemail,HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		Employee employee=new Employee();
		employee.setEmpname(empname);
		employee.setEmpemail(empemail);
		// �ⲻ��һ����ҳ��ѯ
		// ����PageHelper��ҳ���
		// �ڲ�ѯ֮ǰֻ��Ҫ���ã�����ҳ�룬�Լ�ÿҳ�Ĵ�С
		PageHelper.startPage(pn, 10);
		// startPage��������������ѯ����һ����ҳ��ѯ
		List<Employee> emps = employeeService.getSome(employee);
		// ʹ��pageInfo��װ��ѯ��Ľ����ֻ��Ҫ��pageInfo����ҳ������ˡ�
		// ��װ����ϸ�ķ�ҳ��Ϣ,���������ǲ�ѯ���������ݣ�����������ʾ��ҳ��
		@SuppressWarnings({ "rawtypes", "unchecked" })
		PageInfo page = new PageInfo(emps, 5);
		return Msg.success().add("pageInfo", page);
	}
	@ApiIgnore
	@RequestMapping("/checkuser")
	@ResponseBody
	public Msg checkuser(@RequestParam("empName")String empName){
		
		//���ж��û����Ƿ��ǺϷ��ı��ʽ;
				String regx = "(^[a-zA-Z0-9_-]{6,16}$)|(^[\u2E80-\u9FFF]{2,5})";
				if(!empName.matches(regx)){
					return Msg.fail().add("va_msg", "�û���������6-16λ���ֺ���ĸ����ϻ���2-5λ����");
				}
				
				//���ݿ��û����ظ�У��
				boolean b = employeeService.checkUser(empName);
				if(b){
					return Msg.success();
				}else{
					return Msg.fail().add("va_msg", "�û���������");
				}
				
		
		
	}
	@ApiOperation(value = "��ѯ�û���Ϣ", notes = "��ѯ�û�", httpMethod = "GET")
	@RequestMapping(value="/emp/{id}",method=RequestMethod.GET)
	@ResponseBody
	public Msg getEmp(@PathVariable("id") Integer id){
		Employee employee=employeeService.getEmp(id);
		
		return Msg.success().add("emp", employee);
	}
	
	
	/**
	 * ���ֱ�ӷ���ajax=PUT��ʽ������
	 * ��װ������
	 * Employee 
	 * [empId=1014, empName=null, gender=null, email=null, dId=null]
	 * 
	 * ���⣺
	 * �������������ݣ�
	 * ����Employee�����װ���ϣ�
	 * update tbl_emp  where emp_id = 1014;
	 * 
	 * ԭ��
	 * Tomcat��
	 * 		1�����������е����ݣ���װһ��map��
	 * 		2��request.getParameter("empName")�ͻ�����map��ȡֵ��
	 * 		3��SpringMVC��װPOJO�����ʱ��
	 * 				���POJO��ÿ�����Ե�ֵ��request.getParamter("email");
	 * AJAX����PUT����������Ѫ����
	 * 		PUT�����������е����ݣ�request.getParameter("empName")�ò���
	 * 		Tomcatһ����PUT�����װ�������е�����Ϊmap��ֻ��POST��ʽ������ŷ�װ������Ϊmap
	 * org.apache.catalina.connector.Request--parseParameters() (3111);
	 * 
	 * protected String parseBodyMethods = "POST";
	 * if( !getConnector().isParseBodyMethod(getMethod()) ) {
                success = true;
                return;
            }
	 * 
	 * 
	 * ���������
	 * ����Ҫ��֧��ֱ�ӷ���PUT֮�������Ҫ��װ�������е�����
	 * 1��������HttpPutFormContentFilter��
	 * 2���������ã����������е����ݽ�����װ��һ��map��
	 * 3��request�����°�װ��request.getParameter()����д���ͻ���Լ���װ��map��ȡ����
	 * Ա�����·���
	 * @param employee
	 * @return
	 */
	@ApiOperation(value = "�޸��û���Ϣ", notes = "�޸��û�", httpMethod = "PUT")
	@ResponseBody
	@RequestMapping(value="/emp/{empid}",method=RequestMethod.PUT)
	public Msg saveEmp(Employee employee,HttpServletRequest request){
		employeeService.updateEmp(employee);
		return Msg.success()	;
	}
	/**
	 * ������������һ
	 * ����ɾ����1-2-3
	 * ����ɾ����1
	 * 
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "ɾ���û���Ϣ", notes = "ɾ���û�", httpMethod = "DELETE")
	@ResponseBody
	@RequestMapping(value="/emp/{ids}",method=RequestMethod.DELETE)
	public Msg deleteEmp(@PathVariable("ids")String ids){
		//����ɾ��
		if(ids.contains("-")){
			List<Integer> del_ids = new ArrayList<>();
			String[] str_ids = ids.split("-");
			//��װid�ļ���
			for (String string : str_ids) {
				del_ids.add(Integer.parseInt(string));
			}
			employeeService.deleteBatch(del_ids);
		}else{
			Integer id = Integer.parseInt(ids);
			employeeService.deleteEmp(id);
		}
		return Msg.success();
	}
	/*
	 * ����
	 */
	@RequestMapping(value="/addemp",method=RequestMethod.POST)
	@ResponseBody 
	public Msg addemp(Employee employee){

		System.out.println(employee);
//		employeeService.addemp(employee);
		return  Msg.success();
	}
}
