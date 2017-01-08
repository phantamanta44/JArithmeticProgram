package io.github.phantamanta44.veryserious.jarithmeticprogram.impl.arithmetic;

import io.github.phantamanta44.veryserious.jarithmeticprogram.api.arithmetic.IArithmeticOperationFactory;
import io.github.phantamanta44.veryserious.jarithmeticprogram.impl.arithmetic.addition.DefaultAdditionOperationFactory;
import io.github.phantamanta44.veryserious.jarithmeticprogram.util.guard.*;
import io.github.phantamanta44.veryserious.jarithmeticprogram.util.verify.IllegalValueException;
import io.github.phantamanta44.veryserious.jarithmeticprogram.util.verify.equality.EqualityVerification;
import io.github.phantamanta44.veryserious.jarithmeticprogram.util.verify.nonnull.NonNullVerification;

public class DefaultArithmeticOperationFactoryFactory implements IArithmeticOperationFactoryFactory {

    private final IGuardedOperationSet<DefaultArithmeticOperationFactoryContainer> operationSet;
    private String operationName;

    public DefaultArithmeticOperationFactoryFactory() {
        this.operationSet = GuardedOperations.getInstance().createOperationSet();
        try {
            this.operationSet.registerGuardedOperation(new IGuard<DefaultArithmeticOperationFactoryContainer>() {
                @Override
                public boolean shouldFallThrough(DefaultArithmeticOperationFactoryContainer value) {
                    try {
                        EqualityVerification.getInstance().verifyEquality(value.getOperationName(), "add");
                        return false;
                    } catch (IllegalValueException e) {
                        return true;
                    }
                }
            }, new IGuardedOperation<DefaultArithmeticOperationFactoryContainer>() {
                @Override
                public void performOperation(DefaultArithmeticOperationFactoryContainer value) {
                    value.setOperationFactory(new DefaultAdditionOperationFactory());
                }
            });
        } catch (GuardCollissionException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void setOperation(String operationName) {
        this.operationName = operationName;
    }

    @Override
    public IArithmeticOperationFactory instantiateFactory() {
        try {
            NonNullVerification.getInstance().verifyNonNull(operationName);
        } catch (IllegalValueException e) {
            throw new IllegalStateException("No provided operation name!");
        }
        DefaultArithmeticOperationFactoryContainer resultContainer = new DefaultArithmeticOperationFactoryContainer(operationName);
        operationSet.resolveOperation(resultContainer);
        try {
            NonNullVerification.getInstance().verifyNonNull(resultContainer.getOperationFactory());
        } catch (IllegalValueException e) {
            return null;
        }
        return resultContainer.getOperationFactory();
    }

}
