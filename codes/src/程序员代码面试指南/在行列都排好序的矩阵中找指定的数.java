package 程序员代码面试指南;

import java.util.Scanner;

/**
 * @author     ：lightingSummer
 * @date       ：2019/10/10 0010
 * @description：
 */
public class 在行列都排好序的矩阵中找指定的数 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int row = in.nextInt();
        int col = in.nextInt();
        int target = in.nextInt();
        int[][] array = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                array[i][j] = in.nextInt();
            }
        }
        boolean exits = isNumInArray(array, target);
        if (exits) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    private static boolean isNumInArray(int[][] array, int target) {
        if (array == null || array.length == 0 || array[0].length == 0) {
            return false;
        }
        int curRow = 0;
        int curCol = array[0].length - 1;
        while (curRow < array.length && curCol >= 0) {
            if (array[curRow][curCol] == target) {
                return true;
            } else if (array[curRow][curCol] < target) {
                curRow++;
            } else {
                curCol--;
            }
        }
        return false;
    }
}
