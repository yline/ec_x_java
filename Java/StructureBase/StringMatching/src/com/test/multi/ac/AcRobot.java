package com.test.multi.ac;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Ac自动机
 * 
 * @author YLine
 *
 * 2019年4月8日 下午6:24:55
 */
public class AcRobot
{
    private AcNode root = new AcNode('/'); // 无效的，头字符
    
    /**
     * 更新Trie树
     * @param str 新增加的模式串
     */
    public void insert(String str)
    {
        // 构建树
        AcNode temp = root;
        for (int i = 0; i < str.length(); i++)
        {
            temp = temp.insert(str.charAt(i));
        }
        temp.setFlag(true, str.length());
    }
    
    /**
     * 插入或删除Trie树后，需要整体遍历一次，以重新构建failed指针
     * 操作，是层遍历做的
     */
    public void buildFailurePointer()
    {
        // 第一层
        Queue<AcNode> queue = new LinkedList<>();
        queue.add(root);
        
        // 开始逐个遍历
        while (!queue.isEmpty())
        {
            // 当前抛出的节点
            AcNode popNode = queue.remove();
            
            // 遍历抛出节点的子节点
            for (AcNode childNode : popNode.next.values())
            {
                // 上一个节点的坏指针
                AcNode topFailedNode = popNode.failed;
                while (null != topFailedNode)
                {
                    AcNode topFailedNextNode = topFailedNode.next.get(childNode.value);
                    if (null != topFailedNextNode)
                    {
                        childNode.failed = topFailedNextNode;
                        break;
                    }
                    else
                    {
                        topFailedNode = topFailedNode.failed;
                    }
                }
                
                // 没有遍历到相应的内容
                if (null == topFailedNode)
                {
                    childNode.failed = root;
                }
                
                // 添加子节点
                queue.add(childNode);
            }
        }
    }
    
    /**
     * 在主串中，找到所有的模式串的，位置以及对应的模式串(不管嵌套，即：一旦满足，则直接下一个开始查询)
     * @param str 主串
     * @return 所有匹配的模式串的位置 以及 对应的模式串
     */
    public List<AcResult> find(String str)
    {
        List<AcResult> resultList = new ArrayList<>();
        
        AcNode temp = root;
        for (int i = 0; i < str.length(); i++)
        {
            AcNode tempNext = temp.find(str.charAt(i));
            // 不是从root出发，并且下一个不是空
            while (root != temp && null != tempNext)
            {
                temp = temp.failed;
            }
            
            // 没有匹配的内容，重新从root出发
            if (null == tempNext)
            {
                temp = root;
            }
            
            // 找下一个
            while (temp != root)
            {
                if (temp.isEnd)
                {
                    resultList.add(new AcResult(str, i, temp.length));
                }
                temp = temp.failed;
            }
        }
        
        return resultList;
    }
    
    public static class AcResult
    {
        // 主串中开始的位置
        private int startIndex;
        
        // 对应的模式串的内容
        private String patternStr;
        
        public AcResult(String mainStr, int end, int length)
        {
            startIndex = end - length + 1;
            patternStr = mainStr.substring(startIndex, end);
        }

        @Override
        public String toString()
        {
            return "start = " + startIndex + ", pattern = " + patternStr;
        }
        
        public int getStartIndex()
        {
            return startIndex;
        }
        
        public void setStartIndex(int startIndex)
        {
            this.startIndex = startIndex;
        }
        
        public String getPatternStr()
        {
            return patternStr;
        }
        
        public void setPatternStr(String patternStr)
        {
            this.patternStr = patternStr;
        }
    }
}
