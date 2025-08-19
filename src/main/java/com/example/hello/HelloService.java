package com.example.hello;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloService {
	
	private HelloRepository repository;
	
	@Autowired
	public HelloService(HelloRepository repository) {
		this.repository = repository;
	}
	
	/**
	 * 従業員を1人取得する
	 * @param id　従業員ID
	 * @return　従業員情報
	 */
	public Employee getEmployee(String id) {
		// 検索
		Map<String, Object> map = repository.findById(id);
		
		// Mapから値を取得
		String employeeId = (String)map.get("id");
		String name = (String)map.get("name");
		int age = (Integer)map.get("age");
		
		// Employeeクラスに値をセット
		Employee employee = new Employee();
		employee.setEmployeeId(employeeId);
		employee.setEmployeeName(name);
		employee.setEmployeeAge(age);
		
		return employee;
	}

}
