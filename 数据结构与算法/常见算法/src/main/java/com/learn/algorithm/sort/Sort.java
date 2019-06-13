package com.learn.algorithm.sort;

import java.util.Arrays;
import java.util.function.Function;

/**
 * 排序算法
 *
 * @author guoxingyong
 * @data 2019/5/1 19:06
 */
public class Sort {

    /**
     * 冒泡排序:是一种简单的排序算法。它重复地走访过要排序的数列，一次比较两个元素，如果它们的顺序错误就把它们交换过来。走访数列的工作是重复地进行直到没有再需要交换，也就是说该数列已经排序完成。
     * ----------------------------------------------------------------------
     * 时间复杂度(平均) | 时间复杂度(最坏)| 时间复杂度(最好)| 空间复杂度 | 稳定性
     * ----------------------------------------------------------------------
     * O(n^2)      |     O(n^2)    |     O(n)      |   O(1)   |  稳定
     * ----------------------------------------------------------------------
     *
     * @param unSortArray 未排序数组
     * @return 排序数组
     */
    public static int[] bubbleSort(int[] unSortArray) {
        int length = unSortArray.length;
        //在我们循环的时候是比较第j个与第j+1个，所以在每次比较是j+1最后一个，所以为循环的时候可以减1否则会数组越界
        for (int i = 0; i < length - 1; i++) {
            //每次排序那个第length-i后面的元素已经排序好了所以不用再比较了
            for (int j = 0; j < length - i - 1; j++) {
                if (unSortArray[j] > unSortArray[j + 1]) {
                    //这里使用或运算能减少一个中间变量
                    unSortArray[j] = unSortArray[j] ^ unSortArray[j + 1];
                    unSortArray[j + 1] = unSortArray[j] ^ unSortArray[j + 1];
                    unSortArray[j] = unSortArray[j] ^ unSortArray[j + 1];
                }
            }
        }
        return unSortArray;
    }

    /**
     * 选择排序(Selection-sort)是一种简单直观的排序算法。它的工作原理：首先在未排序序列中找到最小（大）元素，
     * 存放到排序序列的起始位置，然后，再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾
     * ----------------------------------------------------------------------
     * 时间复杂度(平均) | 时间复杂度(最坏)| 时间复杂度(最好)| 空间复杂度 | 稳定性
     * ----------------------------------------------------------------------
     * O(n^2)     |     O(n^2)    |     O(n^2)    |   O(1)   |  稳定
     * ----------------------------------------------------------------------
     *
     * @param unSortArray 未排序数组
     * @return 排序数组
     */
    public static int[] selectionSort(int[] unSortArray) {
        int length = unSortArray.length;
        for (int i = 0; i < length; i++) {
            //使用一个index记录当前需要排序的一段中的最小值的下标
            int index = i;
            for (int j = i + 1; j < length; j++) {
                if (unSortArray[j] < unSortArray[index]) {
                    index = j;
                }
            }
            if (i != index) {//当index与i相同就代表当前的i的元素就是最小的那个不需要交换
                unSortArray[i] = unSortArray[i] ^ unSortArray[index];
                unSortArray[index] = unSortArray[i] ^ unSortArray[index];
                unSortArray[i] = unSortArray[i] ^ unSortArray[index];
            }
        }
        return unSortArray;
    }

    /**
     * 插入排序:对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入
     * ----------------------------------------------------------------------
     * 时间复杂度(平均) | 时间复杂度(最坏)| 时间复杂度(最好)| 空间复杂度 | 稳定性
     * ----------------------------------------------------------------------
     * O(n^2)    |     O(n^2)    |     O(n)      |   O(1)   |  稳定
     * ----------------------------------------------------------------------
     *
     * @param unSortArray 未排序数组
     * @return 排序数组
     */
    public static int[] insertionSort(int[] unSortArray) {
        for (int i = 0; i < unSortArray.length; i++) {
            //存贮当前需要去插入的值
            int indexValue = unSortArray[i];
            int index = i;
            //如果index的前一位的值大于需要插入的值，就把index-1的值移动到index位置
            while (index != 0 && unSortArray[index - 1] > indexValue) {
                unSortArray[index] = unSortArray[index - 1];
                index--;
            }
            //最后把需要插入的值插入到index(上面保证了index-1位置的值是比indexValue是要小的)
            unSortArray[index] = indexValue;
        }
        return unSortArray;
    }


