public class main {

    public static void main(String[] args) {
		testDoubles();
		testInts();
		testSimple();
	}

	public static void testDoubles() {

			System.out.println("\n -------------- TESTING DOULBES ");

			double[] dups = { 1.0, 2.0, 3.0, 1.0, 2.0, 3.0 };
			double[] nodups = { 1.0, 2.0, 3.0, 4.0, 5.0, 6.0 };

			Items items = new Items();

			System.out.println("\n________ FIRST TEST WITH DUPLICATES _____");

			items.add(dups);

			System.out.println(items);
			System.out.println("The middle is "+items.middle());
			System.out.println("Duplicate of 2.0? "+items.duplicate(2.0));
			System.out.println("A Set? "+items.set());
			items.removeDuplicates();
			System.out.println("After remove: "+ items);
			System.out.println("The middle is "+items.middle());
			System.out.println("Duplicate of 2.0? "+items.duplicate(2.0));
			System.out.println("A Set? "+items.set());


			System.out.println("\n________ SECOND TEST WITHOUT DUPLICATES _____");

			items = new Items();
			items.add(nodups);

			System.out.println(items);
			System.out.println("The middle is "+items.middle());
			System.out.println("Duplicate of 2.0? "+items.duplicate(2.0));
			System.out.println("A Set? "+items.set());
			items.removeDuplicates();
			System.out.println("After remove: "+ items);
			System.out.println("The middle is "+items.middle());
			System.out.println("Duplicate of 2.0? "+items.duplicate(2.0));
			System.out.println("A Set? "+items.set());

	} // end test doubles

	public static void testInts() {

		System.out.println("\n -------------- TESTING ints ");

		int[] dups = { 1, 2, 3, 1, 2, 3 };
		int[] nodups = { 1, 2, 3, 4, 5, 6 };

		/*
		ItemsInt items = new ItemsInt();


		System.out.println("\n________ FIRST TEST WITH DUPLICATES _____");

		items.add(dups);

		System.out.println(items);
		System.out.println("The middle is "+items.middle());
		System.out.println("Duplicate of 2.0? "+items.duplicate(2.0));
		System.out.println("A Set? "+items.set());
		items.removeDuplicates();
		System.out.println("After remove: "+ items);
		System.out.println("The middle is "+items.middle());
		System.out.println("Duplicate of 2.0? "+items.duplicate(2.0));
		System.out.println("A Set? "+items.set());


		System.out.println("\n________ SECOND TEST WITHOUT DUPLICATES _____");

		items = new Items();
		items.add(nodups);

		System.out.println(items);
		System.out.println("The middle is "+items.middle());
		System.out.println("Duplicate of 2.0? "+items.duplicate(2.0));
		System.out.println("A Set? "+items.set());
		items.removeDuplicates();
		System.out.println("After remove: "+ items);
		System.out.println("The middle is "+items.middle());
		System.out.println("Duplicate of 2.0? "+items.duplicate(2.0));
		System.out.println("A Set? "+items.set());
		*/

	} // end test ints

