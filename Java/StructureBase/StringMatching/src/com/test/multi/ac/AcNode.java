package com.test.multi.ac;

import java.util.HashMap;

/**
 * Trie 树结构，为Ac自动机，新增failed指针
 * 
 * 目标问题：在一篇文章(主串)中，查找多个敏感词(模式串)，在文章中，出现的所有位置
 * 
 * @author YLine
 *
 * 2019年4月8日 下午6:10:59
 */
public class AcNode
{
    // 内容
    public char value;
    
    // 下一个内容，以及对应的对象
    public HashMap<Character, AcNode> next;
    
    // 到达该节点，是否，为结束
    public boolean isEnd;
    
    // 如果，该节点匹配失败，则自动匹配到其它节点。如果没有，则为null, 上层处理为root
    public AcNode failed;
    
    public AcNode(char value)
    {
        this.value = value;
        this.next = new HashMap<>();
        this.isEnd = false;
        this.failed = null;
    }
    
    /**
     * 插入一个内容
     * @param key 下一个字符
     * @return 下一个字符，对应的节点
     */
    public AcNode insert(char key)
    {
        if (next.containsKey(key))
        {
            return next.get(key);
        }
        else
        {
            AcNode trieNode = new AcNode(key);
            next.put(key, trieNode);
            return trieNode;
        }
    }
    
    /**
     * 找到 下一个字符
     * @param key 下一个字符
     * @return 下一个字符，对应的节点。null if 不存在
     */
    public AcNode find(char key)
    {
        if (next.containsKey(key))
        {
            return next.get(key);
        }
        return null;
    }
    
    public void setFlag(boolean isEnd)
    {
        this.isEnd = isEnd;
    }
}
