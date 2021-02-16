### Lab 5 : Iteration, Recursion, and Binary Search
##### Due Monday, February 22 end-of-day
##### Submit a single zipped file to Moodle

##### DUE TODAY, February 16 in-lab exercises. Submit Google form.

<hr>

#### General Requirements:

1. In-lab: exercise to learn about compareTo
2. In-lab: fix add in OrderedList, write equals and compareTo (last name ordering only) in Student.
3. findIterative method in OrderedList using binary search.
4. find (recursive) method in OrderedList using binary search.
5. Documentation: Javadocs and in-line comments

<hr>

### Your Assignment

IN LAB (as much as you can get done)
- Complete portion of Google form related to Experiment.java
- Fix the add method.
- Test the add method with numbers (TestNumbers.java).
- Implement equals in Student.
- Implement compareTo in Student based on last name (**see description below**).
- Test the add method with Student (TestStudents.java). Only the last name ordering will be correct.
- Fill in compareTo method on the Google form.
- Fill in add method on the Google form.

SUBMIT Google form by end-of-lab.

_Feel free to keep going if you have time in lab ... Or let me know you are done and be on your way._

BY DUE DATE
- Complete list above if not done by end of lab.
- Write in-line comments and Javadocs (this is listed first for a reason :-)
- Complete compareTo implementation for ordering by graduation year and major.
- Test add with Student and these orderings (TestStudents.java)
- Implement findIterative.
- Implement find (recursive).
- Test with Integer and Student.

> Note that you will not receive any credit for using a linear search in your find or an add that simply adds to the end of the array.

_I paid special attention to the in-line comments to model good commenting. Please look through them. A good programming habit is to think through the problem, write out the logic in comments, and THEN write the code._

**Ordering for class Student**

For the compareTo method in Student, write 4 cases for ordering (you can use a switch-statement). In the method, use the version specified by the orderBy variable, which should be one of the Order enumerated values. ID is the default ordering.

- last name (LAST): order by lastName, then firstName as tie-breaker.
- year of graduation (YEAR): order by yearOfGrad, then credits as tie-breaker.
- major (MAJOR): order major, then year as tie-breaker.
- id (ID): unique. no tie-breaker needed.

> NOTE: this is not how you should do this, but I have not yet shown you the correct (more complicated) way, so we are doing it like this until I teach you the other.

### Assessment

Grades will be given as A,B,C,D with the numerical equivalence of 95, 85, 75, 65. "F" is not listed because that will be addressed on an individual basis depending on how much of the lab was completed.

The rubric is as follows:

- A : All code components complete, correct, and compiling. Javadocs complete. In-line comments provided in code.
- B : Few code components incomplete or incorrect, Javadocs incomplete, and/or no comments in code.
- C : Many code components or error messages incomplete or incorrect, and/or Javadocs incomplete, and/or code is not commented.
- D : Minimal additions to the code.

To be graded, the file TestList must compile. If it does not compile, it is an automatic deduction of 5% and it will be returned to you to fix it. **CODE WILL NOT BE GRADED (and will receive a 0) UNTIL IT COMPILES.**