    /**
     * 希尔排序:把等待排序的数组按照步长分割成诺干组，让每组进行插入排序
     * ---------------------------------------------------------"C:\Program Files\Java\jdk1.8.0_181\bin\java.exe" -Dvisualvm.id=2857707696865700 "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA 2018.3.5\lib\idea_rt.jar=12484:C:\Program Files\JetBrains\IntelliJ IDEA 2018.3.5\bin" -Dfile.encoding=UTF-8 -classpath "C:\Program Files\Java\jdk1.8.0_181\jre\lib\charsets.jar;C:\Program Files\Java\jdk1.8.0_181\jre\lib\deploy.jar;C:\Program Files\Java\jdk1.8.0_181\jre\lib\ext\access-bridge-64.jar;C:\Program Files\Java\jdk1.8.0_181\jre\lib\ext\cldrdata.jar;C:\Program Files\Java\jdk1.8.0_181\jre\lib\ext\dnsns.jar;C:\Program Files\Java\jdk1.8.0_181\jre\lib\ext\jaccess.jar;C:\Program Files\Java\jdk1.8.0_181\jre\lib\ext\jfxrt.jar;C:\Program Files\Java\jdk1.8.0_181\jre\lib\ext\localedata.jar;C:\Program Files\Java\jdk1.8.0_181\jre\lib\ext\nashorn.jar;C:\Program Files\Java\jdk1.8.0_181\jre\lib\ext\sunec.jar;C:\Program Files\Java\jdk1.8.0_181\jre\lib\ext\sunjce_provider.jar;C:\Program Files\Java\jdk1.8.0_181\jre\lib\ext\sunmscapi.jar;C:\Program Files\Java\jdk1.8.0_181\jre\lib\ext\sunpkcs11.jar;C:\Program Files\Java\jdk1.8.0_181\jre\lib\ext\zipfs.jar;C:\Program Files\Java\jdk1.8.0_181\jre\lib\javaws.jar;C:\Program Files\Java\jdk1.8.0_181\jre\lib\jce.jar;C:\Program Files\Java\jdk1.8.0_181\jre\lib\jfr.jar;C:\Program Files\Java\jdk1.8.0_181\jre\lib\jfxswt.jar;C:\Program Files\Java\jdk1.8.0_181\jre\lib\jsse.jar;C:\Program Files\Java\jdk1.8.0_181\jre\lib\management-agent.jar;C:\Program Files\Java\jdk1.8.0_181\jre\lib\plugin.jar;C:\Program Files\Java\jdk1.8.0_181\jre\lib\resources.jar;C:\Program Files\Java\jdk1.8.0_181\jre\lib\rt.jar;E:\ideaWork\learn\knowledge\数据结构与算法\常见算法\target\classes;E:\repository\org\projectlombok\lombok\1.18.6\lombok-1.18.6.jar" com.learn.algorithm.sort.Sort
     * [-10, 0, 5, 7, 10, 11, 12, 16, 16, 17, 18, 18, 20, 31, 32, 43, 52, 75, 80, 88, 99, 100, 101]
     * insertionSort:134-------------
     * 时间复杂度(平均) | 时间复杂度(最坏)| 时间复杂度(最好)| 空间复杂度 | 稳定性
     * ----------------------------------------------------------------------
     * O(n^1.3)    |     O(n^2)    |     O(n)      |   O(1)      |  稳定
     * ----------------------------------------------------------------------
     *
     * @param unSortArray 未排序数组
     * @return 排序数组
     */
    public static int[] shellSort(int[] unSortArray) {
        int length = unSortArray.length;
        int x = length >> 1;
        while (x > 0) {
            for (int i = 0; i < length; i++) {
                //我们在每次循环的时候把数组按照步长分成多个数组例如{10, 5, 7, 52, 16, 0, 12, 18, 17, 20};
                // 第一次的时候就分为{10,0,20},{5,12},{7,18},{52,17},{16,20}这几组分别进行插入排序
                int index = i;
                int indexValue = unSortArray[i];
                while (index - x >= 0 && unSortArray[index - x] > indexValue) {
                    unSortArray[index] = unSortArray[index - x];
                    index = index - x;
                }
                unSortArray[index] = indexValue;
            }
            x = x >> 1;
        }
        return unSortArray;
    }

    /**
     * 并归排序:将已有序的子序列合并，得到完全有序的序列；即先使每个子序列有序，再使子序列段间有序
     * ----------------------------------------------------------------------
     * 时间复杂度(平均) | 时间复杂度(最坏)| 时间复杂度(最好)| 空间复杂度 | 稳定性
     * ----------------------------------------------------------------------
     * O(nlog(n))  |  O(nlog(n))   |   O(nlog(n))  |   O(n)    |  稳定
     * ----------------------------------------------------------------------
     *
     * @param unSortArray 未排序数组
     * @return 排序数组
     */
    public static int[] mergeSort(int[] unSortArray) {//fixme bug
        if (unSortArray.length < 2) {
            return unSortArray;
        }
        int[] left = Arrays.copyOfRange(unSortArray, 0, unSortArray.length / 2);
        int[] right = Arrays.copyOfRange(unSortArray, unSortArray.length / 2, unSortArray.length);
        return sortTwoSortArray(mergeSort(left), mergeSort(right));
    }

