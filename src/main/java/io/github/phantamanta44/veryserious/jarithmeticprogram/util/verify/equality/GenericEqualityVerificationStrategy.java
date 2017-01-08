package io.github.phantamanta44.veryserious.jarithmeticprogram.util.verify.equality;

import io.github.phantamanta44.veryserious.jarithmeticprogram.util.verify.IVerifier;
import io.github.phantamanta44.veryserious.jarithmeticprogram.util.verify.IllegalValueException;

public class GenericEqualityVerificationStrategy<A, B> implements IEqualityVerificationStrategy<A, B> {

    @Override
    public IVerifier<EqualityTestContainer<A, B>> generateVerificationSolution() {
        return new IVerifier<EqualityTestContainer<A, B>>() {
            @Override
            public void testValidity(EqualityTestContainer<A, B> value) throws IllegalValueException {
                if (!value.valueA.equals(value.valueB)) {
                    throw new IllegalValueException(value, "Values are not equal!");
                }
            }
        };
    }

}
