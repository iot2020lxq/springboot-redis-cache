package cn.iot.cache.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import cn.iot.cache.bean.Employee;
import cn.iot.cache.mapper.EmployeeMapper;

@CacheConfig(cacheNames= {"emp"})	//指定缓存公共配置
@Service
public class EmployeeService {

	@Autowired
	EmployeeMapper employeeMapper;
	
	/*
	 *  运行流程：
     *   @Cacheable：
     *   1、方法运行之前，先去查询Cache（缓存组件），按照cacheNames指定的名字获取；
     *      （CacheManager先获取相应的缓存），第一次获取缓存如果没有Cache组件会自动创建。
     *   2、去Cache中查找缓存的内容，使用一个key，默认就是方法的参数；
     *      key是按照某种策略生成的；默认是使用keyGenerator生成的，默认使用SimpleKeyGenerator生成key；
     *          SimpleKeyGenerator生成key的默认策略；
     *                  如果没有参数；key=new SimpleKey()；
     *                  如果有一个参数：key=参数的值
     *                  如果有多个参数：key=new SimpleKey(params)；
     *   3、没有查到缓存就调用目标方法；
     *   4、将目标方法返回的结果，放进缓存中
     *
     *   @Cacheable标注的方法执行之前先来检查缓存中有没有这个数据，默认按照参数的值作为key去查询缓存，
     *   如果没有就运行方法并将结果放入缓存；以后再来调用就可以直接使用缓存中的数据；
     *
     *   核心：
     *      1）、使用CacheManager【ConcurrentMapCacheManager】按照名字得到Cache【ConcurrentMapCache】组件
     *      2）、key使用keyGenerator生成的，默认是SimpleKeyGenerator
	 * 
	 * 属性：
	 * value/cahceNames：指定缓存的名称，将方法的返回结果放在哪个缓存中，可以指定多个缓存名称
	 * key：缓存数据使用的key，用来指定缓存数据。默认方法参数
	 * keyGenerator：key的生成器，可以自己指定key的生成器组件id
	 * 		key/keyGenerator二选一
	 * cacheManeger：指定缓存管理器，或者cacheResolver指定获取解析器
	 * condition：指定符合条件的才缓存
	 * unless：执行符合条件的不缓存
	 * sync：使用使用异步模式，以异步的方式将方法的返回值存入缓存，但unless属性会失效
	 * 
	 */
	@Cacheable(cacheNames= {"emp"},key="#id")
	public Employee getEmpById(Integer id) {

		System.out.println("查询id："+id);
		Employee employee = employeeMapper.getEmpById(id);
		return employee;
	}
	
	/*
	 * @CachePut：即调用了数据库方法，又更新或创建指定缓存，将方法的结果存入缓存
	 * 	
	 */
	@CachePut(value="emp",key="#emp.id")
	public Employee updateEmp(Employee emp) {
		employeeMapper.updateEmployee(emp);
		return emp;
	}

	/*
	 * @CacheEvict：清除缓存
	 * 	key：清除缓存的指定数据
	 * 	allEntries：是否清除缓存的所有数据
	 * 	beforeInvocation：是否在方法之前清除缓存，默认fasle，在方法执行完之后清除缓存
	 * 		如果在方法之前清除缓存，无论有没有发生异常，都清除缓存
	 * 		如果在方法之后清除缓存，有发生异常，就不清除缓存
	 */
	@CacheEvict(value="emp",key="#id",allEntries=false)
	public void deleteCache(Integer id) {
		// TODO Auto-generated method stub
		System.out.println("delete："+id);
	}
	
	/*
	 * 复杂缓存
	 */
	@Caching(
		cacheable = { @Cacheable(value="emp",key="#lastName") },
		put = { @CachePut(value="emp",key="#result.id") }
	)
	public Employee getEmpByLastName(String lastName) {
		return employeeMapper.getEmpByLastName(lastName);
	}
	
}
