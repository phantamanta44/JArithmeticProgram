package io.github.phantamanta44.veryserious.jarithmeticprogram.impl.input;

import io.github.phantamanta44.veryserious.jarithmeticprogram.api.input.INumeralParsingStrategyFactory;
import io.github.phantamanta44.veryserious.jarithmeticprogram.api.input.NumeralType;

public class DefaultNumeralParsingStrategyFactoryContainer<T extends Number> {

    private final NumeralType<T> type;
    private INumeralParsingStrategyFactory<T> strategyFactory;

    public DefaultNumeralParsingStrategyFactoryContainer(NumeralType<T> type) {
        this.type = type;
    }

    public NumeralType<T> getType() {
        return type;
    }

    public INumeralParsingStrategyFactory<T> getStrategyFactory() {
        return strategyFactory;
    }

    public void setStrategyFactory(INumeralParsingStrategyFactory<T> strategyFactory) {
        this.strategyFactory = strategyFactory;
    }

}
