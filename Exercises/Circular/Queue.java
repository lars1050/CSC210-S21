/** FIFO Queue class that uses a dummy node and a circular list.
*/
class Queue {

  class Node {
    Integer data;
    Node next;
    Node(Integer d) {
      data = d;
    }
  } // end Node class

  Node head;
  Node tail;

  public Queue() {
    // define a "dummy" node with null data that the head always points to.
    // additionally, have the tail always point to the head.
    head = new Node(null);
    head.next = head;
    tail = head;
  }

  public String toString() {
    // initialize the string that will contain all elements
    String string = "\nQUEUE ";
    // initialize the pointer to the first element.
    // note it starts at head.next, because the head is a dummy node.
    Node p = head.next;
    // traverse list to add each element to string until past the tail.
    // once back at the head, traversed entire list
    // note at least one element (because already tested for empty)
    while (p != head) {
      string += p.data + " ";
      p = p.next;
    }
    string += "\n";
    return string;
  } // end toString()

  public void push(Integer el) {
    // An FIFO queue pushes (adds) to the tail of the list.

  }

  public Integer pop() {
    // An FIFO queue pops (removes) from the head of the list.

		// a stand-in until the code is complete.
		return null;
  }

}
