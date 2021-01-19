## In Lab Exercise
### Due Tuesday, January 18 by end of lab
### Complete the Google Form to show work

https://forms.gle/n5CX4HoHxKujy8ow7

In zyBooks Chapter 18, there was a series of programming exercises assigned. In each one, the function began by filling an array with user input, then doing something to the array. Here is an example of one of those exercises.

```Java
public class LabProgram {
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		int[] userValues = new int[9];  // Set of data specified by the user      
		// user enters number up to 9. uses negative to indicate done.
		for (int i=0; i<9; i++) {
			System.out.print("enter number: ");
			int number = scnr.nextInt();
			if (number < 0) {
				break;
			}
			userValues[i] = number;
		}
		/* Write code to find the middle value of the array */
	}
}
```

There are several ways in which this approach can be improved. These are the issues we are going to address:

1. If input is accepted one number at a time, it is unknown how many numbers the user would like to enter, therefore it is difficult to size the array appropriately. An alternative in the exercise is to get a list of numbers, and the first one indicates how many more numbers the user will enter. This is awkward and it still has the problem of sizing the array appropriately.

2. Filling an array with user data is part of every exercise, and every time it is rewritten for the next exercise. (_Keep in mind that if you are repeating code, it might be time for a helper function!_)

3. It is necessary for a human to interact with the function to enter in data to test it.

4. It is necessary for a human to visually inspect the output and compare it to the expected results to confirm it is correct. (Well, they do have this automated in that the test compares the output string, but this is NOT the way to create automated testing.)

Let's make this code better!

<hr>

We can address the first two issues above by allowing the user to enter in a series of numbers on a single line, without knowing ahead of time how many numbers there will be.

This code has been provided for you in the LabProgram.java file, although we won't be using it in these test exercises. IMHO, I think this is a better way to accept data from a user.

The next step is to write a function that meets the requirements of the assignment. For example, to find the middle value, you would write a function with the signature `int middle(int[] array)`. It might seem excessive to make a function out of such a simple task, but you will see how easy this is to test!

With these two functions, the zyBook exercise would look like the below code. Look at how easy that is to read!!!

```Java
public class LabProgram {
	public static void main(String[] args) {
		int[] userInput = getUserInput();
		System.out.println("Middle value is "+middle(userInput));
   }
}
```

Finally, we want to make it easier for a human to determine if the output is correct using automated testing that is robust, repeatable, and predictable. We can do this by checking the expected output against the actual output. It might look like this:

```Java
public class LabProgram {
	public static void main(String[] args) {
		// TESTING middle()...
		int[] testOne = {1};
		if (1 != middle(testOne)) {
			System.out.println("middle() not working with {1}. Expect 1. Result "+middle(testOne));
		}
		int[] testTwo = {2,3};
		if (1 != middle(testTwo)) {
			System.out.println("middle() not working with {2,3}. Expect 2. Result "+middle(testTwo));
		}
		/** and so on **/
	}
}
```

Notice that something is printed out only when the program is not working. This makes it very easy to see if something is wrong. Because this print statement is repeated so often, I have created an assert class that we will use throughout the semester. The function we will use for this exercise is:

```
public static void assertEquals(Integer expect, Integer result, String msg) {
	boolean match = true;
	// First test for nulls to avoid Exceptions
	if ((null==expect) && (null!=result)) {
		match = false;
	} else if ((null==expect) && (null==result)) {
		match = true;
	} else if (expect != result) {
		match = false;
	}
	if (!match) {
		System.out.println(msg+" Expect "+expect+". Result "+result);
	}
} // end assertEquals (Integer)
```

The above example will now look like this:

```
int[] testOne = {1};
Assert.assertEquals(1,middle(testOne),"Middle of {1}.");

int[] testTwo = {1,2};
Assert.assertEquals(1,middle(testTwo),"Middle of {1,2}");
```

**"What is the big deal?" you ask.** Well, it isn't such a huge improvement here, but the bigger the function, the more important it is to make testing really easy! (And along the way we improved readability, plus we have a nice, reusable way to get user input that is MODULAR.)

<hr>

### YOUR ASSIGNMENT

The functions and tests have mostly been written for you. There are 4 test cases missing that need the assert statements added -- 2 in middle() and 2 in twoSmallest(). And there is an error in the method inRange -- use the tests to locate the lines of code that are incorrect.
