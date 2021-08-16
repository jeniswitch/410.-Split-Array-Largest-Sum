class Solution {
    public int slidingPuzzle(int[][] board) {
        String start = "";
        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < 3; j++) {
                start += board[i][j];
            }
        }
        return bfs(board, start);
    }
    private int bfs(int[][] board, String start) {
        HashMap<String, Integer> map = new HashMap<>();
        final int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Queue<String> q = new LinkedList<>();
        q.offer(start);
        map.put(start, 0);
        String end = "123450";
        
        while(!q.isEmpty()) {
            String crr = q.poll();
            int dis = map.containsKey(crr)? map.get(crr) : 0;
            if(crr.equals(end)) {
                return dis;
            }
            int p = crr.indexOf('0');
            int x = p / 3, y = p % 3;
            for(int i = 0; i < dir.length; i++) {
                int a = x + dir[i][0];
                int b = y + dir[i][1];
                if(a >= 0 && a < 2 && b >= 0 && b < 3) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(crr);
                    int index = a * 3 + b;
                    char c = crr.charAt(index);
                    sb.setCharAt(index, '0');
                    sb.setCharAt(p, c);
                    String str = sb.toString();
                    
                    if(!map.containsKey(str)) {
                        map.put(str, dis + 1);
                        q.offer(str);
                    } 
                }
            }
        }
        return -1;
    }
}