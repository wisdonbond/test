package com.example.demo;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
	public static void main(String args[]){
		Calendar cal = Calendar.getInstance();
		cal.set(2008, 12,31 );
		cal.add(Calendar.MONTH, 1);
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		System.out.print( format1.format(cal.getTime()));
	}
}
