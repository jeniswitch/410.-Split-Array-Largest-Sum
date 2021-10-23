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
        if(head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy, crr = head;
        while(crr != null) {
            if(crr.next != null && pre.next.val == crr.next.val) {
                while(crr != null && crr.next != null && pre.next.val == crr.next.val) {
                    crr = crr.next;
                }
                pre.next = crr.next;
                crr = crr.next;
            }
            else {
                pre = crr;
                crr = crr.next;
            }
        }
        return dummy.next;
    }
}