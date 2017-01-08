package io.github.phantamanta44.veryserious.jarithmeticprogram.impl.iteration;

import io.github.phantamanta44.veryserious.jarithmeticprogram.util.iteration.IIterationStrategy;
import io.github.phantamanta44.veryserious.jarithmeticprogram.util.iteration.IIterationStrategyFactory;
import io.github.phantamanta44.veryserious.jarithmeticprogram.util.iteration.IIterationVisitor;
import io.github.phantamanta44.veryserious.jarithmeticprogram.util.verify.IllegalValueException;

public class StandardIterationStrategyFactory<T> implements IIterationStrategyFactory<T> {

    StandardIterationStrategyContainer<T> iterationContext;

    public StandardIterationStrategyFactory() {
        iterationContext = new StandardIterationStrategyContainer<T>();
    }

    @Override
    public void registerVisitor(IIterationVisitor<T> visitor) {
        iterationContext.addIterationVisitor(visitor);
    }

    @Override
    public void setIterationProvider(Iterable<T> iterable) {
        iterationContext.setIterationProvider(iterable);
    }

    @Override
    public IIterationStrategy<T> instantiateStrategy() throws IllegalValueException {
        iterationContext.checkValidity();
        return new StandardIterationStrategy<T>(iterationContext);
    }

}
