/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node crr = head;
        HashMap<Node, Node> map = new HashMap<>();
        return helper(crr, map);
    }
    private Node helper(Node crr, HashMap<Node, Node> map) {
        if(crr == null) return null;
        if(map.containsKey(crr)) {
            return map.get(crr);
        }
        Node node = new Node(crr.val);
        map.put(crr, node);
        node.next = helper(crr.next, map);
        node.random = helper(crr.random, map);
        return node;
    }
}