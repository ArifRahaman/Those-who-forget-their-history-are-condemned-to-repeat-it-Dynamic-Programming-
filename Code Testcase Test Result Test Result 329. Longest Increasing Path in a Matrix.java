class Solution {
    public int count(int i, int j, int row, int col, int prevVal, int[][] matrix, int[][] dp) {
        if (i < 0 || i >= row || j < 0 || j >= col || matrix[i][j] <= prevVal) return 0;
        if (dp[i][j] != -1) return dp[i][j];
        int up = 1 + count(i - 1, j, row, col, matrix[i][j], matrix, dp);
        int left = 1 + count(i, j - 1, row, col, matrix[i][j], matrix, dp);
        int right = 1 + count(i, j + 1, row, col, matrix[i][j], matrix, dp);
        int down = 1 + count(i + 1, j, row, col, matrix[i][j], matrix, dp);
        return dp[i][j] = Math.max(up, Math.max(down, Math.max(left, right)));
    }

    public int longestIncreasingPath(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int maxi = 0;
        int[][] dp = new int[row][col];
        for (int[] rowArray : dp) {
            Arrays.fill(rowArray, -1);
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                maxi = Math.max(maxi, count(i, j, row, col, -1, matrix, dp));
            }
        }
        return maxi;
    }

}
