package com.jvm.chapter_8_3_2;

/**
 * 方法静态分派演示
 *
 * 所有依赖静态类型来定位方法执行版本的分派动作，都称为静态分派。
 * 静态分派的最典型应用就是方法重载。
 */
public class StaticDispatch {

    static abstract class Human{
    }

    static class Man extends Human{
    }

    static class Women extends Human{
    }

    public void sayHello(Human guy) {
        System.out.println("hello, guy!");
    }

    public void sayHello(Man guy) {
        System.out.println("hello, gentleman!");
    }

    public void sayHello(Women guy) {
        System.out.println("hello, lady!");
    }

    public static void main(String[] args) {
        // Human称为变量的静态类型(Static Type)或者外观类型（Apparent Type），
        // Man称为变量的实际类型（Actual Type）
        Human man = new Man();
        Human women = new Women();
        StaticDispatch sr = new StaticDispatch();
        sr.sayHello(man);
        sr.sayHello(women);
    }

}
