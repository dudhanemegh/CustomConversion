package com.conversion.controller;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.conversion.model.Employee;
import com.conversion.service.EmployeeService;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	Employee emp;
	
	@Autowired
	EmployeeService eservice;
	
	@RequestMapping(value="/create",method=RequestMethod.POST)
	public ResponseEntity<Employee> createEmployee(@RequestBody String json) throws JSONException
	{
		JSONObject jsonObject=new JSONObject(json);
		emp.setEmployeeId(jsonObject.getInt("employeeId"));
		emp.setEmployeeName(jsonObject.getString("employeeName"));
		emp.setDesignation(jsonObject.getString("designation"));
		emp.setSalary(jsonObject.getDouble("salary"));
		eservice.saveEmployee(emp);
		return new ResponseEntity<Employee>(HttpStatus.OK);
	}
	@RequestMapping(value="/{employeeId}", method=RequestMethod.GET)
	public ResponseEntity<Employee> getEmployee(@PathVariable int employeeId) throws JsonGenerationException, JsonMappingException, IOException
	{
	
		ObjectMapper mapper=new ObjectMapper();
		Employee employee=eservice.getEmployyeById(employeeId);
		mapper.writeValue(new File("C:/Users/megha/Desktop/employee.json"), employee);
		return new ResponseEntity<Employee>(employee,HttpStatus.FOUND);
	}

}
