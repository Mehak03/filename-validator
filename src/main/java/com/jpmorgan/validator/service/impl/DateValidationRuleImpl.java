/**
 * 
 */
package com.jpmorgan.validator.service.impl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Map;
import java.util.logging.Logger;

import com.jpmorgan.validator.FileValidator;
import com.jpmorgan.validator.service.IFileValidationRule;

/**
 * Validates date format
 *
 */
public class DateValidationRuleImpl implements IFileValidationRule {
	
	private Logger logger = Logger.getLogger(DateValidationRuleImpl.class.getName());
	public static final String DATE_FORMAT = "dateFormat";
	public static final String DATE = "date";

	@Override
	public boolean validate(String fileName, Map<String, String> context) {
		String dateFormat = context.get(DATE_FORMAT);
		String date = context.get(DATE);
		
		try{
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat);
			LocalDate.parse(date, formatter);
		}catch(DateTimeParseException e){
			printOutputMessage(logger, "File '" + fileName + "' failed validation. Valuation Date is not a valid date format '" + dateFormat + "'.");
			return false;
		}

		return true;
	}

}
