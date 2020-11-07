package com.company;

import java.util.Scanner;


//实现多线程
class MyThread implements Runnable{
    private String ThreadName;
    private long min;
    private long max;
    private long sum=0;
    int index;

    private static boolean contain(long num, int x) {
        return String.valueOf(num).contains(String.valueOf(x));
    }

    public MyThread(String ThreadName,long min,long max,int index){
        this.ThreadName=ThreadName;
        this.min=min;
        this.max=max;
        this.index=index;
    }

    public void run(){
        for(long i=min;i<=max;i++){
            if (contain(i, index)) sum += i;
        }
        System.out.println(ThreadName+" result:"+sum);
    }

    public static void main() {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        MyThread MyThread1=new MyThread("thread1",1, 250000000,x);
        MyThread MyThread2=new MyThread("thread2",250000001, 500000000,x);
        MyThread MyThread3=new MyThread("thread3",500000001, 750000000,x);
        MyThread MyThread4=new MyThread("thread4",750000001, 1000000000,x);
        Thread t1=new Thread(MyThread1);
        Thread t2=new Thread(MyThread2);
        Thread t3=new Thread(MyThread3);
        Thread t4=new Thread(MyThread4);
        t1.start();
        t2.start();
        t3.start();
        t4.start();

        try {                               //等待线程结束
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        long FinalResult=MyThread1.sum+MyThread2.sum+MyThread3.sum+MyThread4.sum;
        System.out.println("final result is:"+ FinalResult);

    }
}







