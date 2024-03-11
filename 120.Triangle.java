class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int l = triangle.size();
        int[][] memo = new int[l][l];

        // Initialize the memoization array with a large value to indicate uncomputed cells
        for (int i = 0; i < l; i++) {
            for (int j = 0; j <= i; j++) {
                memo[i][j] = Integer.MAX_VALUE;
            }
        }

        return ans(triangle, 0, 0, l, memo);
    }

    private int ans(List<List<Integer>> triangle, int row, int col, int len, int[][] memo) {
        if (row == len - 1) {
            return triangle.get(row).get(col);
        }
        if (memo[row][col] != Integer.MAX_VALUE) {
            return memo[row][col];
        }

        int down = triangle.get(row).get(col) + ans(triangle, row + 1, col, len, memo);
        int notTakeDown = triangle.get(row).get(col) + ans(triangle, row + 1, col + 1, len, memo);

        memo[row][col] = Math.min(down, notTakeDown);
        return memo[row][col];
    }
}
