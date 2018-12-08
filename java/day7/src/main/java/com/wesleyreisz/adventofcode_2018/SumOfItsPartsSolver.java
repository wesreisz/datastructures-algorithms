package com.wesleyreisz.adventofcode_2018;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 */
public class SumOfItsPartsSolver
{
    public static void main( String[] args )
    {
        SumOfItsPartsSolver solver = new SumOfItsPartsSolver();
        solver.part1("input.txt");
        solver.part2();
    }

    protected void part1(String fileName){
        //load file
        List<String> lines = loadLines(fileName);
        //create an array of points
        List<SleighNode> listOfNodes = loadNodes(lines);
        
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
        Pattern pattern = Pattern.compile("Step (\\w) must be finished before step (\\w) can begin.");
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


    protected void part2(){
        //print steps
    }

}
