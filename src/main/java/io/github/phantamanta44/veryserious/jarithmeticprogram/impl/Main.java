package io.github.phantamanta44.veryserious.jarithmeticprogram.impl;

import io.github.phantamanta44.veryserious.jarithmeticprogram.api.ArithmeticProgramService;
import io.github.phantamanta44.veryserious.jarithmeticprogram.api.arguments.ArgumentVerification;
import io.github.phantamanta44.veryserious.jarithmeticprogram.api.arithmetic.IArithmeticOperation;
import io.github.phantamanta44.veryserious.jarithmeticprogram.api.arithmetic.IArithmeticOperationFactory;
import io.github.phantamanta44.veryserious.jarithmeticprogram.api.input.*;
import io.github.phantamanta44.veryserious.jarithmeticprogram.api.output.IProgramOutputStrategy;
import io.github.phantamanta44.veryserious.jarithmeticprogram.api.output.IProgramOutputStrategyFactory;
import io.github.phantamanta44.veryserious.jarithmeticprogram.api.output.ProgramOutputType;
import io.github.phantamanta44.veryserious.jarithmeticprogram.impl.guard.DefaultGuardedOperationSetFactory;
import io.github.phantamanta44.veryserious.jarithmeticprogram.impl.input.DefaultNumeralParsingStrategyFactoryProvider;
import io.github.phantamanta44.veryserious.jarithmeticprogram.impl.iteration.DefaultIterationStrategyFactoryFactory;
import io.github.phantamanta44.veryserious.jarithmeticprogram.impl.output.DefaultProgramOutputStrategyFactory;
import io.github.phantamanta44.veryserious.jarithmeticprogram.util.guard.GuardedOperations;
import io.github.phantamanta44.veryserious.jarithmeticprogram.util.iteration.Iterations;
import io.github.phantamanta44.veryserious.jarithmeticprogram.util.verify.IllegalValueException;

import java.io.IOException;

public class Main {

    private static Main INSTANCE = new Main();

    public static void main(String[] args) {
        GuardedOperations.getInstance().bindImplementation(new DefaultGuardedOperationSetFactory());
        Iterations.getInstance().bindImplementation(new DefaultIterationStrategyFactoryFactory());
        NumeralParsing.getInstance().bindImplementation(new DefaultNumeralParsingStrategyFactoryProvider());
        INSTANCE.initializeOutput();
        INSTANCE.doArithmetic(args);
    }

    private IProgramOutputStrategy standardOutputStrategy, errorOutputStrategy;

    public void initializeOutput() {
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
            Runtime.getRuntime().exit(1);
        }
        try {
            IArithmeticOperationFactory operationFactory = ArithmeticProgramService.getOperation(args[0]);
            IArithmeticOperation<Double> operation = operationFactory.instantiate();
            INumeralParsingStrategyFactory<Double> parsingStrategyFactoryProvider = NumeralParsing.getInstance().strategyFactoryFor(NumeralType.DOUBLE_NUMERAL_TYPE);
            INumeralParsingStrategy<Double> parsingStrategy = parsingStrategyFactoryProvider.instantiateStrategy();
            Double firstParsedArgument = parsingStrategy.resolveInput(args[1]);
            Double secondParsedArgument = parsingStrategy.resolveInput(args[2]);
            Double resultantValue = operation.applyArithmeticOperation(firstParsedArgument, secondParsedArgument);
            // TODO Enterprise-quality double stringification
            standardOutputStrategy.performTextualOutputSolution(resultantValue.toString());
        } catch (UnsupportedOperationException e) {
            try {
                errorOutputStrategy.performTextualOutputSolution(e.getMessage());
            } catch (IOException e2) {
                throw new RuntimeException(e2);
            }
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }

}
