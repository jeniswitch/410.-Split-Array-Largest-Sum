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
    private ListNode head, crr;
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        head = new ListNode(0);
        crr = head;
        helper(l1, l2, 0);
        return head.next;
    }
    private void helper(ListNode l1, ListNode l2, int carry) {
        if(l1 == null && l2 == null && carry == 0) {
            return;
        }
        ListNode node = new ListNode();
        int sum = carry;
        if(l1 != null) {
            sum += l1.val;
        }
        if(l2 != null) {
            sum += l2.val;
        }
        node.val = sum % 10;
        crr.next = node;
        crr = node;
        helper(l1 == null ? null : l1.next, l2 == null ? null : l2.next, sum / 10);
    }
}