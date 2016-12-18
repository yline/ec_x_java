package com.test.pps;

public class Sample
{
    public static void main(String[] args)
    {
        // private public 区别
        PrivateAndPublic privateAndPublic = new PrivateAndPublic();
        // privateAndPublic.testPrivate(); 错误的
        privateAndPublic.testPublic();
        
        // static 内存
        ClassStatic classStatic1 = new ClassStatic();
        classStatic1.print();
        ClassStatic classStatic2 = new ClassStatic();
        classStatic2.print();
        // static 实用
        classStatic1.printStatic();
        ClassStatic.printStatic();
        
        // Scope
        ClassScope classScope = new ClassScope();
        classScope.test();
    }
}
