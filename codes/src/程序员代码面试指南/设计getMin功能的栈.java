package 程序员代码面试指南;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author     ：lightingSummer
 * @date       ：2019/10/10 0010
 * @description：
 */
public class 设计getMin功能的栈 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int opNum = in.nextInt();
        MinStack minStack = new MinStack();
        while (opNum-- > 0) {
            String operation = in.next();
            switch (operation) {
                case "push":
                    int val = in.nextInt();
                    minStack.push(val);
                    break;
                case "pop":
                    minStack.pop();
                    break;
                case "getMin":
                    System.out.println(minStack.getMin());
            }
        }
    }

    static class MinStack {
        private Stack<Integer> minStack = new Stack<>();
        private Stack<Integer> numStack = new Stack<>();

        public void push(int val) {
            if (minStack.isEmpty() || minStack.peek() > val) {
                minStack.push(val);
            } else {
                minStack.push(minStack.peek());
            }
            numStack.push(val);
        }

        public int pop() {
            minStack.pop();
            return numStack.pop();
        }

        public int getMin() {
            return minStack.peek();
        }
    }
}
