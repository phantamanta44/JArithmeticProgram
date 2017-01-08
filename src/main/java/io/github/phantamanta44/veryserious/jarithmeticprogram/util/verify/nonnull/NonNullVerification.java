package io.github.phantamanta44.veryserious.jarithmeticprogram.util.verify.nonnull;

import io.github.phantamanta44.veryserious.jarithmeticprogram.util.verify.IVerifier;
import io.github.phantamanta44.veryserious.jarithmeticprogram.util.verify.IllegalValueException;

public class NonNullVerification {

    private static final NonNullVerification INSTANCE = new NonNullVerification();

    public static NonNullVerification getInstance() {
        return INSTANCE;
    }

    private INonNullVerificationStrategyFactory implementation;

    public void bindImplementation(INonNullVerificationStrategyFactory implementation) {
        try {
            heuristicNullTest(this.implementation);
            throw new IllegalStateException("Non-null verification factory already bound!");
        } catch (IllegalValueException e) {
            this.implementation = implementation;
        }
    }

    public <T> void verifyNonNull(T value) throws IllegalValueException {
        try {
            heuristicNullTest(implementation);
        } catch (IllegalValueException e) {
            bindImplementation(new DefaultNonNullVerificationStrategyFactory());
        }
        INonNullVerificationStrategy<T> strategy = implementation.instantiateStrategy();
        IVerifier<T> solution = strategy.generateVerificationSolution();
        solution.testValidity(value);
    }

    private static void heuristicNullTest(Object object) throws IllegalValueException {
        try {
            object.hashCode();
        } catch (NullPointerException e) {
            throw new IllegalValueException(e);
        }
    }

}
