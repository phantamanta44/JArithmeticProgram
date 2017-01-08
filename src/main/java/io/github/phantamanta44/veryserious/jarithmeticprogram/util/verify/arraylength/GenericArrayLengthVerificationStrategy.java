package io.github.phantamanta44.veryserious.jarithmeticprogram.util.verify.arraylength;

import io.github.phantamanta44.veryserious.jarithmeticprogram.util.verify.IVerifier;
import io.github.phantamanta44.veryserious.jarithmeticprogram.util.verify.IllegalValueException;

public class GenericArrayLengthVerificationStrategy<T> implements IArrayLengthVerificationStrategy<T> {

    private final int minimumArrayLength;

    public GenericArrayLengthVerificationStrategy(int minimumArrayLength) {
        this.minimumArrayLength = minimumArrayLength;
    }

    @Override
    public IVerifier<T[]> generateVerificationSolution() {
        return new IVerifier<T[]>() {
            @Override
            public void testValidity(T[] value) throws IllegalValueException {
                if (minimumArrayLength - value.length > 0) {
                    throw new IllegalValueException(value, "Array does not have enough elements!");
                }
            }
        };
    }

}
