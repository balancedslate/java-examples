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
// The purpose of this code is to search a binary tree recursively


class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        // Check the root to be null
        // Check the root to be equal to val, base case
        if (root == null || root.val == val){
            return root;
        }
        // If the value is less than the root, recursively search the left half
        if (val < root.val){
            return searchBST(root.left, val);
        } 
        // Else, recursively search the right half
        else {
            return searchBST(root.right, val);
        }
    }
}