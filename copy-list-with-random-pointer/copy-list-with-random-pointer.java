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
    private int count;
    public Node copyRandomList(Node head) {
        map = new HashMap<>();
        return helper(head);
    }
    
    private Node helper(Node node) {
        if(node == null) return node;
        if(map.containsKey(node)) {
            return map.get(node);
        }
        Node newN = new Node(node.val);
        map.put(node, newN);
        newN.next = helper(node.next);
        newN.random = helper(node.random);
        return newN;
    }
}