package com.dsa.mooc.class_2_2;

import java.util.Stack;

/**
 * 测试Java自带的Stack类
 */

public class StackByJava {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();

        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.peek());
        while (!stack.empty()) {
            System.out.println(stack.pop());
        }

    }
}
