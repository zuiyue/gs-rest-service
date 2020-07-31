package com.zuiyue.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * 1:CAS 是什么 ====》 compare and set
 * 比较并交换
 *
 */

public class CasDemo {
    public static void main(String[] args) {
        AtomicInteger atomicInteger= new AtomicInteger(5);
        atomicInteger.incrementAndGet();

        AtomicStampedReference<String> atomicStampedReference= new AtomicStampedReference<String>("111",1);

        atomicInteger.compareAndSet(5,2019);

        Executors.newFixedThreadPool(7);
    }
}
