package com.wesleyreisz.algorithms;

import java.util.HashMap;
import java.util.Map;

import static java.util.Objects.isNull;

public class StringUtil {
    private static Map<Character, Integer> dictionaryValues;

    private StringUtil(){
        if (isNull(dictionaryValues)) {
            dictionaryValues = new HashMap<Character, Integer>();
            dictionaryValues.put('A', 1);
            dictionaryValues.put('B', 2);
            dictionaryValues.put('C', 3);
            dictionaryValues.put('D', 4);
            dictionaryValues.put('E', 5);
            dictionaryValues.put('F', 6);
            dictionaryValues.put('G', 7);
            dictionaryValues.put('H', 8);
            dictionaryValues.put('I', 9);
        }
    }

    public static int atoi(String input) {
        //if ABC -> return 123;
        StringUtil su = new StringUtil();

        if(isNull(input)){
            return 0;
        }else{
            input = input.toUpperCase();
        }
        var accumulator = 0;
        var multiplier = 1;
        for(int x = input.length()-1; x >= 0; x--){
            var val = input.toCharArray()[x];
            accumulator += dictionaryValues.get(val) * multiplier;
            multiplier = multiplier * 10;
        }
        return accumulator;
    }

}
