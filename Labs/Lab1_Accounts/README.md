## Lab1 Bank Accounts
#### DUE: Tuesday, January 19 at NOON
#### Zip all files and submit via Moodle
#### Do not forget to complete and include report.txt

> Your goal for Tuesday lab is to compile and execute _TestChecking.java_. This does not mean you have the lab complete, nor does it mean that the tests have to be passing. It means you have to create `class Checking` and `class Discover` with constructors and "stubs" for the methods (stubs described under Assessment section).

**BEFORE YOU LEAVE TODAY, PLEASE SUBMIT YOUR COMPLETED GOOGLE FORM.**

> Late submissions will be accepted with a 15% point reduction for every 24 hours after the due date.

> EXCEPT IF you submit on time, and you attend office hours, and you fill out the late submission google form - then you can RESUBMIT within 1 day of the deadline with no penalty.

<hr>

Learning Outcomes:

1. Given functional requirements and minimal code base, you can build classes to meet functional requirements.
2. Use the given (minimal) testing script to ensure code is executable.
3. For derived classes, you understand access to methods and member variables.

<hr>

General Requirements:

1. Create the classes Checking and Visa.
3. Document all code with Javadocs.
4. Modify class Account to meet requirements.
5. Create Transaction class and incorporate into Account. And modify Checking and Visa to add transactions to the account.

<hr>

Provided Files:

- Account.java : The base/super/parent class for bank accounts.
- Credit.java : The interface for a credit account (e.g. credit card)
- Debit.java : The interface for a debit account (e.g. checking account)
- TestChecking.java : The main() to test the Checking class.
- TestVisa.java : The main() to test the Visa class.
- TestTransactions.java : The main() to test the Transaction list.

> It is a lot of overhead to have these separate files for the tests. I have done this to make it easier for you and for me (a lot for me). You can construct your code in stages, and if you run out of time or one part isn't working, this allows me to quickly grade what is working.

<hr>

Assessment:

Grades will be given as A,B,C,D with the numerical equivalence of 95, 85, 75, 65. "F" is not listed because that will be addressed on an individual basis depending on how much of the lab was completed.

The rubric is as follows:

A : All code components complete, correct, and compiling. Javadocs complete.
B : Few code components incomplete or incorrect, or Javadocs incomplete.
C : Many code components incomplete or incorrect, and/or Javadocs incomplete.
D : Minimal additions to the code and Javadocs incomplete.

> To be graded, the files TestChecking and TestVisa must compile and execute without throwing an exception. If it does not compile, it is an automatic deduction of 5% and it will be returned to you to fix it. NO CODE WILL BE GRADED UNTIL IT COMPILES!! TestTransactions is an exception.

Note that having code that compiles does not mean you have to get the lab complete and perfect. It means that for every method called in main, you should have that method defined, even if it is empty and not doing anything. An empty method that returns a fixed result is called a "_stub_", which for our purposes is a placeholder for future code. It is common to start a project by creating a stub for all the methods. In testing, you might use a stub to provide a known result to test a method that depends on the value returned by the stub.

<hr>

### JAVADOCS

Javadocs is an automated documentation tool to share information about the code with other programmers or users of the code. The comments should be professional and describe the behavior of the code.

If you use specific syntax to write comments in your Java code, these comments can be compiled to automatically create web pages. There is a lot that can be done, but we will focus on a few key features.

- Generally describe every class, public method, and variable.
- For each method, indicate the input parameters and the return value.

The expected syntax for every class method is:
```
/** General comment about the method ...
@param var1 description
@param var2 description
@return description
*/
public Integer func(String var1, Double var2) { ... }
```

You can see the results by selecting `>Run>Generate Javadocs` in the pulldown menu of Netbeans. If you use the command line instead, I typically do:

```
mkdir docs
cd docs
javadoc ../*.java
```

### 1. Create `class Checking`

Define the `class Checking` in the file _Checking.java_ as a subclass of `class Account` that implements the `interface Debit`. Overload the constructor using these 2 signatures:

```java
public Checking(String name, Double startBalance);
public Checking(String name);
```

The `Checking(String name)` should have **only 1 line of code**. That one line is `this(name,0);`. What that one line will do is call the other constructor.

The `Checking(String name, double startBalance)` constructor should call the parent class constructor (i.e. _Account_) like this: `super(name);`.

You will need to initialize member variables in the constructor. It should have a **default minimum balance limit of $0.00 and fee of $5.00**, which is a monthly service fee. Additionally, the balance needs to be set.

> NOTICE that the Account member variables are private (not protected). Do NOT change this because it is a safety measure. To access or modify these variables, use the setters and getters.

For easy printing, add the below `toString()` method (notice it is using the _toString()_ method of the super class _Account_ within its toString method):

  ```java
	@Override
  public String toString() {
    return "Checking "+super.toString();
  }
  ```

You must implement all methods declared in the interface _Debit_. For each, change the balance as appropriate for the transaction.

