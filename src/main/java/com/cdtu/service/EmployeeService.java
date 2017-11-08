package com.cdtu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cdtu.bean.Employee;
import com.cdtu.bean.EmployeeExample;
import com.cdtu.bean.EmployeeExample.Criteria;
import com.cdtu.dao.EmployeeMapper;



@Service
public class EmployeeService {

	@Autowired
	EmployeeMapper employeeMapper;
	
	public List<Employee> getAll( ) {
		// TODO Auto-generated method stub
		
		return employeeMapper.selectByExampleWithDept(null);
	}
	
	public List<Employee> getSome(Employee employee){
		return employeeMapper.selectByCountryQueryModel(employee);
	}
	
	public Boolean checkUser(String empname){
		// TODO Auto-generated method stub
		EmployeeExample example = new EmployeeExample();
		Criteria criteria = example.createCriteria();
		criteria.andEmpnameEqualTo(empname);
		long count = employeeMapper.countByExample(example);
		return count == 0;
	}

	public Employee getEmp(Integer id) {
		// TODO Auto-generated method stub
		return employeeMapper.selectByPrimaryKey(id);
	}

	public void updateEmp(Employee employee) {
		employeeMapper.updateByPrimaryKeySelective(employee);
		
	}

		public void deleteEmp(Integer id) {
		// TODO Auto-generated method stub
		employeeMapper.deleteByPrimaryKey(id);
	}

	public void deleteBatch(List<Integer> ids) {
		// TODO Auto-generated method stub
		EmployeeExample example = new EmployeeExample();
		Criteria criteria = example.createCriteria();
		//delete from xxx where emp_id in(1,2,3)
		criteria.andEmpidIn(ids);
		employeeMapper.deleteByExample(example);
	}
}
