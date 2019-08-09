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
            Compartment current = sortedCompartments.get(i);
            Compartment next = sortedCompartments.get(i + 1);
            if (compartmentsOverlaps(current, next)) {
                if (nextIsIncludedInCurrent(current, next)) {
                    next.setEnd(current.getEnd());
                }
            } else {
                counter++;
            }
        }
        return counter;
    }

    private boolean nextIsIncludedInCurrent(Compartment first, Compartment second) {
        return first.getEnd() > second.getEnd();
    }

    private boolean compartmentsOverlaps (Compartment first, Compartment second) {
        return first.getEnd() >= second.getStart();
    }
}
