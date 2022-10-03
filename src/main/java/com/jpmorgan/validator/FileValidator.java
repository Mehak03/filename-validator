package com.jpmorgan.validator;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.jpmorgan.validator.service.IFileValidationRule;
import com.jpmorgan.validator.service.impl.DateValidationRuleImpl;
import com.jpmorgan.validator.service.impl.FileExtensionValidationRuleImpl;
import com.jpmorgan.validator.service.impl.PortfolioCodeValidationRuleImpl;
import com.jpmorgan.validator.service.impl.PrefixValidationRuleImpl;
import com.jpmorgan.validator.service.impl.SequenceValidationRuleImpl;

public class FileValidator {
	
	static Logger logger = Logger.getLogger(FileValidator.class.getName());
	
	private static final String FILE_FORMAT = "Test_<portfoliocode>_<ddmmyyyy>_<2digit-sequencenumber>.csv";
	
	List<IFileValidationRule> rules = new ArrayList<>();
	
	public FileValidator(){
		//Sequence can be externalised
		rules.add(new FileExtensionValidationRuleImpl());
		rules.add(new PrefixValidationRuleImpl());
		rules.add(new PortfolioCodeValidationRuleImpl());
		rules.add(new DateValidationRuleImpl());
		rules.add(new SequenceValidationRuleImpl());
	}
	
	public boolean validateFileName(String filePath){
		if(filePath == null || filePath.length() == 0){
			logger.log(Level.SEVERE, "File path is either null or empty");
			return false;
		}
		
		//Create objects of Path
		Path path = Paths.get(filePath);
		String fullFileName = path.getFileName().toString();
		
		if(!path.toFile().exists()){
			logger.log(Level.SEVERE, "File '"+ fullFileName + "' does not exists");
			return false;
		}
		
		String fileName = fullFileName.split("\\.")[0];
		String fileExtension = fullFileName.split("\\.")[1];
		
		String[] fileNameArr = fileName.split("_");
		
		if(fileNameArr.length != 4){
			logger.log(Level.INFO, "File '"+ fullFileName + "' failed validation.File format should be '" + FILE_FORMAT + "'");
			return false;
		}
		
		Map<String,String> context = initializeContext(fileNameArr, fileExtension);
		
		for(IFileValidationRule rule : rules){
			boolean isValid = rule.validate(fullFileName, context);
			if(!isValid){
				return false;
			}
		}
		
		logger.log(Level.INFO, "File '"+ fullFileName + "' passed validation");
		return true;
	}
	
	/**
	 * 
	 * @param fileNameArr
	 * @param fileExtension
	 * @return
	 */
	private Map<String,String> initializeContext(String[] fileNameArr, String fileExtension){
		Map<String,String> context = new HashMap<>();
		
		context.put(DateValidationRuleImpl.DATE, fileNameArr[2]);
		context.put(DateValidationRuleImpl.DATE_FORMAT, "ddMMyyyy");
		context.put(FileExtensionValidationRuleImpl.FILE_EXTENSION, fileExtension);
		context.put(FileExtensionValidationRuleImpl.FILE_EXTENSION_TYPE, "csv");
		context.put(PortfolioCodeValidationRuleImpl.PORTFOLIO_CODE, fileNameArr[1]);
		context.put(PortfolioCodeValidationRuleImpl.PORTFOLIO_CODE_REGEX, "[ABC]");
		context.put(PrefixValidationRuleImpl.PREFIX_CODE, fileNameArr[0]);
		context.put(PrefixValidationRuleImpl.PREFIX_CODE_VALUE, "Test");
		context.put(SequenceValidationRuleImpl.SEQUENCE_CODE, fileNameArr[3]);
		context.put(SequenceValidationRuleImpl.SEQUENCE_CODE_REGEX, "[0-9][0-9]");
		
		return context;
		
		
	}

}
