package com.cdtu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cdtu.bean.Department;
import com.cdtu.bean.Msg;
import com.cdtu.service.DepartmentService;

import io.swagger.annotations.ApiOperation;

@Controller
public class DepartmentController {

	@Autowired DepartmentService departmentService;
	
	
	/**
	 * ��ѯ�����еĲ���
	 */
	@ApiOperation(value = "��ѯ���в���", notes = "��ѯ����", httpMethod = "GET")
	@RequestMapping(value="/alldepart",method=RequestMethod.GET)
	@ResponseBody
	public Msg getdepart(){
	List<Department> alldepart=departmentService.getDepart();		
	return Msg.success().add("alldepart", alldepart);
	}
	
	
}
