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
    //recursion
    /*public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return helper(l1, l2, 0);
    }
    private ListNode helper(ListNode l1, ListNode l2, int add) {
        if(l1 == null && l2 == null) {
            if(add == 0) {
                return null;
            }
            else {
                return new ListNode(add);
            }
        }
        if(l1 == null) {
            return helper(l2, l1, add);
        }
        int s = l1.val + (l2 == null ? 0 : l2.val) + add;
        ListNode crr = new ListNode(s % 10);
        crr.next = helper(l1.next, l2 == null ? null : l2.next, s / 10);
        return crr;
    }*/
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode crr = dummy;
        int carry = 0;
        while(l1 != null || l2 != null || carry != 0) {
            int sum = 0;
            if(l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2 != null) {
                sum += l2.val; 
                l2 = l2.next;
            }
            sum += carry;
            carry = sum / 10;
            crr.next = new ListNode(sum % 10);
            crr = crr.next;
        }
        return dummy.next;
    }
}