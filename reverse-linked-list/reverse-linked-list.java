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
    public ListNode reverseList(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return head;
        ListNode pre = null, crr = head, next = null;
        while(crr != null) {
            next = crr.next;
            crr.next = pre;
            pre = crr;
            crr = next;
        }
        return pre;
    }
    
}