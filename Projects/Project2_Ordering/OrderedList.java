import java.util.Comparator;
import java.util.*;

/** A list of generic type maintained in order. Order is determined by the user providing a Comparator or if none provided, using the compareTo method of type T. This is a DYNAMICALLY SIZED list, meaning that it has no capacity limit. Any type used with this class must implement both Comparable (a Java interface) and Copyable (a made-up interface for this assignment).
*/
public class OrderedList<T extends Comparable<T> & Copyable<T>> {


}
