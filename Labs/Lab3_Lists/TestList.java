import java.lang.reflect.*;
import java.util.Scanner;
import java.io.*;

public class TestList {

	static Song iggy = new Song("Nightclubbing","Iggy Pop","The Idiot",1977);
	static Song pil = new Song("Swan Lake","Public Image Ltd.","Second Edition",1980);
	static Song femmes = new Song("Add It Up","Violent Femmes","Violent Femmes",1983);

	public static void main(String[] args) {

		// Initial add() and peek() test
		/* It is a bit of a chicken-and-egg problem.
		* To test add(), peek() needs to be correct to confirm song was added.
		* To test peek(), add() needs to be correct to confirm location of song.
		*/

		System.out.println("\n\nSanity check test of add, length, peek.");
		System.out.println("If these initial tests do not pass, the rest of the tests are irrelevant!\n");
		SongList songs = new SongList(5);
		songs.add(iggy);
		Assert.assertEquals(1,songs.length(),"First Add (length)");
		Assert.assertEquals(iggy,songs.peek(0),"Fird Add (iggy)");
		System.out.println("\nSanity Check complete!");
		/* Once the above are confirmed to be working, the rest of the testing can proceed.
		*/

		try {
			testConstructorGetters();
		} catch(Exception e) {
			System.out.println("\n\n*** STOP HERE -- something wrong with constructor!!\n\n");
		}
		try {
			testSearches();
		} catch(Exception e) {
			System.out.println("\n\nSEARCHES THROWING EXCEPTION.");
			e.printStackTrace();
			System.out.println("\n\n");
		}
		try {
			testAdds();
		} catch(Exception e) {
			System.out.println("\n\nADDS THROWING EXCEPTION.");
			e.printStackTrace();
			System.out.println("\n\n");
		}
		try {
			testRemoves();
		} catch(Exception e) {
			System.out.println("\n\nREMOVES THROWING EXCEPTION.");
			e.printStackTrace();
			System.out.println("\n\n");
		}
		try {
			testConvert();
		} catch(Exception e) {
			System.out.println("\n\nCONVERT THROWING EXCEPTION.");
			e.printStackTrace();
			System.out.println("\n\n");
		}
	} // end main

	/* __________________________________________________________________ */
	public static void testConstructorGetters() {
		System.out.println("\n\nTesting SongList constructor ...");

		SongList jams;

		// Test default constructor and getters
		jams = new SongList ();
		Assert.assertEquals(500, jams.capacity(), "SongList() capacity");
		Assert.assertEquals(0, jams.length(), "SongList() length");
		Assert.assertEquals(true, jams.isEmpty(), "SongList() isEmpty");

		// Test constructor with size parameter
		jams = new SongList(5);
		Assert.assertEquals(0, jams.length(), "SongList(5) length");
		Assert.assertEquals(5, jams.capacity(), "SongList(5) capacity");
		Assert.assertEquals(true, jams.isEmpty(), "SongList(5) isEmpty");

		// Test length getter (tested at 0 above)
		jams.add(pil);
		Assert.assertEquals(1,jams.length(),"length()");
		jams.add(iggy);
		Assert.assertEquals(2,jams.length(),"length()");

		// Test isEmpty and isFull.
		jams = new SongList(3);
		Assert.assertEquals(false, jams.isFull(), "isFull - empty");
		Assert.assertEquals(true, jams.isEmpty(), "isEmpty");

		jams.add(pil);
		Assert.assertEquals(false, jams.isFull(), "isFull - 1 of 3");
		Assert.assertEquals(false, jams.isEmpty(), "isEmpty - 1 of 3");

		jams.add(pil);
		jams.add(pil);
		Assert.assertEquals(true, jams.isFull(), "isFull - 3 of 3");
		Assert.assertEquals(false, jams.isEmpty(), "isEmpty - 3 of 3");

		// test length getter when full
		Assert.assertEquals(3,jams.length(),"length()");

	} // end testConstructorGetters

