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
    public void shouldAnswerWithTrue() {
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
        for (int i = 0; i<lines.size(); i++){//998
            int currentFrequency = Integer.valueOf(lines.get(i));
            int resultingFrequency = chronalCalibration.currentCalibration();
            chronalCalibration.adjustCalibration(currentFrequency);

            //look for previous resulting frequency
            if (history.containsKey(resultingFrequency)){
                System.out.println(String.format("first reaches %d twice.", resultingFrequency));
                System.out.println(String.format("full iterations: " + counter));
                break;
            }

            history.put(resultingFrequency, currentFrequency);

            //reset to continue iterations
            if (i==lines.size()-1){
                i = -1;//reset counter back to 0
                counter++;
            }

            //protect against infinite loop by not letting it iterate more than the list length
            if (counter>=lines.size()){
                System.out.println("No repeats");
                break;
            }
        }
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
