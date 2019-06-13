package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The set [1,2,3,...,n] contains a total of n! unique permutations.
 * 1到n，有n!个数据
 * 
 * 按优先排序
 * By listing and labeling all of the permutations in order, we get the following sequence for n = 3:
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 
 * Given n and k, return the kth permutation sequence.
 * @author YLine
 *
 * 2019年6月13日 下午10:57:04
 */
public class SolutionA
{
    public String getPermutation(int n, int k)
    {
        // 先弄一个缓存的大小
        int[] valueArray = new int[n]; // valueArray[i] = (i+1)!
        valueArray[0] = 1;
        for (int i = 1; i < n; i++)
        {
            valueArray[i] = valueArray[i - 1] * (i + 1);
        }
        
        System.out.println(Arrays.toString(valueArray));
        
        // 结果数据
        List<Integer> cacheList = new ArrayList<>(n);
        for (int i = 1; i <= n; i++)
        {
            cacheList.add(i);
        }
        
        System.out.println(Arrays.toString(cacheList.toArray()));
        
        StringBuilder sBuilder = new StringBuilder();
        // 直接去找结果
        int temp = k - 1;
        for (int i = n; i > 0; i--)
        {
            int index = temp / valueArray[i - 1];
            
            System.out.println("index = " + index + ", cache = " + Arrays.toString(cacheList.toArray()));
            
            sBuilder.append(cacheList.get(index));
            cacheList.remove(index);
            temp %= valueArray[i - 1];
        }
        
        System.out.println(sBuilder.toString());
        
        return sBuilder.toString();
    }
}
