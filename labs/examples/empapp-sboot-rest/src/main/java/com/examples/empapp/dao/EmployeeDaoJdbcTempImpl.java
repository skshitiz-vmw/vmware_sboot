package com.examples.empapp.dao;

import com.examples.empapp.exception.ApplicationException;
import com.examples.empapp.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class EmployeeDaoJdbcTempImpl implements EmployeeDao {

    @Autowired
    JdbcTemplate jdbcTemp;

    @Override
    public boolean create(Employee employee) throws ApplicationException {

        String query = "INSERT INTO employee(name, age, designation, department, country) values(\""
                + employee.getName() + "\"," + employee.getAge() + ",\"" + employee.getDesignation() + "\",\""
                + employee.getDepartment() + "\",\"" + employee.getCountry() + "\")";
//        PreparedStatementCreator obj = new PreparedStatementCreator() {
//            @Override
//            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
//                PreparedStatement psmt =  con.prepareStatement();
//                psmt.setString()
//                return psmt;
//            }
//        }
        jdbcTemp.execute(query);
        return true;
    }

    @Override
    public boolean update(Employee employee) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public Employee get(int empId) {
        String query = "SELECT * FROM employee WHERE id = " + empId;
//        return jdbcTemp.query(query, new EmployeeRowMapper()).get(0);
        return jdbcTemp.query(query, new EmployeeResultSetExtractor());
    }

    @Override
    public List<Employee> getAll() {
        String query = "SELECT * FROM employee";
        List<Employee> empList = jdbcTemp.query(query, new EmployeeRowMapper());
        return empList;
    }

    public class EmployeeResultSetExtractor implements ResultSetExtractor<Employee> {

        @Override
        public Employee extractData(ResultSet rs) throws SQLException, DataAccessException {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            int age = rs.getInt("age");
            String designation = rs.getString("designation");
            String department = rs.getString("department");
            String country = rs.getString("country");
            Employee emp = new Employee(id, name, age, designation, department, country);
            return emp;        }
    }

    public class EmployeeRowMapper implements RowMapper<Employee> {

        @Override
        public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            int age = rs.getInt("age");
            String designation = rs.getString("designation");
            String department = rs.getString("department");
            String country = rs.getString("country");
            Employee emp = new Employee(id, name, age, designation, department, country);
            return emp;
        }
    }
}
