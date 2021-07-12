class Solution {
    public int[] findBuildings(int[] heights) {
        List<Integer> lst = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(heights.length - 1);
        lst.add(heights.length - 1);
        for(int i = heights.length - 2; i >= 0; i--) {
            //System.out.println("i " + i);
            while(!stack.isEmpty() && heights[i] > heights[stack.peek()]) {
                lst.add(0, i);
                stack.pop();
            }
            if(stack.isEmpty() || !stack.isEmpty() && heights[i] > heights[stack.peek()]) {
                stack.push(i);
            }
            
        }
        int[] res = new int[lst.size()];
        for(int i = 0; i < lst.size(); i++) {
            res[i] = lst.get(i);
        }
        return res;
    }
}