package 程序员代码面试指南;

import java.util.Scanner;

/**
 * @author     ：lightingSummer
 * @date       ：2019/10/10 0010
 * @description：
 */
public class 不重复打印排序数组中相加和为给定值的所有三元组 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        int target = in.nextInt();
        int[] array = new int[len];
        for (int i = 0; i < len; i++) {
            array[i] = in.nextInt();
        }

        for (int i = 0; i < len - 2; i++) {
            if (i > 0 && array[i] == array[i - 1]) {
                continue;
            }
            int sum = target - array[i];
            int left = i + 1, right = len - 1;
            while (left < right) {
                if (array[left] == sum - array[right]) {
                    if (left == 0 || array[left] != array[left - 1])
                        System.out.println(array[i] + " " + array[left] + " " + array[right]);
                    left++;
                    right--;
                } else if (array[left] < sum - array[right]) {
                    left++;
                } else {
                    right--;
                }
            }
        }
    }
}
