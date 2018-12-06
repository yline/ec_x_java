package com.test;

import com.test.base.Node;
import com.test.base.Solution;

/**
 * 冒泡排序法
 * 1，最好情况时间复杂度
 * 
 * 2，最坏情况时间复杂度
 * 3，平均时间复杂度
 * 
 * 4，空间复杂度
 * 5，稳定性（是否改变）
 * 
 * @author YLine
 *
 * 2018年12月6日 下午10:20:50
 */
public class SolutionBubble implements Solution
{
    
    @Override
    public void sort(Node[] array)
    {
        for (int i = 0; i < array.length; i++) // 仅仅是次数
        {
            for (int j = 0; j < array.length - i - 1; j++) // 相邻两个交换
            {
                if (array[j].value > array[j + 1].value)
                {
                    Node temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
    
}
