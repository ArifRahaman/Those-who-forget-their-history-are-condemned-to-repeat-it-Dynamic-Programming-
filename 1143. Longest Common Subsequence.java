class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        
        // Create a 2D array to store the lengths of longest common subsequences
        int[][] dp = new int[m + 1][n + 1];
        
        // Fill the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // If the characters match, extend the LCS by 1
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    int include1=dp[i-1][j];
                   int include2=dp[i][j-1];
                    dp[i][j] = Math.max(include1,include2);
                }
            }
        }
        
        // Return the length of the longest common subsequence
        return dp[m][n];
        
    }
    
}
