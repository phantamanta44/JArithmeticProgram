package io.github.phantamanta44.veryserious.jarithmeticprogram.impl;

import io.github.phantamanta44.veryserious.jarithmeticprogram.api.ArithmeticProgramService;
import io.github.phantamanta44.veryserious.jarithmeticprogram.api.arithmetic.IArithmeticOperationFactory;

public class DefaultArithmeticProgramService extends ArithmeticProgramService {

    @Override
    public <I extends Number, O extends Number> IArithmeticOperationFactory provideOperation(String operation) {
        return null; // TODO Implement
    }

}
