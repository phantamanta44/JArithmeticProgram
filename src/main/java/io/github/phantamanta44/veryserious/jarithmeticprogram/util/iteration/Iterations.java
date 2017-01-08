package io.github.phantamanta44.veryserious.jarithmeticprogram.util.iteration;


public class Iterations {

    private static final Iterations INSTANCE = new Iterations();

    public static Iterations getInstance() {
        return INSTANCE;
    }

    private IIterationStrategyFactoryFactory implementation;

    public void bindImplementation(IIterationStrategyFactoryFactory implementation) {
        if (this.implementation == null) {
            this.implementation = implementation;
        } else {
            throw new IllegalStateException("Iteration strategy factory factory already bound!");
        }
    }

    public <T> IIterationStrategyFactory<T> retrieveStrategyFactory() {
        if (this.implementation == null) {
            throw new IllegalStateException("No iteration strategy factory factory bound!");
        }
        return implementation.instantiateFactory();
    }
    
}
