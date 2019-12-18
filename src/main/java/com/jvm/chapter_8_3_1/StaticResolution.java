package com.jvm.chapter_8_3_1;

/**
 * 方法静态解析演示
 *
 * 使用javap -verbose StaticResolution反编译
 * 发现是通过invokestatic命令来调用sayHello()方法
 *
 * 解析调用一定是个静态的过程，在编译期间就完全确定，在类装载的解析阶段就会把
 * 涉及的符号引用全部转变为可确定的直接引用，不会延迟到运行期再去完成。
 */
public class StaticResolution {

    public static void sayHello() {
        System.out.println("hello world");
    }

    public static void main(String[] args) {
        StaticResolution.sayHello();
    }

}
