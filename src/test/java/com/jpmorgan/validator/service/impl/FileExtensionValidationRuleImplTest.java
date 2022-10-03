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
 * Validates file extension
 *
 */
public class FileExtensionValidationRuleImplTest {
	
	IFileValidationRule extensionValidator = new FileExtensionValidationRuleImpl();
	
	private Map<String,String> context = new HashMap<>();
	private String fileName = "";
	
	@Before
	public void setUp() {
		fileName = "test";
		context.put(FileExtensionValidationRuleImpl.FILE_EXTENSION, "csv");
		context.put(FileExtensionValidationRuleImpl.FILE_EXTENSION_TYPE, "csv");
	}

	@Test
	public void validate() {
		assertTrue(extensionValidator.validate(fileName, context));
		
		context.put(FileExtensionValidationRuleImpl.FILE_EXTENSION, "txt");
		assertFalse(extensionValidator.validate(fileName, context));
		
		context.put(FileExtensionValidationRuleImpl.FILE_EXTENSION, "");
		assertFalse(extensionValidator.validate(fileName, context));
		
		context.put(FileExtensionValidationRuleImpl.FILE_EXTENSION, null);
		assertFalse(extensionValidator.validate(fileName, context));
		
		context.put(FileExtensionValidationRuleImpl.FILE_EXTENSION_TYPE, "");
		assertFalse(extensionValidator.validate(fileName, context));
		
		context.put(FileExtensionValidationRuleImpl.FILE_EXTENSION_TYPE, null);
		assertFalse(extensionValidator.validate(fileName, context));
	}

}
