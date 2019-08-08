package com.szymaszekleszek;

import com.szymaszekleszek.model.Compartment;
import com.szymaszekleszek.search.SeparableCompartmentsCounter;


public class Main {

    public static void main(String[] args) {
        int count = new SeparableCompartmentsCounter().count(
                new Compartment(22,110),
                new Compartment(11,12),
                new Compartment(3,4),
                new Compartment(7,9),
                new Compartment(8,9),
                new Compartment(10,20),
                new Compartment(1,2),
                new Compartment(55,66)
        );
        System.out.println(count);
    }


}
