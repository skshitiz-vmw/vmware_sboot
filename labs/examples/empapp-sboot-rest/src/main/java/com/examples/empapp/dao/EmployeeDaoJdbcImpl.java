package com.examples.empapp.dao;

import com.examples.empapp.exception.ApplicationException;
import com.examples.empapp.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class EmployeeDaoJdbcImpl implements EmployeeDao {

//	@Autowired
//	MysqlDataSource datasource;
	@Autowired
	Connection conn;
	Statement stmt = null;
	ResultSet rs = null;

	public EmployeeDaoJdbcImpl() {
//		datasource = new MysqlDataSource();
//		datasource.setServerName("localhost");
//		datasource.setDatabaseName("jdbctraining");
//		datasource.setUser("training");
//		datasource.setPassword("training");
//
//		try {
//			conn = datasource.getConnection();
//			System.out.println("Connection created successfully. " + conn);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
	}

	public boolean create(Employee employee) throws ApplicationException {
		// INSERT employee data
		boolean status = false;
		try {
			stmt = conn.createStatement();

			String query = "INSERT INTO employee(name, age, designation, department, country) values(\""
					+ employee.getName() + "\"," + employee.getAge() + ",\"" + employee.getDesignation() + "\",\""
					+ employee.getDepartment() + "\",\"" + employee.getCountry() + "\")";

			status = stmt.execute(query);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ApplicationException("Database Exception: " + e.getMessage(), e);
		}
		return status;
	}

	public boolean update(Employee employee) {
		// UPDATE employee data
		boolean status = false;
		try {
			stmt = conn.createStatement();

			String query = "UPDATE employee SET name = \"" + employee.getName() + "\", age = " + employee.getAge()
					+ ",designation = \"" + employee.getDesignation() + "\",department = \"" + employee.getDepartment()
					+ "\", country = \"" + employee.getCountry() + "\" WHERE id = " + employee.getEmpId();
			System.out.println(query);
			status = stmt.execute(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

	public boolean delete(int id) {
		// DELETE employee data
		boolean status = false;
		try {
			stmt = conn.createStatement();

			String query = "DELETE FROM employee WHERE id = " + id;

			status = stmt.execute(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

	public Employee get(int empId) {
		// SELECT employee data
		Employee emp = null;
		String query = "SELECT * FROM employee WHERE id = " + empId;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);

			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String designation = rs.getString("designation");
				String department = rs.getString("department");
				String country = rs.getString("country");
				emp = new Employee(id, name, age, designation, department, country);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return emp;
	}

	public List<Employee> getAll() {
		// SELECT All employees
		List<Employee> employees = new ArrayList<>();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM employee");

			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String designation = rs.getString("designation");				
				String department = rs.getString("department");
				String country = rs.getString("country");
				employees.add(new Employee(id, name, age, designation, department, country));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return employees;
	}
}