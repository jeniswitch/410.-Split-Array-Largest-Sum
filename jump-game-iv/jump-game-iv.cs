public class Solution {
    public int MinJumps(int[] arr) {
        if(arr.Length == 1) {
            return 0;
        }
        Dictionary<int, List<int>> dic = new Dictionary<int, List<int>>();
        for(int i = 0; i < arr.Length; i++) {
            if(!dic.ContainsKey(arr[i])) {
                dic.Add(arr[i], new List<int>(){i});
            }
            else {
                dic[arr[i]].Add(i);
            }
        }
        List<int> crr = new List<int>();
        crr.Add(0);
        bool[] visited = new bool[arr.Length];
        int step = 0;
        while(crr.Count > 0) {
           List<int> adjacents = new List<int>();
           for(int i = 0; i < crr.Count; i++) {
               int node = crr[i];
               if(node == arr.Length - 1) {
                   return step;
               }
               foreach(int child in dic[arr[node]]) {
                    if(!visited[child]) {
                        adjacents.Add(child);
                        visited[child] = true;
                    }
               }
              
               dic[arr[node]].Clear();
               int n = node + 1;
               int l = node - 1;
               if(n < arr.Length && !visited[n]) {
                   adjacents.Add(n);
                   visited[n] = true;
               }
               if(l > 0 && !visited[l]) {
                   adjacents.Add(l);
                   visited[l] = true;
               }
           }
           crr = adjacents;
           step++;
        }
        return 0;
    }
}