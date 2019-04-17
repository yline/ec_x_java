package com.test.divide;

/**
 * 有序对个数
 * 如果编程求出一组数据的有序对个数？
 * 
 * 最笨的方法：拿每个数字和他后面的数字对比，将比他大的个数记做K，然后考察一遍，最终求和。就是有序对个数
 * 
 * 优化：分治算法，将数组分为A1，A2;分别计算A1为K1，A2为K2，A1和A2之间为K3
 * 则：结果 = K1 + K2 + K3
 * 
 * 参考：https://blog.csdn.net/qq_16399991/article/details/88385128
 * 
 * @author YLine
 *
 * 2019年4月15日 上午10:46:59
 */
public class OrderedNumber
{
    // todo
    
    /**
     * 
     * @param tempArray
     * @param start
     * @param end
     * @return
     */
    private int merge(char[] array, int leftStart, int rightEnd)
    {
        
        int leftEnd = (leftStart + rightEnd) / 2;
        int rightStart = leftEnd + 1;
        
        int result = 0;
        // 遍历
        while (leftStart <= leftEnd && rightStart <= rightEnd)
        {
            if (array[leftStart] < array[rightStart])
            {
                result += (rightEnd - rightStart + 1);
                leftStart++;
                
                // 还需要做交换
            }
            else
            {
                rightStart++;
            }
        }
        
        return result;
        
        /*
        int length = Math.min(leftArray.length, rightArray.length);
        
        int result = 0;
        int leftIndex = 0, rightIndex = 0;
        while (leftIndex < leftArray.length && rightIndex < rightArray.length)
        {
            if (leftArray[leftIndex] < rightArray[rightIndex])
            {
                
            }
        }
        
        return result;*/
    }
}
