class Solution {
    public int maximizeSweetness(int[] sweetness, int K) {
        int l = 1, r = (int)1e9 / (K + 1);
        while(l < r) {
            int mid = l + r + 1 >> 1;
            int cut = 0, localSweetness = 0;
            for(int item : sweetness) {
                localSweetness += item;
                if(localSweetness >= mid) {
                    localSweetness = 0;
                    if(++cut > K) {
                        break;
                    }
                }
            }
            if(cut > K) {
                l = mid;
            }
            else {
                r = mid - 1;
            }
        }
        return l;
    }
}
