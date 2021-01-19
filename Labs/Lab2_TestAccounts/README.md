## Lab2 Unit Testing of Bank Accounts
#### DUE: Monday, Jan 25 end of day
#### Zip all files and submit via Moodle

Your goal IN LAB is to complete the exercise zyBooks-testing: 
https://github.com/lars1050/CSC210-S21/tree/main/Exercises/zyBooks-testing. Use the Google form to submit your work:

https://forms.gle/n5CX4HoHxKujy8ow7

This lab is all about unit tests (see zyBooks sections on Unit Testing for more information). Testing is an important part of code development. You can test your code informally using print statements or interacting with your code and looking at the output (similar to how zyBooks does testing). However, it is standard industry practice that you develop formal automated unit tests using a testing framework, like JUnit. And if you are using _Test-Driven Development_, you will be writing the tests first, then writing the code! Tests can be developed only with a clear understanding of the requirements and of the expected behavior.  

Unit tests are developed with the code and can be used for _regression testing_ (meaning that if you make changes to the code, you can run the tests again and make sure you did not break the code). A _unit_ often refers to a Java class, and a test file might have test cases for every method of the class. A _test case_ would be the test of a single input into the method, with a known/expected output. If the expected output does not match the actual output (i.e. result), the test has failed. In some frameworks, the program will stop executing at the point of a test failure. For our purposes, we will print an error message and continue.

Another important concept to keep in mind is an _edge case_. Many of our programming errors are those along an "edge" or "border" -- either a physical border of a data structure, like the first or last element of an array, or a value border, like 0 that borders positive and negative. For the Balance Limits, you will develop test cases around those borders of the limit values, in addition to test cases not on the border.

<hr>

Learning Outcomes:
1. Given a class, be able to design and implement unit tests.
2. Given unit tests, be able to use them to ensure code correctness.

<hr>

General Requirements:

1. Modify the Account code to manage balance limits correctly.
2. Complete the tests in TestBalanceLimits.java
3. Run YOUR tests against my bad code to find and list the errors in a report document (NO NEED TO FIX THEM -- just find them).

Informative and UNIQUE error messages in the assert statements are very important for identifying the location and nature of the bugs. These error messages will be graded.

_Javadocs_ is not required for testing, but please use good naming conventions.

<hr>

#### 1. Getting Started

Start by _pulling_ the code from GitHub (if you have that setup) OR using the download option on GitHub. If you download, you will again download the entire contents of the repository -- you cannot select a single file or folder for download.

If using Netbeans, create a new ANT project (no packages!) for Lab2. Add the files from GitHub to your project folder. **Add your Lab1 Account.java, Checking.java, and Visa.java** to the Lab2 project.

> PRE-CONDITION: Check your code from Lab1 using the Lab2 test files TestChecking.java and TestVisa.java. Notice that these are different from the Lab1 test files! If there are errors, either fix them (on your own or with the help of a peer, tutor, or Dr. Larson) or email Dr. Larson and request a completed version of the code. In general, keys will not be posted for any of the labs.

#### 2. Fix Code for Managing Limits

Balance limits are checked in the _changeBalance_ method for all types of transactions. However, balance limits should not be applied to the bank transactions of chargeFee and applyInterest. The framework has been established, but it needs to be finished.

- `changeBalance(Double value, Boolean bankTransaction)` should be modified so that the limits are not checked if it is a bankTransaction (i.e. the variable is true).

- `applyInterest()` should call the `changeBalance` with 2 input parameters. The `bankTransaction` value should be true.

- `chargeFee()` should call the `changeBalance` with 2 input parameters. The `bankTransaction` value should be true.


#### 3. Complete Unit Tests in TestBalanceLimits.java

There are 2 sections to complete in the file _TestBalanceLimits.java_ -- one for Checking and one for Visa. For all tests, use the `Assert.assertEquals()` method that has been provided. The signature of this method is:

```
void assertEquals(Double expect, Double result, Double threshold, String msg);
```

When testing Double values, we use a threshold to provide an allowance of difference between the expected and the actual result. For example, it might be okay that the expected value is 1.00 but the actual is 0.9999. In this case, the call to assertEquals might be:

```
assertEquals(1.0, result, .0002,"Testing function XYZ.");
```

Follow the comments in the provided test file. There should be 1 test with an assertEquals statement per comment. Remember that the error messages need to be unique and informative so that you can locate the errors in the code.

Look at the tests provided in the other files for examples.

Run your tests against your code -- there should not be any errors.

#### 4. Test Bad Code with Balance Limit Tests

Use your TestBalanceLimits.java file to test the code provided in the BadCode folder. It doesn't matter how you do this, it is only important that you show the results by completing a report.

Create a _report.txt_ file within the code directory to list all the errors found in the bad code. You do not need to fix the bad code, only identify where the error is by stating the code line number with a brief error msg. For example, you might have this in your report:

```
Checking.java
- line 23: changeBalance not correct.

Account.java
- line 15: chargeFee not correct.
```

Lab Is Complete!

<hr>

#### Assessment:

Grades will be given as A,B,C,D with the numerical equivalence of 95, 85, 75, 65. "F" is not listed because that will be addressed on an individual basis depending on how much of the lab was completed.

The rubric is as follows:

- A : All code components complete, correct, and compiling. Error messages unique and informative. Errors in bad code identified.
- B : Few code components incomplete or incorrect, errors not identified, or error messages not informative.
- C : Many code components or error messages incomplete or incorrect, and/or errors not identified.
- D : Minimal additions to the code.

To be graded, the file TestBalanceLimits must compile and execute without throwing an exception. It must compile with both your code and my bad code. If it does not compile, it is an automatic deduction of 5% and it will be returned to you to fix it. **CODE WILL NOT BE GRADED (and will receive a 0) UNTIL IT COMPILES.**
