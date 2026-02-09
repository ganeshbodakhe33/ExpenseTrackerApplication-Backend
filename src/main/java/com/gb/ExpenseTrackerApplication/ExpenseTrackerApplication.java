package com.gb.ExpenseTrackerApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExpenseTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExpenseTrackerApplication.class, args);
	}

//	What happens here?
//
//	Starts Spring Boot
//
//	Scans all packages under com.expensetracker
//
//	Creates beans (@Service, @Repository, @Controller)

}
