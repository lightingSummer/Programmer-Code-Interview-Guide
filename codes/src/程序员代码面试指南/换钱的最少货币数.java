package 程序员代码面试指南;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author     ：lightingSummer
 * @date       ：2019/10/10 0010
 * @description：
 */
public class 换钱的最少货币数 {
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
        System.out.println(getMinMoneyNum(array, target));
    }

    /**
     * @author: lightingSummer
     * @date: 2019/10/10 0010
     * @description: 完全背包问题 空间优化至O(n)
     */
    private static int getMinMoneyNum(int[] coins, int target) {
        int[] dp = new int[target + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int coin : coins) {
            for (int j = coin; j <= target; j++) {
                if (dp[j - coin] != -1) {
                    if (dp[j] == -1) {
                        dp[j] = dp[j - coin] + 1;
                    } else {
                        dp[j] = Math.min(dp[j - coin] + 1, dp[j]);
                    }
                }
            }
        }
        return dp[target];
    }
}
