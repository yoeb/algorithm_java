package com.jvm.chapter_2_4_2;

/**
 * Java虚拟机栈内存溢出测试
 * VM Args: -Xss128k  设置单个线程栈大小
 * 在单个线程下，无论是由于栈帧太大，还是虚拟机栈容量太小，
 * 当内存无法分配的时候，虚拟机抛出的都是StackOverFlowError异常
 */
public class JavaVMStackSOF {

    private int stackLength = 1;

    public void stackLeak() {
        stackLength ++;
        stackLeak();
    }

    public static void main(String[] args) throws Throwable {
        JavaVMStackSOF oom = new JavaVMStackSOF();
        try {
            // Exception in thread "main" java.lang.StackOverflowError
            oom.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack length:" + oom.stackLength);
            throw e;
        }
    }

}
