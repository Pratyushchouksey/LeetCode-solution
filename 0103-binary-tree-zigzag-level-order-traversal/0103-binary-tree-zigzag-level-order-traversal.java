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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        // Edge Case
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        // Root ko queue me daalo
        queue.offer(root);

        // false = Left to Right
        // true  = Right to Left
        boolean reverse = false;

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
            // Reverse every alternate level
            if (reverse) {
                Collections.reverse(level);
            }

            result.add(level);

            // Change direction
            reverse = !reverse;
        }
        return result;
    }
}