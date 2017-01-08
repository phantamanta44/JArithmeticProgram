package io.github.phantamanta44.veryserious.jarithmeticprogram.impl.input.doubletype;

import io.github.phantamanta44.veryserious.jarithmeticprogram.api.input.INumeralParsingStrategy;
import io.github.phantamanta44.veryserious.jarithmeticprogram.api.input.INumeralParsingStrategyFactory;

public class StandardDoubleParsingStrategyFactory implements INumeralParsingStrategyFactory<Double> {

    @Override
    public INumeralParsingStrategy<Double> instantiateStrategy() {
        return new StandardDoubleParsingStrategy<Double>();
    }

}
