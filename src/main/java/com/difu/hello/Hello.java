package com.difu.hello;

import java.util.concurrent.atomic.AtomicInteger;

public class Hello {
    private AtomicInteger data= new AtomicInteger(0);

    public void increment(){
        data.incrementAndGet();
    }

    public int getData() {
        return data.get();
    }
}
