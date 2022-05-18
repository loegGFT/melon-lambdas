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

    public static List<Melon> filterByWeightExact(List<Melon> melons, int weight) {
        checkValidList(melons);
        checkWeightValid(weight);
        List<Melon> filtered = new ArrayList<>();
        for (Melon current : melons)
            if (weight == current.getWeight())
                filtered.add(current);
        return filtered;
    }

    public static List<Melon> filterByWeightExactOrMore(List<Melon> melons, int weight) {
        checkValidList(melons);
        checkWeightValid(weight);
        List<Melon> filtered = new ArrayList<>();
        for (Melon current : melons)
            if (weight <= current.getWeight())
                filtered.add(current);
        return filtered;
    }

    public static List<Melon> filterByWeightExactOrLess(List<Melon> melons, int weight) {
        checkValidList(melons);
        checkWeightValid(weight);
        List<Melon> filtered = new ArrayList<>();
        for (Melon current : melons)
            if (weight >= current.getWeight())
                filtered.add(current);
        return filtered;
    }

    public static List<Melon> filterByTypePredicated(List<Melon> melons, MelonPredicate melonPredicate) {
        checkValidList(melons);
        List<Melon> filtered = new ArrayList<>();
        for (Melon melon : melons)
            if (melonPredicate.test(melon))
                filtered.add(melon);
        return filtered;
    }

    public static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        checkValidList(list);
        List<T> result = new ArrayList<>();
        for(T t: list)
            if (predicate.test(t))
                result.add(t);
        return result;
    }

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

    private static void checkWeightValid(int weight) {
        if (weight < 1)
            throw new InvalidParameterException("El Peso no puede ser inferior a 1g.");
    }

    private static <T> List<T> checkValidList(List<T> list) {
        if (list == null) {
            throw new IllegalArgumentException("La lista no puede ser nula");
        }
        return list;
    }
}
