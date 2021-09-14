class Solution {
    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        List<Set<String>> sets = new ArrayList<>();
        int n = favoriteCompanies.size();
        for(List<String> lst : favoriteCompanies) {
            sets.add(new HashSet<>(lst));
        }
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            boolean found = false;
            Set<String> seti = sets.get(i);
            for(int j = 0; j < n; j++) {
                Set<String> setj = sets.get(j);
                if(i != j && seti.size() < setj.size() && setj.containsAll(seti)) {
                    found = true;
                    break;
                }
            }
            if(!found) {
                res.add(i);
            }
        }
        return res;

    }
}
