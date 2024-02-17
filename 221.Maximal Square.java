class Solution {
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n + 1][m + 1];
        int max = 0;
        // for(int i = 0; i < n; i++) {
        //     for(int j = 0; j < m; j++) {
        //         if(matrix[i][j] == '1') {
        //             dp[i + 1][j + 1] = 1; // Adding 1 to the index for dp
        //             max = 1; // Update max to 1 if there's at least one '1' in the matrix
        //         }
        //     }
        // }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
         
                    int right = dp[i][j - 1];
                    int down = dp[i - 1][j];
                    int diagonal = dp[i - 1][j - 1];
                         if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = 1 + Math.min(right, Math.min(down, diagonal));
                           }
                    max = Math.max(max, dp[i][j]);
                
            }
        }
        return max * max;
    }
}
