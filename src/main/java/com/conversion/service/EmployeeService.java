package com.conversion.service;

import com.conversion.model.Employee;


public interface EmployeeService {
	public void saveEmployee(Employee employee);
	public Employee getEmployyeById(int employeeId);
}
