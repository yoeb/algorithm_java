package com.jvm.chapter_10_3_3;

/**
 * 条件编译
 * Java中条件编译的实现，也是Java语言的一颗语法糖，根据布尔常量值的真假，
 * 编译器将会把分支中不成立的代码块消除掉，这一工作将在编译器解除语法糖的阶段完成。
 */
public class Test1 {

    public static void main(String[] args) {

        if (true) {
            System.out.println("block 1");
        } else {
            int i = 1 / 0;
            System.out.println("block 2");
        }

    }

}
