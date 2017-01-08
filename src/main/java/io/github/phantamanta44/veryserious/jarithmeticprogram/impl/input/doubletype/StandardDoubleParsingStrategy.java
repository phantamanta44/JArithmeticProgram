package io.github.phantamanta44.veryserious.jarithmeticprogram.impl.input.doubletype;

import io.github.phantamanta44.veryserious.jarithmeticprogram.api.input.INumeralParsingStrategy;

public class StandardDoubleParsingStrategy<T> implements INumeralParsingStrategy<Double> {

    @Override
    public Double resolveInput(String input) {
        return Double.parseDouble(input); // TODO Enterprise-ify
    }

}
