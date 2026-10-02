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

class Solution {
    private int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        int bestPath = findBestPath(root);
        return this.max;
    }

    private int findBestPath(TreeNode parent) {
        int currmax;
        int bestLeft = parent.left == null? 0 : findBestPath(parent.left);
        int bestRight = parent.right == null? 0 : findBestPath(parent.right);
        currmax =  Math.max(Math.max(Math.max(0, parent.val + bestRight), parent.val),  parent.val + bestLeft);
        max = Math.max(max, parent.val + bestRight + bestLeft);
        return currmax;
        
    }
}
