package io.github.phantamanta44.veryserious.jarithmeticprogram.impl.iteration.singlevisitor;

import io.github.phantamanta44.veryserious.jarithmeticprogram.util.iteration.IIterationStrategyFactory;
import io.github.phantamanta44.veryserious.jarithmeticprogram.util.iteration.IIterationStrategyFactoryFactory;

public class SingleVisitorIterationStrategyFactoryFactory implements IIterationStrategyFactoryFactory {

    private static final SingleVisitorIterationStrategyFactoryFactory INSTANCE = new SingleVisitorIterationStrategyFactoryFactory();

    public static SingleVisitorIterationStrategyFactoryFactory getInstance() {
        return INSTANCE;
    }

    private SingleVisitorIterationStrategyFactoryFactory() {
        // NO-OP
    }

    @Override
    public <T> IIterationStrategyFactory<T> instantiateFactory() {
        return new SingleVisitorIterationStrategyFactory<T>();
    }

}
