package io.github.phantamanta44.veryserious.jarithmeticprogram.impl;

import io.github.phantamanta44.veryserious.jarithmeticprogram.api.ArithmeticProgramService;
import io.github.phantamanta44.veryserious.jarithmeticprogram.api.arguments.ArgumentVerification;
import io.github.phantamanta44.veryserious.jarithmeticprogram.api.arithmetic.IArithmeticOperation;
import io.github.phantamanta44.veryserious.jarithmeticprogram.api.arithmetic.IArithmeticOperationFactory;
import io.github.phantamanta44.veryserious.jarithmeticprogram.api.output.IProgramOutputStrategy;
import io.github.phantamanta44.veryserious.jarithmeticprogram.api.output.IProgramOutputStrategyFactory;
import io.github.phantamanta44.veryserious.jarithmeticprogram.api.output.ProgramOutputType;
import io.github.phantamanta44.veryserious.jarithmeticprogram.impl.guard.DefaultGuardedOperationSetFactory;
import io.github.phantamanta44.veryserious.jarithmeticprogram.impl.iteration.DefaultIterationStrategyFactoryFactory;
import io.github.phantamanta44.veryserious.jarithmeticprogram.impl.output.DefaultProgramOutputStrategyFactory;
import io.github.phantamanta44.veryserious.jarithmeticprogram.util.guard.GuardedOperations;
import io.github.phantamanta44.veryserious.jarithmeticprogram.util.iteration.Iterations;
import io.github.phantamanta44.veryserious.jarithmeticprogram.util.verify.IllegalValueException;

import java.io.IOException;

public class Main {

    private static final Main INSTANCE = new Main();

    public static void main(String[] args) {
        GuardedOperations.getInstance().bindImplementation(new DefaultGuardedOperationSetFactory());
        Iterations.getInstance().bindImplementation(new DefaultIterationStrategyFactoryFactory());
        INSTANCE.doArithmetic(args);
    }

    private final IProgramOutputStrategy standardOutputStrategy, errorOutputStrategy;

    public Main() {
        IProgramOutputStrategyFactory programOutputStrategyFactory = new DefaultProgramOutputStrategyFactory();
        programOutputStrategyFactory.setOutputType(ProgramOutputType.STANDARD_OUTPUT);
        this.standardOutputStrategy = programOutputStrategyFactory.instantiateStrategy();
        programOutputStrategyFactory.setOutputType(ProgramOutputType.ERROR_OUTPUT);
        this.errorOutputStrategy = programOutputStrategyFactory.instantiateStrategy();
    }

    public void doArithmetic(String[] args) {
        try {
            ArgumentVerification argumentVerifier = ArgumentVerification.getInstance();
            argumentVerifier.verifyArguments(args);
        } catch (IllegalValueException e) {
            try {
                errorOutputStrategy.performTextualOutputSolution(e.getMessage());
            } catch (IOException e2) {
                throw new RuntimeException(e2);
            }
        }
        try {
            IArithmeticOperationFactory operationFactory = ArithmeticProgramService.getOperation(args[0]);
            IArithmeticOperation<Double, Double> operation = operationFactory.instantiate();
            // TODO Parse input as a double
            // TODO Do arithmetic
            // TODO Output result
        } catch (UnsupportedOperationException e) {
            try {
                errorOutputStrategy.performTextualOutputSolution(e.getMessage());
            } catch (IOException e2) {
                throw new RuntimeException(e2);
            }
        }
    }

}
