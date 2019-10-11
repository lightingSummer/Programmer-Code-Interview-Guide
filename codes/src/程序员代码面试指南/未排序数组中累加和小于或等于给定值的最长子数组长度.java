package 程序员代码面试指南;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class 未排序数组中累加和小于或等于给定值的最长子数组长度 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] params = bufferedReader.readLine().split(" ");
        int len = Integer.valueOf(params[0]);
        int target = Integer.valueOf(params[1]);
        String[] vals = bufferedReader.readLine().split(" ");
        int[] array = new int[len];
        for (int i = 0; i < len; i++) {
            array[i] = Integer.valueOf(vals[i]);
        }
        System.out.println(getLongestSubArraySumLessOrEqualTarget(array, len, target));
    }

    private static int getLongestSubArraySumLessOrEqualTarget(int[] array, int len, int target) {
        int[] sums = new int[len];
        Map<Integer, Integer> map = new HashMap<>();
        sums[len - 1] = array[len - 1];
        map.put(len - 1, len - 1);
        for (int i = len - 2; i >= 0; i--) {
            if (sums[i + 1] < 0) {
                sums[i] = array[i] + sums[i + 1];
                map.put(i, map.get(i + 1));
            } else {
                sums[i] = array[i];
                map.put(i, i);
            }
        }
        int res = 0, sum = 0, end = 0;
        for (int i = 0; i < len; i++) {
            while (end < len && sum + sums[end] <= target) {
                sum += sums[end];
                end = map.get(end) + 1;
            }
            res = Math.max(res, end - i);
            sum -= end > i ? array[i] : 0;
            end = Math.max(end, i + 1);
        }
        return res;
    }
}