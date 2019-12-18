package com.jvm.chapter_8_3_2;

/**
 * 单分派、多分派演示
 *
 * 方法的接收者与方法的参数统称为方法的宗量。
 *
 * 编译阶段，静态分派依据两点：静态类型，方法参数，属于多分派
 * 运行阶段，动态分派依据接收者的实际类型，属于单分派
 * jdk1.6的Java语言是一门静态多分派，动态单分派的语言。
 */
public class Dispatch {

    static class QQ{}

    static class _360{}

    public static class Father {
        public void hardChoice(QQ arg) {
            System.out.println("father choose qq");
        }

        public void hardChoice(_360 arg) {
            System.out.println("father choose 360");
        }
    }

    public static class Son extends Father {
        public void hardChoice(QQ arg) {
            System.out.println("son choose qq");
        }

        public void hardChoice(_360 arg) {
            System.out.println("son choose 360");
        }
    }

    public static void main(String[] args) {
        Father father = new Father();
        Father son = new Son();
        father.hardChoice(new _360());
        son.hardChoice(new QQ());
    }

}
