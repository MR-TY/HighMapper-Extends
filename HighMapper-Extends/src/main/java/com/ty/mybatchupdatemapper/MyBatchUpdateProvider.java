package com.ty.mybatchupdatemapper;

import java.util.Set;

import org.apache.ibatis.mapping.MappedStatement;

import tk.mybatis.mapper.entity.EntityColumn;
import tk.mybatis.mapper.mapperhelper.EntityHelper;
import tk.mybatis.mapper.mapperhelper.MapperHelper;
import tk.mybatis.mapper.mapperhelper.MapperTemplate;
import tk.mybatis.mapper.mapperhelper.SqlHelper;
/**
* @Description: 这样动态生成的sql语句，所有的实体类都能进行更新
* @ClassName: MyBatchUpdateProvider.java
* @version: v1.0.0
* @author: 
* @date: 2018年4月25日 下午7:50:44
 */
public class MyBatchUpdateProvider extends MapperTemplate{

	public MyBatchUpdateProvider(Class<?> mapperClass, MapperHelper mapperHelper) {
		super(mapperClass, mapperHelper);
	}
		/*
			<foreach collection="list" item="record" separator=";" >
				UPDATE tabple_emp
				<set>
					emp_name=#{record.empName},
					emp_age=#{record.empAge},
					emp_salary=#{record.empSalary},
				</set>
				where emp_id=#{record.empId}
			</foreach>
		*/
	public String batchUpdate(MappedStatement statement){
		//1.创建stringBuilder用于拼接sql语句
		StringBuffer stringBuffer = new StringBuffer();
		//2.拼接foreach
		stringBuffer.append("<foreach collection=\"list\" item=\"record\" separator=\";\" >");
		//3.获取实体类对应的class对象	
		Class<?> entityClass = super.getEntityClass(statement);
		//4.获取实体类在数据库中对应的表名
		String tableName = super.tableName(entityClass);
		//5.生成update子句
		String updateClause = SqlHelper.updateTable(entityClass, tableName);
		stringBuffer.append(updateClause);
			stringBuffer.append("<set>");
				//6.获取各个字段的名字
				Set<EntityColumn> columns = EntityHelper.getColumns(entityClass);
				String idcolunm =null;
				String colunmName = null;
				//7.遍历各个字段
				for (EntityColumn entityColumn : columns) {
					//8.判断当前字段是否为主键
					boolean flag = entityColumn.isId();
					//9.是主键就不拼到sql语句里面，并且缓存字段名和字段值
					if (flag==true) {
						 idcolunm = entityColumn.getColumn();
						 colunmName = entityColumn.getColumnHolder("record");
					}else {
						//10.获取字段的名称，不是主键就进行拼装
						String column = entityColumn.getColumn();
						String colunmHolder = entityColumn.getColumnHolder("record");
						stringBuffer.append(column).append("=").append(colunmHolder).append(",");
					}
				}
			stringBuffer.append("</set>");
			//11.使用前面的主键名和主键值创建条件
			stringBuffer.append(" where ").append(idcolunm).append("=").append(colunmName);
			stringBuffer.append("</foreach>");
			//12.返回string
			System.out.println(stringBuffer.toString());
			return stringBuffer.toString();
	}
}
