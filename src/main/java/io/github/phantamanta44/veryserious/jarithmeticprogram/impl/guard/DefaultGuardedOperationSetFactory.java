package io.github.phantamanta44.veryserious.jarithmeticprogram.impl.guard;

import io.github.phantamanta44.veryserious.jarithmeticprogram.util.guard.IGuardedOperationSet;
import io.github.phantamanta44.veryserious.jarithmeticprogram.util.guard.IGuardedOperationSetFactory;

public class DefaultGuardedOperationSetFactory implements IGuardedOperationSetFactory {

    @Override
    public <V> IGuardedOperationSet<V> instantiateOperationSet() {
        return new StandardGuardedOperationSet<V>();
    }

}
