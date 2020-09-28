package com.example.awesome.common.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @ClassName ：IteratorTest
 * @Description ：TODO
 * @Author ：lkv587
 * @Date ：2020-05-18 16:05
 * @Version ：V1.0.0
 */
public class IteratorTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");

        System.out.println("---forEachRemaining---");
        Iterator<String> iterator = list.iterator();
        iterator.forEachRemaining(s -> System.out.println(s));
        System.out.println(iterator.hasNext());

        System.out.println("---hasNext&next---");
        iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println(iterator.hasNext());

        System.out.println("---remove---");
        iterator.remove();

        /**
         * forEach()和forEachRemaining()区别
         * 1.forEach是Iterable的方法，forEachRemaining()是Iterator方法
         * 2.forEach可多次调用，forEachRemaining只能调用一次
         */
        System.out.println("===forEach===");
        list.forEach(s -> System.out.println(s));
    }
}
