package com.example.demo;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
/**
 * 
 * @author Lucry
 *
 */
public class DemoApplication {

	public static void main(String[] args) throws IOException, ParseException {
		SpringApplication.run(DemoApplication.class, args);
		Download classe=new Download();
	}

}
