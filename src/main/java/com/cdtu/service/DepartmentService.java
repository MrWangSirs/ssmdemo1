package com.cdtu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdtu.bean.Department;
import com.cdtu.dao.DepartmentMapper;

@Service
public class DepartmentService {

	@Autowired DepartmentMapper departmentMapper;
	
	
	/**
	 * 查询所有部门
	 * @return
	 */
	public List<Department> getDepart(){	
		return departmentMapper.selectByExample(null);
	}
}
