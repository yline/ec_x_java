package com.test;

import java.util.ArrayDeque;
import java.util.HashMap;

/**
 * Given a string S, consider all duplicated substrings: (contiguous) substrings of S that occur 2 or more times.
 * (The occurrences may overlap.)
 * 
 * Return any duplicated substring that has the longest possible length.
 * (If S does not have a duplicated substring, the answer is "".)
 * 
 * 1，构建Tree树
 * 2，放入数据
 * 3，Tree树遍历一次
 * 
 * @author YLine
 *
 * 2019年11月20日 下午5:24:25
 */
public class SolutionA
{
    public String longestDupSubstring(String S)
    {
        TreeStruct root = new TreeStruct(null, '/', 0);
        
        // 添加char，构建一个Tree树
        for (int i = 0; i < S.length(); i++)
        {
            addString(root, S, i, S.length() - 1);
        }
        
        // Tree树遍历
        ArrayDeque<TreeStruct> queue = new ArrayDeque<>();
        for (TreeStruct child : root.levelMap.values())
        {
            if (child.isOverlap)
            {
                queue.add(child);
            }
        }
        
        TreeStruct targetStruct = null;
        while (!queue.isEmpty())
        {
            TreeStruct poll = queue.pollFirst();

            // 如果，当前的层级比之前高；则赋值
            if (null == targetStruct || poll.level > targetStruct.level)
            {
                targetStruct = poll;
            }
            
            // 加入所有满足条件的子
            for (TreeStruct child : poll.levelMap.values())
            {
                if (child.isOverlap)
                {
                    queue.add(child);
                }
            }
        }
        
        // 获取结果
        if (null == targetStruct)
        {
            return "";
        }
        
        // 从下往上遍历
        StringBuilder sBuilder = new StringBuilder();
        TreeStruct temp = targetStruct;
        while (null != temp.parent)
        {
            sBuilder.append(temp.key);
            temp = temp.parent;
        }
        
        return sBuilder.reverse().toString();
    }
    
    private void addString(TreeStruct root, String S, int start, int end)
    {
        TreeStruct temp = root;
        for (int i = start; i <= end; i++)
        {
            temp = temp.addChild(S.charAt(i));
        }
    }
    
    /**
     * 它代表了一个点
     */
    public static class TreeStruct
    {
        private char key;
        
        private TreeStruct parent; // 父类
        
        private int level; // 当前的层级
        
        private boolean isOverlap; // 是否重复
        
        private HashMap<Character, TreeStruct> levelMap; // 当前层级所有的内容
        
        public TreeStruct(TreeStruct parent, char key, int level)
        {
            this.parent = parent;
            this.key = key;
            this.level = level;
            this.isOverlap = false;
        }
        
        private TreeStruct addChild(char key)
        {
            if (null == levelMap)
            {
                levelMap = new HashMap<>();
            }
            
            TreeStruct child = levelMap.get(key);
            if (null == child)
            {
                child = new TreeStruct(this, key, level + 1);
                levelMap.put(key, child);
            }
            else
            {
                isOverlap = true;
            }
            
            return child;
        }
    }
}
