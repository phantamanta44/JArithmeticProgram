package io.github.phantamanta44.veryserious.jarithmeticprogram.impl.output;

import io.github.phantamanta44.veryserious.jarithmeticprogram.api.output.IProgramOutputStrategyFactory;
import io.github.phantamanta44.veryserious.jarithmeticprogram.api.output.IProgramOutputStrategy;
import io.github.phantamanta44.veryserious.jarithmeticprogram.api.output.ProgramOutputType;
import io.github.phantamanta44.veryserious.jarithmeticprogram.util.guard.*;
import io.github.phantamanta44.veryserious.jarithmeticprogram.util.verify.IllegalValueException;
import io.github.phantamanta44.veryserious.jarithmeticprogram.util.verify.equality.EqualityVerification;
import io.github.phantamanta44.veryserious.jarithmeticprogram.util.verify.nonnull.NonNullVerification;

public class DefaultProgramOutputStrategyFactory implements IProgramOutputStrategyFactory {

    private ProgramOutputType outputType;

    public DefaultProgramOutputStrategyFactory() {
        IGuardedOperationSet<ProgramOutputStrategyContainer> outputTypeOperationSet = GuardedOperations.getInstance().createOperationSet();
        try {
            outputTypeOperationSet.registerGuardedOperation(new IGuard<ProgramOutputStrategyContainer>() {
                @Override
                public boolean shouldFallThrough(ProgramOutputStrategyContainer value) {
                    try {
                        EqualityVerification.getInstance().verifyEquality(value.getStrategy(), ProgramOutputType.STANDARD_OUTPUT);
                        return false;
                    } catch (IllegalValueException e) {
                        return true;
                    }
                }
            }, new IGuardedOperation<ProgramOutputStrategyContainer>() {
                @Override
                public void performOperation(ProgramOutputStrategyContainer value) {
                    IProgramOutputStrategy strategy = new StandardProgramOutputStrategy();
                    value.setStrategy(strategy);
                }
            });
            outputTypeOperationSet.registerGuardedOperation(new IGuard<ProgramOutputStrategyContainer>() {
                @Override
                public boolean shouldFallThrough(ProgramOutputStrategyContainer value) {
                    try {
                        EqualityVerification.getInstance().verifyEquality(value.getStrategy(), ProgramOutputType.ERROR_OUTPUT);
                        return false;
                    } catch (IllegalValueException e) {
                        return true;
                    }
                }
            }, new IGuardedOperation<ProgramOutputStrategyContainer>() {
                @Override
                public void performOperation(ProgramOutputStrategyContainer value) {
                    IProgramOutputStrategy strategy = new ErrorProgramOutputStrategy();
                    value.setStrategy(strategy);
                }
            });
        } catch (GuardCollissionException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void setOutputType(ProgramOutputType outputType) {
        this.outputType = outputType;
    }

    @Override
    public IProgramOutputStrategy instantiateStrategy() {
        try {
            NonNullVerification.getInstance().verifyNonNull(outputType);
            ProgramOutputStrategyContainer outputStrategyContainer = new ProgramOutputStrategyContainer(outputType);
            NonNullVerification.getInstance().verifyNonNull(outputStrategyContainer.getStrategy());
            return outputStrategyContainer.getStrategy();
        } catch (IllegalValueException e) {
            throw new RuntimeException(e);
        }
    }

}
