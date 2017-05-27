package com.example.demo.model;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Holiday {
	private String status;
	private List<holi> holidays;

	public List<holi> getHolidays() {
		return holidays;
	}

	public void setHolidays(List<holi> holidays) {
		this.holidays = holidays;
	}

	public Holiday getFormDate(String date, String countryname) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		try {
			cal.setTime(df.parse(date));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int month = cal.get(Calendar.MONTH) + 1;
		int day = cal.get(Calendar.DAY_OF_MONTH) ;
		int year = cal.get(Calendar.YEAR);
		RestTemplate restTemplate = new RestTemplate();
		Holiday holis = restTemplate
				.getForObject("https://holidayapi.com/v1/holidays?key=bdb85083-f678-4e61-a927-72131aba33d7&country="
						+ countryname + "&year=" + year + "&month=" + month + "&day=" + day, Holiday.class);
		System.out.println(year);
		return holis;
	}

	public Holiday getFormMonth(String date, String countryname) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		try {
			cal.setTime(df.parse(date));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int month = cal.get(Calendar.MONTH) + 1;
		int year = cal.get(Calendar.YEAR);
		RestTemplate restTemplate = new RestTemplate();
		Holiday holis = restTemplate
				.getForObject("https://holidayapi.com/v1/holidays?key=bdb85083-f678-4e61-a927-72131aba33d7&country="
						+ countryname + "&year=" + year + "&month=" + month, Holiday.class);
		
		return holis;

	}

	

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
