class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
         // your code here 
         int[][]dp=new int[n+1][W+1];
         for(int i=1;i<=n;i++){
             for(int w=1;w<=W;w++){
       if(w==0 || i==0){
          dp[i][w]=0;
        }
        else if(wt[i-1]>w){
        //  return knap(W,wt,val,n-1);
        dp[i][w]=dp[i-1][w];
        }else{
        int include= val[i-1]+ dp[i-1][w-wt[i-1]];
            int exclude=dp[i-1][w];
            dp[i][w]=Math.max(include,exclude);
       
             }
         }
        }
         return dp[n][W];
    } 
}

