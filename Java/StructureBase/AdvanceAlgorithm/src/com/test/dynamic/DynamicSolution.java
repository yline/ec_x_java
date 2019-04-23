package com.test.dynamic;

/**
 * 动态规划的接口类
 * 
 * 1，先实现回溯
 * 2，再优化着，实现动态规划
 * 
 * @author YLine
 *
 * 2019年4月23日 上午7:56:33
 */
public interface DynamicSolution
{
    /**
     * 回溯实现
     * @param objArray 所有数据
     */
    public void backtrack(Object... objArray);
    
    /**
     * 动态规划实现
     * @param objArray 所有数据
     */
    public void dynamic(Object... objArray);
}
