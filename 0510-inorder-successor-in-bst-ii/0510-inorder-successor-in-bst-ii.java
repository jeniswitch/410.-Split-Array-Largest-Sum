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
        while(node.parent != null && node.parent.left != node) {
            node = node.parent;
        }
        return node.parent;
    }
    private Node leftmost(Node node) {
        while(node.left != null) {
            node = node.left;
        }
        return node;
    }
}