**ADD JAVADOCS** as you are writing the class. Include documentation for member variables and class methods. This is the easiest way to document your code, as opposed to writing all your code then, as an afterthought, go back and fill in the documentation.

> TO TEST YOUR CODE, run TestChecking.java. If everything is working correctly, you should see this:

```
_______ TESTING CHECKING __________

... Testing Account class methods ...

... Testing Checking class methods ...

_______ END TESTING CHECKING  __________

```

### 2. Create `class Visa`

Essentially repeat the above process for _Visa_. The class _Visa_ is a subclass of _Account_ and it uses the _Credit_ interface. Create 1 constructor -- starting balance is always $0.00.

```java
public Visa(String name);
```

You will need to initialize member variables in the constructor, including a **maxBalanceLimit of $2000.00**, and a **fee of $30.00**, which is an annual membership fee. Set the balance limit and fee in the constructor.

For easy printing, add this `toString()` method (notice it is using the _toString()_ method of the super class _Account_ within its toString method):

  ```java
  public String toString() {
    return "Visa "+super.toString();
  }
  ```

You must implement all methods declared in the interface. For each, set the balance as appropriate for the transaction.

> **Remember that the Credit balance reflects how much the owner of the account owes the bank. Purchases increase the balance while payments decrease it.**

**ADD JAVADOCS** as you are writing the methods. This is the easiest way to document your code.

<hr>

### 3. OOPS -- chargeFee() Not Right

Charging a fee to a checking (debit) account decreases the balance, but charging a fee to a Visa (credit) account increases the balance. You can see this error reflected in the failure of the test:

```
... Testing Account class methods for VISA ...
chargeFee expect 0 diff. Results 20.0
```

Fix this by setting the fee as a negative value for the Visa account.

> At this point, you can start to understand the complexity of creating a base class Account for both credit and debit accounts, and perhaps the design needs some adjustment (but not now). _This is the nature of coding_: at a high level, the code makes sense, but when we get down into the details, we run into unanticipated problems and complexities.

<hr>

### 4. Create interestRate Account Member Variable

The interest rate is hardcoded into the method `applyInterest()` with the statement:

```
changeBalanceByAmount(balance*.215/12);
```

Interest rates are defined annually, but applied monthly, hence it is divided by 12. For credit accounts, this is a charge that increases the balance (because now the owner owes more to the bank) but for debit accounts, this is earned interest (like with savings accounts) yet it also increases the balance. (_Isn't that funny that when you borrow money from the bank they think you should pay them 15-25% interest, but if you lend money to the bank, which is exactly what you are doing because they invest your money while they are "holding" it for you in your savings account, they think they should pay you 1-2% interest._ ) Anyway, back to the problem at hand ...

Hard coding values is typically not good practice. Fix that by creating an `interestRate` member variable in _class Account_. The default for Checking is 0%. The default for Visa is 18.2%, expressed as .182.

Set the Account member variable interestRate in the constructor of the Checking and Visa classes.

With few exceptions, member variables should have a setter and getter (also known as a mutator and accessor). Please use MY PREFERRED signatures for coding these using OVERLOADED methods:

```
public void interestRate(Double rate);
public Double interestRate();
```

<hr>
<hr>

### 5. Create _class Transaction_

Banks keep track of all transactions so that they can be reviewed. Add this functionality to the _Account_ class by defining a _Transaction_ class INSIDE the Account class (yes, you can do that!). Follow the instructions below.

- Import the packages `java.time.LocalDate` and `java.util.ArrayList` into the _Array_ class.

- Create a simple Transaction class within the Account class that has 3 member variables: `description`, `amount`, and `date`. The description should indicate the type of transaction: "purchase", "withdrawal", "payment", or "deposit".

  ```
  private class Transaction {
    private String description;
    private double amount;
    private LocalDate date;
    Transaction(String desc, double dollars) {
      description = desc;
      amount = dollars;
      date = LocalDate.now();
    }
  } // end class Transaction
  ```

- Add `Transaction.toString()`
   ```
	  public String toString() {
	    return String.format("%s $%8.2f %s",date,amount,description);
	  }
	  ```

- Create a private member variable `transactions` in Account
  ```
  private ArrayList<Transaction> transactions = new ArrayList<>()
  ```
  NOTICE this is an ACCOUNT member variable NOT a Transaction member variable.

- Create an Account method that will create a new Transaction and add it to the ArrayList transactions.
  ```
  public addTransaction(String desc, Double amount);
  ```

- Wherever you make a transaction (e.g. deposit, withdrawal, etc.) in Checking or Visa, create a corresponding transaction and add to the transactions list. For example, if you make a withdrawal of $40.00, you would want to call `public void addTransaction("withdrawal",-40)`.

- Add the Account method `public vlid printTransactions()` to print the transaction list. Print a heading first that includes account information. You can use the `toString()` method of Account for this. For example, the heading might look like:
  _Transactions for Account 23610002 (Annika Haas) $150.00_.

The last step is to complete `report.txt` to provide a status report for each component.

Lab Is Complete!
