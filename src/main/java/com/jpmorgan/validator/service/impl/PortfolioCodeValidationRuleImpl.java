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
public class PortfolioCodeValidationRuleImpl implements IFileValidationRule {
	
	private Logger logger = Logger.getLogger(PortfolioCodeValidationRuleImpl.class.getName());
	public static final String PORTFOLIO_CODE_REGEX = "portfolioRegex";
	public static final String PORTFOLIO_CODE = "portfolioCode";

	@Override
	public boolean validate(String fileName, Map<String, String> context) {
		String portfolioCode = context.get(PORTFOLIO_CODE);
		String portfolioRegex = context.get(PORTFOLIO_CODE_REGEX);
		
		if( portfolioCode == null || portfolioCode.isEmpty()){
			printOutputMessage(logger, "File '" + fileName + "' failed validation. portfolio code is null or empty");
			return false;
		}
		
		if( portfolioRegex == null || portfolioRegex.isEmpty()){
			printOutputMessage(logger, "File '" + fileName + "' failed validation. portfolio regex type is null or empty");
			return false;
		}
		
		boolean isValid = portfolioCode.matches(portfolioRegex);
		if(!isValid){
			printOutputMessage(logger, "File '" + fileName + "' failed validation. Portfolio should be A/B/C found " + portfolioCode);
			return false;
		}

		return true;
	}

}
