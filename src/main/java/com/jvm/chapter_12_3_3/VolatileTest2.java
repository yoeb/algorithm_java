package com.jvm.chapter_12_3_3;

/**
 * 由于volatile变量只能保证可见性，在不符合以下两条规则的运算场景中，
 * 我们仍然要通过加锁(使用synchronized或java.util.concurrent中的原子类)来保证原子性。
 *
 * 1）运算结果并不依赖变量的当前值，或者能够确保只有单一的线程修改变量的值。
 * 2）变量不需要与其他的状态变量共同参与不变约束。
 */
public class VolatileTest2 {

    volatile boolean shutdownRequested;

    public void shutdown() {
        shutdownRequested = true;
    }

    public void doWork() {
        while (!shutdownRequested) {
            // do stuff
        }
    }

}
