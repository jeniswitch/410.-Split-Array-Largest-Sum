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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k == 1) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int count = 1;
        ListNode crr = head;
        ListNode dummyh = new ListNode(0);
        ListNode lastTail = null;
        while(crr != null && hasKNodes(crr, k)) {
            while(crr != null && crr.next != null && count < k) {
                count++;
                ListNode next = crr.next;
                crr.next = next.next;
                next.next = dummy.next;
                dummy.next = next;
            }
            if(dummyh.next == null) {
                dummyh.next = dummy.next;
            }
            if(lastTail != null) {
                lastTail.next = dummy.next;
            }
            count = 1;
            lastTail = crr;
            crr = crr.next;
            dummy.next = crr;
        }
        return dummyh.next;
    }
    private boolean hasKNodes(ListNode node, int k) {
        int count = 0;
        ListNode n = node;
        while(n != null) {
            n = n.next;
            count++;
            if(count == k) {
                return true;
            }
        }
        return false;
    }
}