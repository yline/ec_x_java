package com.test;

import java.util.ArrayList;
import java.util.List;

import com.test.base.Solution;

public class SolutionA implements Solution
{
    private List<DataHolder> tempList;
    
    public List<String> generateParenthesis(int n)
    {
        // 初始化第一个数据
        tempList = new ArrayList<>();
        tempList.add(new DataHolder());
        
        while (tempList.get(0).getLength() < 2 * n)
        {
            List<DataHolder> cloneTemp = new ArrayList<>(tempList);
            append(cloneTemp, n);
        }
        
        return getResult(tempList);
    }
    
    private void append(List<DataHolder> cloneTemp, int n)
    {
        tempList.clear();
        for (DataHolder dataHolder : cloneTemp)
        {
            if (dataHolder.left <= dataHolder.right)
            {
                tempList.add(dataHolder.appendLeft());
            }
            else if (dataHolder.left > dataHolder.right && dataHolder.left == n)
            {
                tempList.add(dataHolder.appendRight());
            }
            else
            {
                tempList.add(dataHolder.appendLeftClone());
                tempList.add(dataHolder.appendRight());
            }
        }
    }
    
    private List<String> getResult(List<DataHolder> temp)
    {
        List<String> result = new ArrayList<>();
        for (DataHolder dataHolder : temp)
        {
            result.add(dataHolder.getResult());
        }
        return result;
    }
    
    private class DataHolder
    {
        private StringBuffer stringBuffer;
        
        private int left;
        
        private int right;
        
        public DataHolder()
        {
            stringBuffer = new StringBuffer();
            left = 0;
            right = 0;
        }
        
        public DataHolder appendLeftClone()
        {
            DataHolder temp = new DataHolder();
            temp.stringBuffer = new StringBuffer(stringBuffer);
            temp.stringBuffer.append('(');
            temp.left = left + 1;
            temp.right = right;
            
            return temp;
        }
        
        public DataHolder appendLeft()
        {
            left++;
            stringBuffer.append('(');
            return this;
        }
        
        public DataHolder appendRight()
        {
            right++;
            stringBuffer.append(')');
            return this;
        }
        
        public int getLength()
        {
            return left + right;
        }
        
        public String getResult()
        {
            return stringBuffer.toString();
        }
    }
}
