package com.wesleyreisz.adventofcode_2018;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Unit test for simple SumOfItsPartsSolver.
 */
public class SumOfItsPartsSolverTest
{

    @Test
    public void loadFileTest() {
        SumOfItsPartsSolver ss = new SumOfItsPartsSolver();
        List<String> results = ss.loadLines("testInput.txt");
        assertNotNull(results);
        assertEquals(7, results.size());

        for(String result : results){
            System.out.println(result);
        }

    }

    @Test
    public void testMessageWhenNoFileFound(){
        String msg = "File Not Found Exception Throw: Check stacktrace";
        SumOfItsPartsSolver ss = new SumOfItsPartsSolver();
        List<String> results = ss.loadLines("BadName.txt");

        assertNotNull(results);
        assertEquals(msg,results.get(0));
    }

    @Test
    public void testConvertStringsToNodes(){
        List<String> instructionList = new ArrayList<>();
        instructionList.add("Step C must be finished before step A can begin.");
        instructionList.add("Step C must be finished before step F can begin.");
        instructionList.add("Step A must be finished before step B can begin.");
        instructionList.add("Step A must be finished before step D can begin.");
        SumOfItsPartsSolver ss = new SumOfItsPartsSolver();
        List<SleighNode> results = ss.loadNodes(instructionList);
        assertNotNull(results);
        assertEquals(4, results.size());
        SleighNode node = results.get(3);
        assertEquals('A',node.predecessor);
        assertEquals('D',node.work);
    }
}
