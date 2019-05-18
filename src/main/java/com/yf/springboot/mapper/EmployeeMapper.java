package com.yf.springboot.mapper;


import com.yf.springboot.bean.Employee;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EmployeeMapper {

    @Select("SELECT * FROM employee WHERE id = #{id}")
    public Employee getEmpById(Integer id);

    @Update("UPDATE employee SET lastname=#{lastName},email=#{email},gender=#{gender},dId=#{dId} WHERE id=#{id}")
    public void updateEmp(@Param("id") Integer id,@Param("lastName")String lastName,@Param("gender")String gender,
                          @Param("email")String email,@Param("dId")Integer dId);

    @Delete("DELETE FROM employee WHERE employee.id=#{id}")
    public void deleteEmp(Integer id);

    @Select("SELECT * FROM employee WHERE lastname=#{lastName}")
    public Employee getEmpByLastName(String lastName);

    @Insert("INSERT INTO employee(id,lastName,gender,email,dId) VALUES (#{id},#{lastName},#{gender},#{email},#{dId})")
    public void  insertEmp(@Param("id") Integer id,@Param("lastName")String lastName,@Param("gender")String gender,
                           @Param("email")String email,@Param("dId")Integer dId);
    @Select("SELECT * FROM employee ")
    List<Employee> findAll();

}
