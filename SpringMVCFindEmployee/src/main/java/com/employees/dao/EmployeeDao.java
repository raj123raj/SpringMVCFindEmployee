package com.employees.dao;

import java.sql.SQLException;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.employees.beans.Employee;

public class EmployeeDao {
	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public Employee getEmployeesByNameAndLocation(String employeeName,String locationName) throws SQLException {
		String sql = "select * from employeesdetails where name=? and location = ?";
		return template.queryForObject(sql, new Object[] { employeeName,locationName },
				new BeanPropertyRowMapper<Employee>(Employee.class));
	}
	
	public Employee getEmployeesByGender(String gender,String availabledays) throws SQLException {
		String sql = "select * from employeesdetails where gender=? and availabledays = ?";
		return template.queryForObject(sql, new Object[] { gender,availabledays },
				new BeanPropertyRowMapper<Employee>(Employee.class));
	}
	
	public Employee getEmployeesByQualification(String qualification,String availabledays) throws SQLException {
		String sql = "select * from employeesdetails where qualification=? and availabledays = ?";
		return template.queryForObject(sql, new Object[] { qualification,availabledays },
				new BeanPropertyRowMapper<Employee>(Employee.class));
	}
	
	public Employee getEmployeesByExperience(int experienceInYears) throws SQLException {
		String sql = "select * from employeesdetails where experience=?";
		return template.queryForObject(sql, new Object[] { experienceInYears },
				new BeanPropertyRowMapper<Employee>(Employee.class));
	}
	


}