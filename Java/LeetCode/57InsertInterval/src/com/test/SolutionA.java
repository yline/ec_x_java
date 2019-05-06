package com.test;

import java.util.Arrays;

import org.junit.Assert;

import com.test.base.Solution;

/**
 * log(n)
 * 
 * 典型的二分法；
 * 1，利用最小值，从所有的最大值中，找到比他小，且最近的【二分法】
 * 2，利用最大值，从上一个找到的起点到终点中，找到最小值比他大，且最近的【二分法】
 * 
 * 3，确定跳过的个数，就可以确定长度，然后搬砖就可以了
 * 
 * @author YLine
 *
 * 2019年5月6日 上午9:17:42
 */
public class SolutionA implements Solution
{
    /**
     * 测试子方法
     */
    public static void testMethod()
    {
        SolutionA solution = new SolutionA();
        /*// 左侧开头，所有可能
        assertMethod(solution, new int[] {-1, 0}, new int[] {-1, -1}); // +1
        assertMethod(solution, new int[] {-1, 1}, new int[] {-1, -1}); // 0
        assertMethod(solution, new int[] {-1, 2}, new int[] {-1, 0}); // 0
        assertMethod(solution, new int[] {-1, 3}, new int[] {-1, 0}); // -1
        assertMethod(solution, new int[] {-1, 4}, new int[] {-1, 1}); // -1
        assertMethod(solution, new int[] {-1, 19}, new int[] {-1, 3}); // -3
        
        // 中间开头，所有可能
        assertMethod(solution, new int[] {5, 6}, new int[] {1, 1}); // +1
        assertMethod(solution, new int[] {5, 8}, new int[] {1, 1});
        assertMethod(solution, new int[] {5, 10}, new int[] {1, 2});
        assertMethod(solution, new int[] {5, 13}, new int[] {1, 2});
        assertMethod(solution, new int[] {5, 15}, new int[] {1, 2});
        assertMethod(solution, new int[] {5, 18}, new int[] {1, 3});
        assertMethod(solution, new int[] {5, 19}, new int[] {1, 3});
        
        // 中间开头，所有可能
        assertMethod(solution, new int[] {4, 6}, new int[] {1, 1}); // +1
        assertMethod(solution, new int[] {4, 8}, new int[] {1, 1});
        assertMethod(solution, new int[] {4, 10}, new int[] {1, 2});
        assertMethod(solution, new int[] {4, 13}, new int[] {1, 2});
        assertMethod(solution, new int[] {4, 15}, new int[] {1, 2});
        assertMethod(solution, new int[] {4, 18}, new int[] {1, 3});
        assertMethod(solution, new int[] {4, 19}, new int[] {1, 3});
        
        // 右侧开头
        assertMethod(solution, new int[] {19, 200}, new int[] {3, 3});*/
        
        // 左侧开头，所有可能
        assertMethod(solution, new int[] {-1, 0}, new int[] {-1, -1}); // +1
        assertMethod(solution, new int[] {-1, 1}, new int[] {-1, 0}); // 0
        assertMethod(solution, new int[] {-1, 2}, new int[] {-1, 0}); // 0
        assertMethod(solution, new int[] {-1, 3}, new int[] {-1, 1}); // -1
        assertMethod(solution, new int[] {-1, 4}, new int[] {-1, 1}); // -1
        assertMethod(solution, new int[] {-1, 19}, new int[] {-1, 3}); // -3
        
        // 中间开头，所有可能
        assertMethod(solution, new int[] {5, 6}, new int[] {1, 1}); // +1
        assertMethod(solution, new int[] {5, 8}, new int[] {1, 2});
        assertMethod(solution, new int[] {5, 10}, new int[] {1, 2});
        assertMethod(solution, new int[] {5, 13}, new int[] {1, 2});
        assertMethod(solution, new int[] {5, 15}, new int[] {1, 3});
        assertMethod(solution, new int[] {5, 18}, new int[] {1, 3});
        assertMethod(solution, new int[] {5, 19}, new int[] {1, 3});
        
        // 中间开头，所有可能
        assertMethod(solution, new int[] {4, 6}, new int[] {1, 1}); // +1
        assertMethod(solution, new int[] {4, 8}, new int[] {1, 2});
        assertMethod(solution, new int[] {4, 10}, new int[] {1, 2});
        assertMethod(solution, new int[] {4, 13}, new int[] {1, 2});
        assertMethod(solution, new int[] {4, 15}, new int[] {1, 3});
        assertMethod(solution, new int[] {4, 18}, new int[] {1, 3});
        assertMethod(solution, new int[] {4, 19}, new int[] {1, 3});
        
        // 右侧开头
        assertMethod(solution, new int[] {19, 200}, new int[] {3, 3});
    }
    
    private static void assertMethod(SolutionA solution, int[] newInterval, int[] expect)
    {
        int[][] intervals = new int[][] {{1, 2}, {3, 4}, {8, 10}, {15, 18}};
        int startIndex = solution.findIndex(intervals, 0, intervals.length - 1, newInterval[0], true);
        int endIndex = solution.findIndex(intervals, 0, intervals.length - 1, newInterval[1], true);
        
        Assert.assertEquals(startIndex, expect[0]);
        Assert.assertEquals(endIndex, expect[1]);
    }
    
