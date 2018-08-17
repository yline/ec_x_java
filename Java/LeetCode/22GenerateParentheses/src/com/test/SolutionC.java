package com.test;

import java.util.ArrayList;
import java.util.List;

import com.test.base.Solution;

public class SolutionC implements Solution
{
    
    @Override
    public List<String> generateParenthesis(int n)
    {
        List<DataNode> result = new ArrayList<>();
        result.add(new DataNode(1, 0, "("));
        
        for (int i = 1; i < 2 * n; i++)
        {
            increase(result, n);
        }
        
        return dataNode2String(result);
    }
    
    private void increase(List<DataNode> result, int n)
    {
        List<DataNode> increaseList = new ArrayList<>();
        for (DataNode dataNode : result)
        {
            if (dataNode.left == dataNode.right) // 如果左侧和右侧相同，只能添加左侧
            {
                dataNode.increaseLeft();
            }
            else if (dataNode.left == n) // 如果左侧已经满了，只能添加右侧
            {
                dataNode.increaseRight();
            }
            else // 左侧和右侧都需要添加
            {
                DataNode rightNode = dataNode.clone();
                rightNode.increaseLeft();
                increaseList.add(rightNode);
                
                dataNode.increaseRight();
            }
        }
        result.addAll(increaseList);
    }
    
    private static class DataNode
    {
        private int left = 0;
        
        private int right = 0;
        
        private final StringBuilder stringBuilder;
        
        private DataNode()
        {
            this.stringBuilder = new StringBuilder();
        }
        
        private DataNode(int left, int right, String str)
        {
            this.left = left;
            this.right = right;
            this.stringBuilder = new StringBuilder(str);
        }
        
        public void increaseLeft()
        {
            left++;
            stringBuilder.append('(');
        }
        
        public void increaseRight()
        {
            right++;
            stringBuilder.append(')');
        }
        
        @Override
        protected DataNode clone()
        {
            return new DataNode(left, right, stringBuilder.toString());
        }
        
        @Override
        public String toString()
        {
            return stringBuilder.toString();
        }
    }
    
    private List<String> dataNode2String(List<DataNode> data)
    {
        List<String> result = new ArrayList<>();
        for (DataNode dataNode : data)
        {
            result.add(dataNode.toString());
        }
        return result;
    }
}
