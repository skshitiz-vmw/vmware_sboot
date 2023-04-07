package com.examples.empapp.config;

import com.examples.empapp.dao.EmployeeDao;
import com.examples.empapp.dao.EmployeeDaoJdbcImpl;
import com.examples.empapp.dao.EmployeeDaoJdbcTempImpl;
import com.examples.empapp.dao.EmployeeDaoJpaImpl;
import com.examples.empapp.service.EmployeeService;
import com.examples.empapp.service.EmployeeServiceImpl;
//import com.mysql.cj.jdbc.MysqlDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.SQLException;

@Configuration
public class EmployeeConfig {

    private static Logger log = LoggerFactory.getLogger(EmployeeConfig.class);

    @Bean("empService")
    public EmployeeService empService() {
        EmployeeService empService = new EmployeeServiceImpl();
        return empService;
    }

//    @Bean("empDao")
//    public EmployeeDao empDao() {
////        return new EmployeeDaoJdbcImpl();
////        return new EmployeeDaoJdbcTempImpl();
//        return new EmployeeDaoJpaImpl();
//    }

//    @Bean("datasource")
//    public MysqlDataSource dataSource() {
//        MysqlDataSource	datasource = new MysqlDataSource();
//		datasource.setServerName(dbConfig().getHostname());
//		datasource.setDatabaseName(dbConfig().getDbname());
//		datasource.setUser(dbConfig().getUsername());
//		datasource.setPassword(dbConfig().getPassword());
//        return datasource;
//    }

//    @Bean("connection")
//    public Connection connection() {
//        Connection conn = null;
//        try {
//            conn = dataSource().getConnection();
////            System.out.println("Connection created successfully. " + conn);
//            log.info("{} Connection created successfully.{}", "Welcome,", conn);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return conn;
//    }

//    @Bean
//    public DbConfig dbConfig() {
//        return new DbConfig();
//    }
}
