### Lab 6 : Comparators
##### Due Monday, March 1 end-of-day
##### Submit a single zipped file to Moodle

<hr>

#### General Requirements:

1. Implement comparators to order students by name, by major, and by year.
2. Use a Comparator in your OrderedList.
2. Document your code.
3. Test your code.

<hr>

> It might be time to clean up your Netbeans! Overwhelmed by the many, many project folders in your left sidebar? Right-click the project folder icon and choose to close it. Or maybe you want the folder out of your IDE! Navigate to your NetBeansProjects folder and move old projects out into a backup folder outside the NetBeansProjects folder.

### Your Assignment

In this assignment, you will use the interface Comparator to give the user the option to order Students in various ways. This will replace the switch-statement that you put in the compareTo method in class Student. 

Here is an example of a Comparator for a Simple class that has a String and an Integer component:

```Java
public static class byAlpha implements Comparator<Simple> {
	@Override
	public int compare(Simple s1, Simple s2) {
		return s1.alpha().compareTo(s2.alpha());
	}
}
```

The declarations of lists described in the directions below only establish that these elements exist with the correct signature and/or name, but do not test their functionality. In this and future assignments, it is up to you to determine if your code is working. You will not be assessed on your tests (I won't even look at them), but you will be assessed on the complete and correct behavior of your code.

To get started, copy your Lab 5 into a new project. _If you did not get Lab 5 working, please let me know ASAP and I will get you a working version._ Make the following modifications to this new project.

**In the class Student**

1. Change the compareTo method to only compare IDs.

2. Delete the enum Order and orderBy variable.

2. Implement a `public static Comparator<Student> byName` that orders items by last name, with the first name as a tie breaker. Please DECLARE and DEFINE the comparator in a single statement. This is slightly different from the example shown above.

	**In the class MAIN**

3. Implement a `public static Comparator<Student> byYear` that orders items by year of graduation, with number of credits as a tie breaker. Please DECLARE and DEFINE the comparator in a single statement. 

4. Implement `public static class byMajor implements Comparator<Student>` that orders by Major with year of graduation as tie breaker.

	**In the class OrderedList**

5. Declare a `private Comparator<T> orderBy = null;` variable.

6. Copy the OrderedList constructor that has the size parameter. Add the input parameter `Comparator<T> order` to the copy. In the constructor body, set the OrderedList member variable _orderBy_ = to this input parameter.

7. Modify add() and the find methods to make use of the orderBy comparator. HOWEVER, if the orderBy comparator is null, then use the compareTo method of the T class.

	**In the function main**

8. Declare an OrderedList passing a size and the byName Comparator:

	`OrderedList list = new OrderedList(5, Student.byName);`

9. Declare an OrderedList passing a size and the byYear Comparator:

	`OrderedList list2 = new OrderedList(5, byYear);`

10. Declare an OrderedList passing a size and the byMajor Comparator:

	`OrderedList list3 = new OrderedList(5, new byMajor());`

11. Test your code in whatever way you want to test it.

<hr>

### Documentation

Documentation is an essential part of coding. It is hard to imagine having a job in which you are not part of a team with everyone contributing to the project. This means that others will be using and reviewing your code. And it will be important that they can understand it well enough to use it properly and to modify as needed. The first requires good Javadocs documentation and the second requires good in-line commenting.

Writing code is like writing anything else -- if it is well organized, your reader can better understand the content. There is something called a _Style Guide_ that outlines naming conventions, spacing, indentation, code formatting, etc. for a given language, which when followed, keeps code organized and easy to read. Your company will likely use either a published guide (e.g. https://google.github.io/styleguide/javaguide.html) or its own guide. There are even tools (sometimes referred to as Linters) that check if your code is in compliance with the style guide.

At a minimum, try to follow these rules related to code style:
- Comment your code to explain the logic.
- Use good naming conventions that describe the variable/method/class.
- Keep indentation consistent (learn how to auto indent in your editor).
- Be consistent and minimalistic with your spacing (between items and between lines).
- Remove code that is no longer relevant (it is okay to keep debugging statements or alternative logic in your code, but commented out).
- Group similar functioning code together, possibly labelling sections to easily find things.

And this is a friendly reminder that documentation is _part_ of the coding process, and it can help you think through the logic. Besides the fact that it is probably more efficient to comment as you are coding, not as an afterthought (when you have already forgotten why you wrote that line of code!).

<hr>

### Assessment

Grades will be given as A,B,C,D with the numerical equivalence of 95, 85, 75, 65. "F" is not listed because that will be addressed on an individual basis depending on how much of the lab was completed.

The rubric is as follows:

- A : All code components complete, correct, and compiling. Javadocs complete. In-line comments provided in code.
- B : Few code components incomplete or incorrect, Javadocs incomplete, and/or no comments in code.
- C : Many code components or error messages incomplete or incorrect, and/or Javadocs incomplete, and/or code is not commented.
- D : Minimal additions to the code.

To be graded, your code must compile. If it does not compile, it is an automatic deduction of 5% and it will be returned to you to fix it. **CODE WILL NOT BE GRADED (and will receive a 0) UNTIL IT COMPILES.**

### Resources

- https://docs.oracle.com/javase/8/docs/api/java/util/Comparator.html
- https://www.geeksforgeeks.org/comparator-interface-java/
- https://www.tutorialspoint.com/java/java_using_comparator.htm
- https://www.baeldung.com/java-comparator-comparable
- https://www.geeksforgeeks.org/comparator-interface-java/
- https://learn.zybooks.com/zybook/AUGSBURGCSC210LarsonSpring2021/chapter/26/section/1
