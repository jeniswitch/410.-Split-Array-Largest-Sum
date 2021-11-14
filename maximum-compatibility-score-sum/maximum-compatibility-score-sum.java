class Solution {
    private int max;
    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        max = 0;
        dfs(students, mentors, 0, 0, new boolean[students.length]);
        return max;
    }
    private void dfs(int[][] students, int[][] mentors, int p, int score, boolean[] visited) {
        if(p == students.length) {
            max = Math.max(max, score);
        }
        for(int i = 0; i < mentors.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(students, mentors, p + 1, score + getScore(students[p], mentors[i]), visited);
                visited[i] = false;
            }
        }
    }
    private int getScore(int[] student, int[] mentor) {
        int s = 0;
        for(int i = 0; i < student.length; i++) {
            if(student[i] == mentor[i]) {
                s++;
            }
        }
        return s;
    }
}