package com.test;

import java.util.List;

import com.test.backtracking.EightQueens;
import com.test.backtracking.GraphColoring;
import com.test.backtracking.GraphColoring.Graph;
import com.test.backtracking.Knapsack;

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
    
    public void testKnapsack()
    {
        System.out.println("-------- Knapsack -------");
        
        Knapsack knapsack = new Knapsack();
        
        List<Knapsack.Goods> goodsList = Knapsack.createGoodsList(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9},
            new int[] {1, 3, 5, 7, 9, 11, 13, 15, 17});
        
        assertEquals(2, knapsack.knapsack(goodsList, 3));
        knapsack.reset();
        
        assertEquals(45, knapsack.knapsack(goodsList, 81));
        knapsack.reset();
        
        assertEquals(17, knapsack.knapsack(goodsList, 30));
        knapsack.reset();
        
        assertEquals(18, knapsack.knapsack(goodsList, 31));
        knapsack.reset();
        
        assertEquals(18, knapsack.knapsack(goodsList, 32));
        knapsack.reset();
        
    }
}
