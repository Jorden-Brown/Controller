package com.example.demo;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.springframework.format.datetime.joda.DateTimeParser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class MainController {

	@RequestMapping(method = RequestMethod.GET, value="/time")
	public String getTime(){
		Date date = new Date(System.currentTimeMillis());		
		
	    SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
	    formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
	    return formatter.format(date);
	}
	
	
	 // { "name":"Etc/GMT+9", "tz":"Etc/GMT+9" } 
	
	@RequestMapping(method = RequestMethod.POST, value="/Localtime")
	// @ResponseBody
	public String getLocalTime(@RequestBody timeZone tz){ 
		ZonedDateTime time1 = ZonedDateTime.now(ZoneId.of(tz.getTz()));
		String format = "yyyy-MM-dd 'at' HH:mm:ss z"; 
	    //SimpleDateFormat formatter= new SimpleDateFormat(formatter);
	    //formatter.setTimeZone(TimeZone.getTimeZone(tz.getTz()));
	    return time1.format(DateTimeFormatter.ofPattern(format));//formatter.format(Date.from(time1.toInstant(ZoneOffset.)));
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/Testing")
	public timeZone TestThis() {
		timeZone tz = new timeZone(); 
		tz.setName("Test1");
		tz.setTz("Test2");
		return tz; 
	}
	
	// taking in a body request "timezone" using json 
	@PostMapping("/UTC")
	public String getUTCTime(){
		Date date = new Date(System.currentTimeMillis());	
		
		LocalDateTime time = LocalDateTime.now();
		ZonedDateTime time2 = ZonedDateTime.now(ZoneId.of("UTC"));
		
		return time2.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss a z"));
	    
	}
	
	
	
	
	@GetMapping("/hello")
	public String base() {
		return "Hello world";
	}
}
