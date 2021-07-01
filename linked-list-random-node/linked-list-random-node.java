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
    private int[] arr;
    private final int N = (int)1e4;
    private ListNode h;
    private int len;
    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        arr = new int[N];
        h = head;
        ListNode crr = h;
        int idx = 0;
        while(crr != null) {
            arr[idx++] = crr.val;
            crr = crr.next;
        }
        len = idx;
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        Random rdm = new Random();
        return arr[rdm.nextInt(len)];
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */