## Project 3
### Trees, Recursion, and Tree Search
#### DUE: Thursday, April 22 end-of-day (I will accept up to April 27 end-of-day. No late penalty for this assignment.)
#### Zip all files and submit via Moodle

<hr>

Use the work from the last lab and from the in-class exercise to complete this project.

> Extensive tests have not been provided for this project. It is up to you to confirm that your code is functional. When you first test, use Integers -- it's easy! I have again included the class Simple that has alpha and numeric fields, for testing reordering.

### Implementation

1. Implement `void add(T object)`. A buggy version was provided in an in-class exercise, which you then corrected. Add that code to this method.

2. Implement `BinaryNode<T> find(T object)`. Return the first *BINARYNODE* in the tree that contains the data that is equal to the object. If it is not in the tree, return null.

3. Implement `public ArrayList<T> toArrayList()`. Convert to an array IN ORDER according to orderBy.

5. Implement `public void balance()`. Reorganize the tree so that it is balanced. You do not have to rotate nodes to do this. Probably the easiest is to put everything into an array by performing an inorder traversal (DFS or another iterative version), then build the tree back up. Place the median value as the root, then recursively add the median value of the left and right halves.

6. Implement `public void reorder(Comparator<T> comp)`. Rebuild the tree using this new comparator. It does not have to be balanced when you are done (but you can design the method so that it does balance it if you want -- sort the elements and build a balanced tree).

7. Implement `public void toString()`.

8. Add your lab implementation for `public class Queue<T>`.


10. Implement `public T min()` that returns the minimum value in the tree based on sorting order. Do not iterate over the entire tree to find minimum. It is always located at the same place in the tree!

11. Implement `public T max()` that returns the maximum value in the tree based on sorting order. Do not iterate over the entire tree to find maximum. It is always located at the same place in the tree!

12. Implement `public int calculateHeight()`. Write a recursive method to calculate the height of each node and return the tree height. The recursive definition of node height is:
```
  height(node) = -1,  if the node is null
  height(node) = max(height(node.left), height(node.right)) + 1, otherwise.
```
 _Note that as you add nodes, the height changes. You do not have to adjust the height as you add nodes (but you can if you want)._

13. Implement `public void calculateBalanceFactor()`. As described in Section 9.1 of zyBooks, a node's balance factor is the difference between the height of its left and right subtree. You can use any form of traversal to determine if the balance factor of each node.

13. Implement `public boolean isBalanced()`. Determine if the tree is balanced. This might make use of the `calculateBalanceFactor` or it might be independent of that method.

14. Modify `visualize()` to use the tree height to determine the height and width of the visualization. Probably add 16 to the width for each height of tree.

### Javadocs AND In-Line Comments

You know what to do!

> Did you remember to comment your code and finish your Javadocs?
