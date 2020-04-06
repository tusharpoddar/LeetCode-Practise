import java.util.PriorityQueue;

// to sort a 2d matrix along each of its diagonal
class Solution {
    public int[][] diagonalSort(final int[][] mat) {
        // we solve this proble using a priority queue, 
        // use a priority queue in all the qiestions that require you to sort things. 

        PriorityQueue<Integer> p = new PriorityQueue<>();

        int row = mat.length; 
        int col = mat[0].length;

        // the first case where it needs to pass always
        if(row == col && col == 1){
            return mat;
        }

        // as we need to manipulate the first diagonal or the biggest diagonal
        int k = -1;
        // for this loop we are moving along the column
        // this is done to sort teh lower triangle in the matrix
        while(k < row){
            int i = k; 
            int j = -1;
            while(i + 1 < row && j + 1 < col){
                p.add(mat[i + 1][j + 1]);
                i++; 
                j++;
            }

            i = k;j = -1;
            while(i + 1 < row && j + 1 < col){
                int temp = p.poll();
                mat[i + 1][j + 1] = temp;
                i++; 
                j++;
            }
            k++;
        }

        // used to solve the upper triangle
        k = 0;
        while(k < col){
            int i = -1; 
            int j = k;
            while(i + 1 < row && j + 1 < col){
                p.add(mat[i + 1][j + 1]);
                i++; 
                j++;
            }

            i = -1;
            j = k;
            while(i + 1 < row && j + 1 < col){
                int temp = p.poll();
                mat[i + 1][j + 1] = temp;
                i++;
                j++;
            }
            k++;
        }
        return mat;
    }


}