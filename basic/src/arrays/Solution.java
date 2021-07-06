package arrays;

public class Solution {
    public static boolean findNumberIn2DArray(int[][] matrix, int target) {

        int m = matrix[0].length;
        int n = matrix.length;

        //在第一行找出最后一个小于target的数字的位置
        int y = 0;
        for(int i=0;i<=m-1;i++){
            if(matrix[0][i]<target)
                y = i;
            if(matrix[0][i]>target)
                break;
            if(matrix[0][i]==target)
                return true;
        }

        //在第一列找出最后一个小于target的数字的位置
        int x = 0;
        for(int i=0;i<=n-1;i++){
            if(matrix[i][0]<target)
                x = i;
            if(matrix[i][0]>target)
                break;
            if(matrix[i][0]==target)
                return true;
        }

        for(int i=0;i<=x;i++){
            for(int j=0;j<=y;j++){
                if(matrix[i][j]==target)
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int [][] ab =  {{1, 2}, {3, 4}, {5, 9}};
        boolean numberIn2DArray = findNumberIn2DArray(ab, 5);
        System.out.println(numberIn2DArray);

        //java.lang.ArrayIndexOutOfBoundsException: Index 0 out of bounds for length 0
        //  at line 4, Solution.findNumberIn2DArray
        //  at line 57, __DriverSolution__.__helper__
        //  at line 84, __Driver__.main



    }
}
