package com.test;

import junit.framework.TestCase;

public class Example extends TestCase
{
    private Solution solution;
    
    @Override
    protected void setUp()
        throws Exception
    {
        super.setUp();
        solution = new Solution();
    }
    
    public void testSolution()
    {
    }
    
    public void testSearchLeft()
    {
    }
    
    public void testSearchRight()
    {
        
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        solution = null;
        super.tearDown();
    }
}
