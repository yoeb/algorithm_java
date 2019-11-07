package com.comic_algorithm.chapter_2_data_structure;

/**
 * 循环队列, 一种用数组实现的队列，最大长度为array.length - 1
 */
public class MyCircularQueue {

    private int[] array;

    /**
     * 队头，用于入队
     */
    private int front;
    /**
     * 队尾，用于出队
     */
    private int rear;

    public MyCircularQueue(int capacity) {
        this.array = new int[capacity];
        front = rear = 0;
    }

    /**
     * 入队
     * @param element 入队的元素
     */
    public void enQueue(int element) throws Exception {
        if ((rear + 1) % array.length == front) {
            throw new Exception("队列已满！");
        }
        array[rear] = element;
        rear = (rear + 1) % array.length;
    }

    /**
     * 出队
     */
    public int deQueue() throws Exception {
        if (front == rear) {
            throw new Exception("队列为空！");
        }
        int deQueueElement = array[front];
        front = (front + 1) % array.length;
        return deQueueElement;
    }

    /**
     * 打印
     */
    public void output() {
        for (int i = front; i != rear ;) {
            System.out.print(array[i] + "");
            i = (i + 1) % array.length;
        }
    }

    public static void main(String[] args) throws Exception {

        MyCircularQueue queue = new MyCircularQueue(5);
        queue.enQueue(5);
        queue.enQueue(4);
        queue.enQueue(3);
        queue.enQueue(2);

        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());

        queue.enQueue(0);

        queue.output();

    }

}
