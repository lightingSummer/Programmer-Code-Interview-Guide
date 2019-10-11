package 程序员代码面试指南;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * @author     ：lightingSummer
 * @date       ：2019/10/10 0010
 * @description：
 */
public class 未排序数组中累加和为给定值的最长子数组长度 {
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
        Map<Integer, Integer> map = new HashMap<>((int) (array.length / 0.75));
        map.put(0, -1);
        int res = -1, sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
            if (map.containsKey(sum - target)) {
                res = Math.max(res, i - map.get(sum - target));
            }
        }
        return res;
    }
}
