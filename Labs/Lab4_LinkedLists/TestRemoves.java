public class TestRemoves {

	static Song iggy = new Song("Dum Dum Boys","Iggy Pop","The Idiot","1977");
	static Song pil = new Song("Swan Lake","Public Image Ltd.","Second Edition","1980");
	static Song femmes = new Song("Add It Up","Violent Femmes","Violent Femmes","1983");
	static Song sonic = new Song ("Death Valley","Sonic Youth","Bad Moon Rising");

	// ----------------------------   remove(song)     --------------------
	// -------------------------------------------------------------------
	public static void removeSong() {
		System.out.println("---Testing remove(song) ...");

		List<Song> songs = null;
		songs = TestList.constructList(songs,5);
		songs.add(iggy);
		songs.add(pil);
		songs.add(femmes);
		songs.add(sonic);

		Assert.assertEquals(4,songs.length(),"pre-removal (length)");
		// songs = {iggy,femmes,sonic}
		songs.remove(pil);
		Assert.assertEquals(3,songs.length(),"remove middle (length)");
		Assert.assertEquals(false,songs.contains(pil),"remove middle");
		Assert.assertEquals(iggy,songs.peek(0),"remove middle (1st song)");
		Assert.assertEquals(femmes,songs.peek(1),"remove middle (2nd song)");
		Assert.assertEquals(sonic,songs.peek(2),"remove middle (3rd song)");
		// songs = {iggy,femmes}
		songs.remove(sonic);
		Assert.assertEquals(2,songs.length(),"remove at end (length)");
		Assert.assertEquals(false,songs.contains(sonic),"remove at end");
		Assert.assertEquals(iggy,songs.peek(0),"remove at end (1st song)");
		Assert.assertEquals(femmes,songs.peek(1),"remove at end (2nd song)");
		// songs = {femmes}
		songs.remove(iggy);
		Assert.assertEquals(1,songs.length(),"remove first (length)");
		Assert.assertEquals(false,songs.contains(iggy),"remove first");
		Assert.assertEquals(femmes,songs.peek(0),"remove first (1st song)");
		// songs = {}
		songs.remove(femmes);
		Assert.assertEquals(0,songs.length(),"remove last element (length)");
		Assert.assertEquals(false,songs.contains(femmes),"remove last");
		Assert.assertEquals(null,songs.peek(0),"remove last");

		// remove invalid song. list is empty
		songs.remove(femmes);
		Assert.assertEquals(0,songs.length(),"remove from empty");
		songs.add(pil);
		songs.remove(femmes);
		Assert.assertEquals(1,songs.length(),"remove not in list");
		Assert.assertEquals(pil,songs.peek(0),"remove not in list (1st song)");
	}

	// ------------------------------- remove(index)   --------------------
	// -------------------------------------------------------------------
	public static void removeAtIndex() {
		System.out.println("---Testing remove(index) ...");

		List<Song> songs = null;
		songs = TestList.constructList(songs,5);
		songs.add(iggy);
		songs.add(pil);
		songs.add(femmes);
		songs.add(sonic);

		Assert.assertEquals(4,songs.length(),"pre-removal (length)");

		songs.remove(1);
		// songs = {iggy,femmes,sonic}
		Assert.assertEquals(3,songs.length(),"remove middle (length)");
		Assert.assertEquals(false,songs.contains(pil),"remove middle");
		Assert.assertEquals(iggy,songs.peek(0),"remove middle (1st song)");
		Assert.assertEquals(femmes,songs.peek(1),"remove middle (2nd song)");
		Assert.assertEquals(sonic,songs.peek(2),"remove middle (3rd song)");

		songs.remove(2);
		// songs = {iggy,femmes}
		Assert.assertEquals(2,songs.length(),"remove at end (length)");
		Assert.assertEquals(false,songs.contains(sonic),"remove at end");
		Assert.assertEquals(iggy,songs.peek(0),"remove at end (1st song)");
		Assert.assertEquals(femmes,songs.peek(1),"remove at end (2nd song)");

		songs.remove(0);
		// songs = {femmes}
		Assert.assertEquals(1,songs.length(),"remove first (length)");
		Assert.assertEquals(false,songs.contains(iggy),"remove first");
		Assert.assertEquals(femmes,songs.peek(0),"remove first (1st song)");

		songs.remove(0);
		// songs = {}
		Assert.assertEquals(0,songs.length(),"remove last element (length)");
		Assert.assertEquals(false,songs.contains(femmes),"remove last");
		Assert.assertEquals(null,songs.peek(0),"remove last");

		// remove invalid index. list is empty
		songs.remove(0);
		Assert.assertEquals(0,songs.length(),"remove from empty");
		songs.add(pil);
		songs.remove(1);
		Assert.assertEquals(1,songs.length(),"remove not in list");
		Assert.assertEquals(pil,songs.peek(0),"remove not in list (1st song)");
		songs.remove(-1);
		Assert.assertEquals(1,songs.length(),"remove at -1");
		Assert.assertEquals(pil,songs.peek(0),"remove at -1 (1st song)");
}

// -------------------------------   removeAll     --------------------
// -------------------------------------------------------------------
public static void removeAll() {
	System.out.println("---Testing removeAll() ...");

		List<Song> songs = null;
		songs = TestList.constructList(songs,5);
		songs.add(pil);
		songs.add(femmes);
		songs.add(iggy);
		Assert.assertEquals(3,songs.length(),"pre remove all (length)");
		songs.removeAll();
		Assert.assertEquals(0,songs.length(),"remove all (length)");
		Assert.assertEquals(false,songs.contains(pil),"remove all pil");
		Assert.assertEquals(false,songs.contains(femmes),"remove all femmes");
		Assert.assertEquals(false,songs.contains(iggy),"remove all iggy");
		Assert.assertEquals(null,songs.peek(0),"remove all");

		}


// -------------------------------   removeAll     --------------------
// -------------------------------------------------------------------
public static void removeDuplicates() {
	System.out.println("---Testing removeDuplicates() ...");
	System.out.println("TESTS ADDED SOON!!!");
	} // end removeDuplicates
} // end TestSearches
