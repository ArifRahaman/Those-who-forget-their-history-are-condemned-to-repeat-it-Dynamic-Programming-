class Solution {
    public int change(int sum, int[] arr){
        // int[] dp=new int[amount+1];
        // dp[0]=1;
        //  for(int i=0;i<coins.length;i++){
        //      for(int j=coins[i];j<dp.length;j++){
        //          dp[j]+=dp[j-coins[i]];
        //      }
        //  }
        // return dp[amount];
        	    int mod=1000000007;
                  int n=arr.length;
	            int[][] dp = new int[n + 1][sum + 1];
        
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                if (arr[i - 1] <= j) {
                    int include = (dp[i][j - arr[i - 1]])%mod;
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
//Comment out programme will give you accepted answer
