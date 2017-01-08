package io.github.phantamanta44.veryserious.jarithmeticprogram.util.verify.nonnull;

public class DefaultNonNullVerificationStrategyFactory implements INonNullVerificationStrategyFactory {

    @Override
    public <T> INonNullVerificationStrategy<T> instantiateStrategy() {
        return new GenericNonNullVerificationStrategy<T>();
    }

}
