package com.test.references;

public class Sample
{
    
    public static void main(String[] args)
    {
        ClassReferences classReferences = new ClassReferences();
        classReferences.test1();
        
        int a = 11;
        DataBean bean = new DataBean(11, 11, "11");
        classReferences.test2(11, bean);
        System.out.println("a = " + a);
        System.out.println("bean.getId() = " + bean.getId());
        System.out.println("bean.getAge() = " + bean.getAge());
        System.out.println("bean.getName() = " + bean.getName());
    }
}
