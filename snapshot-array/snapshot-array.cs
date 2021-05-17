public class SnapshotArray {
    private SortedList<int, int>[] dic;
    private int snap_id;
    public SnapshotArray(int length) {
        dic = new SortedList<int, int>[length];
        snap_id = 0;
        for(int i = 0; i < length; i++) {
            dic[i] = new SortedList<int, int>();
            dic[i][snap_id] = 0;
        }
    }
    
    public void Set(int index, int val) {
        dic[index][snap_id] = val;
    }
    
    public int Snap() {
        return snap_id++;
    }
    
    public int Get(int index, int snap_id) {
        if(dic[index].ContainsKey(snap_id)) {
            return dic[index][snap_id];
        }
        if(dic[index].Keys.Last() < snap_id) {
            return dic[index].Values.Last();
        }
        if(dic[index].Keys.First() > snap_id) {
            return dic[index].Values.First();
        }
        dic[index].Add(snap_id, -1);
        int idx = dic[index].IndexOfKey(snap_id);
        idx = idx > 1? idx - 1 : 0;
        Console.WriteLine(dic[index].Count);
        int val = dic[index].Values[idx];
        dic[index].Remove(snap_id);
        return val;
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.Set(index,val);
 * int param_2 = obj.Snap();
 * int param_3 = obj.Get(index,snap_id);
 */