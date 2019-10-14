package 程序员代码面试指南;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * @author     ：lightingSummer
 * @date       ：2019/10/14 0014
 * @description：
 */
public class 求最大子矩阵的大小 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] params = bf.readLine().split(" ");
        int row = Integer.valueOf(params[0]);
        int column = Integer.valueOf(params[1]);
        int[][] array = new int[row][column];
        for (int i = 0; i < row; i++) {
            String[] values = bf.readLine().split(" ");
            for (int j = 0; j < column; j++) {
                array[i][j] = Integer.valueOf(values[j]);
            }
        }
        System.out.println(getMaxSubMatrix(array));
    }

    private static int getMaxSubMatrix(int[][] matrix) {
        int row = matrix.length, col = matrix[0].length;
        int[] array = new int[col];
        int res = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                array[j] = matrix[i][j] == 0 ? 0 : array[j] + 1;
            }
            res = Math.max(res, getMaxSubMatrix(array));
        }
        return res;
    }

    private static int getMaxSubMatrix(int[] array) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for (int i = 0; i < array.length; i++) {
            while (!stack.isEmpty() && array[i] < array[stack.peek()]) {
                int highIndex = stack.pop();
                int preIndex = stack.isEmpty() ? -1 : stack.peek();
                res = Math.max(res, (i - preIndex - 1) * array[highIndex]);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int highIndex = stack.pop();
            int preIndex = stack.isEmpty() ? -1 : stack.peek();
            res = Math.max(res, (array.length - preIndex - 1) * array[highIndex]);
        }
        return res;
    }
}
