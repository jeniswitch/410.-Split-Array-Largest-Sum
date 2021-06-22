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
    public ListNode deleteNodes(ListNode head, int m, int n) {
        int countm = 0, countn = 0;
        ListNode pm  = head, pn = head;
        while(pm != null && pn != null) {
            while(countm < m - 1 && pm != null) {
                pm = pm.next;
                countm++;
            }
            if(pm == null) {
                return head;
            }
            pn = pm;
            countn = 0;
            while(countn < n && pn != null) {
                pn = pn.next;
                countn++;
            }
            pm.next = pn == null ? null : pn.next;
            pm = pm.next;
            countm = 0;
        }
        return head;
    }
}