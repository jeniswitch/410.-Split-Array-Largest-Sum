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
        ListNode slow = head, fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode middle = slow, p = slow.next;
        while(p.next != null) {
            ListNode next = p.next;
            p.next = next.next;
            next.next = middle.next;
            middle.next = next;
        }
        ListNode h1 = head;
        while(h1 != slow) {
            ListNode next2 = slow.next;
            ListNode next1 = h1.next;
            slow.next = next2.next;
            next2.next = h1.next;
            h1.next = next2;
            h1 = next1;
        }
    }
}