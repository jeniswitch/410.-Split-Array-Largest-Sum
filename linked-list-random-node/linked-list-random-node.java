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
    private ListNode h;
    private Random rand;
    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        h = head;
        rand = new Random();
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        ListNode crr = h;
        int i = 1;
        int r = crr.val;
        while(crr.next != null) {
            crr = crr.next;
            if(rand.nextInt(i + 1) == 0) {
                r = crr.val;
            }
            i++;
        }
        return r;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
