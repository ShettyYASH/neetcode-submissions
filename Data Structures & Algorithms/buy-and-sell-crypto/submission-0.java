class Solution {
    public int maxProfit(int[] prices) {
        int left=0;
        int right=1;
        int maxp=0;
        while(right<prices.length) {
            if(prices[left]<prices[right]) {
                int profit=prices[right]-prices[left];
                maxp=Math.max(profit,maxp);
                
                right++;
            }
            else {
                left=right;
                right++;
            }
        }
        return maxp;

        
    }
}
