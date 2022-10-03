package com.jpmorgan.validator.service;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public interface IFileValidationRule {
	
	public boolean validate(String fileName, Map<String,String> context);
	
	default void printOutputMessage(Logger logger, String validationMessage){
		logger.log(Level.INFO, validationMessage);
	}

}
