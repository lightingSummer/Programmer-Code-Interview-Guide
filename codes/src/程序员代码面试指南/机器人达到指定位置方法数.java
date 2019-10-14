package 程序员代码面试指南;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author     ：lightingSummer
 * @date       ：2019/10/14 0014
 * @description：
 */
public class 机器人达到指定位置方法数 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] params = bf.readLine().split(" ");
        int len = Integer.valueOf(params[0]);
        int start = Integer.valueOf(params[1]) - 1;
        int step = Integer.valueOf(params[2]);
        int end = Integer.valueOf(params[3]) - 1;
        System.out.println(getWaysCountToEnd(len, start, step, end));
    }

    private static final int mod = 1000000007;

    private static int getWaysCountToEnd(int len, int start, int step, int end) {
        if (start > len || end > len || start < 0 || end < 0) {
            return 0;
        }
        int[] dp = new int[len];
        dp[start] = 1;
        for (int i = 0; i < step; i++) {
            int[] temp = new int[len];
            temp[0] = dp[1];
            temp[len - 1] = dp[len - 2];
            for (int j = 1; j < len - 1; j++) {
                temp[j] = (dp[j - 1] + dp[j + 1]) % mod;
            }
            dp = temp;
        }
        return dp[end];
    }
}
