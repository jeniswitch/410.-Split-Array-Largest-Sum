class Solution {
    private int[] p;
    private List<Set<String>> sets;
    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        int n = favoriteCompanies.size();
        sets = new ArrayList<>();
        for(List<String> lst : favoriteCompanies) {
            sets.add(new HashSet<>(lst));
        }
        p = new int[n];
        for(int i = 0; i < n; i++) {
            p[i] = i;
        }
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                union(i, j);
            }
        }
        HashSet<Integer> s = new HashSet<>();
        for(int i = 0; i < n; i++) {
            s.add(find(i));
        }
        List<Integer> res = new ArrayList<>();
        res.addAll(s);
        Collections.sort(res);
        return res;
    }
    private int find(int x) {
        if(x != p[x]) p[x] = find(p[x]);
        return p[x];
    }
    private void union(int x, int y) {
        int px = find(x);
        int py = find(y);
        if(px != py) {
            if(check(px, py)) {
                p[py] = px;
            }
            else if(check(py, px)) {
                p[px] = py;
            }
        }
    }
    private boolean check(int x, int y) {
        Set<String> xs = sets.get(x);
        Set<String> ys = sets.get(y);
        if(xs.size() < ys.size()) return false;
        return xs.containsAll(ys);
    }
}