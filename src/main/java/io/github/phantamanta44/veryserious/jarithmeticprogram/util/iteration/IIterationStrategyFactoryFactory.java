package io.github.phantamanta44.veryserious.jarithmeticprogram.util.iteration;

public interface IIterationStrategyFactoryFactory {

    <T> IIterationStrategyFactory<T> instantiateFactory();

}
