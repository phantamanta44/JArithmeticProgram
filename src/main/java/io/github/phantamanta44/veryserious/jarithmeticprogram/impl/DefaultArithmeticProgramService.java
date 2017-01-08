package io.github.phantamanta44.veryserious.jarithmeticprogram.impl;

import io.github.phantamanta44.veryserious.jarithmeticprogram.api.ArithmeticProgramService;
import io.github.phantamanta44.veryserious.jarithmeticprogram.api.arithmetic.IArithmeticOperationFactory;
import io.github.phantamanta44.veryserious.jarithmeticprogram.impl.arithmetic.DefaultArithmeticOperationFactoryFactory;
import io.github.phantamanta44.veryserious.jarithmeticprogram.impl.arithmetic.IArithmeticOperationFactoryFactory;

public class DefaultArithmeticProgramService extends ArithmeticProgramService {

    private final IArithmeticOperationFactoryFactory operationFactoryFactory;

    public DefaultArithmeticProgramService() {
        this.operationFactoryFactory = new DefaultArithmeticOperationFactoryFactory();
    }

    @Override
    public IArithmeticOperationFactory provideOperation(String operation) {
        operationFactoryFactory.setOperation(operation);
        return operationFactoryFactory.instantiateFactory();
    }

}
