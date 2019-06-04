package com.test;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two numbers arr1 and arr2 in base -2, return the result of adding them together.
 * 
 * 给两个数组，它的位数，表示（-2）^(length-1-index)，返回，两个数组的和。并且表达方式相同
 * 
 * Each number is given in array format:  as an array of 0s and 1s, 
 * from most significant bit to least significant bit.  
 * 
 * 案例：
 * For example, arr = [1,1,0,1] represents the number (-2)^3 + (-2)^2 + (-2)^0 = -3.  
 * A number arr in array format is also guaranteed to have no leading zeros: either arr == [0] or arr[0] == 1.
 * arr = [1, 1, 0, 1]，代表 arr = (-2)^3 + (-2)^2 + (-2)^0 = -3
 * 
 * Return the result of adding arr1 and arr2 in the same format: as an array of 0s and 1s with no leading zeros.
 * 返回，arr1 + arr2的结果，并且还是用数组表示
 * 
 * @author YLine
 *
 * 2019年6月4日 上午7:16:39
 */
public class SolutionA
{
    public int[] addNegabinary(int[] arr1, int[] arr2)
    {
        int maxLength = 2 + (Math.max(arr1.length, arr2.length));
        List<Integer> cacheList = new ArrayList<>(maxLength); // 避免多次扩容，减少内存损耗
        
        // 将两个值，颠倒，可以减少工作量
        reverse(arr1);
        reverse(arr2);
        
        // 添加求和
        if (arr1.length >= arr2.length)
        {
            add(arr1, arr2, cacheList);
        }
        else
        {
            add(arr2, arr1, cacheList);
        }
        
        // 得到结果值
        int[] resultArray = new int[cacheList.size()];
        for (int i = 0; i < resultArray.length; i++)
        {
            resultArray[i] = cacheList.get(i);
        }
        return resultArray;
    }
    
    private void reverse(int[] array)
    {
        int left = 0, right = array.length - 1;
        int temp;
        while (left < right)
        {
            temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            
            left++;
            right--;
        }
    }
    
    /**
     * 将两个值，添加进去
     * @param arrA 较长的数组
     * @param arrB 较短的数组
     * @param result 结果
     */
    private void add(int[] arrA, int[] arrB, List<Integer> result)
    {
        int index = 0;
        boolean isLast = false; // 之前是否有进位
        while (index < arrB.length)
        {
            // 直接8种情况遍历就完事了
            if (!isLast)
            {
                // 没有进位
                if (arrA[index] == 0)
                {
                    if (arrB[index] == 0)
                    {
                        result.add(0);
                    }
                    else
                    {
                        result.add(1);
                    }
                }
                else
                {
                    if (arrB[index] == 0)
                    {
                        result.add(1);
                    }
                    else
                    {
                        result.add(0);
                        isLast = true;
                    }
                }
            }
            else
            {
                if (arrA[index] == 0)
                {
                    if (arrB[index] == 0)
                    {
                        
                    }
                    else
                    {
                        
                    }
                }
                else
                {
                    if (arrB[index] == 0)
                    {
                        
                    }
                    else
                    {
                        
                    }
                }
            }
        }
    }
}
