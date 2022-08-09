package com.example.demo;

import java.time.ZonedDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class TimeController {
	@GetMapping("/UTC")
	public ZonedDateTime UTCTime(){
		ZonedDateTime zTime = ZonedDateTime.now();
		return zTime;
	}
	
	public ZonedDateTime DateTime(){
		ZonedDateTime zTime = ZonedDateTime.now();
		return zTime;
	}
}
