class Solution{

	public int perfectSum(int arr[],int n, int sum) 
	{ 
	    // Your code goes here
	    int mod=1000000007;
	            int[][] dp = new int[n + 1][sum + 1];
        
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                if (arr[i - 1] <= j) {
                    int include = (dp[i - 1][j - arr[i - 1]])%mod;
                    int exclude = (dp[i - 1][j])%mod;
                    dp[i][j] = (include + exclude)%mod;
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][sum];
	} 
}