package com.solvd.vector;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.IntSupplier;
import java.util.stream.Collectors;

public class VectorFunctionalUtils {
    public static List<Vector> generate(int n, IntSupplier intSupplier) {
        List<Vector> vectors = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            vectors.add(new TriCoordVector(intSupplier.getAsInt(), intSupplier.getAsInt(), intSupplier.getAsInt()));
        }
        return vectors;
    }

    //generates small-value vectors
    public static List<Vector> generate(int n, int bound, Function<Integer, Integer> intSupplier) {
        List<Vector> vectors = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            vectors.add(new TriCoordVector(intSupplier.apply(bound), intSupplier.apply(bound), intSupplier.apply(bound)));
        }
        return vectors;
    }

    public static List<Vector> sort(List<Vector> vectors, Comparator<Vector> comparator) {
        return vectors
                .stream()
                .sorted(comparator)
                .collect(Collectors.toList());
    }
}
