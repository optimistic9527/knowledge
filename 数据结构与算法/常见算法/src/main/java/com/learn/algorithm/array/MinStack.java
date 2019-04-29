package com.learn.algorithm.array;

/**
 * LeetCode 155. Min Stack
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * <p>
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 *
 * @author guoxingyong
 * @data 2019/4/28 19:53
 */
public class MinStack {
    public static final int DEFAULT_STACK_SIZE = 16;

    /**
     * 用来存储栈的元素饿
     */
    private int[] stackArray;

    /**
     * 当前栈的顶点的下标索引
     */
    private int lastIndex;

    /**
     * 当前栈的阈值是多少
     */
    private int threshold;

    /**
     * 栈的最小值的下标索引
     */
    private int minIndex;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        //初始化一个默认长度的数组
        stackArray = new int[DEFAULT_STACK_SIZE];
        //初始index为-1
        lastIndex = -1;
        //初始阈值为length-1，下标从0开始
        threshold = DEFAULT_STACK_SIZE - 1;
    }

    public void push(int x) {
        //当当前下标已经到达阈值，说明新进来的需要扩容(这里有个小问题就是如果扩容的时候扩容大于int的最大值会有问题)
        if (lastIndex == threshold) {
            int newLength = stackArray.length * 2;
            int[] newArray = new int[newLength];
            System.arraycopy(stackArray, 0, newArray, 0, stackArray.length);
            stackArray = newArray;
            threshold = newLength - 1;
        }
        //栈顶下标移动一位
        lastIndex = lastIndex + 1;
        stackArray[lastIndex] = x;
        //与最小值比较，如果更小替换
        if (x < getMin()) {
            minIndex = lastIndex;
        }
    }

    public void pop() {
        //如果里面只有一个值就直接取出返回了
        if (lastIndex >= 1) {
            //当当前被移动的栈定位最小值的索引这个时候需要找出新的最小值
            if (minIndex == lastIndex) {
                minIndex = 0;
                int minValue = stackArray[0];
                for (int j = 1; j < lastIndex; j++) {
                    int indexValue = stackArray[j];
                    if (minValue > indexValue) {
                        minIndex = j;
                        minValue = indexValue;
                    }
                }
            }
            stackArray[lastIndex] = 0;
            lastIndex = lastIndex - 1;
        } else {
            stackArray[0] = 0;
            lastIndex = -1;
        }
    }

    public int top() {
        return stackArray[lastIndex];
    }

    public int getMin() {
        return stackArray[minIndex];
    }

    public static void main(String[] args) {
        //["MinStack","push","push","push","top","pop","getMin","pop","getMin","pop","push","top","getMin","push","top","getMin","pop","getMin"]
        //
        //[[],[2147483646],[2147483646],[2147483647],[],[],[],[],[],[],[2147483647],[],[],[-2147483648],[],[],[],[]]
        MinStack obj = new MinStack();
        obj.push(2147483646);
        obj.push(2147483646);
        obj.push(2147483647);
        System.out.println(obj.top());
        obj.pop();
        System.out.println(obj.getMin());
        obj.pop();
        System.out.println(obj.getMin());
        obj.pop();
        obj.push(2147483647);
        System.out.println(obj.top());
        System.out.println(obj.getMin());
        obj.push(-2147483648);
        System.out.println(obj.top());
        obj.pop();
        System.out.println(obj.getMin());
    }
}
