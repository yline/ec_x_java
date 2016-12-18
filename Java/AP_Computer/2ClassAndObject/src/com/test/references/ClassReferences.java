package com.test.references;

public class ClassReferences
{
    /** 测试赋值 */
    public void test1()
    {
        int num1 = 3;
        int num2 = num1;
        
        DataBean bean1 = new DataBean();
        DataBean bean2 = bean1;
        DataBean bean3 = new DataBean();
        int code1 = bean1.hashCode();
        int code2 = bean2.hashCode();
        int code3 = bean3.hashCode();
        System.out.println("code1 = " + code1);
        System.out.println("code2 = " + code2);
        System.out.println("code3 = " + code3);
        
        // null
        //        DataBean bean4;
        //        bean4.hashCode();
    }
    
    // 方法 赋值,
    public void test2(int number, DataBean bean)
    {
        number = 2;
        // bean = new DataBean(); // 加与不加  的 result
        bean.setId(2);
        bean.setAge(2);
        bean.setName("2");
    }
}
