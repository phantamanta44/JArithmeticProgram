package io.github.phantamanta44.veryserious.jarithmeticprogram.util.guard;

public interface IGuardedOperationSet<V> {

    void registerGuardedOperation(IGuard<V> guard, IGuardedOperation<V> operation) throws GuardCollissionException;

    void resolveOperation(V guardValue);

}
