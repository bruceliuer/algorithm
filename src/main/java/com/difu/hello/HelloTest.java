package com.difu.hello;

public class HelloTest {


    public static void main(String[] args) {
        Hello hello = new Hello();

        Thread thread1 = new Thread(){
            @Override
            public void run() {
                hello.increment();
                System.out.println("thread1 " + hello.getData());
            }
        };

        Thread thread2 = new Thread(){
            @Override
            public void run() {
                hello.increment();
                System.out.println("thread2 " + hello.getData());
            }
        };
        thread2.start();
        thread1.start();




    }
}
