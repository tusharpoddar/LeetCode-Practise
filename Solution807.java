class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int columns = grid[0].length;
        int row = grid.length;

    // code to combine the cheking of the two things together
    // for(int i=0; i<grid.length; i++){
    //    max_row = grid[i][0];
    //    max_col = grid[0][i];
    //    for(int j=0; j<grid[0].length-1; j++){
    //        if(max_row < grid[i][j+1]){
    //            max_row = grid[i][j+1];
    //        }
    //     if(max_col < grid[j+1][i]){
    //            max_col = grid[j+1][i];
    //        }               
    //    }
    //    leftright.add(max_row);
    //    topbot.add(max_col);
    // }
        
        // represents the highest in the row or the column
        int[] colMat = new int[columns];
        int[] rowMat = new int[row];
        
        for(int i = 0; i < row; i++){
            int maxRow = grid[i][0];
            for(int j = 0; j < columns; j++){
                if(grid[i][j] > maxRow){
                    maxRow = grid[i][j];
                }
            }
            rowMat[i] = maxRow;
        }
        
        for(int i = 0; i < columns; i++){
            int maxCol = grid[0][i];
            for(int j = 0; j < row; j++){
                if(grid[j][i] > maxCol){
                    maxCol = grid[j][i];
                }
            }
            colMat[i] = maxCol;
        }
        
           
        int sum = 0;
        
        for(int i = 0; i < row; i++){
            for(int j = 0; j < columns; j++){
                int numadd = Math.min(rowMat[i], colMat[j]);
                System.out.println(numadd);
                System.out.println(numadd - grid[i][j]);
                sum = sum + (numadd - grid[i][j]);
            }
        }
        
        return sum;
    }
}