/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int sum = 0;
    public TreeNode bstToGst(TreeNode root) {
        
        if(root == null){
            return null;
        }
        root.right = bstToGst(root.right);
        sum += root.val;
        root.val = sum;
        root.left = bstToGst(root.left);
        return root;
    }
}