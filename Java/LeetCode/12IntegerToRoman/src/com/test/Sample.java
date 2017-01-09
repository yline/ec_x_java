package com.test;

import junit.framework.TestCase;

public class Sample extends TestCase
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
        System.out.println("->" + solution.intToRoman(1));
        System.out.println("->" + solution.intToRoman(2));
        System.out.println("->" + solution.intToRoman(3));
        System.out.println("->" + solution.intToRoman(13));
        System.out.println("->" + solution.intToRoman(14));
        System.out.println("->" + solution.intToRoman(19));
        System.out.println("->" + solution.intToRoman(3999));
        System.out.println("->" + solution.intToRoman(1234));
        System.out.println("->" + solution.intToRoman(12345));
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        solution = null;
        super.tearDown();
    }
}
