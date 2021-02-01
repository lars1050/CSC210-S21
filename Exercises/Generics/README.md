## Generics Exercise

When you define a super class, you are identifying which elements are in common across all subclasses. This is very efficient, because you only have to write the code 1 time and the subclasses can make use of it.

Generics have a similar utility. You can define the logic once, but it can be applied to a variety of classes. You have already used generics -- probably without realizing it. `ArrayList<Transaction>` is the class `ArrayList` which has logic that can be applied to any type specified by the user. The type placed between the less-than and greater-than symbol is the type the logic will be applied to.

In this exercise, we will start with items, then create some classes that duplicate the functionality. Then we will create a generic version that can be used with any class.

You will create:
- `class ItemsInt` modeled after the Items class.
- `class ItemsSimple` modeled after the Items class.
- `class ItemsG` using generics and modeled after the Items class

Submit Google form at end of class (regardless of how far you got): 
https://forms.gle/fVtj3Ftvqgu3GXdFA

<hr>

## Some Details

You can use any variable name to represent the type in the class definition. Typcially, you will see `T` used (e.g. `public class Items <T>`). This variable can be used anywhere that you would use a type (e.g. `T value=null;`, `public T myfun();`, or `public myfun2(T param);`). 

You cannot create an array of type T[]. You have to create an array of type Object then cast it with (T[]).

You cannot use a non-Object type (e.g. int, integer, double) with Generics. For numerical values, use Integer, Double, etc.

When you declare an object of a class using Generics, be sure to specify the type (e.g. `ArrayList<Integer> list`, but not `ArrayList list`). The compiler might let you _not_ specify the type and issue a warning, but the code will probably have issues when it runs.

<hr>

## Resources

- Ch. 26 in zyBooks (due Tuesday before lab)
- https://www.tutorialspoint.com/java/java_generics.htm
- https://www.baeldung.com/java-generics 

