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
