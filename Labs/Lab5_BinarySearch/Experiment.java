public class Experiment {

	public static void main(String[] args) {

		// Create the objects for comparison.
		Simple a5 = new Simple("a",5);
		Simple b3 = new Simple("b",3);
		Simple c4 = new Simple("c",4);
		Simple d2 = new Simple("d",2);

		// gather into a list to be sorted
		Simple[] list = { b3, d2, c4, a5 };

		System.out.println("\nUNORDERED LIST");
		for (Simple s : list) {
			System.out.print(s);
		}
		System.out.println();

		// Selection sort.
		// find min, place at index 0. find next min, place at index 1, ...
		// i is location of next element to place in order
		for (int i=0; i<list.length;i++) {
			// initialize location of object currently in list[i]
			int minIndex = i;
			// look to the right of this element to see if anything is smaller
			for (int j=i+1; j<list.length; j++) {
				// use the ordering established in Simple to determine ordering.
				if (list[j].compareTo(list[minIndex]) < 0) {
					minIndex = j;
				}
			}
			// place the found min at list[i], swapping places
			Simple temp = list[i];
			list[i] = list[minIndex];
			list[minIndex] = temp;
		} // end selection sort.

		System.out.println("\nORDERED LIST");
		for (Simple s : list) {
			System.out.print(s);
		}
		System.out.println("\n");

	} // end main()
} // end class Experiment
