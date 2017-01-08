package io.github.phantamanta44.veryserious.jarithmeticprogram.impl.arithmetic.addition;

import io.github.phantamanta44.veryserious.jarithmeticprogram.api.arithmetic.IArithmeticOperation;

public class AdditionOperation<T extends Number> implements IArithmeticOperation<T> {

    @Override
    @SuppressWarnings("unchecked")
    public T applyArithmeticOperation(T valueA, T valueB) {
        double sum = valueA.doubleValue() + valueB.doubleValue(); // TODO Enterprise-ify
        return (T)Double.valueOf(sum);
    }

}
