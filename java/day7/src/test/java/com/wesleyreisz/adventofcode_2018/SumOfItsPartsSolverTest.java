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
        List<String> instructionList = buildTestList();
        SumOfItsPartsSolver ss = new SumOfItsPartsSolver();
        List<SleighNode> results = ss.loadNodes(instructionList);
        assertNotNull(results);
        assertEquals(4, results.size());
        SleighNode node = results.get(3);
        assertEquals('A',node.predecessor);
        assertEquals('D',node.work);
    }

    @Test
    public void testNodeSort(){
        List<String> instructionList = buildTestList();
        SumOfItsPartsSolver ss = new SumOfItsPartsSolver();
        List<SleighNode> sortedList = ss.sortNodes(ss.loadNodes(instructionList));
        assertNotNull(sortedList);
        assertEquals('A',sortedList.get(0).work);
        assertEquals('C',sortedList.get(0).predecessor);
        assertEquals('C',sortedList.get(1).predecessor);
        assertEquals('F',sortedList.get(1).work);
        assertEquals('B',sortedList.get(2).work);
        assertEquals('A',sortedList.get(2).predecessor);
    }

    @Test
    public void testNodeSortDifferentList(){
        List<String> instructionList = buildTestList1();
        SumOfItsPartsSolver ss = new SumOfItsPartsSolver();
        List<SleighNode> sortedList = ss.sortNodes(ss.loadNodes(instructionList));
        assertNotNull(sortedList);
        for(SleighNode n : sortedList){
            System.out.println(String.format("Step %s must be finished before step %s can begin.", n.predecessor, n.work));
        }
    }

    /*helpers*/
    private List<String> buildTestList() {
        List<String> instructionList = new ArrayList<>();
        instructionList.add("Step C must be finished before step F can begin.");
        instructionList.add("Step A must be finished before step B can begin.");
        instructionList.add("Step C must be finished before step A can begin.");
        instructionList.add("Step A must be finished before step D can begin.");
        return instructionList;
    }

    private List<String> buildTestList1() {
        List<String> instructionList = new ArrayList<>();
        instructionList.add("Step S must be finished before step B can begin.");
        instructionList.add("Step S must be finished before step C can begin.");
        instructionList.add("Step S must be finished before step W can begin.");
        instructionList.add("Step Z must be finished before step A can begin.");
        instructionList.add("Step Z must be finished before step C can begin.");
        instructionList.add("Step Z must be finished before step S can begin.");
        instructionList.add("Step Z must be finished before step W can begin.");
        instructionList.add("Step O must be finished before step A can begin.");
        instructionList.add("Step O must be finished before step B can begin.");
        instructionList.add("Step O must be finished before step S can begin.");
        instructionList.add("Step O must be finished before step W can begin.");
        instructionList.add("Step O must be finished before step Z can begin.");
        instructionList.add("Step T must be finished before step A can begin.");
        instructionList.add("Step T must be finished before step E can begin.");
        instructionList.add("Step T must be finished before step I can begin.");
        instructionList.add("Step T must be finished before step M can begin.");
        instructionList.add("Step T must be finished before step V can begin.");
        instructionList.add("Step N must be finished before step A can begin.");
        instructionList.add("Step N must be finished before step B can begin.");
        instructionList.add("Step N must be finished before step H can begin.");
        instructionList.add("Step N must be finished before step O can begin.");
        instructionList.add("Step N must be finished before step Q can begin.");
        return instructionList;
    }
}
