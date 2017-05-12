package com.test;

public class Solution
{
    /**
     * 全排列 ~ 字典排序法(相当于找出下一个较大数)
     * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
     * 
     * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
     * 
     * The replacement must be in-place, do not allocate extra memory.
     * 
     * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
     * 
     * 1,2,3 → 1,3,2
     * 3,2,1 → 1,2,3
     * 1,1,5 → 1,5,1
     * 
     * @param nums
     */
    public void nextPermutation(int[] nums)
    {
        int n = nums.length;
        if (n < 2)
        {
            return;
        }
        
        int index = n - 1;
        while (index > 0)
        {
            if (nums[index - 1] < nums[index])
            {
                break;
            }
            index--;
        }
        
        if (index == 0)
        {
            reverseSort(nums, 0, n - 1);
            return;
        }
        else
        {
            int val = nums[index - 1];
            int j = n - 1;
            while (j >= index)
            {
                if (nums[j] > val)
                {
                    break;
                }
                j--;
            }
            
            swap(nums, j, index - 1);
            reverseSort(nums, index, n - 1);
            return;
        }
    }
    
    public void reverseSort(int[] num, int start, int end)
    {
        if (start > end)
            return;
        for (int i = start; i <= (end + start) / 2; i++)
            swap(num, i, start + end - i);
    }
    
    /**
     * 交换
     * @param str 数组
     * @param i 交换编号
     * @param j 交换编号
     */
    private void swap(int[] str, int i, int j)
    {
        if (i == j)
        {
            return;
        }
        
        int temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }
    
    /**
     * 全排列
     * @param str
     * @param st
     * @param len
     */
    public void arrange(String[] str, int st, int len)
    {
        if (st == len - 1)
        {
            for (int i = 0; i < len; i++)
            {
                System.out.print(str[i] + "  ");
            }
            System.out.println();
        }
        else
        {
            for (int i = st; i < len; i++)
            {
                if (isEqual(str, st, i))
                {
                    break;
                }
                
                swap(str, st, i);
                arrange(str, st + 1, len); // 只有当 st == length - 2; 的时候,才不会继续进来
                swap(str, st, i); // 还原队列
            }
        }
    }
    
    /**
     * 交换
     * @param str 数组
     * @param i 交换编号
     * @param j 交换编号
     */
    private void swap(String[] str, int i, int j)
    {
        if (i == j)
        {
            return;
        }
        
        String temp = new String();
        temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }
    
    /**
     * 判断是否相等
     * @param str 数组
     * @param s 开始编号
     * @param e 交换编号
     */
    private boolean isEqual(String[] str, int s, int e)
    {
        for (int j = s; j < e; j++)
        {
            if (str[j] == str[e])
            {
                return true;
            }
        }
        return false;
    }
}
