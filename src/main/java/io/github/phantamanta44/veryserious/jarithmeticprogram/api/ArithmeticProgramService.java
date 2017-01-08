package io.github.phantamanta44.veryserious.jarithmeticprogram.api;

import io.github.phantamanta44.veryserious.jarithmeticprogram.api.arithmetic.IArithmeticOperationFactory;

import java.util.Iterator;
import java.util.ServiceLoader;

public abstract class ArithmeticProgramService {

    private static final ServiceLoader<ArithmeticProgramService> implementationLoader = ServiceLoader.load(ArithmeticProgramService.class);

    public static <I extends Number, O extends Number> IArithmeticOperationFactory getOperation(String operationName) {
        Iterator<ArithmeticProgramService> iterator = implementationLoader.iterator();
        while (iterator.hasNext()) {
            ArithmeticProgramService service = iterator.next();
            IArithmeticOperationFactory operation = service.provideOperation(operationName);
            if (operation != null) {
                return operation;
            }
        }
        throw new UnsupportedOperationException("The requested operation type is not supported!");
    }

    public abstract <I extends Number, O extends Number> IArithmeticOperationFactory provideOperation(String operation);

}
