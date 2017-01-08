package io.github.phantamanta44.veryserious.jarithmeticprogram.util.guard;

import io.github.phantamanta44.veryserious.jarithmeticprogram.util.verify.IllegalValueException;
import io.github.phantamanta44.veryserious.jarithmeticprogram.util.verify.nonnull.NonNullVerification;

public class GuardedOperations {

    private static final GuardedOperations INSTANCE = new GuardedOperations();

    public static GuardedOperations getInstance() {
        return INSTANCE;
    }

    private IGuardedOperationSetFactory implementation;

    public void bindImplementation(IGuardedOperationSetFactory implementation) {
        try {
            NonNullVerification.getInstance().verifyNonNull(this.implementation);
            throw new IllegalStateException("Guarded operation set factory already bound!");
        } catch (IllegalValueException e) {
            this.implementation = implementation;
        }
    }

    public <V> IGuardedOperationSet<V> createOperationSet() {
        try {
            NonNullVerification.getInstance().verifyNonNull(this.implementation);
            return implementation.instantiateOperationSet();
        } catch (IllegalValueException e) {
            throw new IllegalStateException("No guarded operation set factory bound!");
        }
    }

}
