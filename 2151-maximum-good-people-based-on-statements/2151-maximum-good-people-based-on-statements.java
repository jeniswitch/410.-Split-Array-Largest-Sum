class Solution {
    private int max;
    public int maximumGood(int[][] statements) {
        max = 0;
        int count = 0;
        for(int i = 0; i < statements.length; i++) {
            HashSet<Integer> good = new HashSet<>();
            good.add(i);
            System.out.println("restart from " + i);
            HashSet<Integer> bad = new HashSet<>();
            HashSet<Integer>[]  res = dfs(statements, i, good, bad);
            if(res != null) {
                good = res[0];
                bad = res[1];
                if(good.size() + bad.size() < statements.length) {
                    for(int j = 0; j < statements.length; j++) {
                        if(!good.contains(j) && !bad.contains(j)) {
                            HashSet<Integer> tempGood = new HashSet<>(good);
                            HashSet<Integer> tempBad = new HashSet<>(bad);
                            tempGood.add(j);
                            HashSet<Integer>[]  temp = dfs(statements, j, tempGood, tempBad);
                            if(temp == null) {
                                continue;
                            }
                            good = temp[0];
                            bad = temp[1];
                        }
                    }
                }
                max = Math.max(good.size(), max);
            }
        }
        return max;
    }
    private HashSet<Integer>[] dfs(int[][] statements, int person, HashSet<Integer> good, HashSet<Integer> bad) {
        for(int i = 0; i < statements.length; i++) {
            if(statements[person][i] == 1 && !good.contains(i)) {
                if(bad.contains(i)) {
                    return null;
                }
                System.out.println("add " + i + " to good");
                good.add(i);
                HashSet<Integer>[] res = dfs(statements, i, good, bad);
                if(res == null) {
                    System.out.println(i + " return null");
                    return null;
                }
                good = res[0];
                bad = res[1];
            }
            else if(statements[person][i] == 0) {
                if(good.contains(i)) {
                    System.out.println(i + " return null 2");
                    return null;
                }
                bad.add(i);
                System.out.println("add " + i + " to bad");
            }
            
        }
        System.out.println("person " + person + " return good bad");
        HashSet<Integer>[] res = new HashSet[2];
        res[0] = good;
        res[1] = bad;
        return res;
    }
}