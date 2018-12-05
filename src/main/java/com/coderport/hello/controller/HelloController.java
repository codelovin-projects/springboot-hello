package com.coderport.hello.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api")
public class HelloController {

	private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

	@GetMapping("/hello")
	public ResponseEntity<?> sayHello(
			@RequestParam(name = "name", required = false, defaultValue = "Hello, how are you doing?") String msg) {
		logger.info("HelloController.sayHello() is called...");
		HttpHeaders headers = new HttpHeaders();
		headers.add("Test-Header", "test");
		return new ResponseEntity<>(new com.coderport.hello.beans.Hello(msg), headers, HttpStatus.OK);
	}
}