	public static void testSimple() {

		System.out.println("\n -------------- TESTING SIMPLEs ");

			Simple[] simpleDups = new Simple[5];
			simpleDups[0] = new Simple("A",1);
			simpleDups[1] = new Simple("B",2);
			simpleDups[2] = new Simple("C",3);
			simpleDups[3] = new Simple("A",1);
			simpleDups[4] = new Simple("B",2);

			System.out.println();
			for (int i=0; i<5; i++) {
				System.out.print(simpleDups[i]+" ");
			}
			System.out.println();

			Simple[] simpleNoDups = new Simple[5];
			simpleNoDups[0] = new Simple("A",1);
			simpleNoDups[1] = new Simple("B",2);
			simpleNoDups[2] = new Simple("C",3);
			simpleNoDups[3] = new Simple("D",4);
			simpleNoDups[4] = new Simple("E",5);

			System.out.println();
			for (int i=0; i<5; i++) {
				System.out.print(simpleNoDups[i]+" ");
			}
			System.out.println();

			/*
			ItemsSimple items = new ItemsSimple();

			System.out.println("\n________ FIRST TEST WITH DUPLICATES _____");

			items.add(simpleDups);

			System.out.println(items);
			System.out.println("The middle is "+items.middle());
			System.out.println("Duplicate of 2.0? "+items.duplicate(2.0));
			System.out.println("A Set? "+items.set());
			items.removeDuplicates();
			System.out.println("After remove: "+ items);
			System.out.println("The middle is "+items.middle());
			System.out.println("Duplicate of 2.0? "+items.duplicate(2.0));
			System.out.println("A Set? "+items.set());


			System.out.println("\n________ SECOND TEST WITHOUT DUPLICATES _____");

			items = new Items();
			items.add(simpleNodups);

			System.out.println(items);
			System.out.println("The middle is "+items.middle());
			System.out.println("Duplicate of 2.0? "+items.duplicate(2.0));
			System.out.println("A Set? "+items.set());
			items.removeDuplicates();
			System.out.println("After remove: "+ items);
			System.out.println("The middle is "+items.middle());
			System.out.println("Duplicate of 2.0? "+items.duplicate(2.0));
			System.out.println("A Set? "+items.set());

			*/
		} // end test simple

		public static void testGenerics() {

			System.out.println("\n -------------- TESTING SIMPLEs ");

			double[] doubleDups = { 2.0, 3.0, 4.0, 2.0, 3.0, 4.0 };
			double[] doubleNodups = { 2.0, 3.0, 4.0, 5.0, 6.0, 7.0 };

			int[] intDups = { 1, 2, 3, 1, 2, 3 };
			int[] intNodups = { 1, 2, 3, 4, 5, 6 };

			Simple[] simpleDups = new Simple[5];
			simpleDups[0] = new Simple("A",1);
			simpleDups[1] = new Simple("B",2);
			simpleDups[2] = new Simple("C",3);
			simpleDups[3] = new Simple("A",1);
			simpleDups[4] = new Simple("B",2);

			Simple[] simpleNoDups = new Simple[5];
			simpleNoDups[0] = new Simple("A",1);
			simpleNoDups[1] = new Simple("B",2);
			simpleNoDups[2] = new Simple("C",3);
			simpleNoDups[3] = new Simple("D",4);
			simpleNoDups[4] = new Simple("E",5);

			/*
			ItemsG items = new ItemsG();

			System.out.println("\n___ FIRST TEST WITH GENERIC DUPLICATES _____");

			itemsG.add(   );

			System.out.println(itemsG);
			System.out.println("The middle is "+itemsG.middle());
			System.out.println("Duplicate of 2.0? "+itemsG.duplicate(2.0));
			System.out.println("A Set? "+itemsG.set());
			itemsG.removeDuplicates();
			System.out.println("After remove: "+ itemsG);
			System.out.println("The middle is "+itemsG.middle());
			System.out.println("Duplicate of 2.0? "+itemsG.duplicate(2.0));
			System.out.println("A Set? "+itemsG.set());


			System.out.println("\n___ SECOND TEST GENERIC WITHOUT DUPLICATES _____");

			itemsG = new ItemsG<  >();
			itemsG.add(     );

			System.out.println(itemsG);
			System.out.println("The middle is "+itemsG.middle());
			System.out.println("Duplicate of 2.0? "+itemsG.duplicate(2.0));
			System.out.println("A Set? "+itemsG.set());
			itemsG.removeDuplicates();
			System.out.println("After remove: "+ itemsG);
			System.out.println("The middle is "+itemsG.middle());
			System.out.println("Duplicate of 2.0? "+itemsG.duplicate(2.0));
			System.out.println("A Set? "+itemsG.set());
			*/

		} // end test generics

} // end class main
