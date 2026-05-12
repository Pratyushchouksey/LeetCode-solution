/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
         // If list is empty
        if (head == null) {
            return null;
        }

        // Current pointer
        ListNode current = head;

        // Traverse the linked list
        while (current != null && current.next != null) {

            // If duplicate found
            if (current.val == current.next.val) {

                // Remove duplicate node
                current.next = current.next.next;

            } else {

                // Move forward
                current = current.next;
            }
        }

        return head;
    }
}