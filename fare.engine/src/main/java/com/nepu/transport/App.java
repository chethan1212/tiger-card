package com.nepu.transport;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Application start up.
 * @author chethan.c
 *
 */
@SpringBootApplication
public class App {
	
    public static void main(String[] args) {
    	System.out.println("-----------------Tadaang------------------");
        SpringApplication.run(App.class, args);
        System.out.println("-----------------Done------------------");
    }
}