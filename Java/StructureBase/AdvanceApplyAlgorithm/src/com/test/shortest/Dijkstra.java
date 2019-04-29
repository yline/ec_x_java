package com.test.shortest;

/**
 * Dijkstra 算法 -- 单源最短路径算法（可以看做是一个动态规划）
 * 
 * 参考：https://time.geekbang.org/column/article/76468
 * 
 * @author YLine
 *
 * 2019年4月28日 下午5:22:11
 */
public class Dijkstra
{
    // todo 需要实现一个小顶堆
    public static void shortest(PathGraph graph, int start, int end)
    {
        
    }
    
    public static PathGraph createGraph()
    {
        PathGraph graph = new PathGraph();
        
        graph.addVertex(0);
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        graph.addVertex(5);
        
        graph.addEdge(0, 1, 10);
        graph.addEdge(0, 4, 15);
        
        graph.addEdge(1, 2, 15);
        graph.addEdge(1, 3, 2);
        
        graph.addEdge(2, 5, 5);
        
        graph.addEdge(3, 2, 1);
        graph.addEdge(3, 5, 12);
        
        graph.addEdge(4, 5, 10);
        
        return graph;
    }
}
