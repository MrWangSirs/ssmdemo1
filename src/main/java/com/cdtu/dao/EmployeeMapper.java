package com.cdtu.dao;

import com.cdtu.bean.Employee;
import com.cdtu.bean.EmployeeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EmployeeMapper {
    long countByExample(EmployeeExample example);

    int deleteByExample(EmployeeExample example);

    int deleteByPrimaryKey(Integer empid);

    int insert(Employee record);

    int insertSelective(Employee record);

    List<Employee> selectByCountryQueryModel(Employee employee);
     
    List<Employee> selectByExample(EmployeeExample example);

    Employee selectByPrimaryKey(Integer empid);
    
    List<Employee> selectByExampleWithDept(EmployeeExample example);

    Employee selectByPrimaryKeyWithDept(Integer empId);

    int updateByExampleSelective(@Param("record") Employee record, @Param("example") EmployeeExample example);

    int updateByExample(@Param("record") Employee record, @Param("example") EmployeeExample example);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);
}