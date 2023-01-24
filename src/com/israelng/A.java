package com.israelng;
public class A {
    int a = 5;

    public void print(){
        System.out.println(a);
    }
}
class B extends A{
    int a = 6;
    public void print(){
        System.out.println(a);
    }
}
