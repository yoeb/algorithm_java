package com.jvm.chapter_2_4_3;

import java.util.ArrayList;
import java.util.List;

/**
 * VM Args: -XX:PermSize=4m -XX:MaxPermSize=4m    -Xms20m -Xmx20m
 * 注意：这两个参数在jdk8已经不再支持
 * 最新的jdk7也不再溢出
 */
public class RuntimeConstantPoolOOM {

    public static void main(String[] args) {
        // 使用List保持着常量池引用，避免Full GC回收常量池行为
        List<String> list = new ArrayList<>();
        // 10MB 的PermSize在Integer范围内足够产生OOM了
        int i = 0;
        while (true) {
            list.add(String.valueOf(i ++).intern());
//            System.out.println(list.size());
        }
    }

}
