class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        HashMap<String, String> p = new HashMap<>();
        HashMap<String, String> n = new HashMap<>();
        HashMap<String, TreeSet<String>> union = new HashMap<>();
        
        //initialization
        for(List<String> lst : accounts) {
            for(int i = 1; i < lst.size(); i++) {
                p.put(lst.get(i), lst.get(i));
                n.put(lst.get(i), lst.get(0));
            }
        }
        //path comparession
        for(List<String> lst : accounts) {
            String parrent = find(lst.get(1), p);
            for(int i = 2; i < lst.size(); i++) {
                p.put(find(lst.get(i), p), parrent);
            }
        }
        for(List<String> lst : accounts) {
            String parrent = find(lst.get(1), p);
            if(!union.containsKey(parrent)) {
                union.put(parrent, new TreeSet<>());
            }
            for(int i = 1; i < lst.size(); i++) {
                union.get(parrent).add(lst.get(i));
            }
        }
        List<List<String>> res = new ArrayList<List<String>>();
        for(String k : union.keySet()) {
            List<String> emails = new ArrayList(union.get(k));
            emails.add(0, n.get(k));
            res.add(emails);
        }
        return res;
    }
    private String find(String x, HashMap<String, String> p) {
        if(p.get(x) != x) p.put(x, find(p.get(x), p));
        return p.get(x);
    }
}