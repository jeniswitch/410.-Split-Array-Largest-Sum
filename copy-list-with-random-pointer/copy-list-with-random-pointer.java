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
    private HashMap<Node, Node> map;
    public Node copyRandomList(Node head) {
        map = new HashMap<>();
        return helper(head);
    }
    private Node helper(Node node) {
        if(node == null) return null;
        if(map.containsKey(node)) return map.get(node);
        Node n = new Node(node.val);
        map.put(node, n);
        n.next = helper(node.next);
        n.random = helper(node.random);
        return n;
    }
}