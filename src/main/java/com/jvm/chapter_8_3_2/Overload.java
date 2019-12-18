package com.jvm.chapter_8_3_2;

import java.io.Serializable;

/**
 * 重载方法匹配优先级
 * char -> int -> long -> Character -> Serializable -> Object -> char ...
 * 演示了编译期间选择静态分派目标的过程，这个过程也是Java语言实现方法重载的本质。
 */
public class Overload {

    public static void sayHello(Object arg) {
        System.out.println("hello Object");
    }

    public static void sayHello(int arg) {
        System.out.println("hello int");
    }

    public static void sayHello(int... arg) {
        System.out.println("hello int ...");
    }

    public static void sayHello(long arg) {
        System.out.println("hello long");
    }

    public static void sayHello(long... arg) {
        System.out.println("hello long ...");
    }

    public static void sayHello(Character arg) {
        System.out.println("hello Character");
    }

    public static void sayHello(char arg) {
        System.out.println("hello char");
    }

    public static void sayHello(char... arg) {
        System.out.println("hello char ...");
    }

    public static void sayHello(Serializable arg) {
        System.out.println("hello Serializable");
    }

    public static void main(String[] args) {
        sayHello('a');
    }
}
