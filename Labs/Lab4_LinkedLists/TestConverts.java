// import java.lang.reflect.*;
// import java.util.Scanner;
// import java.io.*;

public class TestConverts {

	static Song iggy = new Song("Dum Dum Boys","Iggy Pop","The Idiot","1977");
	static Song pil = new Song("Swan Lake","Public Image Ltd.","Second Edition","1980");
	static Song femmes = new Song("Add It Up","Violent Femmes","Violent Femmes","1983");
	static Song wire = new Song("Map Ref 41 Degrees", "Wire", "154", "1979");
	static Song sonic = new Song ("Death Valley","Sonic Youth","Bad Moon Rising");


		// ---------------------------   T[] toArray      --------------------
		// -------------------------------------------------------------------
	public static void toArrayReturnArray() {
		System.out.println("--- testing T[] toArray() ...");

		Object[] array;

		List<Song> songs = null;
		songs = TestList.constructList(songs,4);
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
			Assert.assertEquals((Song)array[0], iggy, "toArray 1 element (value)");
		}

		songs.add(pil); // songs = {iggy,pil}
		array = songs.toArray();
		if (null==array) {
			System.out.println("ERROR: toArray 2 elements. Returns null.");
		} else {
			Assert.assertEquals(2,array.length,"toArray 2 elements (length)");
			Assert.assertEquals((Song)array[0], iggy, "toArray 2 elements (1st song)");
			Assert.assertEquals((Song)array[1], pil, "toArray 2 elements (2nd song)");
		}

		songs.add(femmes);
		songs.add(sonic); // songs = {iggy,pil,femmes,sonic}
		array = songs.toArray();
		if (null==array) {
			System.out.println("ERROR: toArray at capacity. Returns null.");
		} else {
			Assert.assertEquals(4,array.length,"toArray at capacity (length)");
			Assert.assertEquals((Song)array[0], iggy, "toArray at capacity (1st song)");
			Assert.assertEquals((Song)array[1], pil, "toArray at capacity (2nd song)");
			Assert.assertEquals((Song)array[2], femmes, "toArray at capacity (3rd song)");
			Assert.assertEquals((Song)array[3], sonic, "toArray at capacity (4th song)");
		}

	} // end toArrayReturnArray


	// -----------------------   toArray(T[])      --------------------
	// -------------------------------------------------------------------
	public static void toArrayVoid() {
		System.out.println("--- testing void toArray(T[]) ...");

		List<Song> songs = null;
		songs = TestList.constructList(songs,4);
		Song[] toFill = new Song[4];
		songs.toArray(toFill);
		if (null!=toFill && null!=toFill[0]) {
			System.out.println(
			"ERROR: toArray(T[]) empty list. Expect null. Results not null.");
		}

		songs.add(iggy);
		songs.toArray(toFill);
		if (null==toFill) {
			System.out.println("ERROR: toArray(T[]) 1 element. Returns null.");
		} else {
			Assert.assertEquals(toFill[0], iggy, "toArray(T[]) 1 element (value)");
		}

		songs.add(pil); // songs = {iggy,pil}
		songs.toArray(toFill);
		if (null==toFill) {
			System.out.println("ERROR: toArray(T[]) 2 elements. Returns null.");
		} else {
			Assert.assertEquals((Song)toFill[0], iggy, "toArray(T[]) 2 elements (1st song)");
			Assert.assertEquals((Song)toFill[1], pil, "toArray(T[]) 2 elements (2nd song)");
		}

		songs.add(femmes);
		songs.add(sonic); // songs = {iggy,pil,femmes,sonic}
		songs.toArray(toFill);
		if (null==toFill) {
			System.out.println("ERROR: toArray(T[]) at capacity. Returns null.");
		} else {
			Assert.assertEquals((Song)toFill[0], iggy, "toArray(T[]) at capacity (1st song)");
			Assert.assertEquals((Song)toFill[1], pil, "toArray(T[]) at capacity (2nd song)");
			Assert.assertEquals((Song)toFill[2], femmes, "toArray(T[]) at capacity (3rd song)");
			Assert.assertEquals((Song)toFill[3], sonic, "toArray(T[]) at capacity (4th song)");
		}
	} // end toArrayVoid


} // end TestConverts
