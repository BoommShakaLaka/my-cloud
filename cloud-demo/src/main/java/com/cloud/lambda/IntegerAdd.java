package com.cloud.lambda;

@FunctionalInterface
public interface IntegerAdd<A, B, C> {

    C add(A a, B b);
}
