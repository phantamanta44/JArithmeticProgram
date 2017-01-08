package io.github.phantamanta44.veryserious.jarithmeticprogram.util.guard;

public interface IGuard<V> {

    boolean shouldFallThrough(V value);

}
