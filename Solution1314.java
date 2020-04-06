class Solution {
    public int[][] matrixBlockSum(int[][] mat, int K) {
        int r = mat.length;
        int c = mat[0].length;
        int[][] temp = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                temp[i][j] = mat[i][j];
                // adding the values of the first column in the second and third colum and so on. 
                if (i - 1 >= 0) {
                    temp[i][j] += temp[i - 1][j];
                }
                if (j - 1 >= 0) {
                    temp[i][j] += temp[i][j - 1];
                }
                if(i - 1 >= 0 && j - 1 >= 0) {
                    temp[i][j] -= temp[i-1][j-1];
                }
            }
        }
      
        int[][] res = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int startR = Math.max(i - K, 0);
                int startC = Math.max(j - K, 0);
                int endR = Math.min(i + K, r - 1);
                int endC = Math.min(j + K, c - 1);
                res[i][j] = temp[endR][endC];
                if (startR > 0) {
                    res[i][j] -= temp[startR - 1][endC]; 
                }
                if (startC > 0) {
                    res[i][j] -= temp[endR][startC - 1]; 
                }
                if (startR > 0 && startC > 0) {
                    res[i][j] += temp[startR - 1][startC - 1]; 
                }
            }
        }
        return res;
    }
}