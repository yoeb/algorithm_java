package com.jvm.chapter_10_3_1;

import java.util.ArrayList;
import java.util.List;

/**
 * 这段代码是不能被编译的，是因为参数List<Integer>和List<String>编译之后都被擦除了，
 * 变成了一样的原生类型List<E>,擦除动作导致这两个方法的特征签名变得一摸一样。
 */
public class GenericTypes {

/*    public static String method(List<String> list) {
        System.out.println("invoke method(List<String> list )");
        return "";
    }*/

    public static int method(List<Integer> list) {
        System.out.println("invoke method(List<Integer> list )");
        return 1;
    }

    public static void main(String[] args) {
        // method(new ArrayList<String> ());
        method(new ArrayList<Integer> ());
    }

}
