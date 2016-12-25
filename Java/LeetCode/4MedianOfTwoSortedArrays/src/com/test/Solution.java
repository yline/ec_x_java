package com.test;

import java.util.Arrays;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * 
 * Example 1:
nums1 = [1, 3]
nums2 = [2]

The median is 2.0
 * 
 * 
 * Example 2:
nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5
 * 
 * @author YLine
 *
 * 2016年12月25日 下午2:18:10
 */
public class Solution
{
    /**
     * 时间复杂度 不符合要求
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays1(int[] nums1, int[] nums2)
    {
        int[] num3 = new int[nums1.length + nums2.length];
        
        int i = 0, j = 0;
        while (i < nums1.length || j < nums2.length)
        {
            if (i == nums1.length)
            {
                num3[i + j] = nums2[j];
                j++;
            }
            else if (j == nums2.length)
            {
                num3[i + j] = nums1[i];
                i++;
            }
            else if (nums1[i] < nums2[j])
            {
                num3[i + j] = nums1[i];
                i++;
            }
            else
            {
                num3[i + j] = nums2[j];
                j++;
            }
        }
        
        System.out.println(Arrays.toString(num3));
        
        if (num3.length % 2 == 0)
        {
            return (num3[num3.length / 2] + num3[(num3.length / 2) - 1]) * 1.0 / 2;
        }
        else
        {
            return num3[num3.length / 2];
        }
    }
    
    /**
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2)
    {
        if (null == nums1)
        {
            nums1 = new int[0];
        }
        
        if (nums2 == null)
        {
            nums2 = new int[0];
        }
        
        int length1 = nums1.length;
        int length2 = nums2.length;
        
        if (length1 < length2)
        {
            // 确保第一个数组比第二个数组长度大
            return findMedianSortedArrays(nums2, nums1);
        }
        
        // 如果长度小的数组长度为0，就返回前一个数组的中位数
        if (length2 == 0)
        {
            return (nums1[(length1 - 1) / 2] + nums1[length1 / 2]) / 2.0;
        }
        
        int lo = 0;
        int hi = length2 * 2;
        int mid1;
        int mid2;
        double left1;
        double left2;
        double right1;
        double right2;
        
        while (lo <= hi)
        {
            mid2 = (lo + hi) / 2;
            mid1 = length1 + length2 - mid2;
            
            left1 = (mid1 == 0) ? Integer.MIN_VALUE : nums1[(mid1 - 1) / 2];
            left2 = (mid2 == 0) ? Integer.MIN_VALUE : nums2[(mid2 - 1) / 2];
            
            right1 = (mid1 == length1 * 2) ? Integer.MAX_VALUE : nums1[mid1 / 2];
            right2 = (mid2 == length2 * 2) ? Integer.MAX_VALUE : nums2[mid2 / 2];
            
            if (left1 > right2)
            {
                lo = mid2 + 1;
            }
            else if (left2 > right1)
            {
                hi = mid2 - 1;
            }
            else
            {
                return (Math.max(left1, left2) + Math.min(right1, right2)) / 2;
            }
        }
        
        return -1;
    }
}
