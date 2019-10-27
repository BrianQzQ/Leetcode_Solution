//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
public class Q_121 {

    public static void main(String[] args) {
        int[]prices={7,1,5,3,6,4};
        Q_121 q=new Q_121();
        q.maxProfit(prices);
    }
    public int maxProfit(int[] prices) {
        //int N = prices.length;
        int res=0;int buy= Integer.MAX_VALUE;
        for(int i:prices){
            buy=Math.min(buy,i);
            res=Math.max(res,i-buy);
        }
        return res;
    }

    public int maxProfit2(int[] prices) {
        int N = prices.length;
        //int[][]res=new int[N][N];
        int max = 0;
        for (int l = 0; l < N - 1; l++)
            for (int r = l + 1; r < N; r++)
                max = Math.max(max, prices[r] - prices[l]);
        return max;
    }
}
