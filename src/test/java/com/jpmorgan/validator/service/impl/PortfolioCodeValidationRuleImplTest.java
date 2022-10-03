/**
 * 
 */
package com.jpmorgan.validator.service.impl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.junit.Before;
import org.junit.Test;

import com.jpmorgan.validator.service.IFileValidationRule;

/**
 * Validates file extension
 *
 */
public class PortfolioCodeValidationRuleImplTest {
	
	IFileValidationRule portfolioValidator = new PortfolioCodeValidationRuleImpl();
	
	private Map<String,String> context = new HashMap<>();
	private String fileName = "";
	
	@Before
	public void setUp() {
		fileName = "test";
		context.put(PortfolioCodeValidationRuleImpl.PORTFOLIO_CODE, "A");
		context.put(PortfolioCodeValidationRuleImpl.PORTFOLIO_CODE_REGEX, "[ABC]");
	}

	@Test
	public void validate() {
		assertTrue(portfolioValidator.validate(fileName, context));
		
		context.put(PortfolioCodeValidationRuleImpl.PORTFOLIO_CODE, "E");
		assertFalse(portfolioValidator.validate(fileName, context));
		
		context.put(PortfolioCodeValidationRuleImpl.PORTFOLIO_CODE, "");
		assertFalse(portfolioValidator.validate(fileName, context));
		
		context.put(PortfolioCodeValidationRuleImpl.PORTFOLIO_CODE, null);
		assertFalse(portfolioValidator.validate(fileName, context));
		
		context.put(PortfolioCodeValidationRuleImpl.PORTFOLIO_CODE_REGEX, "");
		assertFalse(portfolioValidator.validate(fileName, context));
		
		context.put(PortfolioCodeValidationRuleImpl.PORTFOLIO_CODE_REGEX, null);
		assertFalse(portfolioValidator.validate(fileName, context));
	}
}
