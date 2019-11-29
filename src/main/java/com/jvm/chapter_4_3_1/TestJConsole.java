package com.jvm.chapter_4_3_1;

import java.util.ArrayList;
import java.util.List;

/**
 * JConsole: Java监视与管理控制台
 */
public class TestJConsole {

    /**
     * 内存占位符对象，一个OOMObject大约占64K
     * VM Args: -Xms100m -Xmx100m -XX:+UseSerialGC
     */
    static class OOMObject {
        public byte[] placeholder = new byte[64 * 1024];
    }

    public static void fillHeap(int num) throws InterruptedException {
        List<OOMObject> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            // 稍作延时，令监视曲线的变化更加明显
            Thread.sleep(50);
            list.add(new OOMObject());
        }
        System.gc();
    }

    public static void main(String[] args) throws InterruptedException {
        fillHeap(1000);
    }

}
