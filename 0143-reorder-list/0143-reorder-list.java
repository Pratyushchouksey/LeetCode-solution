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
    public void reorderList(ListNode head) {

        if(head == null || head.next == null) {
            return;
        }

        //find middle
        ListNode slow = head;
        ListNode fast = head;

        while(fast!= null && fast.next!= null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        //Reverse second half
        ListNode prev = null;
        ListNode curr = slow.next;

        // break first half
        slow.next = null;

        while(curr != null) {

            ListNode next = curr.next;

            curr.next = prev;

            prev = curr;
            curr = next;
        }

        // Step 3: Merge alternately
        ListNode first = head;
        ListNode second = prev;

        while(second != null)
        {
          ListNode temp1 = first.next;
          ListNode temp2 = second.next;

          first.next = second;
          second.next = temp1;

          first = temp1;
          second = temp2;
        }
    }
}