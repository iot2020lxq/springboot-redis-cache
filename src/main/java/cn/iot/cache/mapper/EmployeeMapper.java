package cn.iot.cache.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import cn.iot.cache.bean.Employee;

public interface EmployeeMapper {

	@Select("select * from employee where id = #{id}")
	public Employee getEmpById(Integer id);
	
	@Insert("insert into employee(lastName,email,gender,d_id) values(#{lastName},#{email},#{gender}),#{dId}")
	public void insertEmployee(Employee emp);
	
	@Delete("dlete from employee where id = #{id}")
	public void deleteEmpById(Integer id);
	
	@Update("update employee set lastName=#{lastName},email=#{email},gender=#{gender},d_id=#{dId} where id=#{id}")
	public void updateEmployee(Employee employee);

	@Select("select * from employee where lastName = #{lastName}")
	public Employee getEmpByLastName(String lastName);
}