    @Override
    public int[][] insert(int[][] intervals, int[] newInterval)
    {
        if (intervals.length == 0)
        {
            int[][] result = new int[1][];
            result[0] = newInterval;
            return result;
        }
        
        int start = findIndex(intervals, 0, intervals.length - 1, newInterval[0], true);
        int end = findIndex(intervals, 0, intervals.length - 1, newInterval[1], true);
        
        boolean isStartInner = (start != -1 && newInterval[0] <= intervals[start][1]);
        boolean isEndInner = (end != -1 && newInterval[1] <= intervals[end][1]);
        
        int diff;
        if (isStartInner)
        {
            diff = (end - start);
        }
        else
        {
            diff = (end - start - 1);
        }
        
        int[][] result = new int[intervals.length - diff][2];
        
        // 第一部分赋值（长度 = startInner ? start : start + 1）
        int firstEnd = isStartInner ? start : start + 1;
        for (int i = 0; i < firstEnd; i++)
        {
            result[i] = intervals[i];
        }
        
        // 交合部分赋值，(长度 = 1)
        int min = isStartInner ? intervals[start][0] : newInterval[0];
        int max = isEndInner ? intervals[end][1] : newInterval[1];
        result[firstEnd] = new int[] {min, max};
        
        // 后续部分赋值(长度 = length - end - 1)
        for (int i = end + 1; i < intervals.length; i++)
        {
            result[i - diff] = intervals[i];
        }
        
        StringBuilder sBuilder = new StringBuilder();
        for (int i = 0; i < result.length; i++)
        {
            sBuilder.append(Arrays.toString(result[i]));
            sBuilder.append(',');
        }
        System.out.println(sBuilder.toString() + ", isStartInner = " + isStartInner + ", endInner = " + isEndInner);
        
        return result;
    }
    
    private int findIndex(int[][] intervals, int from, int to, int val, boolean side)
    {
        int index = side ? 0 : 1;
        int length = to - from;
        
        // 最左侧
        if (val < intervals[from][index])
        {
            return -1;
        }
        
        // 最右侧
        if (val >= intervals[to][index])
        {
            return to;
        }
        
        int left = from, right = to;
        while (left <= right)
        {
            int mid = (left + right) >> 1;
            if (val < intervals[mid][index])
            {
                right = mid - 1;
            }
            else
            {
                if (mid == length || val < intervals[mid + 1][index])
                {
                    return mid;
                }
                else
                {
                    left = mid + 1;
                }
            }
        }
        
        // 理论上不会出现
        return -2;
    }
    
    /*@Override
    public int[][] insert(int[][] intervals, int[] newInterval)
    {
        // 最左侧
        if (newInterval[1] < intervals[0][0])
        {
            int[][] result = new int[intervals.length + 1][];
            result[0] = newInterval;
            for (int i = 0; i < intervals.length; i++)
            {
                result[i + 1] = intervals[i];
            }
            return result;
        }
        
        // 最右侧
        if (newInterval[0] > intervals[intervals.length - 1][1])
        {
            int[][] result = new int[intervals.length + 1][];
            for (int i = 0; i < intervals.length; i++)
            {
                result[i] = intervals[i];
            }
            result[intervals.length] = newInterval;
            return result;
        }
        
        int startIndex = findMinFormMax(intervals, 0, newInterval[0]);
        int endIndex = findMaxFromMin(intervals, startIndex + 1, newInterval[1]);
        
    
        // 中间状态
        int length = intervals.length;
        int fromValue;
        if (newInterval[0] < intervals[startIndex + 1][0])
        {
            // 不重叠
            fromValue = newInterval[0];
        }
        else
        {
            // 重叠
            fromValue = intervals[startIndex + 1][0];
        }
    
        return null;
    }*/
    
    /*
    *//**
         * 利用最小值，从所有的最大值中，找到比他小，且最近的【二分法】
         * 如果，它是最小的，则返回-1
         * 如果，它是最大的，则返回最后一个，length-1
         * 
         * @param intervals 有序无重叠的，数组
         * @param min 最小值
         * @return 找到的位置对应的index
         */
    /*
    private int findMinFormMax(int[][] intervals, int start, int min)
    {
     // 比最左侧的最大值，小
     if (min <= intervals[0][1])
     {
         return -1;
     }
     
     // 比最右侧的最大值，大
     if (min > intervals[intervals.length - 1][1])
     {
         return intervals.length - 1;
     }
     
     // 正常二分法
     int left = start, right = intervals.length - 1;
     while (left <= right)
     {
         int mid = (left + right) >> 1;
         if (intervals[mid][1] < min)
         {
             left = mid + 1;
         }
         else
         {
             // 找到最近的，则返回
             if (mid == 0 || intervals[mid - 1][1] < min)
             {
                 return mid - 1;
             }
             else // 否则，继续
             {
                 right = mid - 1;
             }
         }
     }
     
     // 不会出现这种情况
     return -2;
    }
    
    *//**
         * 利用最大值，从上一个找到的起点到终点中，找到最小值比他大，且最近的【二分法】
         * @param intervals 有序无重叠的，数组
         * @param max 最大值
         * @return 找到的位置对应的index
         *//*
              private int findMaxFromMin(int[][] intervals, int start, int max)
              {
               // 异常start参数
               if (start == intervals.length)
               {
                   return intervals.length;
               }
               
               // 比最左侧的最小值，小
               if (max < intervals[start][0])
               {
                   return start;
               }
               
               // 比最右侧的最大值，大
               if (max >= intervals[intervals.length - 1][0])
               {
                   return intervals.length;
               }
               
               // 正常二分法
               int left = start, right = intervals.length - 1;
               while (left <= right)
               {
                   int mid = (left + right) >> 1;
                   if (intervals[mid][0] > max)
                   {
                       right = mid - 1;
                   }
                   else
                   {
                       if (mid + 1 == intervals.length || intervals[mid + 1][0] > max)
                       {
                           return mid + 1;
                       }
                       else
                       {
                           left = mid + 1;
                       }
                   }
               }
               
               // 不存在这种情况
               return -2;
              }*/
}
