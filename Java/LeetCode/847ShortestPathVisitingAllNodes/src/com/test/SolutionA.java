package com.test;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * An undirected, connected graph of N nodes (labeled 0, 1, 2, ..., N-1) is given as graph.
 * graph.length = N, and j != i is in the list graph[i] exactly once,
 * if and only if nodes i and j are connected.
 * 
 * Return the length of the shortest path that visits every node.
 * You may start and stop at any node, you may revisit nodes multiple times, and you may reuse edges.
 * 
 * Example 1:
 * Input: [[1,2,3],[0],[0],[0]]
 * Output: 4
 * Explanation: One possible path is [1,0,2,0,3]
 * 
 * Example 2:
 * Input: [[1],[0,2,4],[1,3,4],[2],[1,2]]
 * Output: 4
 * Explanation: One possible path is [0,1,4,2,3]
 * 
 * Note:
 * 1 <= graph.length <= 12
 * 0 <= graph[i].length < graph.length
 * 
 * @author YLine
 *
 * 2019年9月10日 下午5:20:37
 */
public class SolutionA
{
    public int shortestPathLength(int[][] graph)
    {
        VisitNode node = new VisitNode(graph.length);
        return 0;
    }
    
    private void dfs(int[][] graph, int index)
    {
        
    }
    
    private static class VisitNode
    {
        private final int length;
        
        private int oneSize; // 大于1，的个数
        
        private int[] visitArray;
        
        private ArrayDeque<Integer> queue;
        
        private VisitNode(int length)
        {
            this.visitArray = new int[length];
            Arrays.fill(visitArray, 0);
            
            this.oneSize = 0;
            this.length = length;
            this.queue = new ArrayDeque<>();
        }
        
        private boolean addLast(int index)
        {
            if (visitArray[index] == 0)
            {
                visitArray[index] = 1;
                oneSize++;
            }
            else
            {
                visitArray[index]++;
            }
            
            queue.addLast(index);
            return oneSize == length;
        }
        
        private void removeLast()
        {
            if (!queue.isEmpty())
            {
                int index = queue.pollLast();
                visitArray[index]--;
            }
        }
        
        private boolean isExist(int index)
        {
            return visitArray[index] != 0;
        }
    }
}
