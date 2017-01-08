package io.github.phantamanta44.veryserious.jarithmeticprogram.util.iteration;


import io.github.phantamanta44.veryserious.jarithmeticprogram.util.verify.IllegalValueException;
import io.github.phantamanta44.veryserious.jarithmeticprogram.util.verify.nonnull.NonNullVerification;

public class Iterations {

    private static final Iterations INSTANCE = new Iterations();

    public static Iterations getInstance() {
        return INSTANCE;
    }

    private IIterationStrategyFactoryFactory implementation;

    public void bindImplementation(IIterationStrategyFactoryFactory implementation) {
        try {
            NonNullVerification.getInstance().verifyNonNull(this.implementation);
            throw new IllegalStateException("Iteration strategy factory factory already bound!");
        } catch (IllegalValueException e) {
            this.implementation = implementation;
        }
    }

    public <T> IIterationStrategyFactory<T> retrieveStrategyFactory() {
        try {
            NonNullVerification.getInstance().verifyNonNull(this.implementation);
            return implementation.instantiateFactory();
        } catch (IllegalValueException e) {
            throw new IllegalStateException("No iteration strategy factory factory bound!");
        }
    }
    
}
