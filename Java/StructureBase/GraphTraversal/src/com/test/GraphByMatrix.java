package com.test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * http://blog.csdn.net/ochangwen/article/details/50729993
 * @author YLine
 *
 * 2016年12月25日 下午11:33:27
 */
public class GraphByMatrix
{
    public static final boolean UNDIRECTED_GRAPH = false;//无向图标志  
    
    public static final boolean DIRECTED_GRAPH = true;//有向图标志  
    
    public static final int MAX_VALUE = Integer.MAX_VALUE;
    
    public static final int ERROR = -1;
    
    private boolean graphType;
    
    /** 实际向量大小 */
    private int vertexSize;
    
    // 存储所有顶点信息的一维数组  
    private Object[] vertexesArray;
    
    // 存储图中顶点之间关联关系的二维数组,及边的关系  
    private int[][] edgesMatrix;
    
    // 记录第i个节点是否被访问过  
    private boolean[] visited;
    
    private StringBuffer stringBuffer = new StringBuffer();
    
    /** 
     * @param graphType 图的类型：有向图/无向图 
     * @param size      图的 最大容量值 
     */
    public GraphByMatrix(boolean graphType, int size)
    {
        this.graphType = graphType;
        
        this.vertexSize = 0;
        visited = new boolean[size];
        vertexesArray = new Object[size];
        edgesMatrix = new int[size][size];
        
        // 对数组进行初始化，顶点间没有边关联的值为Integer类型的最大值  
        for (int row = 0; row < edgesMatrix.length; row++)
        {
            for (int column = 0; column < edgesMatrix.length; column++)
            {
                edgesMatrix[row][column] = MAX_VALUE;
            }
        }
    }
    
    private void initResult()
    {
        stringBuffer = new StringBuffer();
    }
    
    public String getResult()
    {
        return this.stringBuffer.toString();
    }
    
    /** 
     * DFS:递归方式 
     * 从第一个添加的顶点开始搜索
     */
    public void DFS()
    {
        // 这里是从第一个添加的顶点开始搜索  
        DFS(vertexesArray[0]);
    }
    
    /***
     * 指定点开始搜索
     * @param obj
     */
    public void DFS(Object obj)
    {
        int index = getIndex(obj);
        DFS(index);
    }
    
    /**
     * 指定点开始搜索
     * @param index
     */
    public void DFS(int index)
    {
        Arrays.fill(visited, false); // 全部设置为 未访问过
        
        initResult(); // 清空返回值
        
        traverse(index); // 这里要想清楚，不能放下面if else的后面！  
        
        // graphType为true为有向图  
        if (graphType)
        {
            for (int i = 0; i < vertexSize; i++)
            {
                if (!visited[i])
                {
                    traverse(i);
                }
            }
        }
        
    }
    
    /** 获取 内存中的顶点的,标记 */
    private int getIndex(Object obj)
    {
        int index = ERROR;
        for (int i = 0; i < vertexSize; i++)
        {
            if (vertexesArray[i].equals(obj))
            {
                index = i;
                break;
            }
        }
        
        if (index == ERROR)
        {
            throw new NullPointerException("NullPointerException without the value" + obj);
        }
        
        return index;
    }
    
    // 深度优先就是由开始点向最深处遍历，没有了就回溯到上一级顶点  
    private void traverse(int i)
    {
        visited[i] = true;
        stringBuffer.append(vertexesArray[i]);
        
        //由于是递归，如果j=-1,该方法仍然会运行，会回溯到上一级顶点！！！  
        for (int j = firstAdjVex(i); j >= 0; j = nextAdjVex(i, j))
        {
            if (!visited[j])
            {
                traverse(j);
            }
        }
        
    }
    
    /** 
     * 广度优先遍历算法 Breadth-first search（非递归） 
     */
    public void BFS()
    {
        Queue<Integer> queue = new LinkedList<Integer>(); // LinkedList实现了Queue接口 FIFO  
        
        Arrays.fill(visited, false); // 全部设置为 未访问过
        
        initResult();
        
        // 这个循环是为了确保每个顶点都被遍历到  
        for (int i = 0; i < vertexSize; i++)
        {
            if (!visited[i])
            {
                queue.add(i);
                visited[i] = true;
                stringBuffer.append(vertexesArray[i]);
                
                while (!queue.isEmpty())
                {
                    int row = queue.remove();
                    
                    for (int k = firstAdjVex(row); k >= 0; k = nextAdjVex(row, k))
                    {
                        if (!visited[k])
                        {
                            queue.add(k);
                            visited[k] = true;
                            stringBuffer.append(vertexesArray[k]);
                        }
                    }
                    
                }
            }
        }
    }
    
    private int firstAdjVex(int row)
    {
        for (int column = 0; column < vertexSize; column++)
        {
            if (edgesMatrix[row][column] == 1)
                return column;
        }
        return -1;
    }
    
    private int nextAdjVex(int row, int k)
    {
        for (int j = k + 1; j < vertexSize; j++)
        {
            if (edgesMatrix[row][j] == 1)
                return j;
        }
        return -1;
    }
    
    /******************************************************************************************************/
    /** DFS 非递归 */
    public void DFSNonRecursive()
    {
        Stack<Integer> stack = new Stack<Integer>();
        Arrays.fill(visited, false); // 全部设置为 未访问过
        initResult();
        
        for (int i = 0; i < vertexSize; i++)
        {
            if (!visited[i])
            {
                stack.add(i);
                visited[i] = true; // 设置第i个元素已经进栈  
                
                while (!stack.isEmpty())
                {
                    int j = stack.pop();
                    stringBuffer.append(vertexesArray[j]);
                    
                    for (int k = lastAdjVex(j); k >= 0; k = lastAdjVex(j, k))
                    {
                        if (!visited[k])
                        {
                            stack.add(k);
                            visited[k] = true;
                        }
                    }
                }
            }
        }
    }
    
    // 最后一个  
    private int lastAdjVex(int i)
    {
        for (int j = vertexSize - 1; j >= 0; j--)
        {
            if (edgesMatrix[i][j] == 1)
                return j;
        }
        return -1;
    }
    
    // 上一个  
    private int lastAdjVex(int i, int k)
    {
        for (int j = k - 1; j >= 0; j--)
        {
            if (edgesMatrix[i][j] == 1)
                return j;
        }
        return -1;
    }
    
    /** 添加点 */
    public boolean addVertex(Object val)
    {
        assert (val != null); // 如果为空,则终止程序运行
        
        vertexesArray[vertexSize] = val;
        vertexSize++;
        
        return true;
    }
    
    /** 添加方向 */
    public boolean addEdge(int vnum1, int vnum2)
    {
        assert (vnum1 >= 0 && vnum2 >= 0 && vnum1 != vnum2);
        
        //有向图  
        if (graphType)
        {
            edgesMatrix[vnum1][vnum2] = 1;
        }
        else
        {
            edgesMatrix[vnum1][vnum2] = 1;
            edgesMatrix[vnum2][vnum1] = 1;
        }
        return true;
    }
}
