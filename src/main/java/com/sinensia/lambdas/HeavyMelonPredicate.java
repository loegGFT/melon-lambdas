package com.sinensia.lambdas;

public class HeavyMelonPredicate implements MelonPredicate {
    final int WEIGHT_THRESHOLD = 4000;

    @Override
    public boolean test(Melon melon) {
        return melon.getWeight() >= WEIGHT_THRESHOLD;
    }
}
