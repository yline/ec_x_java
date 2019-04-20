package com.test;

import com.test.backtracking.EightQueens;
import com.test.backtracking.GraphColoring;
import com.test.backtracking.GraphColoring.Graph;

import junit.framework.TestCase;

public class BacktrackingSample extends TestCase
{
    public void testEightQueens()
    {
        System.out.println("-------- EightQueens -------");
        EightQueens queens = new EightQueens();
        queens.eightQueen();
        assertEquals(92, queens.getValue());
    }
    
    public void testGraphColoring()
    {
        System.out.println("-------- GraphColoring -------");
        GraphColoring coloring = new GraphColoring();
        
        // 五角星
        Graph graphA = new Graph();
        graphA.addVertex("A");
        graphA.addVertex("B");
        graphA.addVertex("C");
        graphA.addVertex("D");
        graphA.addVertex("E");
        
        graphA.addEdge(0, 2);
        graphA.addEdge(0, 3);
        graphA.addEdge(1, 3);
        graphA.addEdge(1, 4);
        graphA.addEdge(2, 4);
        
        coloring.resetValue();
        coloring.coloring(graphA, 1);
        assertEquals(0, coloring.getValue());
        
        coloring.resetValue();
        coloring.coloring(graphA, 2);
        assertEquals(0, coloring.getValue());
        
        coloring.resetValue();
        coloring.coloring(graphA, 3);
        assertEquals(1, coloring.getValue());
    }
}
