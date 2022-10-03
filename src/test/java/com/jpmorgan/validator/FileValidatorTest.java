package com.jpmorgan.validator;

import org.junit.Assert;
import org.junit.Test;

public class FileValidatorTest {
	
	FileValidator fileVaildator = new FileValidator();
	
	@Test
	public void validateFileName(){
		String filePath = "../filename-validator/src/test/resources/randomfile.txt";
		Assert.assertFalse(fileVaildator.validateFileName(filePath));
		
	    filePath = "../filename-validator/src/test/resources/Test_A_12131987_12.csv";
		Assert.assertFalse(fileVaildator.validateFileName(filePath));
		
		filePath = "../filename-validator/src/test/resources/Test_A_07121987_12.txt";
		Assert.assertFalse(fileVaildator.validateFileName(filePath));
		
		filePath = "../filename-validator/src/test/resources/Test_E_12121987_12.csv";
		Assert.assertFalse(fileVaildator.validateFileName(filePath)); 
		
		filePath = "../filename-validator/src/test/resources/Hello_A_12121987_12.csv";
		Assert.assertFalse(fileVaildator.validateFileName(filePath));
		
		filePath = "../filename-validator/src/test/resources/Test_A_12121987_123.csv";
		Assert.assertFalse(fileVaildator.validateFileName(filePath));
		
		filePath = "../filename-validator/src/test/resources/Test_A_12121987_12.csv";
		Assert.assertTrue(fileVaildator.validateFileName(filePath));
		
	}

}
