package cn.offer;

public class test4 {
    public static void main(String[] args) {
        int tar = 20;
        int [][] mat = new int[6][6];
        for (int i = 0; i < 6; i++) {
            for (int i1 = 0; i1 < 6; i1++) {
                mat[i][i1] = (i+1)*(i1+1)*2;
            }
        }
        System.out.println(Find(100,mat));
        /*
        for (int i = 0; i < 6; i++) {
            for (int i1 = 0; i1 < 6; i1++) {
                System.out.print(mat[i][i1]+" ");
            }
            System.out.println();
        }
*/
    }
    public static boolean Find(int target,int[][] matrix){
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        int rows = matrix.length, cols = matrix[0].length;
        int r = 0, c = cols - 1; // 从右上角开始
        while (r <= rows - 1 && c >= 0) {
            if (target == matrix[r][c])
                return true;
            else if (target > matrix[r][c])
                r++;
            else
                c--;

        }



        return false;
    }
}
