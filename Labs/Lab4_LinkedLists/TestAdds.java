public class TestAdds {

	static Song iggy = new Song("Dum Dum Boys", "Iggy Pop", "The Idiot", "1977");
	static Song pil = new Song("Swan Lake", "Public Image Ltd.", "Second Edition", "1980");
	static Song femmes = new Song("Add It Up", "Violent Femmes", "Violent Femmes", "1983");
	static Song wire = new Song("Map Ref 41 Degrees", "Wire", "154", "1979");
	static Song heat = new Song("A New Kind of Water", "Fame", "Post-Punk", "1981");
	static Song tv = new Song("Dorian Gray", "TV Personalities", "Kids Love It", "1981");
	static Song sonic = new Song("Death Valley", "Sonic Youth", "Bad Moon Rising");

	// ------------------------------- addSong --------------------
	// -------------------------------------------------------------------
	public static void addSong(boolean testCapacity) {
		System.out.println("--- testing add(Song) ...");
		List<Song> songs = null;
		songs = TestList.constructList(songs, 4);
		Assert.assertEquals(0, songs.length(), "pre-add (length)");
		songs.add(iggy);
		Assert.assertEquals(1, songs.length(), "add first (length)");
		Assert.assertEquals(iggy, songs.peek(0), "add first (value)");
		songs.add(pil);
		Assert.assertEquals(2, songs.length(), "add 2nd (length)");
		Assert.assertEquals(pil, songs.peek(1), "add 2nd (value)");
		songs.add(femmes);
		Assert.assertEquals(3, songs.length(), "add 3rd (length)");
		Assert.assertEquals(femmes, songs.peek(2), "add 3rd (value)");

		// test up to and over capacity (if warranted)
		if (testCapacity) {
			songs.add(wire);
			Assert.assertEquals(4, songs.length(), "add to capacity (length)");
			Assert.assertEquals(wire, songs.peek(3), "add to capacity (value)");
			songs.add(heat);
			Assert.assertEquals(4, songs.length(), "add attempt over capacity (length)");
			Assert.assertEquals(wire, songs.peek(3), "add attempt over capacity (value)");
		}
	} // end addSong

	// ------------------------------- addAtIndex --------------------
	// -------------------------------------------------------------------
	public static void addAtIndex(boolean testCapacity) {
		System.out.println("--- testing add(Song,index) ...");
		List<Song> tunes = null;
		tunes = TestList.constructList(tunes, 6);

		tunes.add(iggy, 0);
		// tunes = {iggy}
		Assert.assertEquals(1, tunes.length(), "add to empty (length)");
		Assert.assertEquals(iggy, tunes.peek(0), "add to empty (value)");

		tunes.add(pil, 0);
		// tunes = {pil, iggy}
		Assert.assertEquals(2, tunes.length(), "add at 0 (length)");
		Assert.assertEquals(pil, tunes.peek(0), "add at 0 (value)");
		Assert.assertEquals(iggy, tunes.peek(1), "add at 0 (2nd song)");

		tunes.add(femmes, 2);
		// tunes = {pil,iggy,femmes}
		Assert.assertEquals(3, tunes.length(), "add at end (length)");
		Assert.assertEquals(femmes, tunes.peek(2), "add at end (value)");
		Assert.assertEquals(pil, tunes.peek(0), "add at end (1st song)");
		Assert.assertEquals(iggy, tunes.peek(1), "add at 0 (2nd song)");

		tunes.add(sonic, 1);
		// tunes = {pil,sonic,iggy,femmes}
		Assert.assertEquals(4, tunes.length(), "add to middle (length)");
		Assert.assertEquals(sonic, tunes.peek(1), "add to middle (value)");
		Assert.assertEquals(pil, tunes.peek(0), "add to middle (1st song)");
		Assert.assertEquals(iggy, tunes.peek(2), "add to middle (3rd song)");
		Assert.assertEquals(femmes, tunes.peek(3), "add to middle (4th song)");

		tunes.add(wire, -1);
		// test invalid indices
		Assert.assertEquals(4, tunes.length(), "add at -1 (length)");
		tunes.add(wire, 5);
		Assert.assertEquals(4, tunes.length(), "add beyond last (length)");
		Assert.assertEquals(null, tunes.peek(5), "add beyond last (value)");

		if (testCapacity) {
			tunes.add(wire, 7);
			Assert.assertEquals(4, tunes.length(), "add beyond capacity (length)");
		}
	} // end addAtIndex

	// ------------------------------- addUnique --------------------
	// -------------------------------------------------------------------
	public static void addUnique(boolean testCapacity) {
		System.out.println("--- testing addUnique() ...");
		Integer[] one = { 1 };
		Integer[] two = { 2 };
		Integer[] three = { 1, 2, 3 };

		List<Integer> numbers = null;
		numbers = TestList.constructList(numbers, 5);
		numbers.add(2);
		numbers.add(3);

		// test adding 1 item that is unique
		numbers.addUnique(one);
		Assert.assertEquals(3, numbers.length(), "add 1 to {2,3}");

		// test adding 1 item that is not unique
		Integer length = numbers.length();
		numbers.addUnique(two);
		Assert.assertEquals(length, numbers.length(), "attempt add 2 to {2,3,1}");

		// test add multiple with some unique, some not
		numbers = TestList.constructList(numbers, 5);
		numbers.add(2);
		numbers.add(3);
		numbers.add(4);
		numbers.addUnique(three);
		Assert.assertEquals(4, numbers.length(), "attempt add {1,2,3} to {2,3,4}");
		Assert.assertEquals(1, numbers.peek(3), "attempt add {1,2,3} - add 1 only");

		// test add multiple with all unique
		numbers = TestList.constructList(numbers, 10);
		numbers.add(4);
		numbers.add(5);
		numbers.add(6);
		numbers.addUnique(three);
		Assert.assertEquals(6, numbers.length(), "add 3 unique to {4,5,6} length");
		Assert.assertEquals(2, numbers.peek(4), "add 3 unique to {4,5,6} value");

		// test add multiple with none unique
		numbers = TestList.constructList(numbers, 10);
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
		numbers.addUnique(three);
		Assert.assertEquals(3, numbers.length(), "attempt add 3 dups length");

	} // end addUnique

	// ------------------------------- set --------------------
	// -------------------------------------------------------------------
	public static void set() {
		System.out.println("--- testing set(Song,index) ...");
		List<Song> jams = null;
		jams = TestList.constructList(jams, 6);
		// †his assumes that add is working correctly!
		jams.add(iggy);
		jams.add(pil);
		jams.add(femmes);

		jams.set(wire, 0);
		// jams = {wire,pil,femmes}. Set at first element
		Assert.assertEquals(3, jams.length(), "set(0) length");
		Assert.assertEquals(wire, jams.peek(0), "set(0) value");
		Assert.assertEquals(pil, jams.peek(1), "set(0) (2nd song)");
		Assert.assertEquals(femmes, jams.peek(2), "set(0) (3rd song)");

		jams.set(heat, 1);
		// jams = {wire,heat,femmes}. Set at middle element
		Assert.assertEquals(3, jams.length(), "set(1) length");
		Assert.assertEquals(heat, jams.peek(1), "set(1) value");
		Assert.assertEquals(wire, jams.peek(0), "set(1) (1st song)");
		Assert.assertEquals(femmes, jams.peek(2), "set(1) (3rd song)");

		jams.set(tv, 2);
		// jams = {wire,heat,tv}. Set at last element
		Assert.assertEquals(3, jams.length(), "set(2) length");
		Assert.assertEquals(tv, jams.peek(2), "set(2) value");
		Assert.assertEquals(wire, jams.peek(0), "set(2) (1st song)");
		Assert.assertEquals(heat, jams.peek(1), "set(2) (2nd song)");

		jams.set(iggy, 3); // set 1 past the last element
		// invalid indices. should not change {wire,heat,tv}
		Assert.assertEquals(3, jams.length(), "set at length, bad index (length)");
		Assert.assertEquals(null, jams.peek(3), "set at length, bad index (value)");
		jams.set(pil, 5);
		Assert.assertEquals(3, jams.length(), "set at capacity, bad index (length)");
		Assert.assertEquals(null, jams.peek(5), "set at capacity, bad index (value)");
		jams.set(pil, -1);
		Assert.assertEquals(3, jams.length(), "set at -1 (length)");
		Assert.assertEquals(wire, jams.peek(0), "set at -1 (value)");
	} // end set()
}
