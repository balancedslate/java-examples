/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

// Author: Levi Kenley
// Class: CSCI230
// Professor: Dr. Sun
// Purpose: To delete a node from a BST
// Running Time:

class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
    // If the root is null you can't delete from it
    if(root == null) {
        return null;
    }
    // If the key is less than the root val, recursively call the delete func
    // On the left half, per BST rules
    if(key < root.val) {
        root.left = deleteNode(root.left, key);
    }
    // If it is greater than the root, delete based off the right half
    // per BST rules
    else if(key > root.val) {
        root.right = deleteNode(root.right, key);
    }    
    else{
         // If left is null, must be the right 
        if(root.left == null) {
            return root.right;
        }
        // If right is null, must be the left
        else if(root.right == null) {
            return root.left;
        }
        // Create and call a minimum node function
        TreeNode min = MinNum(root.right);
        //Swap the root for the minimum
        root.val = min.val;
        //Delete
        root.right = deleteNode(root.right, root.val);
    }
    
       // Return the root node
    return root;
}
// Minimum value function of BST
// Exists on the left of a BST
public TreeNode MinNum(TreeNode node) {
    // Go down strictly the left of the BST
    while(node.left != null) {
        node = node.left;
    }
    // When the node.left is null, this is the lowest value
    return node;
}
    
    
}