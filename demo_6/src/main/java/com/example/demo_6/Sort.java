package com.example.demo_6;

public class Sort {
    public static void main(String args[]){
        int array[] = { 5, 4, 3, 2, 1};
        bubbleSort(array);
        for(int i : array) {
            System.out.print(i+" ");
        }
    }

    private static void bubbleSort(int array[]){
        int len = array.length;
        //循环的次数为数组长度减一，剩下的一个数不需要排序
        for(int i=0;i<len-1;++i){
            boolean noswap=true;
            //循环次数为待排序数第一位数冒泡至最高位的比较次数
            for(int j=0;j<len-1-i;++j){
                if(array[j]>array[j+1]){
                    //the simplest swap
                    int swap = array[j];
                    array[j] = array[j+1];
                    array[j+1] = swap;
                    //swap 1
                    //array[j]=array[j]+array[j+1];
                    //array[j+1]=array[j]-array[j+1];
                    //array[j]=array[j]-array[j+1];
                    //交换或者使用如下方式
                    //a=a^b;
                    //b=b^a;
                    //a=a^b;
                    noswap=false;
                }
            }
            if(noswap) break;
        }
    }
}
