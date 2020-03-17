package cn.iot.cache;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import cn.iot.cache.bean.Employee;
import cn.iot.cache.mapper.EmployeeMapper;

@SpringBootTest
class SpringBoot04CacheApplicationTests {

	@Autowired
	EmployeeMapper employeeMapper;
//	
//	@Autowired
//	StringRedisTemplate stringRedisTemplate;//操作k-v字符串的
//	
//	@Autowired
//	RedisTemplate<Object, Object> redisTemplate;//操作k-v对象的
//	
//	@Autowired
//	RedisTemplate<Object, Employee> myRedisTemplate;//自定义的,操作k-v对象的
	
	/**
	 * 测试redis
	 */
	@Test
	public void test01() {
//		stringRedisTemplate.opsForValue().append("msg", "hello");
		//String msg = stringRedisTemplate.opsForValue().get("msg");
		//System.out.println(msg);
		
//		Employee employee = employeeMapper.getEmpById(1);
//		redisTemplate.opsForValue().set("emp_01", employee);
//		
//		Employee employee = employeeMapper.getEmpById(1);
//		myRedisTemplate.opsForValue().set("emp_01", employee);
	}
	
	
	
	@Test
	void contextLoads() {
		
		Employee employee = employeeMapper.getEmpById(1);
		System.out.println(employee);
	}

}
