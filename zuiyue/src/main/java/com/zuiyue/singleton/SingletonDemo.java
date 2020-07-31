package com.zuiyue.singleton;

public class SingletonDemo {

   // private static SingletonDemo instance= null;
    private static volatile SingletonDemo instance= null;
    private SingletonDemo(){
        System.out.println(Thread.currentThread().getName()+"----------->");
    }

 /*   public static synchronized SingletonDemo getInstance() {
        if (null == instance){
            instance= new SingletonDemo();
        }
        return instance;
    }
*/
    //DCL (double cheeck lock 双端检锁机制)
    public static  SingletonDemo getInstance() {
        if (null == instance){
            synchronized (SingletonDemo.class){
                if (null == instance){
                    instance= new SingletonDemo();
                }
            }

        }
        return instance;
    }
    public static void main(String[] args) {

        for (int i=0;i<100000000;i++){
            new Thread(()->{
                SingletonDemo.getInstance();
            }).start();

        }

        /*System.out.println(getInstance()==getInstance());
        System.out.println(getInstance()==getInstance());
        System.out.println(getInstance()==getInstance());*/
    }

}
