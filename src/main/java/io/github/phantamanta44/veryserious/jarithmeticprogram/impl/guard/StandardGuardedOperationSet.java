package io.github.phantamanta44.veryserious.jarithmeticprogram.impl.guard;

import io.github.phantamanta44.veryserious.jarithmeticprogram.util.guard.GuardCollissionException;
import io.github.phantamanta44.veryserious.jarithmeticprogram.util.guard.IGuard;
import io.github.phantamanta44.veryserious.jarithmeticprogram.util.guard.IGuardedOperation;
import io.github.phantamanta44.veryserious.jarithmeticprogram.util.guard.IGuardedOperationSet;
import io.github.phantamanta44.veryserious.jarithmeticprogram.util.verify.IllegalValueException;
import io.github.phantamanta44.veryserious.jarithmeticprogram.util.verify.nonnull.NonNullVerification;

public class StandardGuardedOperationSet<V> implements IGuardedOperationSet<V> {

    private GuardedOperationLinkedNode<V> guards = null;

    @Override
    public void registerGuardedOperation(IGuard<V> guard, IGuardedOperation<V> operation) throws GuardCollissionException {
        GuardedOperationLinkedNode<V> newNode = new GuardedOperationLinkedNode<V>(guard, operation);
        try {
            NonNullVerification.getInstance().verifyNonNull(guards);
            guards.appendNode(newNode);
        } catch (IllegalValueException e) {
            guards = newNode;
        }
    }

    @Override
    public void resolveOperation(V guardValue) {
        try {
            NonNullVerification.getInstance().verifyNonNull(guards);
            guards.attemptExecution(guardValue);
        } catch (IllegalValueException ignored) {
            // NO-OP
        }
    }

}
