### Lab 3 : Building a LIST Abstract Data Type
#### Due Monday, February 1 end-of-day
#### Submit a single zipped file to Moodle

<hr>

Learning Outcomes:

- Be able to implement a _List_ in Java using the basic data structure array.
- Understand the requirements of the primary operations of add, remove, and find, and variants of these operations.
- In Java, be able to implement the primary operations of add, remove, and find, and variants of these operations.
- Use correct syntax to document code with Javadocs.
- Be able to write informative comments in the code to explain the logic.
- Use a test script to verify correctness.

<hr>

Provided Files:

- **Song.java** : class of the objects to be stored using a List
- **SongList.java** : implements the ADT List of songs using an Array
- **TestList.java** : compile and execute this file. It has main()
- **Assert.java** : assertEquals methods to compare expected and actual results

<hr>

## LISTS

The Abstract Data Type (ADT) **_List_** refers to a collection of elements, which is maintained with primary operations that add, remove, find, and sort elements. In your zyBooks reading, they distinguish between a list, bag, and set. I will make no such distinctions and refer to all of them as a list, but I will be specific in whether or not those elements are unique (i.e. a set) or in a sorted order. The operators applied to a list must be explicitly defined, unlike with queues in which elements are added and removed from specific locations.

It is important to have a shared understanding of the ADT List qualities and how the operators modify the list. For this lab:
- The list may have duplicate elements.
- The list is not sorted.
- If no positional information is provided, the `add()` operator will add to the END of the list.
- If positional information is provided, the `add()` operator will add at the INDEX indicated, without overwriting any elements.
- The `remove(index)` operator will remove at the INDEX indicated.
- The `remove(song)` operator will remove the first occurrence of the song.

<hr>

### DOCUMENTATION

1. Add comments to all your methods that describe the logic. These are not Javadocs comments -- they are descriptions provided for someone reading your code so they can follow the intent of your code. Good comments describe the intent of the code, not the code itself. For example,

	```
	// BAD EXAMPLE because the comment states what the code states
	void remove(int index) {
		// IF the index is negative or greater than the count, return
		if (index < 0 || index > count) return;
	}

	// GOOD EXAMPLE because it explains why you are checking the index
	void remove(int index) {
		// if there is no element at the given index, return immediately
		if (index < 0 || index >= count) return;
	}
	```

2. As you are coding, add javadocs comments where appropriate. Documentation for javadocs can be found here:
    - https://www.oracle.com/technetwork/java/javase/documentation/index-137868.html
    - https://www.tutorialspoint.com/java/java_documentation.htm

    _Where Appropriate_ means that ...
    	- all classes have a javadoc comment above its definition
    	- all methods within a class are documented and include @param, @return, etc. as appropriate (the one exception is setters and getters, which are usually self-explanatory thus do not need documentation)
    	- most class members/attributes/fields (pick your favorite vocabulary term) are documented. Most, if not all of these, have been done for you.

3. When complete, generate javadocs and inspect your work. If you are in NetBeans, there is an option to generate Javadoc documentation from the pulldown _Run_ menu. Notice that in-line comments are not part of Javadocs. This is because you are speaking to different audiences!

<hr>

### CODING

> Note that you can call other methods in the class to take advantage of code you already wrote. If you find yourself copying and pasting code, ask yourself if that is what you really want to do, because perhaps you just want to call the function in which that code exists. Or maybe write a private helper function in the class.



#### List Status

4. Implement `isFull()`. Return true if filled to capacity.
5. Implement `isEmpty()`. Return true if no elements in the array.

#### ADD Methods

**All elements must be stored between index 0 and index count-1.**

6. Implement the method `add(Song song)`.
    - If the structure is not full, add to the end of the list. (The _end_ of the list refers to after the last element in the list.)
    - If the structure is full, do not add anything to the list.
    - Maintain the count.

7. Implement the method `add(Song song, int index)`.
    - If the index is invalid (i.e. a location that leaves space between elements or is out of range) or the structure is full, do not add the song to the list.
    - If the structure is not full and the index is valid, add the element at the index indicated.
    - Shift all elements as appropriate.
    - Maintain the count.
		- Note that the user can add at the index _count_.

6. Implement the method `set(Song song, int index)`.
    - If the index is invalid (i.e. a location that does not currently contain an element or is out of array bounds), return without doing anything.
    - This overwrites the current element at index.

#### Search Methods

7. Implement the `peek(int index)` method.
    - If the index is valid, return the element at that index. It should not be removed, just returned.
    - If the index is not valid, return null.

8. Implement the `location(Song song)` method.
    - If the song is in the list, return the index of the first occurrence.
    - If the song is not in the list, return -1.

9. Implement the `contains(Song song)` method.
    - If the song is in the list, return true, else false.

10. Implement the `findTitle(String title)` method.
	- Return the first occurrence of a song with the given title.
	- If there is no song with that title, return null.
	- NOTE: The match should not be case sensitive (i.e. "THE" should match to "the", "The", "tHe", etc.). _See_ https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/String.html.

#### REMOVE Methods

**All elements must be stored between index 0 and index count-1.**

11. Implement the method `remove(int index)`.
    - If the index is invalid, do not remove anything and return null.
    - If there is an element at _index_, remove the element (store it so you can return it).
    - Shift all elements as appropriate so that all elements are stored betweeen index 0 and index count-1;
    - Maintain the count.

10. Implement the method `remove(Song song)`.
    - If the song is in the list (based on equals), remove the first occurrence from the list.
    - Shift all elements as appropriate so that all elements are stored between index 0 and index count-1.
    - This is a _void_ function. There is no need to return the song, because that is what was passed in, so the caller already has it.
    - Maintain the count.

11. Implement the remove method `removeAll()`.
    - "Remove" all songs from the list. (HINT for Efficiency: You do not have to iterate over the array.)

#### CONVERT Method

12. Implement the method `Song[] toArray()`.
    - Return an array containing all songs in the list.
    - The length of the array should be the number of items stored.
    - If the List is empty, return null.

#### SONG EQUALS

13. Override the `equals` method for Song. See this site for a reference: https://www.geeksforgeeks.org/overriding-equals-method-in-java/. Note that the input parameter is _Object_ not _Song_.

<hr>

#### Assessment:

Grades will be given as A,B,C,D with the numerical equivalence of 95, 85, 75, 65. "F" is not listed because that will be addressed on an individual basis depending on how much of the lab was completed.

The rubric is as follows:

- A : All code components complete, correct, and compiling. Javadocs complete. In-line comments provided in code.
- B : Few code components incomplete or incorrect, Javadocs incomplete, and/or no comments in code.
- C : Many code components or error messages incomplete or incorrect, and/or Javadocs incomplete, and/or code is not commented.
- D : Minimal additions to the code.

To be graded, the file TestList must compile. If it does not compile, it is an automatic deduction of 5% and it will be returned to you to fix it. **CODE WILL NOT BE GRADED (and will receive a 0) UNTIL IT COMPILES.**

#### Addendum

If all your tests pass, you will see the following output:

```
Sanity check test of add, length, peek.
If these initial tests do not pass, the rest of the tests are irrelevant!


Sanity Check complete!


Testing SongList constructor ...


Testing SongList search methods ...
------------testing peek()
------------Testing location()
-------------Testing findTitle()
--------------Testing contains()


Testing SongList add methods ...
--------------add(Song)
--------------add(song, index)
--------------set(Song, index)


Testing SongList remove methods ...
--------------remove(Song)
--------------remove(index)
--------------removeAll()


Testing SongList convert methods ...
--------------Testing toArray()
```
