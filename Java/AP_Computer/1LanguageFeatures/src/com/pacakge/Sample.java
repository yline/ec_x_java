package com.pacakge;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

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
        int i1 = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        
        System.out.println(i1++);
        System.out.println(++i2);
        System.out.println(i3--);
        System.out.println(--i4);
        
        Scanner scanner = new Scanner(System.in);
        System.out.println(scanner.next());
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
