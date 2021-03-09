## Project 2 Ordered List
## DUE THURSDAY, April 1 (no foolin!) end-of-day
#### Zip all files and submit via Moodle

<hr>

In this project, you will be building on previous labs to create a complete OrderedList class. This list class will make use of Comparators to find, add, and sort elements.

The data of Olympians was obtained from kaggle.com, which has many many databases that you can download for free.

<hr>

### OrderedList Class Comparator and Sorting

Create a class variable `Comparator<T> orderBy` to store the default order of the stored class. The array _items_ should always be sorted according to this class comparator. In any method in which a comparator is not passed, the sortOrder comparator should be used.

Initialize `Comparator<T> orderBy` to a Comparator<T> whose compare method calls the `compareTo` method of the class type T.

>NOTE: declare and define all Comparators in the file Orderings.java so I can easily find and review them.

In class Ordering, create a Comparator<Olympian> that compares 2 Olympians for each of the fields listed below. Use the names.
- `orderByName` : last name with first as tie-breaker
- `orderBySport` : no tie-breaker
- `orderByCountry` : year as tie-breaker

### Using Keys

In class Olympian, create a Comparator<Object> comparator that uses a key value to test against a class object for each of the fields.These will be used to query the list using values of key fields. Use the name listed below and **throw an exception if the objects passed are not the correct type**.

- `queryByMedal`
- `queryByYear`
- `queryBySeason`
- `queryByCity`

### Olympian

One required modification to Olympian is to implement the Copyable interface. This will be the only way that you can use it in your list.

### Dynamic Array

Dynamic arrays are arrays that expand as needed without limits. Use a default array size of 100 when first initialized, but at any point, if more elements need to be added, then increase the array size by 100. To do this, you will need to create a new larger array then copy everything over.

### Methods

Open index.html in the docs folder in your web browser.

See  https://htmlpreview.github.io/?https://github.com/lars1050/CSC210-S21/blob/main/Projects/Project2_Ordering/docs/index.html

Documentation (from Javadocs) has been provided for you to describe each of the methods of the class. You determine the implementation. Please LET ME KNOW if you need clarification on any of the descriptions.

You can implement in whichever way you think is appropriate EXCEPT, you must meet the following implementation requirements:

- Member variables are private and methods are public UNLESS they are only used internally in the class.

- Use an array to implement. Start with size 100. If ever the array is full, increase the size by 100. USE A STATIC variable to define this default value.

- Use BINARY SEARCH for the find method. It can be recursive or iterative.

- Create a private sort method. It can have any signature that you think is appropriate. It will be called from the reorder method. It will probably also be useful in the toArray(Comparator) method.

- Use your sort method in the reorder method. The reorder takes in a Comparator, then must reorder the list according to the Comparator.

- Create a Comparator<T> named `orderBy`. The default (i.e. if the user did not pass a Comparator) should use the compareTo method of T.

- Where listed, you must use the interface Copyable to copy the list or parts of the list where specified.


### Documentation

Javadocs and in-line comments. You know what to do!

### Testing

A minimal test file will be provided. There is one posted now, but more will be added to ensure that at least you have all the methods defined.

**IT IS UP TO YOU TO TEST YOUR CODE** and make sure it works. I will not assess your tests -- only your OrderedList, Orderings, and Olympian code.

### ASSESSMENT


> You must earn 60%+ on this project to pass the course. You will be given the opportunity to rework the project until it meets the threshold.
