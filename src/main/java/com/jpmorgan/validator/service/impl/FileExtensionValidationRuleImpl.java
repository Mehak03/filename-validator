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
 * Validates file extension
 *
 */
public class FileExtensionValidationRuleImpl implements IFileValidationRule {
	
	private Logger logger = Logger.getLogger(FileExtensionValidationRuleImpl.class.getName());
	public static final String FILE_EXTENSION_TYPE = "fileExtensionType";
	public static final String FILE_EXTENSION = "fileExtension";

	@Override
	public boolean validate(String fileName, Map<String, String> context) {
		String fileExtensionType = context.get(FILE_EXTENSION_TYPE);
		String fileExtension = context.get(FILE_EXTENSION);
		
		if( fileExtension == null || fileExtension.isEmpty()){
			printOutputMessage(logger, "File '" + fileName + "' failed validation. File extension is null or empty");
			return false;
		}
		
		if( fileExtensionType == null || fileExtensionType.isEmpty()){
			printOutputMessage(logger, "File '" + fileName + "' failed validation. File extension type is null or empty");
			return false;
		}
		
		boolean isValid = fileExtensionType.equalsIgnoreCase(fileExtension);
		if(!isValid){
			printOutputMessage(logger, "File '" + fileName + "' failed validation. Invalid file format. Expected '" + fileExtensionType + "' found '" + fileExtension + "'");
			return false;
		}

		return true;
	}

}
