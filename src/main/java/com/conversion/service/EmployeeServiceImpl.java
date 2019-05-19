package com.conversion.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conversion.dao.EmployeeDao;
import com.conversion.model.Employee;
@Service
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	EmployeeDao employeeDao;
	@Override
	public void saveEmployee(Employee employee) {
		employeeDao.save(employee);
		
	}
	@Override
	public Employee getEmployyeById(int employeeId) {
		
		return employeeDao.findOne(employeeId);
	}
	
	

}
