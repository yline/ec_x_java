package com.pacakge;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * 类名的诠释
 * @author YLine
 *
 * 2016年12月16日 下午8:34:09
 */
public class Sample
{
    
    public static void main(String[] args)
    {
        /*
        int i1 = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        
        int j5 = 0;
        
        System.out.println(i1++);
        System.out.println(++i2);
        System.out.println(i3--);
        System.out.println(--i4);
        
        j5 = i1++;
        System.out.println(j5);
        
        
        boolean A = false, B = false, C = true;
        boolean result = !A && !(B && !C);
        System.out.println("result = " + result);
        */
        Solution solution = new Solution();
        
        solution.testIf();
        solution.testFor1();
        solution.testFor2();
        solution.testWhile();
    }
    
    /**
     * 方法 作用 
     * @param str 传入 参数
     * @return 返回 参数
     * @throws MalformedURLException 抛出的异常
     */
    public String method(String str)
        throws MalformedURLException
    {
        int i = Math.max(1, 2); // java.lang.Math
        
        System.out.println("i = " + i);
        
        URL url = new URL("http://www.baidu.com");
        
        int k = 0xaa;
        int j = 01;
        
        return "";
    }
}
