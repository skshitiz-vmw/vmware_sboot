package com.examples.empapp.config;

import com.examples.empapp.model.Employee;
import com.examples.empapp.service.EmployeeService;
import com.examples.empapp.service.EmployeeServiceColImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class EmployeeConfig {

    @Bean
    public EmployeeService empService() {
        return new EmployeeServiceColImpl();
    }

    @Bean
    @Scope("prototype")
    public Employee employee() {
        return new Employee();
    }
}
