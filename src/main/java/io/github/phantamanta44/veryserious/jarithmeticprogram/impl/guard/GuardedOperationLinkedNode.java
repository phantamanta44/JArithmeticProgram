package io.github.phantamanta44.veryserious.jarithmeticprogram.impl.guard;

import io.github.phantamanta44.veryserious.jarithmeticprogram.util.guard.IGuard;
import io.github.phantamanta44.veryserious.jarithmeticprogram.util.guard.IGuardedOperation;
import io.github.phantamanta44.veryserious.jarithmeticprogram.util.verify.IllegalValueException;
import io.github.phantamanta44.veryserious.jarithmeticprogram.util.verify.nonnull.NonNullVerification;

public class GuardedOperationLinkedNode<V> {

    private final IGuard<V> guard;
    private final IGuardedOperation<V> guardedOperation;
    private GuardedOperationLinkedNode<V> nextNode = null;

    public GuardedOperationLinkedNode(IGuard<V> guard, IGuardedOperation<V> guardedOperation) {
        this.guard = guard;
        this.guardedOperation = guardedOperation;
    }

    public void attemptExecution(V value) {
        if (guard.shouldFallThrough(value)) {
            try {
                NonNullVerification.getInstance().verifyNonNull(nextNode);
                nextNode.attemptExecution(value);
            } catch (IllegalValueException ignored) {
                // NO-OP
                System.out.println("there was no next guard!");
                new Exception().printStackTrace(System.out);
            }
        } else {
            guardedOperation.performOperation(value);
        }
    }

    public void appendNode(GuardedOperationLinkedNode<V> newNode) {
        try {
            NonNullVerification.getInstance().verifyNonNull(nextNode);
        } catch (IllegalValueException e) {
            nextNode = newNode;
        }
    }

    public GuardedOperationLinkedNode<V> getLastNode() {
        try {
            NonNullVerification.getInstance().verifyNonNull(nextNode);
            return nextNode.getLastNode();
        } catch (IllegalValueException e) {
            return this;
        }
    }

}
