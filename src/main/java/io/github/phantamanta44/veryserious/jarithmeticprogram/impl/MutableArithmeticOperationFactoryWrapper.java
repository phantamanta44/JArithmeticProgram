package io.github.phantamanta44.veryserious.jarithmeticprogram.impl;

import io.github.phantamanta44.veryserious.jarithmeticprogram.api.arithmetic.IArithmeticOperationFactory;

public class MutableArithmeticOperationFactoryWrapper {

    private IArithmeticOperationFactory operationFactory;

    public MutableArithmeticOperationFactoryWrapper() {
        this(null);
    }

    public MutableArithmeticOperationFactoryWrapper(IArithmeticOperationFactory operationFactory) {
        this.operationFactory = operationFactory;
    }

    public IArithmeticOperationFactory getOperationFactory() {
        return operationFactory;
    }

    public void setOperationFactory(IArithmeticOperationFactory operationFactory) {
        this.operationFactory = operationFactory;
    }

}
