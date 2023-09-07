package com.ex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;



@SpringBootApplication
@ComponentScan(basePackages = {"com.ex"}) 

public class EmployeeJPA {
    public static void main(String[] args) {
    	SpringApplication.run(EmployeeJPA.class, args);
        
    }

}
