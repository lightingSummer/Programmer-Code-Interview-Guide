package 程序员代码面试指南;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author     ：lightingSummer
 * @date       ：2019/10/10 0010
 * @description：
 */
public class 未排序正数数组中累加和为给定值的最长子数组的长度 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] param = bufferedReader.readLine().split(" ");
        int len = Integer.valueOf(param[0]);
        int target = Integer.valueOf(param[1]);
        String[] numbers = bufferedReader.readLine().split(" ");
        int[] array = new int[len];
        for (int i = 0; i < len; i++) {
            array[i] = Integer.valueOf(numbers[i]);
        }
        System.out.println(getMaxSubArrayLength(array, target));
    }

    private static int getMaxSubArrayLength(int[] array, int target) {
        int left = 0, right = 0, sum = array[0], len = 0;
        while (right < array.length) {
            if (sum == target) {
                len = Math.max(len, right - left + 1);
                sum -= array[left++];
            } else if (sum < target) {
                right++;
                if (right == array.length) {
                    break;
                }
                sum += array[right];
            } else {
                sum -= array[left++];
            }
        }
        return len;
    }
}
