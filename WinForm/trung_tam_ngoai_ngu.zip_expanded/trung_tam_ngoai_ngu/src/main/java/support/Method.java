package support;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Method {
	public static Date String2Date(String str) { 
	   try {
		return(new Date(new SimpleDateFormat("yyyy-MM-dd").parse(str).getTime())) ;
	} catch (ParseException e) {
		return(new Date(0));
	}  
	}
	
	public static Date getDateFromJDate(java.util.Date date) {
		return date != null ? new java.sql.Date(date.getTime()) : null;
	}
	
	public static Date getDateAdd(java.util.Date date) {
		return date != null ? new java.sql.Date(date.getTime()) : new java.sql.Date(System.currentTimeMillis());
	}
	public static String Date2String(java.sql.Date date) {
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");  
		String strDate = dateFormat.format(date);  
		return strDate;
	}
}
