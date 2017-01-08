package io.github.phantamanta44.veryserious.jarithmeticprogram.util.verify.equality;

import io.github.phantamanta44.veryserious.jarithmeticprogram.util.verify.IVerifier;
import io.github.phantamanta44.veryserious.jarithmeticprogram.util.verify.IllegalValueException;

public class EqualityVerification {

    private static final EqualityVerification INSTANCE = new EqualityVerification();

    public static EqualityVerification getInstance() {
        return INSTANCE;
    }

    private IEqualityVerificationStrategyFactory implementation;

    public void bindImplementation(IEqualityVerificationStrategyFactory implementation) {
        if (this.implementation == null) {
            this.implementation = implementation;
        } else {
            throw new IllegalStateException("Equality verification factory already bound!");
        }
    }

    public <A, B> void verifyEquality(A valueA, B valueB) throws IllegalValueException {
        if (implementation == null) {
            bindImplementation(new DefaultEqualityVerificationStrategyFactory());
        }
        IEqualityVerificationStrategy<A, B> strategy = implementation.instantiateStrategy();
        IVerifier<EqualityTestContainer<A, B>> solution = strategy.generateVerificationSolution();
        solution.testValidity(new EqualityTestContainer<A, B>(valueA, valueB));
    }

}
