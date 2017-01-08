package io.github.phantamanta44.veryserious.jarithmeticprogram.util.guard;

public class GuardedOperations {

    private static final GuardedOperations INSTANCE = new GuardedOperations();

    public static GuardedOperations getInstance() {
        return INSTANCE;
    }

    public IGuardedOperationSetFactory implementation;

    public void bindImplementation(IGuardedOperationSetFactory implementation) {
        if (this.implementation == null) {
            this.implementation = implementation;
        } else {
            throw new IllegalStateException("Guarded operation set factory already bound!");
        }
    }

    public <V> IGuardedOperationSet<V> createOperationSet() {
        if (this.implementation == null) {
            throw new IllegalStateException("No guarded operation set factory bound!");
        }
        return implementation.instantiateOperationSet();
    }

}
