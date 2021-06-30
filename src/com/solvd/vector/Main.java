package com.solvd.vector;

import java.util.List;
import java.util.Random;

/**
 * @author asemenkov
 * @since Jun 29, 2021
 */
public class Main {

    public static void main_(String[] args) {
        List<TriCoordVector> vectors = VectorCollectionsUtil.generateVectors(10);
        double median = VectorCollectionsUtil.getMedianLength(vectors);
        List<TriCoordVector> removalList = VectorCollectionsUtil.removeShorterVectors(vectors, median);
        int intersections = VectorCollectionsUtil.countIntersection(vectors, removalList);
    }

    public static void main(String[] args) {

        TriCoordVector v1 = new TriCoordVector(1, 2, 3);
        Vector v2 = new TriCoordVector(4, 5, 6);
        VectorMultipliable<TriCoordVector> v3 = new TriCoordVector(7, 8, 9);

        double cos = v1.getCosAngle(v2);
        double scalar = v2.getScalarProduct(v1);


        Random randomInt = new Random(0);
        List<Vector> vectors = VectorFunctionalUtils.generate(10, randomInt::nextInt);
        vectors.stream().forEach(System.out::println);
    }

}
