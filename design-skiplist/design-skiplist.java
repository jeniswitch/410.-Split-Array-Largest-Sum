class Skiplist {
    public class Node {
        int val;
        Node next, down;
        public Node(int v, Node n, Node d) {
            val = v;
            next = n;
            down = d;
        }
    }
    private Node head;
    private Random rand;
    public Skiplist() {
        head = new Node(0, null, null);
        rand = new Random();
    }
    
    public boolean search(int target) {
        Node crr = head;
        while(crr != null) {
            while(crr != null && crr.next != null && crr.next.val < target) {
                crr = crr.next;
            }
            if(crr.next != null && crr.next.val == target) {
                return true;
            }
            crr = crr.down;
        }
        return false;
    }
    
    public void add(int num) {
        Node crr = head;
        boolean insert = true;
        Stack<Node> stack = new Stack<Node>();
        while(crr != null) {
            while(crr != null && crr.next != null && crr.next.val < num) {
                crr = crr.next;
            }
            stack.push(crr);
            crr = crr.down;
        }
        Node down = null;
        while(insert && !stack.isEmpty()) {
            crr = stack.pop();
            crr.next = new Node(num, crr.next, down);
            down = crr;
            insert = rand.nextDouble() > 0.5;
        }
    }
    
    public boolean erase(int num) {
        Node crr = head;
        boolean found = false;
        while(crr != null) {
            while(crr != null && crr.next != null && crr.next.val < num) {
                crr = crr.next;
            }
            if(crr.next != null && crr.next.val == num) {
                found = true;
                crr.next = crr.next.next;
            }
            crr = crr.down;
        }
        return found;
    }
}

/**
 * Your Skiplist object will be instantiated and called as such:
 * Skiplist obj = new Skiplist();
 * boolean param_1 = obj.search(target);
 * obj.add(num);
 * boolean param_3 = obj.erase(num);
 */