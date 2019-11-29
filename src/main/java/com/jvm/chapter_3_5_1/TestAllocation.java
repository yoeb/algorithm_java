package com.jvm.chapter_3_5_1;

/**
 * 测试内存分配
 * VM Args: -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:SurvivorRatio=8
 * -verbose:gc  在虚拟机发生内存回收时在输出设备显示信息
 * -Xmn10M 设置年轻代大小为10M
 * -XX:SurvivorRatio=8 设置新生代中Eden区与一个Survivor区的空间比例是8比1
 */
public class TestAllocation {

    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {
        byte[] allocation1, allocation2, allocation3, allocation4, allocation5;
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        allocation4 = new byte[2 * _1MB];
        allocation5 = new byte[4 * _1MB];  // 出现一次Minor GC
    }

}
