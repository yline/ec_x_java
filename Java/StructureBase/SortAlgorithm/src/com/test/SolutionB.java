package com.test;

import java.util.Arrays;

public class SolutionB
{
    public static final int[] ARRAY = {5, 8, 4, 12, 32, -12, -43, 0, 9, 43, -23, 8, -4, 43, 5};
    
    public int[] sortQuick()
    {
        int[] temp = ARRAY.clone();
        Arrays.sort(temp);
        return temp;
    }
    
    /**
     * 堆排序
     */
    public int[] sortHeap()
    {
        int[] temp = ARRAY.clone();
        
        buildMaxHeap(temp);
        
        for (int i = temp.length - 1; i >= 1; i--)
        {
            exchangeElements(temp, 0, i);
            maxHeap(temp, i, 0);
        }
        
        return temp;
    }
    
    /** 创建 堆 */
    private void buildMaxHeap(int[] array)
    {
        if (array == null || array.length <= 1)
        {
            return;
        }
        
        int half = array.length / 2;
        for (int i = half; i >= 0; i--)
        {
            maxHeap(array, array.length, i);
        }
    }
    
    /** maxHeap调整堆 */
    private void maxHeap(int[] array, int heapSize, int index)
    {
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        
        int largest = index;
        if (left < heapSize && array[left] > array[index])
        {
            largest = left;
        }
        
        if (right < heapSize && array[right] > array[largest])
        {
            largest = right;
        }
        
        if (index != largest)
        {
            exchangeElements(array, index, largest);
            
            maxHeap(array, heapSize, largest);
        }
    }
    
    /** 选择项,并与第0个元素交换 */
    private void exchangeElements(int[] array, int index1, int index2)
    {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
    
    /** 并归排序 */
    public int[] sortMerge()
    {
        int[] temp = ARRAY.clone();
        
        for (int i = 1; i < temp.length; i *= 2)
        {
            passMerge(temp, i, temp.length);
        }
        
        return temp;
    }
    
    private void passMerge(int[] array, int gap, int length)
    {
        int i = 0;
        
        // 归并gap长度的两个相邻子表
        for (i = 0; i + 2 * gap - 1 < length; i = i + 2 * gap)
        {
            merge(array, i, i + gap - 1, i + 2 * gap - 1);
        }
        
        // 余下两个子表，后者长度小于gap
        if (i + gap - 1 < length)
        {
            merge(array, i, i + gap - 1, length - 1);
        }
    }
    
    private void merge(int[] array, int low, int mid, int high)
    {
        int i = low; // i是第一段序列的下标
        int j = mid + 1; // j是第二段序列的下标
        int k = 0; // k是临时存放合并序列的下标
        int[] array2 = new int[high - low + 1]; // array2是临时合并序列
        
        // 扫描第一段和第二段序列，直到有一个扫描结束
        while (i <= mid && j <= high)
        {
            // 判断第一段和第二段取出的数哪个更小，将其存入合并序列，并继续向下扫描
            if (array[i] <= array[j])
            {
                array2[k] = array[i];
                i++;
                k++;
            }
            else
            {
                array2[k] = array[j];
                j++;
                k++;
            }
        }
        
        // 若第一段序列还没扫描完，将其全部复制到合并序列
        while (i <= mid)
        {
            array2[k] = array[i];
            i++;
            k++;
        }
        
        // 若第二段序列还没扫描完，将其全部复制到合并序列
        while (j <= high)
        {
            array2[k] = array[j];
            j++;
            k++;
        }
        
        // 将合并序列复制到原始序列中
        for (k = 0, i = low; i <= high; i++, k++)
        {
            array[i] = array2[k];
        }
    }
}
