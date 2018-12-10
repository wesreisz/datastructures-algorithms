package com.wesleyreisz.adventofcode;

import static java.util.Objects.isNull;

public class ChronalCalibration {
    private int sum;
    private static ChronalCalibration chronalCalibration;

    private ChronalCalibration(){
    }
    private static ChronalCalibration getInstance(){
        if (isNull(chronalCalibration)){
            chronalCalibration = new ChronalCalibration();
        }
        return chronalCalibration;
    }
    public void adjustCalibration(){
    }
    public int currentCalibration(){
        return sum;
    }
}
