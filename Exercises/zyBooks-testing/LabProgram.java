import java.util.Scanner;

class LabProgram {
	public static void main(String[] args) {
		test_middle();
		test_twoSmallest();
		test_inRange();
		System.out.println();
	}
	// --------------------------------------------------------------------
	// ------------------   The 3 functions to be tested ------------------/
	// --------------------------------------------------------------------
	/** Value in middle of array. Use truncation if even number
	* @param Array. Assume not null.
	* @return value at middle (lower index if even number of elements).
	*/
	public static int middle(int[] A){
		return A[ (A.length-1)/2 ];
	}



	/** Create new array of all values that are inclusively in range. The array should be the exact size of the number of elements in range.
	* @param A int array
	* @param min lower bound
	* @param max upper bound
	* @return array of same size as A containing only those values in range.
	*/
	public static int[] inRange(int[] A, int min, int max) {
		int count = 0;
		for (int el : A) {
			if (min < el && el <= max) {
				++count;
			}
		}
		if (0==count) {
			return null;
		}
		int[] results = new int[count];
		int resultsIdx = 0;
		for (int el : A) {
			if (min < el && el <= max) {
				results[resultsIdx] = el;
				++resultsIdx;
			}
		} // end for loop
		return results;
	} // end inRange()


	/** Find the 2 smallest elements in the array (assume at least 2 elements)
	* @param A int array
	* @return 2 element array of 2 smallest ints IN ORDER
	*/
	public static int[] twoSmallest(int[] A) {
		// assume there are at least 2 ints in the array.
		int[] results = { A[0], A[1] };
		if (A[1] < A[0]) {
			results[0] = A[1];
			results[1] = A[0];
		}
		for (int i=2; i<A.length; i++) {
			if (A[i] <= results[0]) {
				results[1] = results[0];
				results[0] = A[i];
			} else if (A[i] < results[1]) {
				results[1] = A[i];
			}
		} // end for loop
		return results;
	} // end twoSmallest()


	// --------------------------------------------------------------------
	// ------------  AUTOMATED TESTS for the 3 functions ------------------
	// --------------------------------------------------------------------

	/** Automated test of middle(int[] A) : returns middle element */
	public static void test_middle() {
		System.out.println("\nTesting middle ...");

		int[] testOne = {1};
		Assert.assertEquals(1,middle(testOne),"Middle of {1}.");

		int[] testTwo = {1,2};
		Assert.assertEquals(1,middle(testTwo),"Middle of {1,2}");

		// @FINISH THIS ONE!!
		int[] testThree = {1,2,3};

		// @FINISH THIS ONE TOO!!
		int[] testFour = {1,2,3,4};
	}

	/** Automated test of inRange(int min, int max, int[] array) :
	returns new array containing elements of array in range of min and max
	*/
	public static void test_inRange() {
		System.out.println("\nTesting inRange ...");

		int[] results;

		int[] testArray = {1,2,3,4};

		results = inRange(testArray,5,7);
		if (null != results) {
			System.out.println("Nothing in range. Expected null.");
		}

		results = inRange(testArray,2,2);
		if (null == results) {
			System.out.println("One value in range. Expect 1. Results null.");
		} else {
			Assert.assertEquals(1,results.length,"One value in range - size.");
			if (1 <= results.length) {
				Assert.assertEquals(2,results[0],"One value in range - value.");
			}
		}

		results = inRange(testArray,3,4);
		if (null == results) {
			System.out.println("2 vals in range. Expect size 2. Results null.");
		} else {
			Assert.assertEquals(2,results.length,"2 values in range - size.");
			if (2 <= results.length) {
				Assert.assertEquals(3,results[0],"2 values in range - value.");
				Assert.assertEquals(4,results[1],"2 values in range - value.");
			}
		}
	}

	/** Automated test of itwoSmallest(int[] array) :
	returns new array containing the 2 smallest elements of array
	*/
	public static void test_twoSmallest() {
		System.out.println("\nTesting twoSmallest ...");

		int[] results;

		int[] testFront = {2, 1, 5, 4, 3};
		results = twoSmallest(testFront);
		Assert.assertEquals(1,results[0],"Smallest at pos 1.");
		Assert.assertEquals(2,results[1],"2nd smallest at pos 2.");

		// @FINISH THIS ONE.
		int[] testEnd = {5, 2, 3, 1, 0};
		results = twoSmallest(testEnd);

		// @FINISH THIS ONE TOO.
		int[] testMiddle = { 5, 9, 7, 4, 10, 2, 8};
		results = twoSmallest(testMiddle);

	} // end test_twoSmallest

	// --------------------------------------------------------------------
	// ------------  getUserInput fn and print out  -----------------------
	// --------------------------------------------------------------------
	/** Asks user to input integers to store in the returned array */
	public static int[] getUserInput() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter numbers separated by space: ");
		String line = scanner.nextLine();
		String[] tokens = line.split(" ");
		int length = tokens.length;
		int[] numbers = new int[length];
		for (int i=0; i<tokens.length; i++) {
			numbers[i] = Integer.valueOf(tokens[i]);
		}
		return numbers;
	}
	/** Visual inspection to test the results of getUserInput() */
	public static void test_getUserInput() {
		int[] input = null;
		input = getUserInput();
		for (int el : input) {
			System.out.print(el+" ");
		}
		System.out.println();
	}
} // end class Main
