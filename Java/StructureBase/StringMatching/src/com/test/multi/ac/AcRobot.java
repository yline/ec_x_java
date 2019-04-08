package com.test.multi.ac;

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
        temp.setFlag(true);
        
        // 处理failed指针
    }
    
    /**
     * 在主串中，找到所有的模式串的，位置以及对应的模式串(不管嵌套，即：一旦满足，则直接下一个开始查询)
     * @param str
     * @return
     */
    public boolean find(String str)
    {
        AcNode temp = root;
        for (int i = 0; i < str.length(); i++)
        {
            temp = temp.find(str.charAt(i));
            if (null == temp)
            {
                return false;
            }
        }
        return temp.isEnd;
    }
}
