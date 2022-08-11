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
    public ListNode partition(ListNode head, int x) {
        ListNode dummyL = new ListNode(0);
        ListNode dummyR = new ListNode(0);
        ListNode crr = head, crrL = dummyL, crrR = dummyR;
        while(crr != null) {
            if(crr.val < x) {
                crrL.next = crr;
                crrL = crr;
            }
            else {
                crrR.next = crr;
                crrR = crr;
            }
            crr = crr.next;
        }
        crrR.next = null;
        crrL.next = dummyR.next;
        return dummyL.next;
    }
}