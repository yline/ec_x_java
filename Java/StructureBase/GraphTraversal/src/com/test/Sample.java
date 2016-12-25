package com.test;

import junit.framework.TestCase;

public class Sample extends TestCase
{
    private GraphByMatrix graphByMatrix;
    
    @Override
    protected void setUp()
        throws Exception
    {
        graphByMatrix = new GraphByMatrix(GraphByMatrix.UNDIRECTED_GRAPH, 6);
        init();
        super.setUp();
    }
    
    private void init()
    {
        graphByMatrix.addVertex("1 ");
        graphByMatrix.addVertex("2 ");
        graphByMatrix.addVertex("3 ");
        graphByMatrix.addVertex("4 ");
        graphByMatrix.addVertex("5 ");
        graphByMatrix.addVertex("6 ");
        
        graphByMatrix.addEdge(0, 1);
        graphByMatrix.addEdge(0, 2);
        graphByMatrix.addEdge(1, 3);
        graphByMatrix.addEdge(1, 4);
        graphByMatrix.addEdge(2, 1);
        graphByMatrix.addEdge(2, 4);
        graphByMatrix.addEdge(3, 5);
        graphByMatrix.addEdge(2, 4);
        graphByMatrix.addEdge(4, 5);
    }
    
    public void testSort()
    {
        graphByMatrix.DFS();
        System.out.println("DFS Recursive : " + graphByMatrix.getResult());
        assertEquals("1 2 3 5 6 4 ", graphByMatrix.getResult());
        
        graphByMatrix.DFSNonRecursive();
        System.out.println("DFS Not Recursive : " + graphByMatrix.getResult());
        assertEquals("1 2 4 6 5 3 ", graphByMatrix.getResult());
        
        graphByMatrix.DFS("2 ");
        System.out.println("DFS index ensured : " + graphByMatrix.getResult());
        assertEquals("2 1 3 5 6 4 ", graphByMatrix.getResult());
        
        graphByMatrix.BFS();
        System.out.println("BFS Not Recursive : " + graphByMatrix.getResult());
        assertEquals("1 2 3 4 5 6 ", graphByMatrix.getResult());
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        graphByMatrix = null;
        super.tearDown();
    }
}
