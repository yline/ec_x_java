package com.test;

public class Solution
{
    public String convert(String s, int numRows)
    {
        StringBuffer stringBuffer = new StringBuffer();
        
        if (s == null || s.length() <= numRows || numRows == 1)
        {
            return s;
        }
        
        boolean left, right;
        
        for (int i = 0; i < numRows; i++)
        {
            for (int j = 0; j < s.length(); j++)
            {
                left = (j % (2 * numRows - 2) == i);
                right = (j % (2 * numRows - 2) == 2 * numRows - 2 - i);
                
                if (left || right)
                {
                    stringBuffer.append(s.charAt(j));
                }
            }
        }
        
        return stringBuffer.toString();
    }
    
    public String convert2(String s, int nRows)
    {
        
        if (s == null || s.length() <= nRows || nRows == 1)
        {
            return s;
        }
        
        int index = s.length();
        int rowLength = 0; // 计算行的长度，包括最后换行字符
        
        int slash = nRows - 2; // 一个斜线除去首尾所占用的行数
        
        while (index > 0)
        {
            // 竖形的一列
            index -= nRows;
            rowLength++;
            
            // 斜着的列数
            for (int i = 0; i < slash && index > 0; i++)
            {
                rowLength++;
                index--;
            }
        }
        
        char[] result = new char[nRows * rowLength]; // 保存结果的数组，最后一列用于保存换行符
        for (int i = 0; i < result.length; i++)
        { // 初始化为空格
            result[i] = ' ';
        }
        
        int curColumn = 0; // 当前处理的行数
        index = 0;
        while (index < s.length())
        {
            // 处理竖线
            for (int i = 0; i < nRows && index < s.length(); i++)
            {
                result[rowLength * i + curColumn] = s.charAt(index);
                index++;
            }
            curColumn++;
            // 处理斜线
            for (int i = nRows - 2; i > 0 && index < s.length(); i--)
            {
                result[rowLength * i + curColumn] = s.charAt(index);
                curColumn++;
                index++;
            }
        }
        
        // 对字符数组进行紧凑操作
        index = 0;
        while (index < s.length() && result[index] != ' ')
        { // 找第一个是空格的字符位置
            index++;
        }
        int next = index + 1;
        while (index < s.length())
        {
            while (next < result.length && result[next] == ' ')
            { // 找不是空格的元素
                next++;
            }
            result[index] = result[next];
            index++;
            next++;
        }
        return new String(result, 0, index);
    }
}
