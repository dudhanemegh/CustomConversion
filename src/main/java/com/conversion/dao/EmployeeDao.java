package com.conversion.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.conversion.model.Employee;
@Repository
public interface EmployeeDao extends CrudRepository<Employee, Integer> {

}
