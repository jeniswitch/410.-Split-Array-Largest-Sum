/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node inorderSuccessor(Node node) {
        if(node == null) {
            return null;
        }
        if(node.right != null) {
            return leftmost(node.right);
        }
        else {
            Node c = node;
            Node p = node.parent;
            while(p != null && p.left != c) {
                c = p;
                p = p.parent;
            }
            return p;
        }
    }
    private Node leftmost(Node node) {
        while(node.left != null) {
            node = node.left;
        }
        return node;
    }
}