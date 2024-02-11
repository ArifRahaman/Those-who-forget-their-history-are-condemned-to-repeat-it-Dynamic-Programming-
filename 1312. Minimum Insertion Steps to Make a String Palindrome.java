class Solution {
    public int minInsertions(String s) {
        // String S=s;
        StringBuilder sb=new StringBuilder();
        sb.append(s);
        sb.reverse();
        String S=sb.toString();
        // S=s;
        System.out.println(S);
        int l=s.length();
        
        int[][]dp=new int[l+1][l+1];
        for(int i=1;i<=l;i++){
            for(int j=1;j<=l;j++){
                if(s.charAt(i-1)==S.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else{
                    int include=dp[i][j-1];
                    int exclude=dp[i-1][j];
                    dp[i][j]=Math.max(include,exclude);
                }
            }
        }
        return l-dp[l][l];
    }
}
