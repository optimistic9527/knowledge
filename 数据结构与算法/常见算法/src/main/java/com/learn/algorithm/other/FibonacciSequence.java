package com.learn.algorithm.other;

/**
 * 斐波那契数列
 * @author guoxingyong
 * @data 2019/3/1 16:58
 */
public class FibonacciSequence {
    //1,1,2,3,5,8,13
    public int fib(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Illegal argument，n must > 0");
        }
        if (n == 0 || n == 1) {
            return n;
        }
        return fib(n-1)+fib(n-2);
    }
}
