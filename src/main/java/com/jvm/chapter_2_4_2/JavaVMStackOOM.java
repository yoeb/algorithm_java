package com.jvm.chapter_2_4_2;

/**
 * VM Args: -Xss2M
 *
 * 特别提示：如果要运行此段代码，记得要先保存当前的工作，由于在Windows平台的
 * 虚拟机中，Java的线程是映射到操作系统的内核线程上的，所以上述代码执行时有
 * 较大的风险，可能会导致操作系统假死。
 */
public class JavaVMStackOOM {

    private void dontStop() {
        while (true) {

        }
    }

    public void stackLeakByThread() {
        while (true) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    dontStop();
                }
            });
            thread.start();
        }
    }

    public static void main(String[] args) {
        JavaVMStackOOM oom = new JavaVMStackOOM();
        oom.stackLeakByThread();
    }

}
