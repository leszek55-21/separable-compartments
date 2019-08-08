package com.szymaszekleszek.search;

import com.szymaszekleszek.model.Compartment;
import com.szymaszekleszek.sort.CompartmentSorter;

import java.util.*;

public class SeparableCompartmentsCounter {

    public int count (Compartment... compartments) {
        List<Compartment> sortedCompartments = new CompartmentSorter().sort(compartments);
        if(sortedCompartments.isEmpty()) {
            return 0;
        }
        int counter = 1;
        for (int i = 0; i < sortedCompartments.size() - 1; i++) {
            if (compartmentsOverlaps(sortedCompartments, i)) {
                if (sortedCompartments.get(i).getEnd() > sortedCompartments.get(i + 1).getEnd()) {
                    sortedCompartments.get(i + 1).setEnd(sortedCompartments.get(i).getEnd());
                }
            } else {
                counter++;
            }
        }
        return counter;
    }

    private boolean compartmentsOverlaps (List<Compartment> sortedCompartments, int i) {
        return sortedCompartments.get(i).getEnd() >= sortedCompartments.get(i + 1).getStart();
    }
}
