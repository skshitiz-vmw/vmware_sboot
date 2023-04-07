package com.examples.empapp.repository;

import com.examples.empapp.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // No need to provide impl for CRUD operations
}
