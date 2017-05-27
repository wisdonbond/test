package com.example.demo.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Holiday;
import com.example.demo.model.Result;
import com.example.demo.model.holi;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@RestController
public class DemoController {
	@RequestMapping(value = "/{date}/{country1}/{country2}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity getHoliday(@PathVariable String date, @PathVariable String country1, @PathVariable String country2) {

		Result re = macthHoliday(date,country1,country2);
		return new ResponseEntity(re, HttpStatus.OK);

	}

	public holi findNextHoliday(String date, String country1) {
		Holiday holicountry1 = new Holiday().getFormMonth(date, country1);
		List<holi> holis = holicountry1.getHolidays();
		String date2 = date;
		while( holi.toCalendar(date2).get(Calendar.YEAR)<2017){
		for (int i = 0;i < holis.size();i++) {
			Calendar cal1 = holi.toCalendar(holis.get(i).getDate());
			Calendar cal2 = holi.toCalendar(date);
			if (cal1.compareTo(cal2) == 1) {
				
				return holis.get(i);
			}
			else if(i==(holis.size())-1) {
				SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
				Calendar plusdate = holi.toCalendar(date);
				plusdate.add(Calendar.MONTH, 1);
				date2 = format1.format(plusdate.getTime());
				holicountry1 = new Holiday().getFormMonth(date2, country1);
				holis = holicountry1.getHolidays();
			}
			
		}
		}
		return null;
	}
	public Result macthHoliday(String date,String country1,String country2){
		holi holiday = findNextHoliday(date, country1);
		Holiday holi = new Holiday().getFormDate(date, country2);
		while(holi.getHolidays().size() == 0){
		    holiday = findNextHoliday(holiday.getDate(), country1);
			holi = new Holiday().getFormDate(holiday.getDate(), country2);
			
		}
		Result result = new Result();
		result.setDate(holiday.getDate());
		result.setName1(holiday.getName());
		result.setName2(holi.getHolidays().get(0).getName());
		
		return result;
		
	}

}
