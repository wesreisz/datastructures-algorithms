package com.wesleyreisz.adventofcode_2018;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 */
public class SumOfItsPartsSolver
{
    private static final String VOCAB_PATTERN_MATCHER = "Step (\\w) must be finished before step (\\w) can begin.";
    private List<SleighNode> workInstructions;

    public static void main( String[] args )
    {
        if (args.length<=0){
            System.out.println("Please provide a file name.");
            return;
        }

        SumOfItsPartsSolver solver = new SumOfItsPartsSolver();
        solver.part1(args[0]);
        solver.part2();

        solver.printWorkInstructions();
    }

    protected void part1(String fileName){
        //load file
        List<String> lines = loadLines(fileName);
        //create an array of points
        List<SleighNode> listOfNodes = loadNodes(lines);
        //sort list by work
        workInstructions = sortNodes(listOfNodes);
    }

    protected List<String> loadLines(String fileName) {
        List<String> results = new ArrayList<>();

        File file = new File(fileName);
        Scanner sc = null;
        try {
            sc = new Scanner(file);
            while (sc.hasNextLine()){
                results.add(sc.nextLine());

            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            results.add("File Not Found Exception Throw: Check stacktrace");
        }

        return results;
    }
    protected List<SleighNode> loadNodes(List<String> lines) {
        Pattern pattern = Pattern.compile(VOCAB_PATTERN_MATCHER);
        List<SleighNode> allSteps =
                lines.stream().map(line -> {
                    Matcher matcher = pattern.matcher(line);
                    matcher.find();
                    char x = matcher.group(1).charAt(0);
                    char y = matcher.group(2).charAt(0);
                    return new SleighNode(x,y);
                }).collect(Collectors.toList());
        return allSteps;

        /*
        line -> {
            Matcher matcher = pattern.matcher(line);
            matcher.find();
            char x = matcher.group(1).charAt(0);
            char y = matcher.group(2).charAt(1);
            return new SleighNode(x,y);
        }
         */
    }
    protected List<SleighNode> sortNodes(List<SleighNode> listOfNodes) {
        //sort on work field
        Collections.sort(listOfNodes, (o1, o2) -> o1.work - o2.work);

        List<SleighNode> sortedNodes = new ArrayList<>();
        while (listOfNodes.size()>0){
            processWorkPredecessors(listOfNodes,sortedNodes);
        }

        return sortedNodes;
    }

    private void processWorkPredecessors(List<SleighNode> listOfNodes, List<SleighNode> sortedNodes) {
        char tmp = listOfNodes.get(0).predecessor;

        //find a tmp list of all predessors matching the work field
        List<SleighNode> tmpListOfNodes = listOfNodes.stream()
                .filter(n -> n.predecessor==tmp)
                .collect(Collectors.toList());

        //sort the tmplist on predecessor
        Collections.sort(tmpListOfNodes, (o1, o2) -> o1.predecessor - o2.predecessor);

        for (SleighNode n : tmpListOfNodes){
            listOfNodes.remove(n);//remove from old list
            sortedNodes.add(n);//add to new list
        }
    }

    protected void part2(){
        //print steps
    }

    private void printWorkInstructions(){
        for (SleighNode instruction : workInstructions){
            System.out.println(String.format("Step %s must be finished before step %s can begin.",instruction.predecessor,instruction.work));
        }
    }

}
