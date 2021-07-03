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
    private ListNode head;
    public ListNode mergeKLists(ListNode[] lists) {        
        Arrays.sort(lists, (a, b) -> (a != null && b!= null) ? a.val - b.val : (a == null? -1 : 1));
        head = new ListNode(0);
        for(int i = 0; i < lists.length; i++) {
            merge(lists, i);
        }
        return head.next;
    }
    private void merge(ListNode[] lst, int i) {
        if(lst[i] == null) {
            return;
        }
        if(head.next == null) {
            head.next = lst[i];
            return;
        }
        ListNode p1 = head.next;
        ListNode crr = lst[i];
        ListNode p2 = crr;
        while(p1.next != null && p2 != null) {
            ListNode pre = p2;
            while(p1.next != null && p2 != null && p1.val <= p2.val && p1.next.val >= p2.val) {
                pre = p2;
                p2 = p2.next;
            }
            p2 = pre;
            if(p1.next != null && p1.next.val >= p2.val) {
                ListNode next = p2.next;
                p2.next = p1.next;
                p1.next = crr;
                p1 = p2.next;
                p2 = next;
                crr = next;
            }
            else if(p1.next != null){
                p1 = p1.next;
            }
            if(p2 == null) {
                return;
            }
        }
        if(p2 != null) {
            p1.next = p2;
        }
    }
}