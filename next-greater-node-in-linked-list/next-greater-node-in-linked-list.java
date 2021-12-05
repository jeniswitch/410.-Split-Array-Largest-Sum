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
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> lst = new ArrayList<>();
        ListNode node = head;
        while(node != null) {
            lst.add(node.val);
            node = node.next;
        }
        int[] res = new int[lst.size()];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < lst.size(); i++) {
            while(!stack.isEmpty() && lst.get(stack.peek()) < lst.get(i)) {
                res[stack.pop()] = lst.get(i);
            }
            stack.push(i);
        }
        return res;
    }
}