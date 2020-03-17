package cn.iot.cache.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import cn.iot.cache.bean.Employee;
import cn.iot.cache.service.EmployeeService;

@RestController
class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/cache/{id}")
	public Employee getEmpById(@PathVariable("id") Integer id) {
		
		Employee employee = employeeService.getEmpById(id);
//		System.out.println("cache："+id);
		return employee;
	}
	
	@GetMapping("/emp")
	public Employee updateEmp(Employee emp) {
		employeeService.updateEmp(emp);
		return emp;
	}
	
	@GetMapping("/delete/{id}")
	public String deleteCache(@PathVariable("id") Integer id) {
		employeeService.deleteCache(id);
		return "清除缓存成功！";
	}
	
	@GetMapping("/emp/{lastName}")
	public Employee getEmpByLastName(@PathVariable("lastName") String lastName) {
		return employeeService.getEmpByLastName(lastName);
	}
	
}
