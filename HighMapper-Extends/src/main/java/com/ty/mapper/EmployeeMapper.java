package com.ty.mapper;

import org.apache.ibatis.annotations.CacheNamespace;

import com.ty.entities.Employee;
import com.ty.mappers_coustomer.MyMapper;

import tk.mybatis.mapper.common.Mapper;
/**
 * 
* @Description: 具体操作数据库的mapper接口
*
* @ClassName: EmployeeMapper.java
* @version: v1.0.0
* @author: 
* @date: 2018年4月24日 下午2:18:44
 */
@CacheNamespace
public interface EmployeeMapper extends MyMapper<Employee>{
	
}
