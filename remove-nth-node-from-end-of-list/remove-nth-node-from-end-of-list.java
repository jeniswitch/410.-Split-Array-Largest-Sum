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
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        helper(dummy, n);
        return dummy.next;
    }
    private int helper(ListNode node, int n) {
        if(node == null) return 0;
        int nextNum = helper(node.next, n);
        if(nextNum == n) {
            node.next = node.next.next;
        }
        return nextNum + 1;
    }
}