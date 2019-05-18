package com.yf.springboot.controller;

import com.yf.springboot.bean.Employee;
import com.yf.springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    //根据id查员工信息
    //浏览器输入示例：http://localhost:9000/emp/1
    @GetMapping("/emp/{id}")
    public Employee getEmp(@PathVariable("id")Integer id){
        return employeeService.getEmp(id);
    }

    //更新员工信息
    //浏览器输入示例：http://localhost:9000/emp/update?id=2&lastName=guoguo&gender=%E7%94%B7&email=982987892@qq.com&dId=2
    @GetMapping("/emp/update")
    public String updateEmp(@RequestParam("id") Integer id,@RequestParam("lastName") String lastName,
                            @RequestParam("gender") String gender,@RequestParam("email") String email,
                            @RequestParam("dId") Integer dId){
        employeeService.updateEmp(id,lastName,gender,email,dId);
        return "update的id是："+id;
    }

    //根据指定id删除员工信息
    //浏览器输入示例：http://localhost:9000/emp/delete/1
    @GetMapping("/emp/delete/{id}")
    public String deleteEmp(@PathVariable Integer id){
        employeeService.deleteEmp(id);
        return "delete的id是："+id;
    }

    //根据lastName查员工信息
    //浏览器输入示例：http://localhost:9000/empName/fan
    @GetMapping("/empName/{lastName}")
    public Employee getByLastName(@PathVariable String lastName){
        Employee emp = employeeService.getEmpByLastName(lastName);
        return emp;
    }

    //插入员工信息
    //浏览器输入示例：http://localhost:9000/emp/insert?id=3&lastName=zhu&gender=%E7%94%B7&email=763756735@qq.com&dId=3
    @GetMapping("/emp/insert")
    public String insertEmp(@RequestParam("id") Integer id,@RequestParam("lastName") String lastName,
                            @RequestParam("gender") String gender,@RequestParam("email") String email,
                            @RequestParam("dId") Integer dId){
        employeeService.insertEmp(id,lastName,gender,email,dId);
        return "insert的id是："+id+"insert的lastName是："+lastName+"insert的gender是："+gender
                +"insert的email是："+email+"insert的dId是："+dId;
    }

    //查询所有员工信息
    //浏览器输入示例： http://localhost:9000/findAll
    @GetMapping("/findAll")
    public List<Employee> findAll() {
        System.out.println("查询所有");
        List<Employee> employeeList = employeeService.findAll();
        for(Employee employee:employeeList) {
            System.out.println("用户："+employee);
        }
        return employeeList;
    }


}
