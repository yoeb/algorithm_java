package com.jvm.chapter_3_2_1;

/**
 * 引用计数算法的缺陷
 * VM Args: -XX:+PrintGCDetails  输出GC的详细日志
 * VM Args: -XX:+PrintHeapAtGC  进行GC打印堆信息
 * testGC()方法执行后，objA和objB会不会被GC呢？
 */
public class ReferenceCountingGC {

    public Object instance = null;

    private static final  int _1MB = 1024 * 1024;

    /**
     * 这个成员属性的唯一意义就是占点内存，以便能在GC日志中看清楚是否被回收过
     */
    private byte[] bigSize = new byte[2 * _1MB];

    public static void main(String[] args) {
        ReferenceCountingGC objA = new ReferenceCountingGC();
        ReferenceCountingGC objB = new ReferenceCountingGC();
        objA.instance = objB;
        objB.instance = objA;

        objA = null;
        objB = null;

        // 假设在这行发生GC，那么objA和objB是否能被回收？
        // [GC 7966K->687K(246784K), 0.0019895 secs]
        System.gc();
    }

}
