package com.szymaszekleszek.count;

import com.szymaszekleszek.model.Compartment;
import com.szymaszekleszek.sort.CompartmentSorter;

import java.util.*;

public class SeparableCompartmentsCounter {

    public int count(Compartment... compartments) {
        List<Compartment> sortedCompartments = new CompartmentSorter().sort(compartments);
        if(sortedCompartments.isEmpty()) {
            return 0;
        }
        int counter = 1;
        for (int i = 0; i < sortedCompartments.size() - 1; i++) {
            Compartment first = sortedCompartments.get(i);
            Compartment second = sortedCompartments.get(i + 1);
            if (compartmentsOverlaps(first, second)) {
                if (secondIsIncludedInFirst(first, second)) {
                    second.setEnd(first.getEnd());
                }
            } else {
                counter++;
            }
        }
        return counter;
    }

    private boolean secondIsIncludedInFirst (Compartment first, Compartment second) {
        return first.getEnd() > second.getEnd();
    }

    private boolean compartmentsOverlaps (Compartment first, Compartment second) {
        return first.getEnd() >= second.getStart();
    }
}
