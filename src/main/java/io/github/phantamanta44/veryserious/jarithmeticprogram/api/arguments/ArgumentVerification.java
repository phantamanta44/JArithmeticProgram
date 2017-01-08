package io.github.phantamanta44.veryserious.jarithmeticprogram.api.arguments;

import io.github.phantamanta44.veryserious.jarithmeticprogram.impl.arguments.DefaultArgumentVerificationStrategyFactory;
import io.github.phantamanta44.veryserious.jarithmeticprogram.util.verify.IVerifier;
import io.github.phantamanta44.veryserious.jarithmeticprogram.util.verify.IllegalValueException;

public class ArgumentVerification {

    private static final ArgumentVerification INSTANCE = new ArgumentVerification();

    public static ArgumentVerification getInstance() {
        return INSTANCE;
    }

    private IArgumentVerificationStrategyFactory implementation;

    public void bindImplementation(IArgumentVerificationStrategyFactory implementation) {
        if (this.implementation == null) {
            this.implementation = implementation;
        } else {
            throw new IllegalStateException("Argument verification factory already bound!");
        }
    }

    public void verifyArguments(String[] args) throws IllegalValueException {
        if (implementation == null) {
            bindImplementation(new DefaultArgumentVerificationStrategyFactory());
        }
        IArgumentVerificationStrategy strategy = implementation.instantiateStrategy();
        IVerifier<String[]> solution = strategy.generateVerificationSolution();
        solution.testValidity(args);
    }

}
