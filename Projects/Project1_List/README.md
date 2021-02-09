### Project 1 : List implemented 2 ways
##### Due Monday, February 15 end-of-day
##### Submit a single zipped file to Moodle
##### Complete the Required Google Form

<hr>

#### Learning Outcomes:

- Be able to define a class using Generics.
- Be able to use a generic interface when defining a class.
- Be able to implement an ADT List using a singly linked list.
- Be able to implement an ADT List using an array.

#### General Requirements:

1. Complete ALL methods in ListLinked (implements interface List).
2. Complete ALL methods in ListArray (implements interface List).
3. Document all code using Javadocs.
4. Document code internally with in-line comments.
5. Verify code using tests from this directory (see guide below).
6. Complete the google form.

### SPECIAL RULE: NO FOR-LOOPS in the linked list! YOU MUST USE WHILE-LOOPS!
#### EXCEPT if you are iterating over an array that was passed in (e.g. in `addUnique(T[] array)` and `toArray(T[] array)`).

> My apologies for not adding the "in the linked list" part! **You can keep your for-loops in the arrays, but not in linked lists.** 

<hr>

### Getting Started

There is no need to start a new project, instead modify a couple of files (I think just the 2 below, but if you think I forgot to provide some tests, please let me know!). I have included Song, List, and Assert for reference. These have not changed from previous labs.

Comment out the Lab 4 test and uncomment all the others in _TestList.java_. I do recommend uncommenting only 1 at a time so you can focus on one type of operation at a time.

```Java
//testLab4(testArray);
/***************************************************************** */
/********************* UNCOMMENT THESE AS YOU COMPLETE THE PROJECT */
testSearches();
testAdds(testArray);
testRemoves();
testConvert();
```

Modify the removeDuplicates test. You can copy and paste into the file.

```Java
// -------------------------------   removeDuplicates     --------------------
// -------------------------------------------------------------------
public static void removeDuplicates() {
	System.out.println("---Testing removeDuplicates() ...");
	List<Integer> list = null;

	// Test an empty list.
	list = TestList.constructList(list,5);
	list.removeDuplicates();
	Assert.assertEquals(0,list.length(),"remove dups from empty");

	// Test a list with 1 element.
	list.add(5);
	list.removeDuplicates();
	Assert.assertEquals(1,list.length(),"remove dups from {5} (length)");
	Assert.assertEquals(5,list.peek(0),"remove dups from {5}");

	// Test a list with 2 elements - no duplicates.
	list.add(4);	// list = {5,4}
	list.removeDuplicates();
	Assert.assertEquals(2,list.length(),"remove dups from {5,4} (length)");
	Assert.assertEquals(5,list.peek(0),"remove dups {5,4} at 0");
	Assert.assertEquals(4,list.peek(1),"remove dups {5,4} at 1");

	// Test a list with 3 elements - no duplicates.
	list.add(3);	// list = {5,4,3}
	list.removeDuplicates();
	Assert.assertEquals(3,list.length(),"remove dups from {5,4,3} (length)");
	Assert.assertEquals(5,list.peek(0),"remove dups {5,4,3} at 0");
	Assert.assertEquals(4,list.peek(1),"remove dups {5,4,3} at 1");
	Assert.assertEquals(3,list.peek(2),"remove dups {5,4,3} at 2");

	// Test a list with 5 elements - duplicates at end. {5,4,3,5,5}
	list = TestList.constructList(list,5);
	list.add(5);
	list.add(4);
	list.add(3);
	list.add(5);
	list.add(5);
	list.removeDuplicates();
	Assert.assertEquals(3,list.length(),"remove dups from {5,4,3,5,5} (length)");
	Assert.assertEquals(5,list.peek(0),"remove dups {5,4,3,5,5} at 0");
	Assert.assertEquals(4,list.peek(1),"remove dups {5,4,3,5,5} at 1");
	Assert.assertEquals(3,list.peek(2),"remove dups {5,4,3,5,5} at 2");

	// Test a list with 5 elements - duplicates at front. {5,5,5,2,1}
	list = TestList.constructList(list,5);
	list.add(5);
	list.add(5);
	list.add(5);
	list.add(2);
	list.add(1);
	list.removeDuplicates();
	Assert.assertEquals(3,list.length(),"remove dups from {5,5,5,2,1} (length)");
	Assert.assertEquals(5,list.peek(0),"remove dups {5,5,5,2,1} at 0");
	Assert.assertEquals(2,list.peek(1),"remove dups {5,5,5,2,1} at 1");
	Assert.assertEquals(1,list.peek(2),"remove dups {5,5,5,2,1} at 2");

	// Test a list with 7 elements - duplicates in middle. {1,5,2,5,3,5,4}
	list = TestList.constructList(list,7);
	list.add(1);
	list.add(5);
	list.add(2);
	list.add(5);
	list.add(3);
	list.add(5);
	list.add(4);
	list.removeDuplicates();
	Assert.assertEquals(5,list.length(),"remove dups from {1,5,2,5,3,5,4} (length)");
	Assert.assertEquals(1,list.peek(0),"remove dups {1,5,2,5,3,5,4 at 0}");
	Assert.assertEquals(5,list.peek(1),"remove dups {1,5,2,5,3,5,4} at 1");
	Assert.assertEquals(2,list.peek(2),"remove dups {1,5,2,5,3,5,4} at 2");
	Assert.assertEquals(3,list.peek(3),"remove dups {1,5,2,5,3,5,4} at 3");
	Assert.assertEquals(4,list.peek(4),"remove dups {1,5,2,5,3,5,4} at 4");

	// Test a list - multiple duplicates. {1,5,1,2,5,3,5,3}
	list = TestList.constructList(list,10);
	list.add(1);
	list.add(5);
	list.add(1);
	list.add(2);
	list.add(5);
	list.add(3);
	list.add(5);
	list.add(3);
	list.removeDuplicates();
	Assert.assertEquals(4,list.length(),"remove dups from {1,5,1,2,5,3,5,3} (length)");
	Assert.assertEquals(1,list.peek(0),"remove dups {1,5,1,2,5,3,5,3} at 0}");
	Assert.assertEquals(5,list.peek(1),"remove dups {1,5,1,2,5,3,5,3} at 1");
	Assert.assertEquals(2,list.peek(2),"remove dups {1,5,1,2,5,3,5,3} at 2");
	Assert.assertEquals(3,list.peek(3),"remove dups {1,5,1,2,5,3,5,3} at 3");

	} // end removeDuplicates
```

