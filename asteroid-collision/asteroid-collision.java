class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        ArrayList<Integer> lst = new ArrayList<>();
        for(int a : asteroids) {
            if(lst.size() == 0) {
                lst.add(a);
            }
            else {
                int top = lst.get(lst.size() - 1);
                if(top > 0 && a < 0) {
                    if(Math.abs(top) == Math.abs(a)) {
                        lst.remove(lst.size() - 1);
                    }
                    else if(Math.abs(top) < Math.abs(a)) {
                        lst.set(lst.size() - 1, a);
                        while(lst.size() > 1) {
                            int last = lst.get(lst.size() - 1);
                            int pre = lst.get(lst.size() - 2);
                            if(pre > 0 && last < 0) {
                                int absLast = Math.abs(last);
                                int absPre = Math.abs(pre);
                                if(absLast == absPre) {
                                    lst.remove(lst.size() - 1);
                                    lst.remove(lst.size() - 1);
                                }
                                else if(absLast < absPre) {
                                    lst.remove(lst.size() - 1);
                                }
                                else {
                                    lst.remove(lst.size() - 2);
                                }
                            }
                            else {
                                break;
                            }
                        }
                    }
                }
                else {
                    lst.add(a);
                }
            }
        }
        int[] arr = lst.stream().mapToInt(i -> i).toArray();
        return arr;
    }
}