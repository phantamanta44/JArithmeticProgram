package io.github.phantamanta44.veryserious.jarithmeticprogram.util.verify.nonnull;

public interface INonNullVerificationStrategyFactory {

    <T> INonNullVerificationStrategy<T> instantiateStrategy();

}
