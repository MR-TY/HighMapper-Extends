package com.ty.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.entities.Employee;
import com.ty.mapper.EmployeeMapper;
import com.ty.mybatchupdatemapper.MyBatchUpdateProvider;

import tk.mybatis.mapper.entity.Example;

@Service
public class EmplyoeeService {
	@Autowired
	private EmployeeMapper employeeMapper;
	
	public List<Employee> selectAll(){
		return employeeMapper.selectAll();
	}
	
	public void updateBatch(List<Employee> employees){
		employeeMapper.batchUpdate(employees);
	}
//通过对象的传入查询一个员工
//	public Employee getOne(Employee employee) {
//		return employeeMapper.selectOne(employee);
//	}
//	public Employee selectOneByPrimaryKey(Integer id) {
//		return employeeMapper.selectByPrimaryKey(id);
//	}
//	public boolean isExitsPrimaryKey(Integer id) {
//		return employeeMapper.existsWithPrimaryKey(id);
//	}
//	public void insertOneEmp(Employee employee) {
//		employeeMapper.insert(employee);
//	}
//	public void updateEmp(Employee employee) {
//		employeeMapper.updateByPrimaryKeySelective(employee);
//	}
//	public void deleteEmps(Employee employee) {
//		employeeMapper.delete(employee);
//	}
//	public void deleteByKey(Integer id) {
//		employeeMapper.deleteByPrimaryKey(id);
//	}
//	public List<Employee> selectEmp(Example example) {
//		return employeeMapper.selectByExample(example);
//	}
}
