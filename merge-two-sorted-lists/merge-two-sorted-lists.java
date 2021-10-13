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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) return null;
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode p1 = l1, p2 = l2;
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        while(p1 != null && p2 != null) {
            ListNode crr = null;
            if(p1.val <= p2.val) {
                crr = p1;
                p1 = p1.next;
            }
            else {
                crr = p2;
                p2 = p2.next;
            }
            p.next = crr;
            p = crr;
        }
        if(p1 != null) p.next = p1;
        if(p2 != null) p.next = p2;
        return dummy.next;
    }
}