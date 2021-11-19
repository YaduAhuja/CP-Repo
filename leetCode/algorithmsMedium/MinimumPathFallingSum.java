package leetCode.algorithmsMedium;

import java.util.HashMap;

public class MinimumPathFallingSum {
    private static HashMap<String, Integer> map;

    public static void main(String[] args) {
        int matrix[][] = {{2, 1, 3}, {6, 5, 4}, {7, 8, 9}};
        System.out.println(minFallingPathSum(matrix));
    }

    private static int minFallingPathSum(int[][] matrix) {
        map = new HashMap<>();
        int ret = Integer.MAX_VALUE;
        for (int i = 0; i < matrix[0].length; i++) {
            ret = Math.min(ret, getPathSum(0, i, matrix));
        }
        return ret;
    }

    private static int getPathSum(int x, int y, int[][] matrix) {

        if (x == matrix.length) return 0;

        int ret = Integer.MAX_VALUE;
        String s = x + " " + y;
        if (map.containsKey(s)) return map.get(s);

        if (y < 0 || y >= matrix[0].length) {
            return ret - (int) 1e4;
        }

        ret = Math.min(ret, matrix[x][y] + getPathSum(x + 1, y, matrix));
        ret = Math.min(ret, matrix[x][y] + getPathSum(x + 1, y - 1, matrix));
        ret = Math.min(ret, matrix[x][y] + getPathSum(x + 1, y + 1, matrix));
        map.put(s, ret);
        return ret;
    }
}
