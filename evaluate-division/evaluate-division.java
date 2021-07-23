class Solution {
    private HashMap<String, HashMap<String, Double>> g;
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        g = new HashMap<>();
        buildGragh(equations, values);
        double[] res = new double[queries.size()];
        for(int i = 0; i < queries.size(); i++) {
            res[i] = dfs(queries.get(i).get(0), queries.get(i).get(1), new HashSet<>());
        }
        return res;
    }
    private void buildGragh(List<List<String>> equations, double[] values) {
        for(int i = 0; i < equations.size(); i++) {
            String l = equations.get(i).get(0);
            String r = equations.get(i).get(1);
            g.putIfAbsent(l, new HashMap<String, Double>());
            g.putIfAbsent(r, new HashMap<String, Double>());
            g.get(l).put(r, values[i]);
            g.get(r).put(l, 1 / values[i]);
        }
    }
    private double dfs(String l, String r, HashSet<String> visited) {
        if(!g.containsKey(l)) {
            return -1;
        }
        if(g.get(l).containsKey(r)) {
            return g.get(l).get(r);
        }
        visited.add(l);
        for(Map.Entry<String, Double> neighbour : g.get(l).entrySet()) {
            if(!visited.contains(neighbour.getKey())) {
                double pdt = dfs(neighbour.getKey(), r, visited);
                if(pdt != -1) {
                    return pdt * neighbour.getValue();
                }
            }
        }
        return -1;
    }
}