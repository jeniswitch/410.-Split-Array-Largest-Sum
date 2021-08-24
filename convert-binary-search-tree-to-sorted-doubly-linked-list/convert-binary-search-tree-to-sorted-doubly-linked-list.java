/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/

class Solution {
    private List<Integer> lst;
    public Node treeToDoublyList(Node root) {
        lst = new ArrayList<Integer>();
        Node head = new Node(0);
        if(root == null) {
            return null;
        }
        helper(root);
        Node pre = head;
        for(int i = 0; i < lst.size(); i++) {
            Node node = new Node(lst.get(i));
            if(i == 0) {
                head.right = node;
            }
            else {
                node.left = pre;
                pre.right = node;
            }
            pre = node;
        }
        head.right.left = pre;
        pre.right = head.right;
        return head.right;
    }
    private void helper(Node node) {
        if(node == null) {
            return;
        }
        helper(node.left);
        lst.add(node.val);
        helper(node.right);
    }
}