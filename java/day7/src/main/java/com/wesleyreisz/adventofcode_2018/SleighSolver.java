package com.wesleyreisz.adventofcode_2018;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 */
public class SleighSolver
{
    public static void main( String[] args )
    {
        SleighSolver solver = new SleighSolver();
        solver.part1("input.txt");
        solver.part2();
    }

    protected void part1(String fileName){
        //load file
        List<String> lines = loadLines(fileName);
    }

    protected List<String> loadLines(String fileName){
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
        }

        return results;
    }


    protected void part2(){
        //print steps
    }

}
