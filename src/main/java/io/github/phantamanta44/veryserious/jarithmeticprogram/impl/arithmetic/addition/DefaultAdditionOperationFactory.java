package io.github.phantamanta44.veryserious.jarithmeticprogram.impl.arithmetic.addition;

import io.github.phantamanta44.veryserious.jarithmeticprogram.api.arithmetic.IArithmeticOperation;
import io.github.phantamanta44.veryserious.jarithmeticprogram.api.arithmetic.IArithmeticOperationFactory;

public class DefaultAdditionOperationFactory implements IArithmeticOperationFactory {

    @Override
    public <T extends Number> IArithmeticOperation<T> instantiate() {
        return new AdditionOperation<T>();
    }

}
