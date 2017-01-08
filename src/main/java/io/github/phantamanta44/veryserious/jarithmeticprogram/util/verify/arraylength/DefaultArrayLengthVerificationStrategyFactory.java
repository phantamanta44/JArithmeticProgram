package io.github.phantamanta44.veryserious.jarithmeticprogram.util.verify.arraylength;

public class DefaultArrayLengthVerificationStrategyFactory implements IArrayLengthVerificationStrategyFactory {

    private int minimumArrayLength = 0;

    @Override
    public void setMinimumArrayLength(int minimumArrayLength) {
        this.minimumArrayLength = minimumArrayLength;
    }

    @Override
    public <T> IArrayLengthVerificationStrategy<T> instantiateStrategy() {
        return new GenericArrayLengthVerificationStrategy<T>(minimumArrayLength);
    }

}