	/* __________________________________________________________________ */
	public static void testSearches() {
		System.out.println("\n\nTesting SongList search methods ...");

		SongList songs;

		// check that search compares values (ignoring case), not references
		Song femmes2 = new Song("add IT up","violent femmes","violent femmes",1983);
		Song iggy2 = new Song("niGHtclubbing","Iggy pop","The idiot",1977);
		Song pil2 = new Song("SWAN lake","Public image Ltd.","Second edition",1980);

		Song s = new Song("a", "b", "c");

		songs = new SongList(5);
		songs.add(femmes);
		songs.add(iggy);
		songs.add(pil);

		System.out.println("------------testing peek()");
		Assert.assertEquals(femmes,songs.peek(0),"Peek at index 0");
		Assert.assertEquals(iggy,songs.peek(1),"Peek at index 1");
		Assert.assertEquals(pil,songs.peek(2),"Peek at index 2");
		Assert.assertEquals(null,songs.peek(3), "Peek invalid >count");
		Assert.assertEquals(null,songs.peek(5), "Peek invalid >length");
		Assert.assertEquals(null,songs.peek(-1), "Peek invalid -1");

		System.out.println("------------Testing location()");
		Assert.assertEquals(0, songs.location(femmes2), "locate first");
		Assert.assertEquals(1, songs.location(iggy2), "locate middle");
		Assert.assertEquals(2, songs.location(pil2), "locate last");
		Assert.assertEquals(-1, songs.location(s), "locate but not in list");

		System.out.println("-------------Testing findTitle()");
		Assert.assertEquals(femmes, songs.findTitle("add it up"), "locate first");
		Assert.assertEquals(iggy, songs.findTitle("nightclubbing"), "locate middle");
		Assert.assertEquals(pil, songs.findTitle("swan lake"), "locate last");
		Assert.assertEquals(null, songs.findTitle("no song"), "locate (not in list)");

		System.out.println("--------------Testing contains()");
		Assert.assertEquals(true, songs.contains(iggy),"Contains in list");
		Assert.assertEquals(false,songs.contains(s),"Contains() not in list.");
	} // end testSearches

	/* __________________________________________________________________ */
	public static void testAdds() {
		System.out.println("\n\nTesting SongList add methods ...");

		SongList tunes;

		// more songs to work with
		Song wire = new Song("Map Ref 41 Degrees", "Wire", "154", 1979);
		Song heat = new Song("A New Kind of Water","Fame" ,"Post-Punk",1981);
		Song tv = new Song("Dorian Gray","TV Personalities","Kids Love It",1981);
		Song sonic = new Song ("Death Valley","Sonic Youth","Bad Moon Rising");

		System.out.println("--------------add(Song)");
		tunes = new SongList(3);

		Assert.assertEquals(0,tunes.length(),"pre-add (length)");
		tunes.add(iggy);
		Assert.assertEquals(1,tunes.length(),"add first (length)");
		Assert.assertEquals(iggy,tunes.peek(0),"add first (value)");
		tunes.add(pil);
		Assert.assertEquals(2,tunes.length(),"add 2nd (length)");
		Assert.assertEquals(pil,tunes.peek(1),"add 2nd (value)");
		tunes.add(femmes);
		Assert.assertEquals(3,tunes.length(),"add to capacity (length)");
		Assert.assertEquals(femmes,tunes.peek(2),"add to capacity (value)");
		tunes.add(iggy);
		Assert.assertEquals(3,tunes.length(),"add attempt over capacity (length)");
		Assert.assertEquals(femmes,tunes.peek(2),"add attempt over capacity (value)");


		System.out.println("--------------add(song, index)");
		tunes = new SongList(6);
		tunes.add(iggy,0);
		// tunes = {iggy}
		Assert.assertEquals(1,tunes.length(),"add to empty (length)");
		Assert.assertEquals(iggy,tunes.peek(0),"add to empty (value)");

		tunes.add(pil,0);
		// tunes = {pil, iggy}
		Assert.assertEquals(2,tunes.length(),"add at 0 (length)");
		Assert.assertEquals(pil,tunes.peek(0),"add at 0 (value)");
		Assert.assertEquals(iggy,tunes.peek(1),"add at 0 (2nd song)");

		tunes.add(femmes,2);
		// tunes = {pil,iggy,femmes}
		Assert.assertEquals(3,tunes.length(),"add at end (length)");
		Assert.assertEquals(femmes,tunes.peek(2),"add at end (value)");
		Assert.assertEquals(pil,tunes.peek(0),"add at end (1st song)");
		Assert.assertEquals(iggy,tunes.peek(1),"add at end (2nd song)");

		tunes.add(sonic,1);
		// tunes = {pil,sonic,iggy,femmes}
		Assert.assertEquals(4,tunes.length(),"add to middle (length)");
		Assert.assertEquals(sonic,tunes.peek(1),"add to middle (value)");
		Assert.assertEquals(pil,tunes.peek(0),"add to middle (1st song)");
		Assert.assertEquals(iggy,tunes.peek(2),"add to middle (3rd song)");
		Assert.assertEquals(femmes,tunes.peek(3),"add to middle (4th song)");

		// test invalid indices
		tunes.add(wire,-1);
		Assert.assertEquals(4,tunes.length(),"add at -1 (length)");
		tunes.add(wire,5);
		Assert.assertEquals(4,tunes.length(),"add beyond last (length)");
		Assert.assertEquals(null,tunes.peek(5),"add beyond last (value)");
		tunes.add(wire,7);
		Assert.assertEquals(4,tunes.length(),"add beyond capacity (length)");


		System.out.println("--------------set(Song, index)");
		tunes = new SongList(6);
		// †his assumes that add is working correctly!
		tunes.add(iggy);
		tunes.add(pil);
		tunes.add(femmes);

		tunes.set(wire,0);
		// jams = {wire,pil,femmes}. Set at first element
		Assert.assertEquals(3,tunes.length(),"set(0) length");
		Assert.assertEquals(wire,tunes.peek(0),"set(0) value");
		Assert.assertEquals(pil,tunes.peek(1),"set(0) (2nd song)");
		Assert.assertEquals(femmes,tunes.peek(2),"set(0) (3rd song)");

		tunes.set(heat,1);
		// jams = {wire,heat,femmes}. Set at middle element
		Assert.assertEquals(3,tunes.length(),"set(1) length");
		Assert.assertEquals(heat,tunes.peek(1),"set(1) value");
		Assert.assertEquals(wire,tunes.peek(0),"set(1) (1st song)");
		Assert.assertEquals(femmes,tunes.peek(2),"set(1) (3rd song)");

		tunes.set(tv,2);
		// jams = {wire,heat,tv}. Set at last element
		Assert.assertEquals(3,tunes.length(),"set(2) length");
		Assert.assertEquals(tv,tunes.peek(2),"set(2) value");
		Assert.assertEquals(wire,tunes.peek(0),"set(2) (1st song)");
		Assert.assertEquals(heat,tunes.peek(1),"set(2) (2nd song)");

		tunes.set(iggy,3);	// set 1 past the last element
		//  invalid indices. should not change {wire,heat,tv}
		Assert.assertEquals(3,tunes.length(),"set at length, bad index (length)");
		Assert.assertEquals(null,tunes.peek(3),"set at length, bad index (value)");
		tunes.set(pil,5);
		Assert.assertEquals(3,tunes.length(),"set at capacity, bad index (length)");
		Assert.assertEquals(null,tunes.peek(5),"set at capacity, bad index (value)");
		tunes.set(pil,-1);
		Assert.assertEquals(3,tunes.length(),"set at -1 (length)");
		Assert.assertEquals(wire,tunes.peek(0),"set at -1 (value)");
	}

