package com.test;

import com.test.base.Graph;
import com.test.base.Solution;

/**
 * DFS:递归方式 
 * .指定点开始搜索
 * @author YLine
 *
 * 2019年2月22日 下午3:52:51
 */
public class SolutionDFS implements Solution
{
    private int startIndex = 0;
    
    @Override
    public Object[] traverse(Graph graph)
    {
        int size = graph.getSize();
        Object[] objArray = new Object[size];
        
        dfs(graph, objArray, startIndex, 0);
        
        return objArray;
    }
    
    public void setStartIndex(int startIndex)
    {
        if (startIndex >= 0)
        {
            this.startIndex = startIndex;
        }
    }
    
    /**
     * @param index 开始位置
     * @param deep 遍历深度
     */
    private void dfs(Graph graphs, Object[] objArray, int index, int deep)
    {
        if (graphs.isVisited(index))
        {
            return;
        }
        
        Object obj = graphs.getValue(index);
        objArray[deep] = obj;
        deep++;
        
        for (int next : graphs.getNextArray(index))
        {
            dfs(graphs, objArray, next, deep);
        }
    }
}
