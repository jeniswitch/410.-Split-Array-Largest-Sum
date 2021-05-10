public class RandomizedCollection {
    private List<int> lst;
    private Dictionary<int, HashSet<int>> dic;
    private Random rd;
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        lst = new List<int>();
        dic = new Dictionary<int, HashSet<int>>();
        rd = new Random();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public bool Insert(int val) {
        if(dic.ContainsKey(val)) {
            dic[val].Add(lst.Count);
        }
        else {
            dic.Add(val, new HashSet<int>(){lst.Count});
        }
        lst.Add(val);
        return dic[val].Count == 1;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public bool Remove(int val) {
        if(!dic.ContainsKey(val) || dic[val].Count == 0) {
            return false;
        }
        int removIndex = dic[val].First();
        int lastIndex = lst.Count - 1;
        int lastVal = lst[lastIndex];
        dic[val].Remove(removIndex);
        lst[removIndex] = lastVal;
        dic[lastVal].Add(removIndex);
        dic[lastVal].Remove(lastIndex);
        
        lst.RemoveAt(lastIndex);
      
        return true;
    }
    
    /** Get a random element from the collection. */
    public int GetRandom() {
        return lst[rd.Next(0, lst.Count)];
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * bool param_1 = obj.Insert(val);
 * bool param_2 = obj.Remove(val);
 * int param_3 = obj.GetRandom();
 */