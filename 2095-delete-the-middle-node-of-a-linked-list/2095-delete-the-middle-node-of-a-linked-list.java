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
    public ListNode deleteMiddle(ListNode head) {
        ListNode crr = head;
        int count = 0;
        while(crr != null) {
            crr = crr.next;
            count++;
        }
        if(count < 2) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = null;
        if(count % 2 == 0) {
            crr = dummy; 
            fast = crr;
        }
        else {
            crr = head;
            fast = crr.next.next;
        }
        while(fast.next != null) {
            fast = fast.next.next;
            crr = crr.next;
        }
        crr.next = crr.next.next;
        return head;
    }
}