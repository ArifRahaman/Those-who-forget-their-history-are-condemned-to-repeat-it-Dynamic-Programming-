class Solution {
    public int numSquares(int n) {
        int[] arr = new int[101];
        for (int i = 1; i <= 100; i++) {
            arr[i] = i * i;
        }

        int[][] dp = new int[101][n + 1];
        
        // Initialization
        for (int j = 0; j <= n; j++) {
            dp[0][j] = Integer.MAX_VALUE; // Setting to maximum value
        }
        dp[0][0] = 0; // Base case

        for (int i = 1; i <= 100; i++) {
            for (int j = 1; j <= n; j++) {
                if (arr[i] <= j) {
                    int include = dp[i][j - arr[i]] + 1;
                    int exclude = dp[i - 1][j];
                    dp[i][j] = Math.min(include, exclude);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[100][n];
    }
}
