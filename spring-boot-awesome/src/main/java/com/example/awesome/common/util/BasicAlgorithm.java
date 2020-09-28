package com.example.awesome.common.util;

import java.util.Arrays;

/**
 * @ClassName ：BasicAlgorithm
 * @Description ：TODO
 * @Author ：lkv587
 * @Date ：2020-01-15 16:11
 * @Version ：V1.0.0
 */
public class BasicAlgorithm {

    public static int[] BASE_DATA = {2,4,7,3,6,9,1,8,5};

    /**
     * @Description: 冒泡排序
     * @Param: 
     * @return: 
     * @Author: LKV587
     * @Date: 2020/1/15 18:32
     */
    public void bubbleSort(int[] sourceArray){
        int[] arr = Arrays.copyOf(sourceArray,sourceArray.length);

        for (int i = 1; i < arr.length ; i++) {
            boolean flag = true;

            for (int j = 0; j < arr.length - i ; j++) {

                if (arr[j] > arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;

                    flag = false;
                }
            }

            if (flag){
                break;
            }
        }
    }

    /**
     * @Description: 选择排序
     * @Param: 
     * @return:
     * @Author: LKV587
     * @Date: 2020/1/15 18:32
     */
    public void selectSort(int[] sourceArray){
        int[] arr = Arrays.copyOf(sourceArray,sourceArray.length);

        for (int i = 0; i < arr.length ; i++) {
            int min = i;
            for (int j = i+1; j < arr.length ; j++) {
                if (arr[j] < arr[min]){
                    min = j;
                }
            }
            if (i != min){
                int tmp = arr[i];
                arr[i] = arr[min];
                arr[min] = tmp;
            }
        }
    }


    /**
     * @Description: 插入排序
     * @Param: 
     * @return: 
     * @Author: LKV587
     * @Date: 2020/1/16 11:54
     */
    public void insertSort(int[] sourceArray){
        int[] arr = Arrays.copyOf(sourceArray,sourceArray.length);
        //从下标1开始，下标0默认有序的
        for (int i = 1; i < arr.length ; i++) {
             int tmp = arr[i];

             int j = i;
             while (j > 0 && tmp < arr[j-1]){
                 arr[j] = arr[j-1];
                 j--;
             }

             if (j!=i){
                 arr[j] = tmp;
             }
        }
    }

    public static void main(String[] args) {
        BasicAlgorithm algorithm = new BasicAlgorithm();
        algorithm.bubbleSort(BASE_DATA);
    }
}
