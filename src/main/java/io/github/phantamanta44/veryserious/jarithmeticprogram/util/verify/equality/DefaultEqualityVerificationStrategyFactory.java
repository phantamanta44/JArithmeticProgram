package io.github.phantamanta44.veryserious.jarithmeticprogram.util.verify.equality;

public class DefaultEqualityVerificationStrategyFactory implements IEqualityVerificationStrategyFactory {

    @Override
    public <A, B> IEqualityVerificationStrategy<A, B> instantiateStrategy() {
        return new GenericEqualityVerificationStrategy<A, B>();
    }

}
