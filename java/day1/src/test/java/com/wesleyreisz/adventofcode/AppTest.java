package com.wesleyreisz.adventofcode;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        boolean notFirstPass = false;
        int counter = 0;
        HashMap<Integer,Integer> history = new HashMap<>();
        List<String> lines = loadLines("input.txt");
        assertNotNull(lines);

        ChronalCalibration chronalCalibration = ChronalCalibration.getInstance();
        /*
        lines.stream().forEach(x->{
            int currentAdjustment = Integer.valueOf(x);
            chronalCalibration.adjustCalibration(currentAdjustment);
            history.put(chronalCalibration.currentCalibration(),currentAdjustment);
        });
        */

        //look for a repeated current value frequency
        for (int i = 0; i<lines.size(); i++){
            int currentAdjustment = Integer.valueOf(lines.get(i));
            int currentCalibration = chronalCalibration.currentCalibration();
            chronalCalibration.adjustCalibration(currentAdjustment);
            history.put(currentCalibration,currentAdjustment);

            if (i==lines.size()-1){
                //keep looping
                i = 0;
                notFirstPass = true;
                counter++;
            }

            //after first iteration... look for repeats
            if (notFirstPass){
                if (history.containsKey(currentCalibration)){
                    System.out.println(String.format("first reaches %d twice.", history.get(currentCalibration)));
                    break;
                }
            }

            //protect against infinite loop
            if (counter>=lines.size()){
                System.out.println("No repeats");
                break;
            }
        }

        System.out.println(chronalCalibration.currentCalibration());
    }

    //helper
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

}