<hr>

### Code Requirements

#### SPECIAL RULE: NO FOR-LOOPS IN THE LINKED LISTS! YOU MUST USE WHILE-LOOPS!
#### EXCEPT if you are iterating over an array that was passed in (e.g. in `addUnique(T[] array)` and `toArray(T[] array)`).

> My apologies for not adding the "in the linked list" part! **You can keep your for-loops in the arrays, but not in linked lists.** 

> You may not use any code from the web as part of your solution for any part of this project!! The one exception is the pseudocode that is in your zyBooks textbook. I will ask you to both read and write code that operates on arrays and linked list on the exam (guaranteed!), so you will have a hard time doing that on the exam if you don't practice it with this project.

Complete all the methods that are part of the List interface The requirements are the same as they were given for Lab 3. The following are new and should be implemented for BOTH arrays and linked lists.

- `addUnique(T[] array)` : add the elements in the array to the list UNLESS it is already in the list, then don't add it. If the list is full but you still have more to add, then ignore the rest of the array and return.

- `lastLocation(T item)` : return the location of the last occurrence of the item in the list.

- `removeDuplicate()` : remove any duplicate items in the list **without copying the list** into a new structure. This is a very hard method to write! I suggest you do this after you have everything else done so you don't waste too much time trying to write it then debug it. You can still get an A as long as you give it a try -- even if it doesn't work.

- `toArray(T[] array)` : as long as all of the elements in the List can fit into the array, then copy them into the array, maintaining their order. If they don't fit, don't copy anything over.

> Remember to set the variable `testArray` at the top of _TestList.java_ to test both your ListArray code and your ListLinked code!! If it is true, you are testing the ListArray class. If it is false, you are testing the ListLinked class.

### Documentation requirements

- Javadocs including method descriptions and param and return descriptions, as appropriate.

- In-line comments -- describe the outcome or intent of the code, not the code.

- Google Form: https://forms.gle/S7C1GXNiApUPR64M6

	It is standard practice in industry that projects contain readme's and that you provide a regular report of the status of the code to your project manager. This Google form will stand in for that type of communication.


### Assessment

> This project is worth 15% of your overall course grade.

Here are the rules so that you and I have a clear understanding of the expectations ...

**If you present work as your own, but you paid someone to do it, or it was copied from the web or a book, or you got it from a friend, or from a friend's homework from last semester, or from your mother, or from anyone else, then you will be given a 0 on this assignment and potentially receive an F for the course. And it will be reported to the dean.**

**If you are asked to describe your solution but you cannot explain your code, then you might receive a 0 on this assignment.**

**You must earn at least 65% on this project to pass the course.** If you do not reach that threshold, you will be given an opportunity to work on it until you do reach that threshold (and you can seek my help to get it there). However, the grade you earned at the time of submission will be the one used to calculate your grade for the course.

**There is no opportunity to extend the deadline without penalty for this project.** Late submissions will incur a 5% deduction for every day it is late.

To be graded, the file TestList must compile for both ListArray and ListLinked. If it does not compile, it is an automatic deduction of 5% and it will be returned to you to fix it. **Code will not be graded (and will receive a 0) until it compiles.** I am available to help if you are struggling to get it to compile.

<hr>

**It is your responsibility to test your code and to make sure it is passing the tests provided for both ListArray and ListLinked.** Please give yourself enough time to seek help if you are having a hard time debugging your code.

Grades will be given as A,B,C,D with the numerical equivalence of 95%, 85%, 75%, 65%. "F" is not listed because that will be addressed on an individual basis depending on how much of the lab was completed.

The rubric is as follows:

- A : All methods complete and compiling. Nearly all are correct. Javadocs complete. In-line comments complete and meaningful. Google form submitted.
- B : All methods complete and compiling. Some are not correct OR documentation is missing or insufficient (or a combination of incorrect code and insufficient documentation).
- C : Some methods not complete and/or not correct. And documentation is not sufficient.
- D : Minimal additions to the code.
