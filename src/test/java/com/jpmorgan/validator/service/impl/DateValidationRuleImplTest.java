/**
 * 
 */
package com.jpmorgan.validator.service.impl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.junit.Before;
import org.junit.Test;

import com.jpmorgan.validator.FileValidator;
import com.jpmorgan.validator.service.IFileValidationRule;

/**
 * Test to validate date
 *
 */
public class DateValidationRuleImplTest {
	
	IFileValidationRule dateValidator = new DateValidationRuleImpl();
	
	private Map<String,String> context = new HashMap<>();
	private String fileName = "";
	
	@Before
	public void setUp() {
		fileName = "test";
		context.put(DateValidationRuleImpl.DATE_FORMAT, "ddMMyyyy");
	}

	@Test
	public void validate() {
		context.put(DateValidationRuleImpl.DATE, "01012000");
		assertTrue(dateValidator.validate(fileName, context));
		
		context.put(DateValidationRuleImpl.DATE, "01132000");
		assertFalse(dateValidator.validate(fileName, context));
	}

}
