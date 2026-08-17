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
    public List<List<Integer>> levelOrder(TreeNode root) {
         List<List<Integer>> result = new ArrayList<>();

        // Edge Case
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        // Root ko queue me daalo
        queue.offer(root);

        while (!queue.isEmpty()) {

            // Current level me kitne nodes hain
            int levelSize = queue.size();

            List<Integer> level = new ArrayList<>();

            // Current level ke saare nodes process karo
            for (int i = 0; i < levelSize; i++) {

                TreeNode node = queue.poll();

                // Current node ko level list me add karo
                level.add(node.val);

                // Left child
                if (node.left != null) {
                    queue.offer(node.left);
                }

                // Right child
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            // Current level ko final result me add karo
            result.add(level);
        }

        return result;
    }
}