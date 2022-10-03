/**
 * 
 */
package com.jpmorgan.validator.service.impl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.jpmorgan.validator.service.IFileValidationRule;

/**
 * Validates file sequence
 *
 */
public class SequenceValidationRuleImplTest {
	
	IFileValidationRule sequenceValidator = new SequenceValidationRuleImpl();
	
	private Map<String,String> context = new HashMap<>();
	private String fileName = "";
	
	@Before
	public void setUp() {
		fileName = "test";
		context.put(SequenceValidationRuleImpl.SEQUENCE_CODE, "12");
		context.put(SequenceValidationRuleImpl.SEQUENCE_CODE_REGEX, "[0-9][0-9]");
	}

	@Test
	public void validate() {
		assertTrue(sequenceValidator.validate(fileName, context));
		
		context.put(SequenceValidationRuleImpl.SEQUENCE_CODE, "345");
		assertFalse(sequenceValidator.validate(fileName, context));
		
		context.put(SequenceValidationRuleImpl.SEQUENCE_CODE, "");
		assertFalse(sequenceValidator.validate(fileName, context));
		
		context.put(SequenceValidationRuleImpl.SEQUENCE_CODE, null);
		assertFalse(sequenceValidator.validate(fileName, context));
		
		context.put(SequenceValidationRuleImpl.SEQUENCE_CODE_REGEX, "");
		assertFalse(sequenceValidator.validate(fileName, context));
		
		context.put(SequenceValidationRuleImpl.SEQUENCE_CODE_REGEX, null);
		assertFalse(sequenceValidator.validate(fileName, context));
	}
}
