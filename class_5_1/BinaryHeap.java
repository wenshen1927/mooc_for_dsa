package com.dsa.mooc.class_5_1;

import com.dsa.mooc.class_4_1.BinSearchTree;

/**
 * 堆：（以最大堆为例）
 * 1、完全二叉树（用数组表示）2、关键字的最大值在根节点上
 */
//todo:这个类目前还有些问题
public class BinaryHeap {

    private Node[] heapArray;//存储堆元素的数组
    private int maxSize;//堆的容量
    private int currentSize;//堆中当前元素的个数

    private class Node {
        private int data;

        public Node(int data) {
            this.data = data;
        }
    }

    //创建堆
    public BinaryHeap(int max) {
        this.maxSize = max;
        currentSize = 1;//默认是1
        heapArray = new Node[maxSize + 1];//数组0的位置设为哨兵
        heapArray[0] = new Node(Integer.MAX_VALUE);//哨兵：数组第一个位置，值为最大值
    }

    //判空
    public boolean isEmpty() {
        return (currentSize == 1);
    }

    //判满
    public boolean isFull() {
        return (currentSize == maxSize + 1);
    }

    //插入（最大堆）
    public boolean insert(int key) {
        Node node = new Node(key);
        if (isFull()) {
            System.out.println("Insert Error:heap is full");
            return false;
        }
        //先插进来
        heapArray[currentSize] = node;
        //在调整位置
        trickleUp(currentSize++);
        return true;
    }

    /**
     * 向上调整堆
     *
     * @param index 叶子节点
     */
    public void trickleUp(int index) {
        int parent = index / 2;//获得父节点的索引
        Node bottom = heapArray[index];//将新添加的尾结点存在bottom中,暂时保存

        //找到node应该在的位置
        while (heapArray[index].data > heapArray[parent].data) {//当前节点大于父节点
            //更新Index节点
            heapArray[index] = heapArray[parent];
            //交换当前节点的索引
            index = parent;
            //更新parent索引
            parent = parent / 2;

        }
        heapArray[index] = bottom;
    }

    //删除最大值（最大堆）:删除一定是删根节点（最大值）
    //策略：用最后一个节点来替代根节点删除，在比较有序性
    public Node deleteMax() {
        if (isEmpty()) {
            System.out.println("Error:heap is empty");
            return null;
        }
        Node root = heapArray[1];
        //先用currentSize来代替root的位置
        heapArray[1] = heapArray[--currentSize];//这里之所以用--currentSize，而不用currentSize--，是因为在上面insert的时候，每次插入完，currentSize都会加1，最后一次插入之后currentSize要比真实size大1.所以这里先-1，使currentSize指向最后一个元素。
        //再从根节点调整堆的有序性
        trickleDown(1);
        return root;
    }

    /**
     * 从上到下调整堆
     *
     * @param index 根节点索引
     */
    private void trickleDown(int index) {
        Node root = heapArray[index];//保存根节点的值
        // 寻找root应该存放的位置
        int parent;
        int child;
        for (parent = index; parent * 2 < currentSize; ) {//i * 2代表当前节点的左儿子，若做儿子都不存在的话，那么右儿子肯定也不存在
            child = parent * 2;
            //找左右儿子中较大的那个
            if ((child + 1) <= currentSize && heapArray[child].data < heapArray[child + 1].data) {
                child++;//若右子节点存在且比较大，则child指向右子节点,否则child指向左子节点
            }
            //判断根节点是否比child节点大
            if (heapArray[parent].data > heapArray[child].data) {
                break;
            } else {//根节点比子节点小，交换索引，继续迭代（如果没到叶节点的话）
                parent = child;
            }
        }
        heapArray[parent] = root;
    }

    //建立堆：
    //方法一：直接插入最大堆O(nlogn)
    //方法二：（线性复杂度）先将n个元素按输入顺序插入，先满足完全二叉树的结构特性
    //      再调整成一个堆(见视频讲解)
    public void createMaxHeap(int[] arr) {
        int lastNode = currentSize / 2;
        Node[] nodes = new Node[arr.length];
        for (int i = 0; i < arr.length; i++) {
            nodes[i] = new Node(arr[i]);
        }
        heapArray = nodes;
        for (int i = lastNode; i > 0; i--) {
            trickleDown(i);
        }
    }

    //遍历与查找
    //堆基本上是无序的，所以难以遍历或者查找。但是能快速地移除最大值或者插入新的节点。
    public void display() {
        if (!isEmpty()) {
            for (int i = 0; i < currentSize; i++) {
                System.out.printf("index:%d ", i);
                System.out.printf("value:%d ", heapArray[i].data);
                System.out.println();
            }
        } else {
            System.out.println("heap is empty!");
        }
    }

    public static void main(String[] args) {
        int[] a = {10, 40, 30, 60, 90, 70, 20, 50, 80};
        BinaryHeap heap = new BinaryHeap(10);
        System.out.printf("\n== 最 大 堆: %s", heap);
        System.out.println();
        heap.display();
        //1、(线性复杂度)创建的最大堆
        heap.createMaxHeap(a);
        heap.display();
        //2、一般方法创建的最大堆（复杂度NlogN）
//        System.out.println("依次添加元素");
//        for (int i = 0; i < a.length; i++) {
//            System.out.printf("%d ", a[i]);
//            heap.insert(a[i]);
//        }
//        System.out.println();
//        heap.display();
        System.out.println();
        System.out.printf("\n== 最 大 堆: %s", heap);
        int i = 85;
        heap.insert(i);
        System.out.printf("\n 添加元素:%d", i);
        System.out.printf("\n最大堆:%s", heap);
        System.out.println();
        heap.display();

        int max = heap.deleteMax().data;
        System.out.printf("\n删除最大值:%d", max);
        System.out.printf("\n== 最 大 堆: %s", heap);
        System.out.println();
        heap.display();

        max = heap.deleteMax().data;
        System.out.printf("\n删除最大值:%d", max);
        System.out.printf("\n== 最 大 堆: %s", heap);
        System.out.println();
        heap.display();
    }
}
