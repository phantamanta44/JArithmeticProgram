package io.github.phantamanta44.veryserious.jarithmeticprogram.util.guard;

public interface IGuardedOperationSetFactory {

    <V> IGuardedOperationSet<V> instantiateOperationSet();

}
