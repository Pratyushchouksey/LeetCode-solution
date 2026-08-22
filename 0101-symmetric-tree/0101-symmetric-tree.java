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
    public boolean isSymmetric(TreeNode root) {
        return fun(root.left, root.right);
    }
    public boolean fun(TreeNode root1, TreeNode root2) {
        //Dono null hai
        if(root1==null && root2==null){
            return true;
        }
        //dono me se koi ek null hai or ek nahi
        if(root1==null || root2==null){
            return false;
        }
        //dono ka value same nahi hai
        if(root1.val != root2.val){
            return false;
        }

        // Mirror check
        boolean r1 = fun(root1.left, root2.right);
        boolean r2 = fun(root1.right, root2.left);

        return r1 && r2;
        
    }
}