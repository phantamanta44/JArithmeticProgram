package io.github.phantamanta44.veryserious.jarithmeticprogram.util.iteration;

import io.github.phantamanta44.veryserious.jarithmeticprogram.util.verify.IllegalValueException;

public interface IIterationStrategyFactory<T> {

    void registerVisitor(IIterationVisitor<T> visitor);

    void setIterationProvider(Iterable<T> iterable);

    IIterationStrategy<T> instantiateStrategy() throws IllegalValueException;

}
