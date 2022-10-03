#Instructions

Unzip the contents manually and expand the contents someplace on your system

#Prerequisites
Have a jdk installed
Have Maven installed and available on your PATH or IDE

#Assumptions
1. Currently the program has been built for a specific file format : Test_<portfoliocode>_<ddmmyyyy>_<2digit-sequencenumber>.csv where protfoliocode can be A/B/C and sequence number is 2 digit.

The program has been written implementating Chain of Responsibility pattern.

#Verify Installation

Open a command prompt & run mvn clean install

[INFO] Scanning for projects...
[INFO] 
[INFO] -------------< com.jpmorgan.validator:filename-validator >--------------
[INFO] Building filename-validator 0.0.1-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- maven-clean-plugin:2.5:clean (default-clean) @ filename-validator ---
[INFO] Deleting /Users/avnish/Documents/workspace/filename-validator/target
[INFO] 
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ filename-validator ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory /Users/avnish/Documents/workspace/filename-validator/src/main/resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ filename-validator ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 7 source files to /Users/avnish/Documents/workspace/filename-validator/target/classes
[INFO] 
[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ filename-validator ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] Copying 8 resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:testCompile (default-testCompile) @ filename-validator ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 6 source files to /Users/avnish/Documents/workspace/filename-validator/target/test-classes
[INFO] 
[INFO] --- maven-surefire-plugin:2.12.4:test (default-test) @ filename-validator ---
[INFO] Surefire report directory: /Users/avnish/Documents/workspace/filename-validator/target/surefire-reports

-------------------------------------------------------
 T E S T S
