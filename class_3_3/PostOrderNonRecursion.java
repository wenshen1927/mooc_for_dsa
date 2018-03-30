package com.dsa.mooc.class_3_3;

import java.util.Stack;
import java.util.prefs.NodeChangeEvent;

/**
 * 非递归地后序遍历：
 * 后序遍历和前序中序两种不同，有两种思路
 * <p>
 * 1、第一种：
 * 给节点加上一个isFirst的标记，判断是否第一次被访问。
 * 对于任一结点P，将其入栈，然后沿其左子树一直往下搜索，直到搜索到没有左孩子的结点，
 * 此时该结点出现在栈顶，但是此时不能将其出栈并访问，因此其右孩子还为被访问。
 * 所以接下来按照相同的规则对其右子树进行相同的处理，当访问完其右孩子时，该结点又出现在栈顶，此时可以将其出栈并访问。
 * 这样就保证了正确的访问顺序。
 * 可以看出，在这个过程中，每个结点都两次出现在栈顶，只有在第二次出现在栈顶时，才能访问它。
 * 因此需要多设置一个变量标识该结点是否是第一次出现在栈顶。
 * <p>
 * 2、第二种：
 */

public class PostOrderNonRecursion {
    private Node root;

    private class Node {
        private Object data;
        private Node leftNode;
        private Node rightNode;
        private boolean isFirst;//判断是否第一次出现

        public Node(Object data) {
            this.data = data;
            this.isFirst = true;//默认第一次出现
        }
    }

    /**
     * @param root 输入二叉树的根节点
     */
    public void postOrder1(Node root) {
        Stack stack = new Stack();
        Node bt = root;
        while (bt != null || !stack.isEmpty()) {
            while (bt != null) {//同样先压遍历左子树，经过的节点全部压栈
                stack.push(bt);
                bt = bt.leftNode;
            }
            if (!stack.isEmpty()) {
                Node temp = (Node) stack.pop();//查看栈顶元素
                if (temp.isFirst) {//如果栈顶的元素是第一次出现的话，那么当前指针指向右子节点
                    temp.isFirst = false;
                    stack.push(temp);//把新的节点（isFirst的值变了）压栈
                    bt = temp.rightNode;
                } else {//栈顶元素第二次出现
                    System.out.println(temp.data);
                    bt = null;//当前指针指向null
                }
            }
        }
    }

    public void postOrder2(Node root) {

    }
}
