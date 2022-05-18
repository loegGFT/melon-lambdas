package com.sinensia.lambdas;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Melon> melons = Arrays.asList(
                new Melon("Gac", 5500, "Europe"),
                new Melon("Bailan", 6000, "China"),
                new Melon("Watermelon", 1200, "Europe"),
                new Melon("Gac", 3400, "US"),
                new Melon("Gac", 1100, "US"),
                new Melon("Bailan", 1300, "China")
        );
        List<Melon> found;

        // Clean the list of any null elements
        while (melons.remove(null));

        for (int i = 0; i < melons.size(); ++i) {
            System.out.println(melons.get(i).toString());
        }

        System.out.println("Lista de filtrados (Bailan):");
        found = Filter.filterByType(melons, "bailan");
        if (found.size() > 0)
            for (Melon melon : found)
                System.out.println(melon.toString());
        else
            System.out.println("No se han encontrado melones Bailan.");

        System.out.println("Lista de filtrados (Peso Exacto):");
        found = Filter.filterByWeightExact(melons, 1200);
        if (found.size() > 0)
            for (Melon melon : found)
                System.out.println(melon.toString());
        else
            System.out.println("No se han encontrado melones que pesan 1200g.");

        System.out.println("Lista de filtrados (Peso Exacto o Superior):");
        found = Filter.filterByWeightExactOrMore(melons, 1200);
        if (found.size() > 0)
            for (Melon melon : found)
                System.out.println(melon.toString());
        else
            System.out.println("No se han encontrado melones que pesan 1200g o mas.");

        System.out.println("Lista de filtrados (Peso Exacto o Inferior):");
        found = Filter.filterByWeightExactOrLess(melons, 1200);
        if (found.size() > 0)
            for (Melon melon : found)
                System.out.println(melon.toString());
        else
            System.out.println("No se han encontrado melones que pesan 1200g o menos.");

        System.out.println("Lista de filtrados (Gac):");
        GacMelonPredicate gacMelonPredicate = new GacMelonPredicate();
        found = Filter.filterByTypePredicated(melons, gacMelonPredicate);
        if (found.size() > 0)
            for (Melon melon : found)
                System.out.println(melon.toString());
        else
            System.out.println("No se han encontrado melones gac.");

        System.out.println("Lista de filtrados (Melon Pesado):");
        HeavyMelonPredicate heavyMelonPredicate = new HeavyMelonPredicate();
        found = Filter.filterByTypePredicated(melons, heavyMelonPredicate);
        if (found.size() > 0)
            for (Melon melon : found)
                System.out.println(melon.toString());
        else
            System.out.println("No se han encontrado melones pesados.");

        System.out.println("Lista de filtrados (Melones Europeos)");
        for (Melon melon : Filter.filterMelons(melons, melon -> melon!=null && melon.getOrigin().equalsIgnoreCase("Europe")))
            System.out.println(melon.toString());

        System.out.println("Lista de filtrados (Sandias):");
        for (Melon melon : Filter.filter(melons, melon -> melon.getType().equalsIgnoreCase("Watermelon")))
            System.out.println(melon.toString());
    }
}
