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
        if(head == null || head.next == null || head.next.next == null) {
            return;
        }
        ListNode crr = head;
        while(crr.next != null && crr.next.next != null) {
            crr = crr.next;
        }
        ListNode next = crr.next;
        crr.next = null;
        next.next = head.next;
        head.next = next;
        reorderList(next.next);
    }
}