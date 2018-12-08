package com.wesleyreisz.adventofcode_2018;

import java.util.Objects;

public class SleighNode {
    char predecessor;
    char work;

    public SleighNode(char predecessor, char work) {
        this.predecessor = predecessor;
        this.work = work;
    }

    public char getPredecessor() {
        return predecessor;
    }

    public void setPredecessor(char predecessor) {
        this.predecessor = predecessor;
    }

    public char getWork() {
        return work;
    }

    public void setWork(char work) {
        this.work = work;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SleighNode that = (SleighNode) o;
        return predecessor == that.predecessor &&
                work == that.work;
    }

    @Override
    public int hashCode() {
        return Objects.hash(predecessor, work);
    }
}
