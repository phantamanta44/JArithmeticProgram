package io.github.phantamanta44.veryserious.jarithmeticprogram.api.input;

public interface INumeralParsingStrategyFactoryProvider {

    <T extends Number> INumeralParsingStrategyFactory<T> factoryFor(NumeralType<T> type);

}
