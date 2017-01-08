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
        if (this.implementation == null) {
            this.implementation = implementation;
        } else {
            throw new IllegalStateException("Non-null verification factory already bound!");
        }
    }

    public <T> void verifyNonNull(T value) throws IllegalValueException {
        if (implementation == null) {
            bindImplementation(new DefaultNonNullVerificationStrategyFactory());
        }
        INonNullVerificationStrategy<T> strategy = implementation.instantiateStrategy();
        IVerifier<T> solution = strategy.generateVerificationSolution();
        solution.testValidity(value);
    }

}
