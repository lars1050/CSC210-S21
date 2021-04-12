/**
*/

public class TestBST {
	public static void main(String[] args) {
		testAdd();
		testFinds();
		System.out.println("\nBST Tests Complete ----\n");
	}

	public static void testAdd() {
		System.out.println("\ntesting order for add ...");

		// Create a new tree with simple objects. Using Simple compareTo
		BST<Simple> numbers = new BST<Simple>();
		numbers.add(new Simple("a",30));
		numbers.add(new Simple("b",10));
		numbers.add(new Simple("c",40));
		numbers.add(new Simple("d",20));
		numbers.add(new Simple("e",5));
		numbers.add(new Simple("f",50));

		// This should print the numbers in sorted order (by default compareTo)
		System.out.println(numbers);

		// Repeat above with a comparator passed in the constructor.
	}

	public static void testFinds() {

		System.out.println("\ntesting find, min, max ...");

		BST<Integer> numbers = new BST<Integer>();

		// Add to the tree
		Integer[] array = {30,10,40,20,50,60,15,5};
		for (Integer el : array) {
			numbers.add(el);
		}
		System.out.println(numbers);

		// Test that everything is in the tree (and is found)
		BinaryNode<Integer> node;
		for (Integer el : array) {
			node = numbers.find(el);
			System.out.println("Find("+el+")"+"="+node.data());
		}

		// Test when not in tree
		System.out.println("Find(100)="+numbers.find(100));
	}
}
