/*package com.cdtu.test;

import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cdtu.bean.Employee;
import com.cdtu.bean.EmployeeExample;
import com.cdtu.dao.DepartmentMapper;
import com.cdtu.dao.EmployeeMapper;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class MapperTest {
	
	@Autowired
	DepartmentMapper departmentMapper;
	
	@Autowired
	EmployeeMapper employeeMapper;
	
	@Autowired
	SqlSession sqlSession;
	
	*//**
	 * 
	 *//*
	@Test
	public void testCRUD(){

//		System.out.println(departmentMapper);
		

//		employeeMapper.insertSelective(new Employee("向宏宇", "543868043@qq.com", "成都市武侯区", 2));
		

		EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
		for(int i = 0;i<100000;i++){
			String uid = UUID.randomUUID().toString().substring(0,5)+i;
			mapper.insertSelective(new Employee(uid,uid+"@atguigu.com","成都市武侯区", 1));
		}
		System.out.println("插入完成");
		
		
//		System.out.println(employeeMapper.selectByExampleWithDept(new EmployeeExample()));
	}

}
*/