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
        LengthTail ltA = getLengthTail(headA);
        LengthTail ltB = getLengthTail(headB);
        if(ltA.tail != ltB.tail) {
            return null;
        }
        ListNode shorter = ltA.len <= ltB.len ? headA : headB;
        ListNode longer = ltA.len > ltB.len ? headA : headB;
        
        ListNode crrShorter = shorter;
        ListNode crrLonger = movePointer(longer, Math.abs(ltA.len - ltB.len));
        while(crrShorter != crrLonger) {
            crrShorter = crrShorter.next;
            crrLonger = crrLonger.next;
        }
        return crrShorter;
    }
    class LengthTail{
        int len;
        ListNode tail;
        public LengthTail(){};
        public LengthTail(int l, ListNode n){
            len = l;
            tail = n;
        }
    }
    private ListNode movePointer(ListNode head, int diff) {
        if(diff == 0) return head;
        ListNode crr = head;
        while(crr != null && diff > 0) {
            crr = crr.next;
            diff--;
        }
        return crr;
    }
    private LengthTail getLengthTail(ListNode head) {
        ListNode crr = head;
        LengthTail lt = new LengthTail();
        while(crr != null) {
            if(crr.next == null) {
                lt.tail = crr;
            }
            crr = crr.next;
            lt.len++;
        }
        return lt;
    }
}