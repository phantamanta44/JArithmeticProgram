package io.github.phantamanta44.veryserious.jarithmeticprogram.util.verify.numeral;

import io.github.phantamanta44.veryserious.jarithmeticprogram.util.verify.IVerifier;
import io.github.phantamanta44.veryserious.jarithmeticprogram.util.verify.IllegalValueException;

public class NumeralVerification {

    private static final NumeralVerification INSTANCE = new NumeralVerification();

    public static NumeralVerification getInstance() {
        return INSTANCE;
    }

    private INumeralVerificationStrategyFactory implementation;

    public void bindImplementation(INumeralVerificationStrategyFactory implementation) {
        if (this.implementation == null) {
            this.implementation = implementation;
        } else {
            throw new IllegalStateException("Non-null verification factory already bound!");
        }
    }

    public void verifyNumeral(String value) throws IllegalValueException {
        if (implementation == null) {
            bindImplementation(new DefaultNumeralVerificationStrategyFactory());
        }
        INumeralVerificationStrategy strategy = implementation.instantiateStrategy();
        IVerifier<String> solution = strategy.generateVerificationSolution();
        solution.testValidity(value);
    }

}
