package com.wesleyreisz.adventofcode;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
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
        List<String> lines = loadLines("input.txt");
        assertNotNull(lines);

        ChronalCalibration chronalCalibration = ChronalCalibration.getInstance();
        lines.stream().forEach(x->chronalCalibration.adjustCalibration(Integer.valueOf(x)));

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
