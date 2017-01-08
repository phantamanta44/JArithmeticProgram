package io.github.phantamanta44.veryserious.jarithmeticprogram.util.verify.nonnull;

import io.github.phantamanta44.veryserious.jarithmeticprogram.util.verify.IVerifier;
import io.github.phantamanta44.veryserious.jarithmeticprogram.util.verify.IllegalValueException;

public class GenericNonNullVerificationStrategy<T> implements INonNullVerificationStrategy<T> {

    @Override
    public IVerifier<T> generateVerificationSolution() {
        return new IVerifier<T>() {
            @Override
            public void testValidity(T value) throws IllegalValueException {
                try {
                    value.hashCode();
                } catch (NullPointerException e) {
                    throw new IllegalValueException(value, "Value was null!");
                }
            }
        };
    }

}
