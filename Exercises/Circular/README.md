### FIFO Circular Queue

This code starts an FIFO Queue using a Circular Queue with a dummy node.
- FIFO means First-In-First-Out (add at end, remove at front)
- Circular means that the tail points to the head.
- "dummy" means that the head is always a node with null data.

Note that there is no _count_ of how many elements are in the queue. No `.next` pointer points to null. There is not a method that tests if the list is empty or full.

Write the `push` and `pop` methods. Do not add any other member variables or methods. **There is only 1 special case that you have to watch for in the pop method.** This means you only need 1 if-statement in the pop method and 0 if-statements in the push method! You can add more if you like, but it is not needed.

1. Draw the pictures for an FIFO queue.
	- Start "empty" (meaning only the dummy node) and add 1 element to the queue.
	- Start with 1 element in the queue and add another.
	- Start with 2 elements and remove one.
	- Start with 1 element and remove it.
2. Add the comments.
3. Write the code.

If successful, when you run Main you will see:

```
QUEUE 1 2 3

1
2
3

QUEUE
```
