package com.solvd.vector;

import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.function.Function;

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

        //Task 1 - Vector generation
        System.out.println("=====Generation===");
        Random randomInt = new Random(0);
        List<Vector> vectors = VectorFunctionalUtils.generate(10, randomInt::nextInt);
        vectors.stream().forEach(System.out::println);

        List<Vector> smallVectors = VectorFunctionalUtils.generate(10, 20, randomInt::nextInt);

        //Task 2 - Sorting
        System.out.println("=====Sorting=====");
        Comparator<Vector> vectorComparator = (o1, o2) -> {
                if(o1.getLength() > o2.getLength()) {
                    return -1;
                } else if(o1.getLength() < o2.getLength()) {
                    return 1;
                }
                return 0;
        };
        List<Vector> sortedVectors = VectorFunctionalUtils.sort(vectors, vectorComparator::compare);
        sortedVectors.forEach(System.out::println);

        //Task 3 - Mapping
        System.out.println("=====Mapping=====");
        List<Long> lengths = VectorFunctionalUtils.map(sortedVectors, vector -> (long) vector.getLength());
        lengths.forEach(System.out::println);

        //Task 4 - Streams
        System.out.println("=====Streams=====");
        Long sum = lengths.stream()
                .filter(num -> num%2 == 0)
                .peek(System.out::println)
                .reduce(0L, (num1, num2) -> num1 + num2);

        System.out.println("Sum = " + sum);
        System.out.println("Max = " + Integer.MAX_VALUE);
        System.out.println(sum > Integer.MAX_VALUE);

    }



}
