/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pA = headA;
        ListNode pB = headB;
        int lenA = getLen(headA);
        int lenB = getLen(headB);
        while(lenA > lenB) {
            pA = pA.next;
            lenA--;
        }
        while(lenB > lenA) {
            pB = pB.next;
            lenB--;
        }
        while(pA != pB) {
            pA = pA.next;
            pB = pB.next;
        }
        return pA;
    }
    private int getLen(ListNode head) {
        int len = 0;
        ListNode crr = head;
        while(crr != null) {
            crr = crr.next;
            len++;
        }
        return len;
    }
}