    /**
     * ----------------------------------------------------------------------
     * 时间复杂度(平均) | 时间复杂度(最坏)| 时间复杂度(最好)| 空间复杂度 | 稳定性
     * ----------------------------------------------------------------------
     * O(nlog(n))  |  O(nlog(n))   |   O(nlog(n))  |   O(n)    |  稳定
     * ----------------------------------------------------------------------
     *
     * @param unSortArray 未排序数组
     * @return 排序数组
     */
    public static int[] quickSort(int[] unSortArray, int start, int end) {//fixme bug
        //如果其实点大于结束点直接返回并且end小于unSortArray的length
        if (start >= end) {
            return unSortArray;
        }
        //以起始点的值定位基准点
        int partitionValue = unSortArray[start];
        //比较从基准点之后的一位开始
        int lowIndex = start + 1;
        int highIndex = end - 1;
        while (lowIndex < highIndex) {
            //我们在第一个小于基准值的地方停下来
            while (lowIndex < highIndex && unSortArray[highIndex] > partitionValue) {
                highIndex--;
            }
            //我们在第一个大于基准值的地方停下来
            while (lowIndex < highIndex && unSortArray[lowIndex] < partitionValue) {
                lowIndex++;
            }
            if (lowIndex < highIndex) {
                unSortArray[lowIndex] = unSortArray[lowIndex] ^ unSortArray[highIndex];
                unSortArray[highIndex] = unSortArray[lowIndex] ^ unSortArray[highIndex];
                unSortArray[lowIndex] = unSortArray[lowIndex] ^ unSortArray[highIndex];
            }
        }
        if(unSortArray[highIndex]<partitionValue){
            unSortArray[start] = unSortArray[highIndex];
            unSortArray[highIndex] = partitionValue;
        }
        quickSort(unSortArray, start, highIndex);
        quickSort(unSortArray, highIndex + 1, end);
        return unSortArray;
    }
    //todo 把二叉树写了之后就把堆排序写了


    /**
     * @param left  已经排好序的左边数组
     * @param right 已经排好序的右边数组
     * @return 已经排好序的合并数组
     */
    private static int[] sortTwoSortArray(int[] left, int[] right) {
        int length = left.length + right.length;
        int[] newArray = new int[length];
        int leftIndex = 0;
        int rightIndex = 0;
        for (int i = 0; i < length; i++) {
            //如果rightIndex已经大于他的长度了，代表right数组已经被取完了，直接拿left数组里的就可以了
            if (rightIndex >= right.length) {
                newArray[i] = left[leftIndex];
                leftIndex++;
                continue;
            }
            //leftIndex如果已经比left的数组长了代表已经被取完了,直接去right数组拿就可以了
            if (leftIndex >= left.length) {
                newArray[i] = right[rightIndex];
                rightIndex++;
                continue;
            }
            //都没有达到边界，就把小的放进去
            if (left[leftIndex] < right[rightIndex]) {
                newArray[i] = left[leftIndex];
                leftIndex++;
            } else {
                newArray[i] = right[rightIndex];
                rightIndex++;
            }
        }
        return newArray;
    }

    public static void main(String[] args) {
        // System.out.println("bubbleSort:" + testTime(Sort::bubbleSort));
        //System.out.println("selectionSort:" + testTime(Sort::selectionSort));
        System.out.println("insertionSort:" + testTime(Sort::insertionSort));
        System.out.println("shellSort:" + testTime(Sort::shellSort));
        // System.out.println("mergeSort:" + testTime(Sort::mergeSort));
        long start = System.currentTimeMillis();
        int[] sortArray = null;
        for (int i = 0; i < 1000000; i++) {
            int[] unSortArray1 = new int[]{18, 5, 7, 52, 16, 0, 12, 10, 17, 20, -10, 100, 11, 18, 32, 16, 80, 101, 75, 43, 99, 88, 31};
            sortArray = quickSort(unSortArray1, 0, unSortArray1.length);
        }
        System.out.println(Arrays.toString(sortArray));
        System.out.println("quickSort:" + (System.currentTimeMillis() - start));

    }


    private static long testTime(Function<int[], int[]> sort) {
        long start = System.currentTimeMillis();
        int[] sortArray = null;
        for (int i = 0; i < 1000000; i++) {
            int[] unSortArray1 = new int[]{18, 5, 7, 52, 16, 0, 12, 10, 17, 20, -10, 100, 11, 18, 32, 16, 80, 101, 75, 43, 99, 88, 31};
            sortArray = sort.apply(unSortArray1);
            //quickSort(unSortArray1, 0, unSortArray1.length);
        }
        System.out.println(Arrays.toString(sortArray));
        return System.currentTimeMillis() - start;
    }
}
