package com.pengh.leetcode;

import java.util.Arrays;
import java.util.Stack;


/**
 * 同步数据栈
 */
public class _155MinStack {

    private Stack<Integer> intStack;
    private Stack<Integer> minStack;

    /** initialize your data structure here. */
    public _155MinStack() {
        intStack=new Stack<>();
        minStack=new Stack<>();
    }

    public void push(int x) {
        intStack.push(x);
        if(minStack.empty()||minStack.peek()>x){
            minStack.push(x);
        }
        else {
            minStack.push(minStack.peek());
        }
    }

    public void pop() {
        intStack.pop();
        minStack.pop();
    }

    public int top() {
        if(!intStack.empty()){
            return intStack.peek();
        }
        throw new RuntimeException("栈为空");
    }

    public int getMin() {
        if(!minStack.empty()){
            return minStack.peek();
        }
        throw new RuntimeException("栈为空");
    }
}

/**
 * ["MinStack","push","push","push","getMin","push","push","push","push","push","top","push","push","getMin","push","getMin","push","push","getMin","push","top","push","getMin","push","push","push","push","getMin","push","push","top","push","push","getMin","pop","getMin","push","push","getMin","getMin","push","getMin","pop","push","push","push","getMin","push","getMin","getMin","getMin","pop","getMin","push","push","getMin","top","getMin","push","getMin","getMin","getMin","getMin","push","getMin","getMin","getMin","push","getMin","push","getMin","push","getMin","getMin","getMin","getMin","pop","getMin","push","getMin","getMin","push","push","pop","push","getMin","push","top","top","push","push","getMin","pop","getMin","push","top","push","getMin","push","getMin","getMin"]
 * [[],[85],[-99],[67],[],[-27],[61],[-97],[-27],[35],[],[99],[-66],[],[-89],[],[4],[-70],[],[52],[],[54],[],[94],[-41],[-75],[-32],[],[5],[29],[],[-78],[-74],[],[],[],[-58],[-44],[],[],[-64],[],[],[-45],[-99],[-27],[],[-96],[],[],[],[],[],[26],[-58],[],[],[],[25],[],[],[],[],[33],[],[],[],[71],[],[-62],[],[-78],[],[],[],[],[],[],[-30],[],[],[85],[-15],[],[-40],[],[72],[],[],[18],[59],[],[],[],[-59],[],[10],[],[9],[],[]]
 */
