package com.jvm.chapter_2_4_1;

import java.util.ArrayList;
import java.util.List;

/**
 * Java堆溢出测试
 * jvm启动参数：
 * -XX: +HeapDumpOnOutOfMemoryError 让虚拟机在出现内存溢出异常时Dump出当前的内存堆转储快照
 * -Xms20m  初始堆大小
 * -Xmx20m  最大堆大小
 * VM Args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 */
public class HeapOOM {

    static class OOMObject {}

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();

        while (true) {
            // Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
            list.add(new OOMObject());
        }
    }

}
