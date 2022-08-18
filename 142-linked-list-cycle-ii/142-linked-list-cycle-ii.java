/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        Result res = hasCycle(head);
        
        if(!res.res) {
            return null;
        }
        ListNode p1 = head, p2 = res.node;
        while(p1 != p2) {           
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }
    class Result{
        ListNode node;
        boolean res;
        Result() {};
    }
    private Result hasCycle(ListNode head) {
        Result res = new Result();
        if(head == null || head.next == null) {
            return res;
        }
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null) {
            
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                res.node = slow;
                res.res = true;
                return res;
            }
        }
        return res;
    }
}