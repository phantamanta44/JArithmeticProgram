package io.github.phantamanta44.veryserious.jarithmeticprogram.util.verify.arraylength;

import io.github.phantamanta44.veryserious.jarithmeticprogram.util.verify.IVerifier;
import io.github.phantamanta44.veryserious.jarithmeticprogram.util.verify.IllegalValueException;

public class ArrayLengthVerification {

    private static final ArrayLengthVerification INSTANCE = new ArrayLengthVerification();

    public static ArrayLengthVerification getInstance() {
        return INSTANCE;
    }

    private IArrayLengthVerificationStrategyFactory implementation;

    public void bindImplementation(IArrayLengthVerificationStrategyFactory implementation) {
        if (this.implementation == null) {
            this.implementation = implementation;
        } else {
            throw new IllegalStateException("Non-null verification factory already bound!");
        }
    }

    public <T> void verifyArrayLength(T[] value, int length) throws IllegalValueException {
        if (implementation == null) {
            bindImplementation(new DefaultArrayLengthVerificationStrategyFactory());
        }
        implementation.setMinimumArrayLength(length);
        IArrayLengthVerificationStrategy<T> strategy = implementation.instantiateStrategy();
        IVerifier<T[]> solution = strategy.generateVerificationSolution();
        solution.testValidity(value);
    }

}
