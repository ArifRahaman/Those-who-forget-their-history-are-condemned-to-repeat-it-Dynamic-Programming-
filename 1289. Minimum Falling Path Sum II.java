
class Solution {
    public int minFallingPathSum(int[][] points) {
        int n = points.length;
        int m = points[0].length;

        int[][] dp = new int[n][m];

        // Initialize the first row of dp
        for (int i = 0; i < m; i++) {
            dp[0][i] = points[0][i];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = 0; k < m; k++) {
                    if (k != j) {
                        min = Math.min(min, dp[i - 1][k]);
                    }
                }
                dp[i][j] = points[i][j] + min;
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            ans = Math.min(dp[n - 1][i], ans);
        }
        return ans;

    }
}
