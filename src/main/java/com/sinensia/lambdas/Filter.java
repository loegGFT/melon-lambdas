package com.sinensia.lambdas;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

public final class Filter {
    public Filter() {
        throw new AssertionError("Filter no se puede instanciar");
    }

    /**
     * Filters a list of melons by type, returning the list of melons with a matching type, or an empty list if none exist
     * @param melons List of melons to filter
     * @param type Type of melons to filter by
     * @return List of melons that are of the specified type
     */
    public static List<Melon> filterByType(List<Melon> melons, String type) {
        checkValidList(melons);
        List<Melon> filtered = new ArrayList<>();
        for (Melon current : melons)
            if (type.equalsIgnoreCase(current.getType()))
                filtered.add(current);
        return filtered;
    }

    /**
     * Filters a list of melons by exact weight.
     * @param melons List of melons to filter
     * @param weight Weight in grams
     * @return List of melons with the exact weight, or an empty list if none exist.
     */
    public static List<Melon> filterByWeightExact(List<Melon> melons, int weight) {
        checkValidList(melons);
        checkWeightValid(weight);
        List<Melon> filtered = new ArrayList<>();
        for (Melon current : melons)
            if (weight == current.getWeight())
                filtered.add(current);
        return filtered;
    }

    /**
     * Filters a list of melons by exact weight or above.
     * @param melons List of melons to filter.
     * @param weight Weight in grams.
     * @return List of melons with the exact weight or above it, or an empty list if none exist.
     */
    public static List<Melon> filterByWeightExactOrMore(List<Melon> melons, int weight) {
        checkValidList(melons);
        checkWeightValid(weight);
        List<Melon> filtered = new ArrayList<>();
        for (Melon current : melons)
            if (weight <= current.getWeight())
                filtered.add(current);
        return filtered;
    }

    /**
     * Filters a list of melons by exact weight or below.
     * @param melons List of melons to filter.
     * @param weight Weight in grams.
     * @return List of melons with the exact weight or below it, or an empty list if none exist.
     */
    public static List<Melon> filterByWeightExactOrLess(List<Melon> melons, int weight) {
        checkValidList(melons);
        checkWeightValid(weight);
        List<Melon> filtered = new ArrayList<>();
        for (Melon current : melons)
            if (weight >= current.getWeight())
                filtered.add(current);
        return filtered;
    }

    /**
     * Filters a list of melons by a predicate.
     * @param melons List of melons to filter.
     * @param melonPredicate Predicate that filters the list.
     * @return List of melons that match the predicate, or an empty list if none exist.
     */
    public static List<Melon> filterByTypePredicated(List<Melon> melons, MelonPredicate melonPredicate) {
        checkValidList(melons);
        List<Melon> filtered = new ArrayList<>();
        for (Melon melon : melons)
            if (melonPredicate.test(melon))
                filtered.add(melon);
        return filtered;
    }

    /**
     * Filters a list according to a predicate
     * @param list List to filter
     * @param predicate Predicate to filter the list
     * @return List filtered, or an empty list if none exist.
     * @param <T> Type of element to filter
     */
    public static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        checkValidList(list);
        List<T> result = new ArrayList<>();
        for(T t: list)
            if (predicate.test(t))
                result.add(t);
        return result;
    }

    /**
     * Filters a list of melons according to a predicate
     * @param melons List of Melons to filter
     * @param predicate Predicate which we filter the list with
     * @return Filtered list of Melons, or an empty list if none exist.
     */
    public static List<Melon> filterMelons(List<Melon> melons, MelonPredicate predicate) {
        checkValidList(melons);
        List<Melon> result = new ArrayList<>();
        for(Melon melon: melons) {
            if(predicate.test(melon)) {
                result.add(melon);
            }
        }
        return result;
    }

    /**
     * Checks if the weight is valid.
     * @param weight Weight to check the validity of
     * @throws InvalidParameterException Thrown when the weight is invalid (weight < 1)
     */
    private static void checkWeightValid(int weight) {
        if (weight < 1)
            throw new InvalidParameterException("El Peso no puede ser inferior a 1g.");
    }

    /**
     * Checks if a list is valid.
     * @param list List to check the validity of
     * @return The valid list
     * @param <T> Type of elements in the list.
     * @throws IllegalArgumentException Thrown when the list is null.
     */
    private static <T> List<T> checkValidList(List<T> list) {
        if (list == null) {
            throw new IllegalArgumentException("La lista no puede ser nula");
        }
        return list;
    }
}
