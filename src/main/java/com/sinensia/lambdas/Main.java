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

        for (int i = 0; i < melons.size(); ++i) {
            System.out.println(melons.get(i).toString());
        }

        System.out.println("Lista de filtrados (Bailan):");
        List<Melon> bailan = Filter.filterByType(melons, "bailan");
        if (bailan.size() > 0)
            for (Melon melon : bailan)
                System.out.println(melon.toString());
        else
            System.out.println("No se han encontrado melones Bailan.");

        System.out.println("Lista de filtrados (Peso Exacto):");
        List<Melon> peso = Filter.filterByWeightExact(melons, 1200);
        if (peso.size() > 0)
            for (Melon melon : peso)
                System.out.println(melon.toString());
        else
            System.out.println("No se han encontrado melones que pesan 1200g.");

        System.out.println("Lista de filtrados (Peso Exacto o Superior):");
        List<Melon> peso2 = Filter.filterByWeightExactOrMore(melons, 1200);
        if (peso2.size() > 0)
            for (Melon melon : peso2)
                System.out.println(melon.toString());
        else
            System.out.println("No se han encontrado melones que pesan 1200g o mas.");

        System.out.println("Lista de filtrados (Peso Exacto o Inferior):");
        List<Melon> peso3 = Filter.filterByWeightExactOrLess(melons, 1200);
        if (peso3.size() > 0)
            for (Melon melon : peso3)
                System.out.println(melon.toString());
        else
            System.out.println("No se han encontrado melones que pesan 1200g o menos.");
    }
}
