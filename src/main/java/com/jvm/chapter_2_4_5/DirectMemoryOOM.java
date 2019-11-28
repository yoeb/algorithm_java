package com.jvm.chapter_2_4_5;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * VM Args:-Xmx20M -XX:-XX:MaxDirectMemorySize=10m
 */
public class DirectMemoryOOM {

    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {
        try {
            Field unsafeField = Unsafe.class.getDeclaredFields()[0];
            unsafeField.setAccessible(true);
            Unsafe unsafet = (Unsafe) unsafeField.get(null);
            while (true) {
                unsafet.allocateMemory(_1MB);
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

}
