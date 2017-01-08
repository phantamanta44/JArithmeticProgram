package io.github.phantamanta44.veryserious.jarithmeticprogram.util.verify.numeral;

import io.github.phantamanta44.veryserious.jarithmeticprogram.util.verify.IVerifier;
import io.github.phantamanta44.veryserious.jarithmeticprogram.util.verify.IllegalValueException;
import io.github.phantamanta44.veryserious.jarithmeticprogram.util.verify.nonnull.NonNullVerification;

public class NumeralVerification {

    private static final NumeralVerification INSTANCE = new NumeralVerification();

    public static NumeralVerification getInstance() {
        return INSTANCE;
    }

    private INumeralVerificationStrategyFactory implementation;

    public void bindImplementation(INumeralVerificationStrategyFactory implementation) {
        try {
            NonNullVerification.getInstance().verifyNonNull(this.implementation);
            throw new IllegalStateException("Non-null verification factory already bound!");
        } catch (IllegalValueException e) {
            this.implementation = implementation;
        }
    }

    public void verifyNumeral(String value) throws IllegalValueException {
        try {
            NonNullVerification.getInstance().verifyNonNull(this.implementation);
        } catch (IllegalValueException e) {
            bindImplementation(new DefaultNumeralVerificationStrategyFactory());
        }
        INumeralVerificationStrategy strategy = implementation.instantiateStrategy();
        IVerifier<String> solution = strategy.generateVerificationSolution();
        solution.testValidity(value);
    }

}
