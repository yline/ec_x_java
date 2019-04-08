package com.test;

import com.test.multi.ac.AcRobot;
import com.test.multi.trie.Trie;

import junit.framework.TestCase;

/**
 * 多模式，字符串匹配
 * 多模式：在多个模式串和一个主串之间做匹配
 * @author YLine
 *
 * 2019年4月8日 下午5:17:23
 */
public class MultiSample extends TestCase
{
    @Override
    protected void setUp()
        throws Exception
    {
        super.setUp();
    }
    
    public void testTrie()
    {
        System.out.println("-------------testTrie--------------");
        
        Trie trie = new Trie();
        trie.insert("how");
        trie.insert("hi");
        trie.insert("her");
        trie.insert("hello");
        trie.insert("so");
        trie.insert("see");
        
        assertEquals(false, trie.find(""));
        assertEquals(false, trie.find("h"));
        assertEquals(false, trie.find("ho"));
        assertEquals(false, trie.find("hio"));
        assertEquals(false, trie.find("hoq"));
        
        assertEquals(true, trie.find("how"));
        assertEquals(true, trie.find("hi"));
        assertEquals(true, trie.find("her"));
        assertEquals(true, trie.find("hello"));
        assertEquals(true, trie.find("so"));
        assertEquals(true, trie.find("see"));
    }
    
    public void testAc()
    {
        System.out.println("-------------testAc--------------");
        
        // 构建，暂时不做删除
        AcRobot robot = new AcRobot();
        robot.insert("c");
        robot.insert("bc");
        robot.insert("bcd");
        robot.insert("abcd");
        
        // 查找对应的值
        robot.find("adfdsjfkdasjfkldsjal;fjdsla");
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        super.tearDown();
    }
}
