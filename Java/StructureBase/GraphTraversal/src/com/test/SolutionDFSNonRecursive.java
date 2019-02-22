package com.test;

import java.util.Stack;

import com.test.base.Graph;
import com.test.base.Solution;

/**
 * DFS:非递归方式 
 * .指定点开始搜索
 * @author YLine
 *
 * 2019年2月22日 下午4:25:32
 */
public class SolutionDFSNonRecursive implements Solution
{
    
    @Override
    public Object[] traverse(Graph graph)
    {
        int size = graph.getSize();
        Object[] objArray = new Object[size];
        
        int deep = 0;
        
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < size; i++)
        {
            if (!graph.isVisited(i))
            {
                stack.add(i);
                graph.setVisitedEnable(i);
                
                while (!stack.isEmpty())
                {
                    int topIndex = stack.pop();
                    objArray[deep] = graph.getValue(topIndex);
                    deep++;
                    
                    for (int next : graph.getNextArray(topIndex))
                    {
                        if (!graph.isVisited(next))
                        {
                            stack.add(next);
                            graph.setVisitedEnable(next);
                        }
                    }
                }
            }
        }
        
        return objArray;
    }
}
