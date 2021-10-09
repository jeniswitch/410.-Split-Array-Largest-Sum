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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next == null) return null; 
        int step = 0;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy, fast = dummy;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            step++;
        }
        if(fast == null) {
            step = 2 * step - 1 - n;
        }
        else step = 2 * step - n;
        if(step == 0) {
            return dummy.next.next;
        }
        slow = dummy;
        while(step > 0) {
            slow = slow.next;
            step--;
        }
        if(slow != null && slow.next != null)
        slow.next = slow.next.next;
        return dummy.next;
    }
}