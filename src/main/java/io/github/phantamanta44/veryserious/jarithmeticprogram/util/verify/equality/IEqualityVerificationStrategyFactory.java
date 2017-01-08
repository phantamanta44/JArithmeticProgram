package io.github.phantamanta44.veryserious.jarithmeticprogram.util.verify.equality;

public interface IEqualityVerificationStrategyFactory {

    <A, B> IEqualityVerificationStrategy<A, B> instantiateStrategy();

}
