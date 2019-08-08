package com.szymaszekleszek.model;

public class Compartment {

    private int start;
    private int end;

    public Compartment (int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart () {
        return start;
    }

    public void setStart (int start) {
        this.start = start;
    }

    public int getEnd () {
        return end;
    }

    public void setEnd (int end) {
        this.end = end;
    }

    @Override
    public String toString () {
        return "Compartment{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}
