package io.github.phantamanta44.veryserious.jarithmeticprogram.impl.iteration;

import io.github.phantamanta44.veryserious.jarithmeticprogram.util.iteration.IIterationStrategyFactory;
import io.github.phantamanta44.veryserious.jarithmeticprogram.util.iteration.IIterationStrategyFactoryFactory;

public class DefaultIterationStrategyFactoryFactory implements IIterationStrategyFactoryFactory {

    @Override
    public <T> IIterationStrategyFactory<T> instantiateFactory() {
        return new StandardIterationStrategyFactory<T>();
    }

}
