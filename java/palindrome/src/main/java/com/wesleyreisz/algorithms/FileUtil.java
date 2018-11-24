package com.wesleyreisz.algorithms;

import static java.util.Objects.isNull;

public class FileUtil {
    public static boolean isPalidrome(String val) throws NoValuePresentException {
        if (isNull(val)){
            throw new NoValuePresentException();
        }
        //replace spaces
        val = val.replaceAll("\\s","");
        for (int i=0;i<((val.length()/2)+1);i++){
            char leftCharacter = val.charAt(i);
            if (leftCharacter!=val.charAt(val.length()-(i+1))){
                return false;
            }
        }
        return true;
    }

    protected static class NoValuePresentException extends Exception {
    }
}
