package io.github.phantamanta44.veryserious.jarithmeticprogram.util.verify.arraylength;

import io.github.phantamanta44.veryserious.jarithmeticprogram.util.verify.IVerifier;
import io.github.phantamanta44.veryserious.jarithmeticprogram.util.verify.IllegalValueException;
import io.github.phantamanta44.veryserious.jarithmeticprogram.util.verify.nonnull.NonNullVerification;

public class ArrayLengthVerification {

    private static final ArrayLengthVerification INSTANCE = new ArrayLengthVerification();

    public static ArrayLengthVerification getInstance() {
        return INSTANCE;
    }

    private IArrayLengthVerificationStrategyFactory implementation;

    public void bindImplementation(IArrayLengthVerificationStrategyFactory implementation) {
        try {
            NonNullVerification.getInstance().verifyNonNull(this.implementation);
            throw new IllegalStateException("Non-null verification factory already bound!");
        } catch (IllegalValueException e) {
            this.implementation = implementation;
        }
    }

    public <T> void verifyArrayLength(T[] value, int length) throws IllegalValueException {
        try {
            NonNullVerification.getInstance().verifyNonNull(this.implementation);
        } catch (IllegalValueException e) {
            bindImplementation(new DefaultArrayLengthVerificationStrategyFactory());
        }
        implementation.setMinimumArrayLength(length);
        IArrayLengthVerificationStrategy<T> strategy = implementation.instantiateStrategy();
        IVerifier<T[]> solution = strategy.generateVerificationSolution();
        solution.testValidity(value);
    }

}
