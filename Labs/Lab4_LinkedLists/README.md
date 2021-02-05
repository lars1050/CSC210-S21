### Lab 4 : Generics and Linked Lists
##### Due Monday, February 8 end-of-day
##### Submit a single zipped file to Moodle

<hr>

#### Learning Outcomes:

- Be able to define a class using Generics.
- Be able to use a generic interface when defining a class.
- Be able to implement a few basic operations of a linked list.

#### General Requirements:

1. Convert `class SongList` of Lab3 to `class ListArray <T>`, which implements `List`
2. Create `class ListLinked <T>`, which implements `List`.
3. Complete the specified operations/methods for LinkedList.
4. Document all code using Javadocs.
5. Document code internally with in-line comments.
6. Verify code using tests from this directory (see guide below).

## SPECIAL RULE: NO FOR-LOOPS! YOU MUST USE WHILE-LOOPS!

<hr>

### Getting Started

This lab fulfills part of the requirements of project 1. For that reason, I recommend that you create a new project in your development environment and refer to it as Project 1 or Project List. There are several files in this lab, so you probably will want to download the files rather than copy and paste. Add to this project your Song and SongList files from Lab 3. Once you fulfill the requirements of Lab 4, keep going! I will only test the methods that are required for this lab during assessment, so it will not matter if you have non-required methods partially or incorrectly implemented at the time of Lab 4 submission. Of course, it will matter the following week when the entire project is due.

<hr>

### Unit Testing

I have created a new set of test files for unit testing. These files allow you to test both your array and linked list implementation with (mostly) the same tests. There is a separate file for each set of behaviors (e.g. searches, adds, removes, and converts). Within each file, a separate method has been created to test the corresponding method in your implementation. For example, in TestSearches there is a method lcoation() that tests only your location method. ALL tests for all methods will run when you run TestList.java.

You can select whether you are testing your array implementation or your linked list implementation by setting the variable _testArray_ in TestList.java. Alternatively, you can select using command-line arguments (if you execute at the command line instead of in your IDE). Before you submit, make sure this TestList file is compiling for both implementations!

My last comment is that this is not likely how you would see this put together in an industry setting. First, you would not create 2 different implementations with the exact same functionality. You would probably use formal testing platforms (like JUnit) rather than this "homegrown" version. You would probably have everything in packages. And you would probably put all the test code in its own directory so that it doesn't clutter the production code. And for "bad" input or erroneous conditions, you would probably be throwing exceptions. It has been structured this way for ease-of-use and ease-of-grading.

### Requirements

## SPECIAL RULE: NO FOR-LOOPS! YOU MUST USE WHILE-LOOPS! 

1. Convert `class SongList` to `class ListArray <T>` which implements the List interface. *FIND AND REPLACE IS YOUR FRIEND!* Add methods as needed to implement the interface. These can be stubs -- they need to be completed for the project but not the lab.

  - Change all comments or variables that refer to songs. 
  - Notice that all `int` types have been changed to `Integer` in the List interface. Change int types in ListArray to match (the one exception is leaving `int i` for your for-loops).
  - Make sure the Sanity Check and Constructor tests are working for ListArray.

2. Add `class LinkedList <T>` which also implements the List interface. It might be easiest to copy the ListArray and remove all use of the array, replacing it with the basic data structure of a linked list.

3. Implement the following methods for a Linked List:
  - length().
  - add(T item). Add an element at the end of the linked list.
  - remove(T item). Remove this element from the list.
  - peek(int index). Return the element at the indicated "index". The head of the list is considered "index" 0.
