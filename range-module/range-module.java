class RangeModule {
    private TreeMap<Integer, Integer> range;
    public RangeModule() {
        range = new TreeMap<Integer, Integer>();
    }
    
    public void addRange(int left, int right) {
        Integer start = range.floorKey(left);
        Integer end = range.floorKey(right);
        if(start != null && range.get(start) >= left) {
            //[1, 4)
            //   [4, 6)
            left = start;
        }
        if(end != null && range.get(end) > right) {
            right = range.get(end);
        }
        range.put(left, right);
        range.subMap(left, false, right, true).clear();
    }
    
    public boolean queryRange(int left, int right) {
        Integer start = range.floorKey(left);
        if(start == null) {
            return false;
        }
        return range.get(start) >= right;
    }
    
    public void removeRange(int left, int right) {
        Integer start = range.floorKey(left);
        Integer end = range.floorKey(right);
        //the order cannot be changed
        if(end != null && range.get(end) > right) {
            range.put(right, range.get(end));
        }
        if(start != null && range.get(start) > left) {
            range.put(start, left);
        }
        range.subMap(left, true, right, false).clear();
    }
}

/**
 * Your RangeModule object will be instantiated and called as such:
 * RangeModule obj = new RangeModule();
 * obj.addRange(left,right);
 * boolean param_2 = obj.queryRange(left,right);
 * obj.removeRange(left,right);
 */