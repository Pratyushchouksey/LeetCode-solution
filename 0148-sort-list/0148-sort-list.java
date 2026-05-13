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
    public ListNode merge(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }

        // attach remaining nodes
        curr.next = (list1 != null) ? list1 : list2;

        return dummy.next;
    }
    public ListNode sortList(ListNode head) {
        if (head == null ||  head.next == null) return head;
        ListNode firsthalf = head;
        ListNode slow = head;
        ListNode fast = head;
     while(fast.next!= null && fast.next.next!=null){
        slow = slow.next;
        fast = fast.next.next;

     }
     ListNode secondhalf = slow.next;
     slow.next = null;
        firsthalf = sortList(firsthalf);
         secondhalf = sortList(secondhalf);
       ListNode ans = merge(firsthalf,secondhalf);
  return ans;
    }

}