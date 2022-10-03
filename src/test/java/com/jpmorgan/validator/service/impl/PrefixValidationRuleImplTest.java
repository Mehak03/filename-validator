package com.jpmorgan.validator.service.impl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.jpmorgan.validator.service.IFileValidationRule;

/**
 * Validates file prefix
 *
 */
public class PrefixValidationRuleImplTest {
	
	IFileValidationRule prefixValidator = new PrefixValidationRuleImpl();
	
	private Map<String,String> context = new HashMap<>();
	private String fileName = "";
	
	@Before
	public void setUp() {
		fileName = "test";
		context.put(PrefixValidationRuleImpl.PREFIX_CODE, "Test");
		context.put(PrefixValidationRuleImpl.PREFIX_CODE_VALUE, "Test");
	}

	@Test
	public void validate() {
		assertTrue(prefixValidator.validate(fileName, context));
		
		context.put(PrefixValidationRuleImpl.PREFIX_CODE, "Hello");
		assertFalse(prefixValidator.validate(fileName, context));
		
		context.put(PrefixValidationRuleImpl.PREFIX_CODE, "");
		assertFalse(prefixValidator.validate(fileName, context));
		
		context.put(PrefixValidationRuleImpl.PREFIX_CODE, null);
		assertFalse(prefixValidator.validate(fileName, context));
		
		context.put(PrefixValidationRuleImpl.PREFIX_CODE_VALUE, "");
		assertFalse(prefixValidator.validate(fileName, context));
		
		context.put(PrefixValidationRuleImpl.PREFIX_CODE_VALUE, null);
		assertFalse(prefixValidator.validate(fileName, context));
	}

}
