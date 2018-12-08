package com.wesleyreisz.adventofcode_2018;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Unit test for simple SleighSolver.
 */
public class SleighSolverTest
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void loadFileTest()
    {
        SleighSolver ss = new SleighSolver();
        List<String> results = ss.loadLines("testInput.txt");
        assertNotNull(results);
        assertEquals(7, results.size());

        for(String result : results){
            System.out.println(result);
        }

    }
}
