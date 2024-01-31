
class Solution{
    static int equalPartition(int N, int nums[])
    {
        // code here
        long sum =0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        if(sum%2==1) return 0;
         int target=(int)sum/2;
        // return isSubsequenceSum(nums,target);
        boolean ans=isSubsequenceSum(nums,target);
        if(ans==true){
            return 1;
        }
        return 0;
        
        
    }
    
    private static boolean isSubsequenceSum(int[] arr, int k) {
        int n = arr.length;
        boolean[][] dp = new boolean[n + 1][k + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=k;j++){
                  if(arr[i-1]>j){
                      dp[i][j]=dp[i-1][j];
                  }
                else{
                    // dp[i][j]=dp[i-1][j] || dp[i-1][j-arr[i-1]];
                    boolean include=dp[i-1][j-arr[i-1]];
                    boolean exclude=dp[i-1][j];
                    dp[i][j]=include||exclude;
                }
                }
        
        }   

        return dp[n][k];
    }
}
