package com.levi.interview_me.jvm;

public class HeapSpaceSample {
//    public static void main(String[] args) throws InterruptedException {
//        //返回Java虚拟机中的堆内存总量
//        long usedMemory = Runtime.getRuntime().totalMemory() / 1024 / 1024;
//        //返回Java虚拟机试图使用的最大堆内存量
//        long maxMemory = Runtime.getRuntime().maxMemory() / 1024 / 1024;
//        System.out.println("堆当前占用 : " + usedMemory + "M");
//        System.out.println("堆最大内存 : " + maxMemory + "M");
//        System.out.println("开始等待10s");
//        Thread.sleep(10000);
//        System.out.println("开始生成对象");
//        for (int i = 0; i < 100; i++) {
//            byte[] bytes = new byte[8*1024 * 1024];
//            Thread.sleep(100);
//            System.out.println(i);
//        }
//
//        try {
//            Thread.sleep(10000000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }

    private static String A = "A";
    private static String B = "B";
    public static void main(String[] args) {
        new HeapSpaceSample().deadLock();
    }
    private void deadLock() {
        Thread t1 = new Thread(() -> {
            synchronized (A) {
                try { Thread.currentThread().sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (B) {
                    System.out.println("1");
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (B) {
                    synchronized (A) {
                        System.out.println("2");
                    }
                }
            }
        });
        t1.start();
        t2.start();
    }
}

