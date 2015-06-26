package com.backbase.expert.training.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DateUtil {

	private static final Logger log = LoggerFactory.getLogger(DateUtil.class);

	public static final String BIRHTDATE_FORMAT="dd-MM-yyyy";
	
	
	public static Date stringToDate(String dateAsString, String format) {
		Date date=new Date();
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		try {
			 date = sdf.parse(dateAsString);
		} catch (ParseException e) {
			log.error(e.getMessage(), e);
		}
		return date;
	}


	
}
