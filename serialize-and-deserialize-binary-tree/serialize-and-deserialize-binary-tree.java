/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    private Queue<TreeNode> q;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        q = new LinkedList<TreeNode>();
        if(root == null) {
            return "";
        }
        String res = "";
        q.offer(root);
        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            if(node == null) {
                res += "n ";
                continue;
            }
            res += String.valueOf(node.val) + " ";
            q.offer(node.left);
            q.offer(node.right);
        }
        return res;
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length() == 0) {
            return null;
        }
        String[] arr = data.split(" ");
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        q.offer(root);
        for(int i = 1; i < arr.length; i++) {
            TreeNode node = q.poll();
            if(!arr[i].equals("n")) {
                TreeNode left = new TreeNode(Integer.parseInt(arr[i]));
                node.left = left;
                q.offer(left);
            }
            if(!arr[++i].equals("n")) {
                TreeNode right = new TreeNode(Integer.parseInt(arr[i]));
                node.right = right;
                q.offer(right);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));