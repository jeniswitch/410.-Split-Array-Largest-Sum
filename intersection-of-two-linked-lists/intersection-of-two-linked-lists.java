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
        ListNode pA =  headA;
        ListNode pB = headB;
        while(pA != pB) {
            pA = pA == null ? headA : pA.next;
            pB = pB == null ? headB : pB.next;
        }
        return pA;
    }
}