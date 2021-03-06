package com.test.base;

import java.util.Arrays;

import com.test.SolutionA;

import junit.framework.TestCase;

public class Example extends TestCase {
	private SolutionA solution;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}

	public void testSolutionA() {
		solution = new SolutionA();
		assertSolution();
	}

	private void assertSolution() {
		int[] numA = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		solution.rotate(numA, 3);
		System.out.println(Arrays.toString(numA));

		int[] numB = new int[] { 1, 2, 3, 4, 5, 6 };
		solution.rotate(numB, 2);
		System.out.println(Arrays.toString(numB));
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}
}
