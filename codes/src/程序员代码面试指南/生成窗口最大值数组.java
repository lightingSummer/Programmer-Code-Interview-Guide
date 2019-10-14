package 程序员代码面试指南;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

/**
 * @author     ：lightingSummer
 * @date       ：2019/10/11 0011
 * @description：
 */
public class 生成窗口最大值数组 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] params = bufferedReader.readLine().split(" ");
        int len = Integer.valueOf(params[0]);
        int width = Integer.valueOf(params[1]);
        String[] vals = bufferedReader.readLine().split(" ");
        int[] array = new int[len];
        for (int i = 0; i < len; i++) {
            array[i] = Integer.valueOf(vals[i]);
        }
        getSectionMaxValue(array, width);
    }

    private static void getSectionMaxValue(int[] array, int width) {
        LinkedList<Integer> list = new LinkedList<>();
        int len = array.length, index = 0;
        int[] res = new int[len - width + 1];
        for (int i = 0; i < len; i++) {
            while (!list.isEmpty() && array[list.peekLast()] < array[i]) {
                list.pollLast();
            }
            list.add(i);
            if (list.peekFirst() == i - width) {
                list.pollFirst();
            }
            if (i >= width - 1) {
                res[index++] = array[list.peekFirst()];
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int num : res) {
            sb.append(num + " ");
        }
        System.out.println(sb.toString());
    }
}
