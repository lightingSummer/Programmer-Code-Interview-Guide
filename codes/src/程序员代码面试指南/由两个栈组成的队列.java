package 程序员代码面试指南;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author     ：lightingSummer
 * @date       ：2019/10/10 0010
 * @description：
 */
public class 由两个栈组成的队列 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int opNum = in.nextInt();
        QueueStack queueStack = new QueueStack();
        while (opNum-- > 0) {
            String operation = in.next();
            switch (operation) {
                case "add":
                    int val = in.nextInt();
                    queueStack.add(val);
                    break;
                case "poll":
                    queueStack.poll();
                    break;
                case "peek":
                    System.out.println(queueStack.peek());
            }
        }

    }

    static class QueueStack {
        private Stack<Integer> popStack = new Stack<>();
        private Stack<Integer> pushStack = new Stack<>();

        public void add(int val) {
            pushStack.push(val);
        }

        public int poll() {
            if (popStack.isEmpty()) {
                range();
            }
            return popStack.pop();
        }

        public int peek() {
            if (popStack.isEmpty()) {
                range();
            }
            return popStack.peek();
        }

        private void range() {
            while (!pushStack.isEmpty()) {
                popStack.push(pushStack.pop());
            }
        }
    }
}