	/* __________________________________________________________________ */
	public static void testRemoves() {
		System.out.println("\n\nTesting SongList remove methods ...");

		// This is assuming add, length, contains is working!

		SongList jams;

		Song femmes2 = new Song("add IT up","violent femmes","violent femmes",1983);
		Song sonic = new Song ("Death Valley","Sonic Youth","Bad Moon Rising");

		jams = new SongList(5);
		jams.add(iggy);
		jams.add(pil);
		jams.add(femmes);
		jams.add(sonic);


		System.out.println("--------------remove(Song)");
		// songs = {iggy,pil,femmes,sonic}
		Assert.assertEquals(4,jams.length(),"pre-removal (length)");

		jams.remove(pil);
		// songs = {iggy,femmes,sonic}
		Assert.assertEquals(3,jams.length(),"remove middle (length)");
		Assert.assertEquals(false,jams.contains(pil),"remove middle");
		Assert.assertEquals(iggy,jams.peek(0),"remove middle (1st song)");
		Assert.assertEquals(femmes,jams.peek(1),"remove middle (2nd song)");
		Assert.assertEquals(sonic,jams.peek(2),"remove middle (3rd song)");

		jams.remove(sonic);
		// songs = {iggy,femmes}
		Assert.assertEquals(2,jams.length(),"remove at end (length)");
		Assert.assertEquals(false,jams.contains(sonic),"remove at end");
		Assert.assertEquals(iggy,jams.peek(0),"remove at end (1st song)");
		Assert.assertEquals(femmes,jams.peek(1),"remove at end (2nd song)");

		jams.remove(iggy);
		// songs = {femmes}
		Assert.assertEquals(1,jams.length(),"remove first (length)");
		Assert.assertEquals(false,jams.contains(iggy),"remove first");
		Assert.assertEquals(femmes,jams.peek(0),"remove first (1st song)");

		jams.remove(femmes2);
		// songs = {}
		Assert.assertEquals(0,jams.length(),"remove last element (length)");
		Assert.assertEquals(false,jams.contains(femmes),"remove last");
		Assert.assertEquals(null,jams.peek(0),"remove last");

		// remove invalid song. list is empty
		jams.remove(femmes);
		Assert.assertEquals(0,jams.length(),"remove from empty");
		jams.add(pil);
		jams.remove(femmes);
		Assert.assertEquals(1,jams.length(),"remove not in list");
		Assert.assertEquals(pil,jams.peek(0),"remove not in list (1st song)");

		System.out.println("--------------remove(index)");
		jams = new SongList(5);
		jams.add(iggy);
		jams.add(pil);
		jams.add(femmes);
		jams.add(sonic);

		Assert.assertEquals(4,jams.length(),"pre-removal (length)");

		jams.remove(1);
		// songs = {iggy,femmes,sonic}
		Assert.assertEquals(3,jams.length(),"remove middle (length)");
		Assert.assertEquals(false,jams.contains(pil),"remove middle");
		Assert.assertEquals(iggy,jams.peek(0),"remove middle (1st song)");
		Assert.assertEquals(femmes,jams.peek(1),"remove middle (2nd song)");
		Assert.assertEquals(sonic,jams.peek(2),"remove middle (3rd song)");

		jams.remove(2);
		// songs = {iggy,femmes}
		Assert.assertEquals(2,jams.length(),"remove at end (length)");
		Assert.assertEquals(false,jams.contains(sonic),"remove at end");
		Assert.assertEquals(iggy,jams.peek(0),"remove at end (1st song)");
		Assert.assertEquals(femmes,jams.peek(1),"remove at end (2nd song)");

		jams.remove(0);
		// songs = {femmes}
		Assert.assertEquals(1,jams.length(),"remove first (length)");
		Assert.assertEquals(false,jams.contains(iggy),"remove first");
		Assert.assertEquals(femmes,jams.peek(0),"remove first (1st song)");

		jams.remove(0);
		// songs = {}
		Assert.assertEquals(0,jams.length(),"remove last element (length)");
		Assert.assertEquals(false,jams.contains(femmes),"remove last");
		Assert.assertEquals(null,jams.peek(0),"remove last");

		// remove invalid index. list is empty
		jams.remove(0);
		Assert.assertEquals(0,jams.length(),"remove from empty");
		jams.add(pil);
		jams.remove(1);
		Assert.assertEquals(1,jams.length(),"remove not in list");
		Assert.assertEquals(pil,jams.peek(0),"remove not in list (1st song)");
		jams.remove(-1);
		Assert.assertEquals(1,jams.length(),"remove at -1");
		Assert.assertEquals(pil,jams.peek(0),"remove at -1 (1st song)");


		System.out.println("--------------removeAll()");
		jams = new SongList(5);
		jams.add(pil);
		jams.add(femmes);
		jams.add(iggy);
		Assert.assertEquals(3,jams.length(),"pre remove all (length)");
		jams.removeAll();
		Assert.assertEquals(0,jams.length(),"remove all (length)");
		Assert.assertEquals(false,jams.contains(pil),"remove all pil");
		Assert.assertEquals(false,jams.contains(femmes),"remove all femmes");
		Assert.assertEquals(false,jams.contains(iggy),"remove all iggy");
		Assert.assertEquals(null,jams.peek(0),"remove all");

	}

