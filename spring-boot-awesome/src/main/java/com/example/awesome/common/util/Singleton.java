package com.example.awesome.common.util;

/**
 * @ClassName ：Singleton
 * @Description ：双重校验锁实现单例模式
 * @Author ：lkv587
 * @Date ：2020-08-02 22:18
 * @Version ：V1.0.0
 */
public class Singleton {

    //volatile禁止指令重排序
    private volatile static Singleton uniqueInstance;

    private Singleton(){

    }

    private static Singleton getUniqueInstance(){
        //1.先判断对象是否实例化
        if (uniqueInstance == null){
            //2.没有实例化，给对象加锁
            synchronized(Singleton.class){
                //3.再次校验是否实例化
                if (uniqueInstance == null) {
                    uniqueInstance = new Singleton();
                    /**
                     * new Singleton分三步：
                     * 1.为实例分配内存空间
                     * 2.初始化实例
                     * 3.将实例指向分配的内存地址
                     */
                }
            }
        }
        return uniqueInstance;
    }
}
