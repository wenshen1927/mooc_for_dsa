package com.dsa.mooc.class_2_2;

/**
 * 用栈实现字符串逆序
 */

public class StringReversal {
    public static void main(String[] args) {
        String str = new String("how are you");
        StackByLinkedList stack = new StackByLinkedList();
        char[] chars = str.toCharArray();
        for (char a :
                chars) {
            stack.push(a);
        }
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
