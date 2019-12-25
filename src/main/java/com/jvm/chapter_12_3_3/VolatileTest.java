package com.jvm.chapter_12_3_3;

/**
 * volatile变量自增运算测试
 *
 * 当一个变量被定义成volatile之后，他将具备两种特性，
 * 第一是保证此变量对所有线程的可见性，
 * 这里的“可见性”是指当一条线程修改了这个变量的值，新值对于其他线程来说是可以立即得知的。
 * 第二个语义是禁止指令重排序优化，普通的变量仅仅会保证在该方法的执行过程中所有依赖赋值结果
 * 的地方都能获取到正确的结果，而不能保证变量赋值操作的顺序与程序代码中的执行顺序一致。
 *
 * @author yangbin
 * 2019/12/25
 */
public class VolatileTest {

    public static volatile int race = 0;

    public static void increase() {
        race ++;
    }

    private static final int THREADS_COUNT = 20;

    public static void main(String[] args) {
        Thread[] threads = new Thread[THREADS_COUNT];
        for (int i = 0; i < THREADS_COUNT; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 10000; i++) {
                        increase();
                    }
                }
            });
            threads[i].start();
        }

        // 等待所有累加线程都结束
        while (Thread.activeCount() > 2) {
            Thread.yield();
            System.out.println("===========================");
            Thread.currentThread().getThreadGroup().list();
            System.out.println("===========================");
        }
        System.out.println(race);
    }

}
