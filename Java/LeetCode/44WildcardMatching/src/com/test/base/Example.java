package com.test.base;

import com.test.SolutionB;

import junit.framework.TestCase;

public class Example extends TestCase
{
    private Solution solution;
    
    @Override
    protected void setUp()
        throws Exception
    {
        super.setUp();
    }
    
    //    public void testSolutionA()
    //    {
    //        solution = new SolutionA();
    //        assertSolution();
    //    }
    
    public void testSolutionB()
    {
        solution = new SolutionB();
        assertSolution();
    }
    
    private void assertSolution()
    {
        assertEquals(false, solution.isMatch("aa", "a"));
        assertEquals(false, solution.isMatch("cb", "?a"));
        assertEquals(false, solution.isMatch("acdcb", "a*c?b"));
        assertEquals(true, solution.isMatch("aa", "*"));
        assertEquals(true, solution.isMatch("adceb", "*a*b"));
        
        String sA = "aaabbbaabaaaaababaabaaabbabbbbbbbbaabababbabbbaaaaba";
        String pA = "a*******b";
        assertEquals(false, solution.isMatch(sA, pA));
        
        String sB =
            "abbabaaabbabbaababbabbbbbabbbabbbabaaaaababababbbabababaabbababaabbbbbbaaaabababbbaabbbbaabbbbababababbaabbaab"
                + "abaabbbababababbbbaaabbbbbabaaaabbababbbbaababaabbababbbbbababbbabaaaaaaaabbbbbaabaaababaaaabb";
        String pB =
            "**aa*****ba*a*bb**aa*ab****a*aaaaaa***a*aaaa**bbabb*b*b**aaaaaaaaa*a********ba*bbb***a*ba*bb*bb**a*b*bb";
        // assertEquals(true, solution.isMatch(sB, pB));
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        solution = null;
        super.tearDown();
    }
}
