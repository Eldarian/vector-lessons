package com.solvd.vector;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntSupplier;

public class VectorFunctionalUtils {
    public static List<Vector> generate(int n, IntSupplier intSupplier) {
        List<Vector> vectors = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            vectors.add(new TriCoordVector(intSupplier.getAsInt(), intSupplier.getAsInt(), intSupplier.getAsInt()));
        }
        return vectors;
    }
}
