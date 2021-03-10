import java.util.Random;

// CAN



/** Sort stuff */
public class Main {


	/**  random number generator, seeded with 10 for reproducability */
	static Random rng = new Random(10);

	/**  The maximum value to be stored in an array */
	static int maxValue = 100;

	public static void main(String[] args) {

		// the array to be sorted
		int[] array = new int[20];

		// set true/false to test your code
		boolean testSelection = true;
		boolean testInsertion = true;

		if (testSelection) {

			System.out.println("\nTESTING SELECTON SORT");

			// Fill the array with random numbers
			array = new int[10];
			// numerical values will be in range 0 to maxInt
			for (int i=0; i<array.length; i++) {
				array[i] = rng.nextInt(maxValue);
			}

			// The original
			System.out.print("BEFORE ");
			for (int n : array) {
				System.out.print(n+" ");
			}
			System.out.println();

			Sort.selection(array);

			// Check the results
			System.out.print("AFTER  ");
			for (int n : array) {
				System.out.print(n+" ");
			}
			System.out.println();
		} // end testSelection

		if (testInsertion) {

			System.out.println("\nTESTING INSERTION SORT");

			// Fill the array with random numbers
			array = new int[10];
			// numerical values will be in range 0 to maxInt
			for (int i=0; i<array.length; i++) {
				array[i] = rng.nextInt(maxValue);
			}

			// The original
			System.out.print("BEFORE ");
			for (int n : array) {
				System.out.print(n+" ");
			}
			System.out.println();

			Sort.insertion(array);

			// Check the results
			System.out.print("AFTER  ");
			for (int n : array) {
				System.out.print(n+" ");
			}
			System.out.println();
		} // end testInsertion

	} // end main()
} // end class Main
