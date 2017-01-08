package io.github.phantamanta44.veryserious.jarithmeticprogram.api;

import io.github.phantamanta44.veryserious.jarithmeticprogram.api.arithmetic.IArithmeticOperationFactory;
import io.github.phantamanta44.veryserious.jarithmeticprogram.impl.arithmetic.MutableArithmeticOperationFactoryWrapper;
import io.github.phantamanta44.veryserious.jarithmeticprogram.util.iteration.*;
import io.github.phantamanta44.veryserious.jarithmeticprogram.util.verify.IllegalValueException;
import io.github.phantamanta44.veryserious.jarithmeticprogram.util.verify.nonnull.NonNullVerification;

import java.util.ServiceLoader;

public abstract class ArithmeticProgramService {

    private static final ServiceLoader<ArithmeticProgramService> implementationLoader = ServiceLoader.load(ArithmeticProgramService.class);

    public static IArithmeticOperationFactory getOperation(final String operationName) {
        final NonNullVerification nonNullVerifier = NonNullVerification.getInstance();
        IIterationStrategyFactory<ArithmeticProgramService> iterationStrategyFactoryFactory = Iterations.getInstance().retrieveStrategyFactory();
        final MutableArithmeticOperationFactoryWrapper resultContainer = new MutableArithmeticOperationFactoryWrapper();
        iterationStrategyFactoryFactory.registerVisitor(new IIterationVisitor<ArithmeticProgramService>() {
            @Override
            public void visit(ArithmeticProgramService service) {
                IArithmeticOperationFactory operationFactory = service.provideOperation(operationName);
                try {
                    nonNullVerifier.verifyNonNull(operationFactory);
                    resultContainer.setOperationFactory(operationFactory);
                    throw new IterationExitException();
                } catch (IllegalValueException ignored) {
                    // NO-OP
                }
            }
        });
        iterationStrategyFactoryFactory.setIterationProvider(implementationLoader);
        try {
            IIterationStrategy<ArithmeticProgramService> iterationStrategy = iterationStrategyFactoryFactory.instantiateStrategy();
            iterationStrategy.performIterationSolution();
        } catch (IllegalValueException e) {
            throw new RuntimeException(e);
        }
        try {
            nonNullVerifier.verifyNonNull(resultContainer.getOperationFactory());
            return resultContainer.getOperationFactory();
        } catch (IllegalValueException e) {
            throw new UnsupportedOperationException("The requested operation type is not supported!");
        }
    }

    public abstract IArithmeticOperationFactory provideOperation(String operation);

}
