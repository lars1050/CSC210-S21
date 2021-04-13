### Heap Exercise

A heap is visualized as a tree but stored as an array. A heap has the property that the root is the maximum element within the data structure. Furthermore, for any node in the tree, it is the maximum of all nodes in its subtrees. 

Implement the following:
- maxHeapify(int index) : This "sinks" the data at the given node down into its proper place in the tree.
- extractMax() : This removes the maximum element (root) and rearranges the tree to maintain its heap property.
- keyChanged(T item) : The modifies the data associated with that item. It should then rearrange the heap, as necessary, to maintain the heap property.

To test your code, 
- Convert the printed array to its tree form (on paper) and confirm that the tree is being created and maintained properly when adding elements. 
- Change a key value by increasing it enought to cause a reordering.
- Change a key value by decreasing it enough to cause a reordering.
- Add a for loop to extract the max until it is empty, printing each element. These should print from largest to smallest.

Submit on Moodle in the lab section.

