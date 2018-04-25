package com.ty.mapper;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ty.entities.Employee;
import com.ty.service.EmplyoeeService;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

public class EmployeeMapperTest {
	private ApplicationContext iocContext = new ClassPathXmlApplicationContext("applicationContext.xml");
	private EmplyoeeService employeeService = iocContext.getBean(EmplyoeeService.class);
	
	@Test
	public void testCustomerMapper(){
		System.out.println(employeeService.selectAll());
	}
	
	@Test
	public void updateBatch(){
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(new Employee(2, "ee",100.0 , 12));
		employees.add(new Employee(3, "qq", 100.0, 12));
		employeeService.updateBatch(employees);
	}
	
	@Test
	public void cacheable(){
		List<Employee> employees = null;
		employees = employeeService.selectAll();
		System.out.println(employees);
		System.out.println("");
		employees = employeeService.selectAll();
		System.out.println(employees);
	}
//	@Test
//	public void testSelectOne() {
//		//1.创建一个封装查询条件
//		Employee employee = new Employee(null, null, "tom", null);
//		//2.执行查询
//		Employee employee2 = employeeService.getOne(employee);
//		//3.打印查询的结果
//		System.out.println("emplyoee:"+employee2);
//	}
//
//	@Test
//	public void testPrimarySelect(){
//		Integer id = 1;
//		Employee employee = employeeService.selectOneByPrimaryKey(id);
//		System.out.println(employee);
//	}
//
//	@Test
//	public void testSelectAll() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testSelectCount() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testSelectByPrimaryKey() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testExistsWithPrimaryKey() {
//		Integer id = 32;
//		boolean t = employeeService.isExitsPrimaryKey(id);
//		System.out.println(t);
//	}
//
//	@Test
//	public void testInsert() {
//		//创建实体类
//		Employee employee = new Employee(null, 2111.00, "saary", 22);
//		//调用service方法
//		employeeService.insertOneEmp(employee);
//	}
//
//	@Test
//	public void testInsertSelective() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testUpdateByPrimaryKey() {
//		Employee employee = new Employee(2, 122.0, "dd", null);
//		employeeService.updateEmp(employee);
//	}
//
//	@Test
//	public void testUpdateByPrimaryKeySelective() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testDelete() {
//		//声明实体类作为查询的条件
//		Employee employee = null;
//		//执行删除
//		employeeService.deleteEmps(employee);
//	}
//
//	@Test
//	public void testDeleteByPrimaryKey() {
//		Integer id = 1;
//		employeeService.deleteByKey(id);
//	}
//
//	@Test
//	public void testSelectByExample() {
//		
//		//1.设置目标：WHERE (emp_salary>? AND emp_age<?) OR (emp_salary<? AND emp_age>?)
//		//2.创建一个example对象
//		Example example = new Example(Employee.class);
//		
//		//---------设置查询的条件:薪水自增，年龄自减------------
//		example.orderBy("emp_salary").asc().orderBy("emp_age").desc();
//		
//		//----------设置去重------------------
//		example.setDistinct(true);
//		
//		//3.创建Criteria对象
//		Criteria criteria1 = example.createCriteria();
//		Criteria criteria2 = example.createCriteria();
//		
//		//4.在两个Criteria中设置查询条件
//		//property：实体类的属性名
//		//value：实体类的属性值
//		criteria1.andGreaterThan("emp_salary", 200).andLessThan("emp_age", 25);
//		criteria2.andLessThan("emp_salary", 200).andGreaterThan("emp_age", 20);
//		
//		//5.用or把它们两个连起来
//		example.or(criteria2);
//		
//		//6.执行查询
//		List<Employee> employees = employeeService.selectEmp(example);
//		
//		System.out.println(employees);
//	}
//
//	@Test
//	public void testSelectOneByExample() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testSelectCountByExample() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testDeleteByExample() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testUpdateByExample() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testUpdateByExampleSelective() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testSelectByExampleAndRowBounds() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testSelectByRowBounds() {
//		fail("Not yet implemented");
//	}
}
