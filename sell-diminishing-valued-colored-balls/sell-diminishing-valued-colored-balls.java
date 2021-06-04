/*  orders = 6
    2   4   6   8   8   10
    2   4   6   8   8   8   total = 10 + 9, buy 2
    2   4   6   8   8   8   orders = 4, 4/3 = 1, 4%3 = 1, total+=(8 + 8 + 8) * 1 = 24 buy 3
                            total += (7) * 1 = 7, buy 1
    2 5
    2 2 (5 + 4 + 3)= 12 by 3
    orders = 1
*/
class Solution {
    public int maxProfit(int[] inventory, int orders) {
        Arrays.sort(inventory);
        int crrIndex = inventory.length - 1;
        int crrValue = inventory[crrIndex];
        int nextValue = 0;
        long profit = 0;
        while(orders > 0) {
            while(crrIndex >= 0 && inventory[crrIndex] == crrValue) {
                crrIndex--;
            }
            nextValue = crrIndex < 0 ? 0 : inventory[crrIndex];
            int repeatedTimes = inventory.length - 1 - crrIndex;
            int buy = (crrValue - nextValue) * repeatedTimes;
            if(buy <= orders) {
                int a = nextValue + 1;
                profit += (long)(crrValue + a) * (crrValue - a + 1) / 2 * repeatedTimes;
            }
            else {
                int loop = orders / repeatedTimes;
                int remainder = orders % repeatedTimes;
                int a = crrValue - loop + 1;
                profit += (long)(crrValue + a) * (crrValue - a + 1) / 2 * repeatedTimes;
                profit += (long)(crrValue - loop) * remainder;
            }
            orders -= buy;
            profit = profit % 1000000007;
            crrValue = nextValue;
        }
        return (int)profit;
    }
}