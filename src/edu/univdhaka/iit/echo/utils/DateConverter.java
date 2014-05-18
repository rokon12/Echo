package edu.univdhaka.iit.echo.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DateConverter {

    private static final Logger log = LoggerFactory
	    .getLogger(DatabaseTemplate.class);

    public static void main(String[] args) {
	stringToDateConversion("2012-12-21");
    }

    public static Date stringToDateConversion(String date) {
	log.debug("stringToDateConversion() date= {}", date);
	try {
	    Date parsedDate = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH)
		    .parse(date);
	    log.debug("stringToDateConversion() parsedDate={}", parsedDate);
	} catch (ParseException e) {
	    log.error("unable to parse date", e);
	}

	return null;
    }

    private String converUtilDateToSqlDate(final java.util.Date utilDate) {
	log.debug("converUtilDateToSqlDate() utilDate ={}", utilDate.toString());
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	String sqlDate = sdf.format(utilDate);
	log.debug("sqlDate ={}", sqlDate);
	return sqlDate;
    }
}
