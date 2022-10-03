/**
 * 
 */
package com.jpmorgan.validator.service.impl;

import java.util.Map;
import java.util.logging.Logger;

import com.jpmorgan.validator.service.IFileValidationRule;

/**
 * Validates file extension
 *
 */
public class SequenceValidationRuleImpl implements IFileValidationRule {
	
	private Logger logger = Logger.getLogger(SequenceValidationRuleImpl.class.getName());
	public static final String SEQUENCE_CODE_REGEX = "sequenceRegex";
	public static final String SEQUENCE_CODE = "sequenceCode";

	@Override
	public boolean validate(String fileName, Map<String, String> context) {
		String sequenceCode = context.get(SEQUENCE_CODE);
		String sequenceRegex = context.get(SEQUENCE_CODE_REGEX);
		
		if( sequenceCode == null || sequenceCode.isEmpty()){
			printOutputMessage(logger, "File '" + fileName + "' failed validation. sequence code is null or empty");
			return false;
		}
		
		if( sequenceRegex == null || sequenceRegex.isEmpty()){
			printOutputMessage(logger, "File '" + fileName + "' failed validation. sequence regex type is null or empty");
			return false;
		}
		
		boolean isValid = sequenceCode.matches(sequenceRegex);
		if(!isValid){
			printOutputMessage(logger, "File '" + fileName + "' failed validation. Sequence number should be 2 digit");
			return false;
		}

		return true;
	}

}
