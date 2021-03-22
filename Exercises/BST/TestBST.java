/**

Add has been completed for you but it is buggy!

Place a breakpoint at the indicated line.

In your breakout session, have one person run the debugger while another person draws the tree. DO NOT CHANGE THE CODE until you have drawn the complete (incorrect) tree. Then see if you can fix the code. Confirm by tracing through the debugger.

HAND IN:
- The drawing of the incorrectly constructed tree.
- The corrected code.

If you finish that, you can start to develop the code for the following:
- find (iterative or recursive)
- toString (recursive). This should create an ORDERED list.

Use the zyBooks to help you form the methods.
*/


public class TestBST {
	public static void main(String[] args) {
		testAdd();
		testFind();
		System.out.println("\nBST Tests Complete ----\n");
	}

	public static void testAdd() {

		System.out.println("\ntesting order for add ...");

		// Create a new list
		BinarySearchTree<Integer> numbers = new BinarySearchTree<Integer>();

		// Add some numbers
		numbers.add(30);
		numbers.add(10);
		numbers.add(40);
		numbers.add(20);
		numbers.add(5);
		numbers.add(50);

		/* TODO: Breakpoint here to draw constructed tree */
		System.out.println(numbers);
	}

	public static void testFind() {

		System.out.println("\ntesting find ...");

		BinarySearchTree<Integer> numbers = new BinarySearchTree<Integer>();

		// Add to the tree
		Integer[] array = {30,10,40,20,50,60,15,5};
		for (Integer el : array) {
			numbers.add(el);
		}
		System.out.println(numbers);

		// Test that everything is in the tree (and is found)
		Integer data;
		for (Integer el : array) {
			data = numbers.find(el);
			System.out.println("Find("+el+")"+"="+data);
		}

		// Test when not in tree
		System.out.println("Find(100)="+numbers.find(100));
	}
}
