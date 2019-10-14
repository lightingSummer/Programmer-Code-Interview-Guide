package 程序员代码面试指南;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author     ：lightingSummer
 * @date       ：2019/10/14 0014
 * @description：
 */
public class 换钱的方法数 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] params = bf.readLine().split(" ");
        int len = Integer.valueOf(params[0]);
        int money = Integer.valueOf(params[1]);
        String[] vals = bf.readLine().split(" ");
        int[] array = new int[len];
        for (int i = 0; i < len; i++) {
            array[i] = Integer.valueOf(vals[i]);
        }
        System.out.println(getComposeCountOfMoney(array, money));
    }

    private static int getComposeCountOfMoney(int[] coins, int money) {
        int[] dp = new int[money + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int j = coin; j <= money; j++) {
                dp[j] += dp[j - coin];
                dp[j] %= 1000000007;
            }
        }
        return dp[money];
    }
}
