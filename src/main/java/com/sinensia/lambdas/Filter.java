package com.sinensia.lambdas;

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
        List<Melon> filtered = new java.util.ArrayList<>();
        for (Melon current : melons)
            if (type.equalsIgnoreCase(current.getType()))
                filtered.add(current);
        return filtered;
    }

    public static List<Melon> filterByWeightExact(List<Melon> melons, int weight) {
        List<Melon> filtered = new java.util.ArrayList<>();
        for (Melon current : melons)
            if (weight == current.getWeight())
                filtered.add(current);
        return filtered;
    }

    public static List<Melon> filterByWeightExactOrMore(List<Melon> melons, int weight) {
        List<Melon> filtered = new java.util.ArrayList<>();
        for (Melon current : melons)
            if (weight <= current.getWeight())
                filtered.add(current);
        return filtered;
    }

    public static List<Melon> filterByWeightExactOrLess(List<Melon> melons, int weight) {
        List<Melon> filtered = new java.util.ArrayList<>();
        for (Melon current : melons)
            if (weight >= current.getWeight())
                filtered.add(current);
        return filtered;
    }
}
