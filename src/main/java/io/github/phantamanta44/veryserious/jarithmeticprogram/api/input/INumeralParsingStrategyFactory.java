package io.github.phantamanta44.veryserious.jarithmeticprogram.api.input;

public interface INumeralParsingStrategyFactory<T extends Number> {

    INumeralParsingStrategy<T> instantiateStrategy();

}
