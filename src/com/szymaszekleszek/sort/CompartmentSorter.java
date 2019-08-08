package com.szymaszekleszek.sort;

import com.szymaszekleszek.model.Compartment;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CompartmentSorter {

    public List<Compartment> sort (Compartment[] compartments) {
        return Stream.of(compartments)
                .sorted(Comparator.comparing(Compartment::getStart)
                        .thenComparing(Compartment::getEnd))
                .collect(Collectors.toList());
    }
}
