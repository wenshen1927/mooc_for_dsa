package com.dsa.mooc.class_5_1;

import org.junit.Test;

import java.util.PriorityQueue;

/**
 * 测试Java的优先队列
 */
public class HeapTest {
    @Test
    public void testPriorityQueue() {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.offer(50);
        queue.offer(20);
        queue.offer(30);
        queue.offer(70);
        queue.offer(60);
        queue.offer(30);
        queue.offer(40);
        queue.offer(10);
        queue.offer(80);
        System.out.println(queue);
    }
}
