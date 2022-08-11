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
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode crr = null;
        if(fast != null) {
            crr = slow.next;
        }
        else {
            crr = slow;
        }
        while(crr != null) {
            stack.push(crr.val);
            crr = crr.next;
        }
        slow = head;
        while(!stack.isEmpty()) {
            if(slow.val != stack.pop()) {
                return false;
            }
            slow = slow.next;
        }
        return true;
    }
}