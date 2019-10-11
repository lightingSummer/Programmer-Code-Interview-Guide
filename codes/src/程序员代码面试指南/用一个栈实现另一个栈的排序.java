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
public class 用一个栈实现另一个栈的排序 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.valueOf(bufferedReader.readLine());
        String[] numbers = bufferedReader.readLine().split(" ");
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            stack.push(Integer.valueOf(numbers[i]));
        }
        Stack<Integer> newStack = stackSort(stack);
        while (!newStack.isEmpty()) {
            System.out.print(newStack.pop()+" ");
        }
    }

    private static Stack<Integer> stackSort(Stack<Integer> stack) {
        Stack<Integer> helpStack = new Stack<>();
        while (!stack.isEmpty()) {
            int num = stack.pop();
            while (!helpStack.isEmpty() && helpStack.peek() > num) {
                stack.push(helpStack.pop());
            }
            helpStack.push(num);
        }
        return helpStack;
    }
}
