package com.example.hello;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class HelloRepository {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public HelloRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	/**
	 * 従業員情報を検索します。
	 * @param id 従業員ID
	 * @return Map型の従業員情報（キー：カラム名,バリュー：従業員情報）
	 */
	public Map<String, Object>findById(String id) {
		// SELECT文
		String query = "SELECT * FROM employee WHERE id = ?";
		
		//　検索実行
		Map<String, Object> employee = jdbcTemplate.queryForMap(query, id);
		
		return employee;
	}
}
