package io.github.phantamanta44.veryserious.jarithmeticprogram.api.input;

import io.github.phantamanta44.veryserious.jarithmeticprogram.util.verify.IllegalValueException;
import io.github.phantamanta44.veryserious.jarithmeticprogram.util.verify.nonnull.NonNullVerification;

public class NumeralParsing {

    private static final NumeralParsing INSTANCE = new NumeralParsing();

    public static NumeralParsing getInstance() {
        return INSTANCE;
    }

    private INumeralParsingStrategyFactoryProvider implementation;

    public void bindImplementation(INumeralParsingStrategyFactoryProvider implementation) {
        try {
            NonNullVerification.getInstance().verifyNonNull(this.implementation);
            throw new IllegalStateException("Numeral parsing strategy factory provider already bound!");
        } catch (IllegalValueException e) {
            this.implementation = implementation;
        }
    }

    public <T extends Number> INumeralParsingStrategyFactory<T> strategyFactoryFor(NumeralType<T> type) {
        try {
            NonNullVerification.getInstance().verifyNonNull(this.implementation);
            return implementation.factoryFor(type);
        } catch (IllegalValueException e) {
            throw new IllegalStateException("No numeral parsing strategy factory provider bound!");
        }
    }

}
