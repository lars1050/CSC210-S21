import java.io.*;
import java.util.Comparator;
import java.util.Random;

class Main {

  public static void main(String[] args) {

		// Create maxHeap for testing
		MaxHeap<Simple> heap = new MaxHeap<>();

		// Add a test set with (0,z) (1,y) ...
		Random rand = new Random();
		for (int j=0; j<10; j++) {
			int i = rand.nextInt(26);
			heap.insert(new Simple(String.valueOf((char)((int)'z'-i)),i));
		}
		heap.print();
	}


} // end class TestLab8
