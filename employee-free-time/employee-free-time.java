/*
// Definition for an Interval.
class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};
*/

class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> res = new ArrayList<>();
        List<Interval> lst = new ArrayList<>();
        schedule.forEach(e -> lst.addAll(e));
        Collections.sort(lst, ((a, b) -> a.start - b.start));
        Interval temp = lst.get(0);
        for(Interval itv : lst) {
            if(temp.end < itv.start) {
                res.add(new Interval(temp.end, itv.start));
                temp = itv;
            }
            else {
                temp = temp.end < itv.end ? itv : temp;
            }
        }
        return res;
    }
}