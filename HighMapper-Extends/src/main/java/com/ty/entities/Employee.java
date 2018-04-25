package com.ty.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "TABLE_EMP")
public class Employee implements Serializable{
	@Id
	private Integer emp_id;
	private String emp_ename;
	private Double emp_salary;
	private Integer emp_age;
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(Integer emp_id, String emp_ename, Double emp_salary, Integer emp_age) {
		super();
		this.emp_id = emp_id;
		this.emp_ename = emp_ename;
		this.emp_salary = emp_salary;
		this.emp_age = emp_age;
	}
	public Integer getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(Integer emp_id) {
		this.emp_id = emp_id;
	}
	public String getEmp_ename() {
		return emp_ename;
	}
	public void setEmp_ename(String emp_ename) {
		this.emp_ename = emp_ename;
	}
	public Double getEmp_salary() {
		return emp_salary;
	}
	public void setEmp_salary(Double emp_salary) {
		this.emp_salary = emp_salary;
	}
	public Integer getEmp_age() {
		return emp_age;
	}
	public void setEmp_age(Integer emp_age) {
		this.emp_age = emp_age;
	}
	@Override
	public String toString() {
		return "Employee [emp_id=" + emp_id + ", emp_ename=" + emp_ename + ", emp_salary=" + emp_salary + ", emp_age="
				+ emp_age + "]";
	}
}
