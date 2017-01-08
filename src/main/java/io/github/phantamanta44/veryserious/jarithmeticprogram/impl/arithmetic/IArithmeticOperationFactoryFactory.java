package io.github.phantamanta44.veryserious.jarithmeticprogram.impl.arithmetic;

import io.github.phantamanta44.veryserious.jarithmeticprogram.api.arithmetic.IArithmeticOperationFactory;

public interface IArithmeticOperationFactoryFactory {

    void setOperation(String operationName);

    IArithmeticOperationFactory instantiateFactory();

}
