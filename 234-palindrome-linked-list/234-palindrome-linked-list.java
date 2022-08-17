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
        int len = 0;
        ListNode crr = head;
        while(crr != null) {
            crr = crr.next;
            len++;
        }
        return helper(head, len).isPalindrome;
    }
    class Result {
        ListNode node;
        boolean isPalindrome;
        Result() {}
    }
    private Result helper(ListNode node, int len) {
        Result res = new Result();
        if(node == null || len <= 0) {
            res.isPalindrome = true;
            res.node = node;
            return res;
        }
        else if(len == 1) {
            res.isPalindrome = true;
            res.node = node.next;
            return res;
        }
        res = helper(node.next, len - 2);
        if(res.node == null) {
            return res;
        }
        if(!res.isPalindrome || res.node.val != node.val) {
            res.isPalindrome = false;
            return res;
        }
        res.node = res.node.next;
        return res;
    }
}