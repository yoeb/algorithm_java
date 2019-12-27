package com.java_concurrent_programming.chapter_1_1_1;

/**
 * 下面的代码演示串行和并发执行并累加操作的时间
 * 请分析：下面的代码并发执行一定比串行执行快吗？
 */
public class ConcurrencyTest {

    private static final long count = 100001;

    public static void main(String[] args) throws InterruptedException {
        concurrency();
        serial();
    }

    /**
     * 并发
     * @throws InterruptedException 中断抛出异常
     */
    private static void concurrency() throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int a = 0;
                for (long i = 0; i < count; i++) {
                    a += 5;
                }
            }
        });
        thread.start();
        int b = 0;
        for (long i = 0; i < count; i++) {
            b--;
        }
        long time = System.currentTimeMillis() - start;
        thread.join();
        System.out.println("concurrency :" + time + "ms,b=" + b);
    }

    /**
     * 串行
     */
    private static void serial() {
        long start = System.currentTimeMillis();
        int a = 0;
        for (long i = 0; i < count; i++) {
            a += 5;
        }
        int b = 0;
        for (long i = 0; i < count; i++) {
            b--;
        }
        long time = System.currentTimeMillis() - start;
        System.out.println("serial:" + time + "ms,b=" + b + ",a=" + a);
    }

}
