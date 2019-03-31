package com.test.single.bm;

/**
 * 好后缀规则 + 坏字符规则
 * @author YLine
 *
 * 2019年3月30日 下午8:03:41
 */
public class BMMerge
{
    /**
     * 坏字符，优先；
     * 若坏字符，不合适，则，好后缀规则
     * @param mainStr 主串
     * @param patternStr 模式串
     * @return -1 if 不匹配
     */
    public static int mergeBm(String mainStr, String patternStr)
    {
        // 好后缀，规则，badIndex - 移动的位置，映射关系
        int[] suffixArray = BMGoodSuffix.getNextArray(patternStr.toCharArray());
        
        // 坏字符，规则
        int mainIndex = 0;
        while (mainIndex < mainStr.length())
        {
            // 坏字符位置
            int badIndex = -1;
            for (int i = patternStr.length() - 1; i >= 0; i--)
            {
                if (patternStr.charAt(i) != mainStr.charAt(mainIndex + i))
                {
                    badIndex = i;
                    break;
                }
            }
        }
        
        return -1;
    }
}
