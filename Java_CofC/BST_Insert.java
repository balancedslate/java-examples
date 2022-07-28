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
// The purpose of this code is to insert a new node into a BST
// The runtime of this algorithim is

class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        // If the root is null, create a new BST
        if (root == null) {
                return new TreeNode(val);
            }
            // If the root is greater than the new value
            // Insert to the left per BST rules
            if (root.val > val) {
                root.left = insertIntoBST(root.left, val);
            }
            // If the root is less than the new value
            // Insert to the right per BST rules
            if (root.val < val) {
                root.right = insertIntoBST(root.right, val);
            }
            // Return the root to display the entire tree. 
            return root;
    }
}
