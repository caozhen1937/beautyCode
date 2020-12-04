package com.leetcode.sync;

/**
 * Created by caozhen on 2020/12/3
 */
public class SyncTest implements Runnable {
    private static int count;
    private static int count1;
    private static int count2;

    // 对象锁
    public synchronized void add() {
        count++;
    }

    // 类锁(对类加锁有两种方式，这是第一种，修饰静态方法)
    public synchronized static void add1() {
        count1++;
    }

    // 类锁(对类加锁有两种方式，这是第二种，修饰代码块，以类.class为锁)
    public void add2() {
        synchronized (SyncTest.class) {
            count2++;
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < 100000; i++) {
            add();
            add1();
            add2();
        }

    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new SyncTest());
        Thread thread2 = new Thread(new SyncTest());
        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("count: " + count);
        System.out.println("count1: " + count1);
        System.out.println("count2: " + count2);
    }
}
