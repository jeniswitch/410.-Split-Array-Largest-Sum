/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        Node levelStart = root;
        while(levelStart != null) {
            Node crr = levelStart;
            while(crr != null) {
                if(crr.left != null) crr.left.next = crr.right;
                if(crr.right != null && crr.next != null) crr.right.next = crr.next.left;
                crr = crr.next;
            }
            levelStart = levelStart.left;
        }
        return root;
    }
}