	/* __________________________________________________________________ */
	public static void testConvert() {
		System.out.println("\n\nTesting SongList convert methods ...");

		SongList songs;
		Song[] array;

		System.out.println("--------------Testing toArray()");
		songs = new SongList(4);
		if (null!=songs.toArray()) {
			System.out.println(
			"ERROR: toArray empty list. Expect null. Results not null.");
		}

		songs.add(iggy);
		array = songs.toArray();
		if (null==array) {
			System.out.println("ERROR: toArray 1 element. Returns null.");
		} else {
			Assert.assertEquals(1,array.length,"toArray 1 element (length)");
			Assert.assertEquals(array[0], iggy, "toArray 1 element (value)");
		}

		songs.add(pil); // songs = {iggy,pil}
		array = songs.toArray();
		if (null==array) {
			System.out.println("ERROR: toArray 2 elements. Returns null.");
		} else {
			Assert.assertEquals(2,array.length,"toArray 2 elements (length)");
			Assert.assertEquals(array[0], iggy, "toArray 2 elements (1st song)");
			Assert.assertEquals(array[1], pil, "toArray 2 elements (2nd song)");
		}

		Song sonic = new Song ("Death Valley","Sonic Youth","Bad Moon Rising");
		songs.add(femmes);
		songs.add(sonic); // songs = {iggy,pil,femmes,sonic}
		array = songs.toArray();
		if (null==array) {
			System.out.println("ERROR: toArray at capacity. Returns null.");
		} else {
			Assert.assertEquals(4,array.length,"toArray at capacity (length)");
			Assert.assertEquals(array[0], iggy, "toArray at capacity (1st song)");
			Assert.assertEquals(array[1], pil, "toArray at capacity (2nd song)");
			Assert.assertEquals(array[2], femmes, "toArray at capacity (3rd song)");
			Assert.assertEquals(array[3], sonic, "toArray at capacity (4th song)");
		}
	} // end testConvert
} // end class Main
