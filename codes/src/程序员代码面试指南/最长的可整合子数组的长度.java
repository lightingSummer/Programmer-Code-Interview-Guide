package 程序员代码面试指南;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author     ：lightingSummer
 * @date       ：2019/10/10 0010
 * @description：
 */
public class 最长的可整合子数组的长度 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        int[] array = new int[len];
        for (int i = 0; i < len; i++) {
            array[i] = in.nextInt();
        }
        System.out.println(getMaxLenOfRangedArrayDP(array, len));
    }

    /**
     * @author : lightingSummer
     * @date: 2019/10/10 0010
     * @description: dp动态规划 时间复杂度o(nlogn) 空间o(n)
     */
    private static int getMaxLenOfRangedArrayDP(int[] array, int len) {
        Arrays.sort(array);
        int[] dp = new int[len];
        int res = 0;
        dp[0] = 1;
        for (int i = 1; i < len; i++) {
            if (array[i] - array[i - 1] == 1) {
                dp[i] = dp[i - 1] + 1;
            } else if (array[i] == array[i - 1]) {
                dp[i] = dp[i - 1];
            } else {
                dp[i] = 1;
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    private static int getMaxLenOfRangedArray(int[] array, int len) {
        Map<Integer, Integer> leftCnt = new HashMap<>((int) (len / 0.75));
        Map<Integer, Integer> rightCnt = new HashMap<>((int) (len / 0.75));
        Arrays.sort(array);
        for (int i = 0; i < array.length; i++) {
            // 左边
            if (!leftCnt.containsKey(array[i])) {
                if (leftCnt.containsKey(array[i] - 1)) {
                    leftCnt.put(array[i], leftCnt.get(array[i] - 1) + 1);
                } else {
                    leftCnt.put(array[i], 0);
                }
            }
            // 右边
            if (!rightCnt.containsKey(array[len - 1 - i])) {
                if (rightCnt.containsKey(array[len - 1 - i] - 1)) {
                    rightCnt.put(array[len - 1 - i], rightCnt.get(array[len - 1 - i] - 1) + 1);
                } else {
                    rightCnt.put(array[len - 1 - i], 0);
                }
            }
        }
        int res = 0;
        for (int num : array) {
            res = Math.max(1 + leftCnt.get(num) + rightCnt.get(num), res);
        }
        return res;
    }
}