-------------------------------------------------------
Running com.jpmorgan.validator.FileValidatorTest
Sep 30, 2022 10:25:13 PM com.jpmorgan.validator.FileValidator validateFileName
INFO: File 'randomfile.txt' failed validation.File format should be 'Test_<portfoliocode>_<ddmmyyyy>_<2digit-sequencenumber>.csv'
Sep 30, 2022 10:25:13 PM com.jpmorgan.validator.service.IFileValidationRule printOutputMessage
INFO: File 'Test_A_12131987_12.csv' failed validation. Valuation Date is not a valid date format 'ddMMyyyy'.
Sep 30, 2022 10:25:13 PM com.jpmorgan.validator.service.IFileValidationRule printOutputMessage
INFO: File 'Test_A_07121987_12.txt' failed validation. Invalid file format. Expected 'csv' found 'txt'
Sep 30, 2022 10:25:13 PM com.jpmorgan.validator.service.IFileValidationRule printOutputMessage
INFO: File 'Test_E_12121987_12.csv' failed validation. Portfolio should be A/B/C found E
Sep 30, 2022 10:25:13 PM com.jpmorgan.validator.service.IFileValidationRule printOutputMessage
INFO: File 'Hello_A_12121987_12.csv' failed validation. Prefix for the file should 'Hello' found 'Test'
Sep 30, 2022 10:25:13 PM com.jpmorgan.validator.service.IFileValidationRule printOutputMessage
INFO: File 'Test_A_12121987_123.csv' failed validation. Sequence number should be 2 digit
Sep 30, 2022 10:25:13 PM com.jpmorgan.validator.FileValidator validateFileName
INFO: File 'Test_A_12121987_12.csv' passed validation
Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.203 sec
Running com.jpmorgan.validator.service.impl.SequenceValidationRuleImplTest
Sep 30, 2022 10:25:13 PM com.jpmorgan.validator.service.IFileValidationRule printOutputMessage
INFO: File 'test' failed validation. Sequence number should be 2 digit
Sep 30, 2022 10:25:13 PM com.jpmorgan.validator.service.IFileValidationRule printOutputMessage
INFO: File 'test' failed validation. sequence code is null or empty
Sep 30, 2022 10:25:13 PM com.jpmorgan.validator.service.IFileValidationRule printOutputMessage
INFO: File 'test' failed validation. sequence code is null or empty
Sep 30, 2022 10:25:13 PM com.jpmorgan.validator.service.IFileValidationRule printOutputMessage
INFO: File 'test' failed validation. sequence code is null or empty
Sep 30, 2022 10:25:13 PM com.jpmorgan.validator.service.IFileValidationRule printOutputMessage
INFO: File 'test' failed validation. sequence code is null or empty
Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0 sec
Running com.jpmorgan.validator.service.impl.PrefixValidationRuleImplTest
Sep 30, 2022 10:25:13 PM com.jpmorgan.validator.service.IFileValidationRule printOutputMessage
INFO: File 'test' failed validation. Prefix for the file should 'Hello' found 'Test'
Sep 30, 2022 10:25:13 PM com.jpmorgan.validator.service.IFileValidationRule printOutputMessage
INFO: File 'test' failed validation. prefix is null or empty
Sep 30, 2022 10:25:13 PM com.jpmorgan.validator.service.IFileValidationRule printOutputMessage
INFO: File 'test' failed validation. prefix is null or empty
Sep 30, 2022 10:25:13 PM com.jpmorgan.validator.service.IFileValidationRule printOutputMessage
INFO: File 'test' failed validation. prefix is null or empty
Sep 30, 2022 10:25:13 PM com.jpmorgan.validator.service.IFileValidationRule printOutputMessage
INFO: File 'test' failed validation. prefix is null or empty
Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0 sec
Running com.jpmorgan.validator.service.impl.PortfolioCodeValidationRuleImplTest
Sep 30, 2022 10:25:13 PM com.jpmorgan.validator.service.IFileValidationRule printOutputMessage
INFO: File 'test' failed validation. Portfolio should be A/B/C found E
Sep 30, 2022 10:25:13 PM com.jpmorgan.validator.service.IFileValidationRule printOutputMessage
INFO: File 'test' failed validation. portfolio code is null or empty
Sep 30, 2022 10:25:13 PM com.jpmorgan.validator.service.IFileValidationRule printOutputMessage
INFO: File 'test' failed validation. portfolio code is null or empty
Sep 30, 2022 10:25:13 PM com.jpmorgan.validator.service.IFileValidationRule printOutputMessage
INFO: File 'test' failed validation. portfolio code is null or empty
Sep 30, 2022 10:25:13 PM com.jpmorgan.validator.service.IFileValidationRule printOutputMessage
INFO: File 'test' failed validation. portfolio code is null or empty
Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.02 sec
Running com.jpmorgan.validator.service.impl.FileExtensionValidationRuleImplTest
Sep 30, 2022 10:25:13 PM com.jpmorgan.validator.service.IFileValidationRule printOutputMessage
INFO: File 'test' failed validation. Invalid file format. Expected 'csv' found 'txt'
Sep 30, 2022 10:25:13 PM com.jpmorgan.validator.service.IFileValidationRule printOutputMessage
INFO: File 'test' failed validation. File extension is null or empty
Sep 30, 2022 10:25:13 PM com.jpmorgan.validator.service.IFileValidationRule printOutputMessage
INFO: File 'test' failed validation. File extension is null or empty
Sep 30, 2022 10:25:13 PM com.jpmorgan.validator.service.IFileValidationRule printOutputMessage
INFO: File 'test' failed validation. File extension is null or empty
Sep 30, 2022 10:25:13 PM com.jpmorgan.validator.service.IFileValidationRule printOutputMessage
INFO: File 'test' failed validation. File extension is null or empty
Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.007 sec
Running com.jpmorgan.validator.service.impl.DateValidationRuleImplTest
Sep 30, 2022 10:25:13 PM com.jpmorgan.validator.service.IFileValidationRule printOutputMessage
INFO: File 'test' failed validation. Valuation Date is not a valid date format 'ddMMyyyy'.
Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.002 sec

Results :

Tests run: 6, Failures: 0, Errors: 0, Skipped: 0

[INFO] 
[INFO] --- maven-jar-plugin:2.4:jar (default-jar) @ filename-validator ---
[INFO] Building jar: /Users/avnish/Documents/workspace/filename-validator/target/filename-validator-0.0.1-SNAPSHOT.jar
[INFO] 
[INFO] --- maven-install-plugin:2.4:install (default-install) @ filename-validator ---
[INFO] Installing /Users/avnish/Documents/workspace/filename-validator/target/filename-validator-0.0.1-SNAPSHOT.jar to /Users/avnish/.m2/repository/com/jpmorgan/validator/filename-validator/0.0.1-SNAPSHOT/filename-validator-0.0.1-SNAPSHOT.jar
[INFO] Installing /Users/avnish/Documents/workspace/filename-validator/pom.xml to /Users/avnish/.m2/repository/com/jpmorgan/validator/filename-validator/0.0.1-SNAPSHOT/filename-validator-0.0.1-SNAPSHOT.pom
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  6.460 s
[INFO] Finished at: 2022-09-30T22:25:14+10:00
[INFO] ------------------------------------------------------------------------
