package com.wesleyreisz.adventofcode;

import static java.util.Objects.isNull;

public class ChronalCalibration {
    private int sum;
    private static ChronalCalibration chronalCalibration;

    private ChronalCalibration(){
    }
    public static ChronalCalibration getInstance(){
        if (isNull(chronalCalibration)){
            chronalCalibration = new ChronalCalibration();
        }
        return chronalCalibration;
    }
    public void adjustCalibration(int adjustement){
        sum += adjustement;
    }
    public int currentCalibration(){
        return sum;
    }
}
