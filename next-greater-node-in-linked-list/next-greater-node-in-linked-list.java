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
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> arr = new ArrayList<>();
        ListNode node = head;
        while(node != null) {
            arr.add(node.val);
            node = node.next;
        }
        int[] res = new int[arr.size()];
        for(int i = 0; i < arr.size(); i++) {
            while(!stack.isEmpty() && arr.get(stack.peek()) < arr.get(i)) {
                res[stack.pop()] = arr.get(i);
            }
            stack.push(i);
        }
        return res;
    }
}