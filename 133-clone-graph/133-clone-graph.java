/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        Map<Node, Node> visited = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.offer(node);
        visited.put(node, new Node(node.val));
        while(!q.isEmpty()) {
            Node crr = q.poll();
            for(Node nb : crr.neighbors) {
                if(!visited.containsKey(nb)) {
                    visited.put(nb, new Node(nb.val));
                    q.offer(nb);
                }
                visited.get(crr).neighbors.add(visited.get(nb));
            }
        }
        return visited.get(node);
    }
}