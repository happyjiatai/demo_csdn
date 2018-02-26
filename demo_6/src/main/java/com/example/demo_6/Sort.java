package com.example.demo_6;

public class Sort {
    public static void main(String args[]){
        int array[] = { 5, 4, 3, 2, 1};
        /*bubbleSort(array);
        for(int i : array) {
            System.out.print(i+" ");
        }*/

        int array1[] = { 48, 36, 68, 72, 12, 48, 02};
        quickSort(array1, 0, 6);
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

    //a：待排序数组，low：最低位的下标，high：最高位的下标
    private static void quickSort(int a[],int low, int high)
    {
        if(low>=high)
        {
            return;
        }
        System.out.println("----" + 0 +"----");
        for(int i = low; i <= high; i++){
            System.out.print(a[i] + " ");
        }
        System.out.println();
        int left=low;
        int right=high;
        int key=a[left];    /*用数组的第一个记录作为分区元素*/
        int index = 1 ;
        while(left!=right){
            System.out.println("----" + index++ +"----");
            while(left<right&&a[right]>=key)    /*从右向左扫描，找第一个码值小于key的记录，并交换到key*/
                --right;
            a[left]=a[right];
            while(left<right&&a[left]<=key)
                ++left;
            a[right]=a[left];    /*从左向右扫描，找第一个码值大于key的记录，并交换到右边*/
            for(int i = low; i <= high; i++){
                System.out.print(a[i] + " ");
            }
            System.out.print("\n");
        }
        a[left]=key;    /*分区元素放到正确位置*/
        System.out.println("----over----");
        for(int i = low; i <= high; i++){
            System.out.print(a[i] + " ");
        }
        System.out.print("\n\n");
        quickSort(a,low,left-1);
        quickSort(a,left+1,high);
    }
}
