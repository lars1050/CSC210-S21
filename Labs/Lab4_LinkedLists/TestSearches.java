public class TestSearches {

	static Song iggy = new Song("Dum Dum Boys","Iggy Pop","The Idiot","1977");
	static Song pil = new Song("Swan Lake","Public Image Ltd.","Second Edition","1980");
	static Song femmes = new Song("Add It Up","Violent Femmes","Violent Femmes","1983");

	// check that search compares values (ignoring case), not references
	static Song iggy2 = new Song("Dum Dum boys","Iggy pop","The idiot","1977");
	static Song pil2 = new Song("Swan lake","Public image Ltd.","Second edition","1980");
	static Song femmes2 = new Song("Add it up","violent femmes","violent femmes","1983");
	static Song s = new Song("a", "b", "c");


	// -------------------------------   peek     --------------------
	// -------------------------------------------------------------------
	public static void peek() {
		System.out.println("---Testing peek ...");

		List<Song> songs = null;
		songs = TestList.constructList(songs,5);
		songs.add(femmes);
		songs.add(iggy);
		songs.add(pil);

		//testing peek
		System.out.println("------------testing peek()");
		Assert.assertEquals(femmes,songs.peek(0),"Peek at index 0");
		Assert.assertEquals(iggy,songs.peek(1),"Peek at index 1");
		Assert.assertEquals(pil,songs.peek(2),"Peek at index 2");
		Assert.assertEquals(null,songs.peek(3), "Peek invalid >count");
		Assert.assertEquals(null,songs.peek(5), "Peek invalid >length");
		Assert.assertEquals(null,songs.peek(-1), "Peek invalid -1");
	}

	// -------------------------------   location     --------------------
	// -------------------------------------------------------------------
	public static void location() {
		System.out.println("---Testing location ...");
		//Testing location
		List<Song> songs = null;
		songs = TestList.constructList(songs,5);
		songs.add(iggy);
		songs.add(pil);
		songs.add(femmes);
		Assert.assertEquals(0, songs.location(iggy2), "location first");
		Assert.assertEquals(1, songs.location(pil2), "location middle");
		Assert.assertEquals(2,songs.location(femmes2), "location last");
		Assert.assertEquals(-1, songs.location(s), "location not in list");
	} // end location

	// -------------------------------   contains     --------------------
	// -------------------------------------------------------------------
	public static void contains() {
		System.out.println("---Testing contains ...");
		List<Song> songs = null;
		songs = TestList.constructList(songs,5);
		songs.add(iggy);
		songs.add(pil);
		songs.add(femmes);
		Assert.assertEquals(true, songs.contains(iggy2),"Contains in list");
		Assert.assertEquals(false,songs.contains(s),"Contains() not in list.");
	} // end contains

	// -------------------------------  lastLocation     --------------------
	// -------------------------------------------------------------------
	public static void lastLocation() {
		System.out.println("---Testing lastLocation ...");

		List<Integer> numbers = null;
		numbers = TestList.constructList(numbers,10);
		Integer[] testLast = {1,2,3,2,3,2,3};
		for (Integer i : testLast) {
			numbers.add(i);
		}
		Assert.assertEquals(6,numbers.lastLocation(3),"Last in list.");
		Assert.assertEquals(0,numbers.lastLocation(1),"First in list.");
		Assert.assertEquals(5,numbers.lastLocation(2),"Middle of list");
		Assert.assertEquals(-1,numbers.lastLocation(4),"Not in list.");
	} // end lastIndexOf

} // end TestSearches
