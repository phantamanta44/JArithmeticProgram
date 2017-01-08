package io.github.phantamanta44.veryserious.jarithmeticprogram.api.input;

public interface INumeralParsingStrategy<T extends Number> {

    T resolveInput(String input);

}
