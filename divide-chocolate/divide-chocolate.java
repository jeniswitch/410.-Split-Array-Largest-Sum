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
/*
public int maximizeSweetness(int[] A, int K) {
        int left = 1, right = (int)1e9 / (K + 1);
        while (left < right) {
            int mid = (left + right + 1) / 2;
            int cur = 0, cuts = 0;
            for (int a : A) {
                if ((cur += a) >= mid) {
                    cur = 0;
                    if (++cuts > K) break;
                }
            }
            if (cuts > K)
                left = mid;
            else
                right = mid - 1;
        }
        return left;
    }
*/