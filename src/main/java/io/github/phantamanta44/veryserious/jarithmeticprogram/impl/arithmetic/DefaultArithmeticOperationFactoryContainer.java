package io.github.phantamanta44.veryserious.jarithmeticprogram.impl.arithmetic;

import io.github.phantamanta44.veryserious.jarithmeticprogram.api.arithmetic.IArithmeticOperationFactory;

public class DefaultArithmeticOperationFactoryContainer {

    private final String operationName;
    private IArithmeticOperationFactory operationFactory;

    public DefaultArithmeticOperationFactoryContainer(String operationName) {
        this.operationName = operationName;
    }

    public String getOperationName() {
        return operationName;
    }

    public IArithmeticOperationFactory getOperationFactory() {
        return operationFactory;
    }

    public void setOperationFactory(IArithmeticOperationFactory operationFactory) {
        this.operationFactory = operationFactory;
    }

}
