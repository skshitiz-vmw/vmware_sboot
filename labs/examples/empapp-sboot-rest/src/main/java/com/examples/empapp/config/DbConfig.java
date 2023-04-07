package com.examples.empapp.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

//@Component
@ConfigurationProperties(prefix = "db")
public class DbConfig {
//    @Value("${db.hostname}")
    private String hostname;
//    @Value("${db.dbname}")
    private String dbname;
//    @Value("${db.username}")
    private String username;
//    @Value("${db.password}")
    private String password;

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getDbname() {
        return dbname;
    }

    public void setDbname(String dbname) {
        this.dbname = dbname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
