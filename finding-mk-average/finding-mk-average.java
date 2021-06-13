class MKAverage {
    private TreeMap<Integer, Integer> top;
    private TreeMap<Integer, Integer> middle;
    private TreeMap<Integer, Integer> bottom;
    private int countTop, countBottom;
    private long sum;
    private int m, k;
    private Queue<Integer> q;
    public MKAverage(int m, int k) {
        this.m = m;
        this.k = k;
        top = new TreeMap<Integer, Integer>();
        middle = new TreeMap<Integer, Integer>();
        bottom = new TreeMap<Integer, Integer>();
        countTop = 0;
        countBottom = 0;
        sum = 0;
        q = new LinkedList<Integer>();
    }
    
    public void addElement(int num) {
        if(q.size() == m) {
            int rem = q.poll();
            if(top.containsKey(rem)) {
                remove(top, rem);
                countTop--;
            }
            else if(middle.containsKey(rem)) {
                remove(middle, rem);
                sum -= rem;
            }
            else {
                remove(bottom, rem);
                countBottom--;
            }
        }
        q.offer(num);
        add(middle, num);
        sum += num;
        while(!middle.isEmpty() && countTop < k) {
            sum -= middle.lastKey();
            add(top, remove(middle, middle.lastKey()));
            countTop++;
        }
        while(!middle.isEmpty() && !top.isEmpty() && top.firstKey() < middle.lastKey()) {
            sum += top.firstKey();
            add(middle, remove(top, top.firstKey()));
            sum -= middle.lastKey();
            add(top, remove(middle, middle.lastKey()));
        }
        while(!middle.isEmpty() && countBottom < k) {
            sum -= middle.firstKey();
            add(bottom, remove(middle, middle.firstKey()));
            countBottom++;
        }
        while(!bottom.isEmpty() && !middle.isEmpty() && bottom.lastKey() > middle.firstKey()) {
            sum += bottom.lastKey();
            add(middle, remove(bottom, bottom.lastKey()));
            sum -= middle.firstKey();
            add(bottom, remove(middle, middle.firstKey()));
        }
    }
    
    public int calculateMKAverage() {
        if(q.size() < m) {
            return -1;
        }
        return (int)(sum / (m - 2 * k));
    }
    
    private int remove(TreeMap<Integer, Integer> tm, int num) {
        tm.put(num, tm.get(num) - 1);
        if(tm.get(num) == 0) {
            tm.remove(num);
        }
        return num;
    }
    
    private void add(TreeMap<Integer, Integer> tm, int num) {
        tm.put(num, tm.getOrDefault(num, 0) + 1);
    }
}

/**
 * Your MKAverage object will be instantiated and called as such:
 * MKAverage obj = new MKAverage(m, k);
 * obj.addElement(num);
 * int param_2 = obj.calculateMKAverage();
 */