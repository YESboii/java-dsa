package Tree.AVL;

import java.util.HashMap;

/*
Adelson-Velsky and Landis
A self-balancing BST where each node is associated with a balance factor(*)
and the balance factor must be (|1| , 0) else it is a violation

Search - O(log n)
insert - O(log n ) + O(1) for balancing at max 2 rotations.
Delete - O(log n) + O(log n) must rotate at every level

and we must balance the tree.
4 cases:
LL,RR,LR,RL
**Balance factor is the difference between the height of left subtree and right subtree.
 */
public class AVL {

}

