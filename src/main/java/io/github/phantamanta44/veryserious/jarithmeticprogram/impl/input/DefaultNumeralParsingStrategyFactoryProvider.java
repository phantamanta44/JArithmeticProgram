package io.github.phantamanta44.veryserious.jarithmeticprogram.impl.input;

import io.github.phantamanta44.veryserious.jarithmeticprogram.api.input.INumeralParsingStrategyFactory;
import io.github.phantamanta44.veryserious.jarithmeticprogram.api.input.INumeralParsingStrategyFactoryProvider;
import io.github.phantamanta44.veryserious.jarithmeticprogram.api.input.NumeralType;
import io.github.phantamanta44.veryserious.jarithmeticprogram.impl.input.doubletype.StandardDoubleParsingStrategyFactory;
import io.github.phantamanta44.veryserious.jarithmeticprogram.util.guard.*;
import io.github.phantamanta44.veryserious.jarithmeticprogram.util.verify.IllegalValueException;
import io.github.phantamanta44.veryserious.jarithmeticprogram.util.verify.equality.EqualityVerification;
import io.github.phantamanta44.veryserious.jarithmeticprogram.util.verify.nonnull.NonNullVerification;

public class DefaultNumeralParsingStrategyFactoryProvider implements INumeralParsingStrategyFactoryProvider {

    private final IGuardedOperationSet<DefaultNumeralParsingStrategyFactoryContainer> factoryOperationSet;

    @SuppressWarnings("unchecked")
    public DefaultNumeralParsingStrategyFactoryProvider() {
        factoryOperationSet = GuardedOperations.getInstance().createOperationSet();
        try {
            factoryOperationSet.registerGuardedOperation(new IGuard<DefaultNumeralParsingStrategyFactoryContainer>() {
                @Override
                public boolean shouldFallThrough(DefaultNumeralParsingStrategyFactoryContainer value) {
                    try {
                        EqualityVerification.getInstance().verifyEquality(value.getType(), NumeralType.DOUBLE_NUMERAL_TYPE);
                        return false;
                    } catch (IllegalValueException e) {
                        return true;
                    }
                }
            }, new IGuardedOperation<DefaultNumeralParsingStrategyFactoryContainer>() {
                @Override
                public void performOperation(DefaultNumeralParsingStrategyFactoryContainer value) {
                    value.setStrategyFactory(new StandardDoubleParsingStrategyFactory());
                }
            }); // TODO Float, integer parsing?
        } catch (GuardCollissionException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public <T extends Number> INumeralParsingStrategyFactory<T> factoryFor(NumeralType<T> type) {
        DefaultNumeralParsingStrategyFactoryContainer<T> resultContainer = new DefaultNumeralParsingStrategyFactoryContainer<T>(type);
        factoryOperationSet.resolveOperation(resultContainer);
        try {
            NonNullVerification.getInstance().verifyNonNull(resultContainer.getStrategyFactory());
            return resultContainer.getStrategyFactory();
        } catch (IllegalValueException e) {
            throw new UnsupportedOperationException("No implementation for numeral type: " + type.getPrimitiveType().toString());
        }
    }

}
