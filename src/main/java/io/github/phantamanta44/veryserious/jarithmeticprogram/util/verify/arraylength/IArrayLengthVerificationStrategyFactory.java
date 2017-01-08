package io.github.phantamanta44.veryserious.jarithmeticprogram.util.verify.arraylength;

public interface IArrayLengthVerificationStrategyFactory {

    void setMinimumArrayLength(int length);

    <T> IArrayLengthVerificationStrategy<T> instantiateStrategy();

}
