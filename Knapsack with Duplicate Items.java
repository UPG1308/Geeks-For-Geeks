class Solution{
    static int knapSack(int N, int W, int val[], int wt[])
    {
        // code here
         int[] dp = new int[W + 1]; // Create a 1D array to store the maximum value for each weight

        for (int w = 1; w <= W; w++) {
            for (int i = 0; i < N; i++) {
                if (wt[i] <= w) {
                    dp[w] = Math.max(dp[w], dp[w - wt[i]] + val[i]);
                }
            }
        }

        return dp[W];
    }
