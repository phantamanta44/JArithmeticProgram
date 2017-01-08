package io.github.phantamanta44.veryserious.jarithmeticprogram.impl.iteration.singlevisitor;

import io.github.phantamanta44.veryserious.jarithmeticprogram.util.iteration.IIterationStrategy;
import io.github.phantamanta44.veryserious.jarithmeticprogram.util.iteration.IterationExitException;

import java.util.Iterator;

public class SingleVisitorIterationStrategy<T> implements IIterationStrategy<T> {

    private final SingleVisitorIterationStrategyContext<T> iterationContext;

    public SingleVisitorIterationStrategy(SingleVisitorIterationStrategyContext<T> iterationContext) {
        this.iterationContext = iterationContext;
    }

    @Override
    public void performIterationSolution() {
        Iterator<T> iterator = iterationContext.getIterationProvider().iterator();
        while (iterator.hasNext()) {
            T nextElement = iterator.next();
            try {
                iterationContext.getIterationVisitor().visit(nextElement);
            } catch (IterationExitException ignored) {
                break;
            }
        }
    }

}
