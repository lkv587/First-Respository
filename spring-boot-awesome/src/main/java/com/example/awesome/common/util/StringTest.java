package com.example.awesome.common.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.*;
import java.util.Map.Entry;

/**
 * @ClassName ：StringTest
 * @Description ：TODO
 * @Author ：lkv587
 * @Date ：2020-05-08 17:26
 * @Version ：V1.0.0
 */
public class StringTest {


    public static void main(String[] args) {
        /**
         * intern
         * str1指向的实例是在堆中，是由“java”和"虚拟机"拼接成的。执行完第一句代码后，执行完这句话后，常量池中会有"java"和"虚拟机"，但是不会有"java虚拟机"。
         * 然后使用str1.intern（）会在常量池中保存str1实例的引用，并且返回引用，因此str1.intern()==str1。
         * 而执行完String str2=new String("我喜欢java");后，常量池中会有"我喜欢java"，
         * 所以在使用str2.intern（）返回的就是字符串常量池中的引用，而str2指向的是堆中的引用，因此str2！=str2.intern()。
         */
//        String str1 = new StringBuilder("java").append("虚拟机").toString();
//        System.out.println(str1.intern() == str1);
//        String str2 = new String("我喜欢java");
//        System.out.println(str2.intern() == str2);
//
//
//        //Map遍历
//        Map map = new HashMap();
//        map.put("aaa","test1");
//        map.put("bbb","test2");
//        Iterator<Map.Entry> entryIterator = map.entrySet().iterator();
//        while(entryIterator.hasNext()){
//            Entry entry = entryIterator.next();
//            System.out.println("key:"+entry.getKey()+" ,value:"+entry.getValue());
//        }
//
//        Map map1 = new HashMap();
//        map1.put("aaa","test1");
//        map1.put("bbb","test2");
//        List<Map<String, String>> roles = new ArrayList<>();
//        roles.add(map);
//        roles.add(map1);
//
//        System.out.println(JSONObject.toJSONString(roles));

        String s = "[{\"roleId\":\"45\",\"sort\":\"1\",\"content\":\"市场\"},{\"roleId\":\"46\",\"sort\":\"3\",\"content\":\"总裁\"},{\"roleId\":\"44\",\"sort\":\"2\",\"content\":\"财务\"}]";
//        JSONObject jsonObject = JSON.parseObject(s);
//        String roleId = jsonObject.getString("roleId");
        JSONArray jsonArray = JSON.parseArray(s);
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            String roleId = jsonObject.getString("roleId");
            if ("44".equals(roleId)){
                int sort = Integer.parseInt(jsonObject.getString("sort"));
                if (sort == 1){
                    System.out.println("一审");
                }else {
                    System.out.println("2,3,4。。。审");
                }
            }
        }
    }
}
