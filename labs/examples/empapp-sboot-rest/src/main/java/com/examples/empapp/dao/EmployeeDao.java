package com.examples.empapp.dao;

import com.examples.empapp.exception.ApplicationException;
import com.examples.empapp.model.Employee;

import java.util.List;

public interface EmployeeDao {

	public boolean create(Employee employee) throws ApplicationException;

	public boolean update(Employee employee);

	public boolean delete(int id);

	public Employee get(int empId);

	public List<Employee> getAll();
}
