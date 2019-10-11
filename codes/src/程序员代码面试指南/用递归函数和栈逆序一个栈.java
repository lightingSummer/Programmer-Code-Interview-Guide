package 程序员代码面试指南;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * @author     ：lightingSummer
 * @date       ：2019/10/10 0010
 * @description：
 */
public class 用递归函数和栈逆序一个栈 {
    public static void main(String[] args) throws IOException {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> sta = new Stack<>();
        int n = Integer.parseInt(buff.readLine());
        String str = buff.readLine();
        String[] str1 = str.split(" ");
        for (int i = 0; i < str1.length; ++i) {
            sta.push(Integer.parseInt(str1[i]));
        }
        for (int i = 0; i < str1.length; ++i) {
            System.out.print(revese(sta) + " ");
        }
    }

    private static int revese(Stack<Integer> sta) {
        if (!sta.isEmpty()) {
            return sta.pop();
        }
        return sta.peek();
    }
}
