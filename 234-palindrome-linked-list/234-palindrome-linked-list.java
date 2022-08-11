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
    public boolean isPalindrome(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy, fast = dummy;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            stack.push(slow.val);
        }
        if(fast != null) {
            slow = slow.next;
        }
        while(!stack.isEmpty()) {
            if(slow.val != stack.pop()) {
                return false;
            }
            slow = slow.next;
        }
        return true;
    }
}