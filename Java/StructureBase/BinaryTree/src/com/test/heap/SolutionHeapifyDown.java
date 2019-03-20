package com.test.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * .堆化，从上往下；以删除为例
 * @author YLine
 *
 * 2019年3月19日 下午7:44:24
 */
public class SolutionHeapifyDown
{
    /**
     * .创建一个,测试数据
     * @return 数组，为了方便拓展，使用List
     */
    public List<Integer> buildTestSource()
    {
        List<Integer> dataList = new ArrayList<>();
        dataList.add(null); // 首个空
        dataList.addAll(Arrays.asList(33));
        dataList.addAll(Arrays.asList(17, 21));
        dataList.addAll(Arrays.asList(16, 13, 15, 9));
        dataList.addAll(Arrays.asList(5, 6, 7, 8, 1, 2));
        return dataList;
    }
    
    public void removeTop(List<Integer> dataList)
    {
        // 将最后一个和第一个交换；并且删除最后一个[删除最大的值]
        int lastValue = dataList.get(dataList.size() - 1);
        dataList.remove(dataList.size() - 1);
        dataList.set(1, lastValue);
        
        // 从上至下堆化
        int maxIndex = (dataList.size() - 1) / 2; // 最后一个index
        boolean isOdd = (dataList.size() & 0x01) == 1; // 是否是奇数
        int preIndex = 1;
        while (preIndex <= maxIndex) // 非叶子节点
        {
            if (isOdd && preIndex == maxIndex) // 一个子节点
            {
                if (dataList.get(preIndex) < dataList.get(preIndex * 2))
                {
                    swap(dataList, preIndex, preIndex * 2);
                    preIndex *= 2;
                }
                else
                {
                    break;
                }
            }
            else // 两个子节点
            {
                if (dataList.get(preIndex) < dataList.get(preIndex * 2) || dataList.get(preIndex) < dataList.get(
                    preIndex * 2 + 1))
                {
                    int exchangeIndex = (dataList.get(preIndex * 2) > dataList.get(preIndex * 2 + 1) ? preIndex * 2
                        : preIndex * 2 + 1);
                    swap(dataList, preIndex, exchangeIndex);
                    preIndex = exchangeIndex;
                }
                else
                {
                    break;
                }
            }
        }
    }
    
    private void swap(List<Integer> dataList, int pre, int last)
    {
        if (pre != last)
        {
            int temp = dataList.get(pre);
            dataList.set(pre, dataList.get(last));
            dataList.set(last, temp);
        }
    }
}
