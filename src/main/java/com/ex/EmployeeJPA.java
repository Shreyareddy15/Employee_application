package com.ex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;



@SpringBootApplication
@ComponentScan(basePackages = {"com.ex"}) // Point to the root package containing all components
//@EnableJpaRepositories("com.ex.RepositoryClass")
public class EmployeeJPA {
    public static void main(String[] args) {
    	ConfigurableApplicationContext context=SpringApplication.run(EmployeeJPA.class, args);
		com.ex.ServiceClass.EmployeeService es=context.getBean(com.ex.ServiceClass.EmployeeService.class);
		com.ex.EmployeeTable.Employee e=new com.ex.EmployeeTable.Employee();
        e.setEid(100);
        e.setEname("shiva");
        e.setContactno(2020202);
        e.setSalary("30000");
        es.saveEmployee(e);
        
    }

}
