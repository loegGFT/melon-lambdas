package com.sinensia.lambdas;

@FunctionalInterface
public interface Predicate<T> {
    boolean test(T t);
}
