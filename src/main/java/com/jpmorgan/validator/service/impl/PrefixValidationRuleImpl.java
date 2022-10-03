package com.jpmorgan.validator.service.impl;

import java.util.Map;
import java.util.logging.Logger;

import com.jpmorgan.validator.service.IFileValidationRule;

/**
 * Validates file prefix
 *
 */
public class PrefixValidationRuleImpl implements IFileValidationRule {
	
	private Logger logger = Logger.getLogger(PrefixValidationRuleImpl.class.getName());
	public static final String PREFIX_CODE_VALUE = "prefixValue";
	public static final String PREFIX_CODE = "prefixCode";

	@Override
	public boolean validate(String fileName, Map<String, String> context) {
		String prefixCode = context.get(PREFIX_CODE);
		String prefixCodeValue = context.get(PREFIX_CODE_VALUE);
		
		if( prefixCode == null || prefixCode.isEmpty()){
			printOutputMessage(logger, "File '" + fileName + "' failed validation. prefix is null or empty");
			return false;
		}
		
		if( prefixCodeValue == null || prefixCodeValue.isEmpty()){
			printOutputMessage(logger, "File '" + fileName + "' failed validation. prefix regex is null or empty");
			return false;
		}
		
		boolean isValid = prefixCode.matches(prefixCodeValue);
		if(!isValid){
			printOutputMessage(logger, "File '" + fileName + "' failed validation. Prefix for the file should '" + prefixCode + "' found '" + prefixCodeValue + "'");
			return false;
		}

		return true;
	}

}
