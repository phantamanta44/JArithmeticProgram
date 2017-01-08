package io.github.phantamanta44.veryserious.jarithmeticprogram.impl.iteration.singlevisitor;

import io.github.phantamanta44.veryserious.jarithmeticprogram.util.iteration.IIterationStrategy;
import io.github.phantamanta44.veryserious.jarithmeticprogram.util.iteration.IIterationStrategyFactory;
import io.github.phantamanta44.veryserious.jarithmeticprogram.util.iteration.IIterationVisitor;
import io.github.phantamanta44.veryserious.jarithmeticprogram.util.verify.IllegalValueException;

public class SingleVisitorIterationStrategyFactory<T> implements IIterationStrategyFactory<T> {

    private final SingleVisitorIterationStrategyContext<T> iterationContext;

    public SingleVisitorIterationStrategyFactory() {
        iterationContext = new SingleVisitorIterationStrategyContext<T>();
    }

    @Override
    public void registerVisitor(IIterationVisitor<T> visitor) {
        iterationContext.setIterationVisitor(visitor);
    }

    @Override
    public void setIterationProvider(Iterable<T> iterable) {
        iterationContext.setIterationProvider(iterable);
    }

    @Override
    public IIterationStrategy<T> instantiateStrategy() throws IllegalValueException {
        iterationContext.checkValidity();
        return new SingleVisitorIterationStrategy<T>(iterationContext);
    }

}
