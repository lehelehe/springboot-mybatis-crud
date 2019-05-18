package com.yf.springboot;

import com.yf.springboot.bean.Employee;
import com.yf.springboot.mapper.EmployeeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot01CacheApplicationTests {

    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    StringRedisTemplate stringRedisTemplate;//操作字符串【常用】

    @Autowired
    RedisTemplate redisTemplate;//操作k-v都是对象

    @Autowired
    RedisTemplate<Object, Employee> empRedisTemplate;

    //查询测试
    @Test
    public void contextLoads() {
        Employee emp = employeeMapper.getEmpById(1);
        System.out.println(emp);
    }

    //插入测试
    @Test
    public void insertLoads() {
        employeeMapper.insertEmp(2,"guo","男","8738637896@qq.com",2);
    }

    //查找全部员工信息测试
    @Test
    public void findAll() {
        List<Employee> employeeList=employeeMapper.findAll();
        System.out.println(employeeList);
    }

    //更新测试
    @Test
    public void update() {
       employeeMapper.updateEmp(2,"guoguo","男","8738637896@qq.com",2);
    }

    /**
     * redis的操作
     *
     */
    @Test
    public void test01(){
//        stringRedisTemplate.opsForValue().append("msg", "hello");
        String msg = stringRedisTemplate.opsForValue().get("msg");

        System.out.println(msg);
    }
    @Test
    public  void test02(){
        Employee emp = employeeMapper.getEmpById(2);
        empRedisTemplate.opsForValue().set("emp-01", emp);

    }



}
