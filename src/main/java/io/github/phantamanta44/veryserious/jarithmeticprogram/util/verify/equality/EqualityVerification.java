package io.github.phantamanta44.veryserious.jarithmeticprogram.util.verify.equality;

import io.github.phantamanta44.veryserious.jarithmeticprogram.util.verify.IVerifier;
import io.github.phantamanta44.veryserious.jarithmeticprogram.util.verify.IllegalValueException;
import io.github.phantamanta44.veryserious.jarithmeticprogram.util.verify.nonnull.NonNullVerification;

public class EqualityVerification {

    private static final EqualityVerification INSTANCE = new EqualityVerification();

    public static EqualityVerification getInstance() {
        return INSTANCE;
    }

    private IEqualityVerificationStrategyFactory implementation;

    public void bindImplementation(IEqualityVerificationStrategyFactory implementation) {
        try {
            NonNullVerification.getInstance().verifyNonNull(this.implementation);
            throw new IllegalStateException("Equality verification factory already bound!");
        } catch (IllegalValueException e) {
            this.implementation = implementation;
        }
    }

    public <A, B> void verifyEquality(A valueA, B valueB) throws IllegalValueException {
        try {
            NonNullVerification.getInstance().verifyNonNull(this.implementation);
        } catch (IllegalValueException e) {
            bindImplementation(new DefaultEqualityVerificationStrategyFactory());
        }
        IEqualityVerificationStrategy<A, B> strategy = implementation.instantiateStrategy();
        IVerifier<EqualityTestContainer<A, B>> solution = strategy.generateVerificationSolution();
        solution.testValidity(new EqualityTestContainer<A, B>(valueA, valueB));
    }

}
