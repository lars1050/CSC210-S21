### Lab 7 : A Pseudo Database
#### Due Monday, March 8 end-of-day
#### Submit a single zipped file to Moodle

#### Submit InLab Google Form: https://forms.gle/mPRcm5QJfGSz7uyk6

<hr>

### Learning Outcomes:

- Be able to write a Comparator that uses a key value.
- Be able to use the Comparator to find elements within the database.
- Devise a test of your code.

<hr>

### COMPARATORS

Define the following Comparators and make sure they are working:

- Comparator\<Student\> `byDefault` using Student compareTo to compare 2 Students.
- Comparator\<Student\> `byLast` comparing last names of 2 Students.
- Comparator\<Object\> `keyFirst` comparing firstName to Student object.
- Comparator\<Object\> `keyMajor` comparing a major to Student object.
- Comparator\<Object\> `keyYear` comparing graduation year to Student object.


### METHODS

Complete the following methods and make sure they are working. All of these methods are using a linear search of the array.

- int find(T item);	// use equals for comparison
- T findLessThan(T item, Comparator\<Student\> orderBy)
- T findKey(Object key, Comparator\<Object\> byKey);
- T[] findAll(Object key, Comparator\<Objec\t> byKey);
- T findKeyOr(Object key1, Comparator\<Object\> byKey1, Object key2, Comparator<Object> byKey2);
- T findKeyAnd(Object key1, Comparator\<Object\> byKey1, Object key2, Comparator<Object> byKey2);

### DOCUMENTATION

As always, Javadocs and inline comments are part of the requirements. You only need to document Database.java.

<hr>

#### Assessment:

Grades will be given as A,B,C,D with the numerical equivalence of 95, 85, 75, 65. "F" is not listed because that will be addressed on an individual basis depending on how much of the lab was completed.

The rubric is as follows:

- A : All code components complete, correct, and compiling. Javadocs complete. In-line comments provided in code.
- B : Few code components incomplete or incorrect, Javadocs incomplete, and/or no comments in code.
- C : Many code components or error messages incomplete or incorrect, and/or Javadocs incomplete, and/or code is not commented.
- D : Minimal additions to the code.

> To be graded, your code must compile (using the specified names in the requirements above for all methods and comparators).
