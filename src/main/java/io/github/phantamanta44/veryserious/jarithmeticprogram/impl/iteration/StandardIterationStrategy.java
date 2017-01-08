package io.github.phantamanta44.veryserious.jarithmeticprogram.impl.iteration;

import io.github.phantamanta44.veryserious.jarithmeticprogram.impl.iteration.singlevisitor.SingleVisitorIterationStrategyFactoryFactory;
import io.github.phantamanta44.veryserious.jarithmeticprogram.util.iteration.*;
import io.github.phantamanta44.veryserious.jarithmeticprogram.util.verify.IllegalValueException;

public class StandardIterationStrategy<T> implements IIterationStrategy<T> {

    private final StandardIterationStrategyContainer<T> iterationContext;

    public StandardIterationStrategy(StandardIterationStrategyContainer<T> iterationContext) {
        this.iterationContext = iterationContext;
    }

    @Override
    public void performIterationSolution() {
        final IIterationStrategyFactoryFactory singleVisitorStrategyFactoryFactory = SingleVisitorIterationStrategyFactoryFactory.getInstance();
        final IIterationStrategyFactory<T> singleVisitorStrategyFactory = singleVisitorStrategyFactoryFactory.instantiateFactory();
        singleVisitorStrategyFactory.registerVisitor(new IIterationVisitor<T>() {
            @Override
            public void visit(final T element) {
                IIterationStrategyFactory<IIterationVisitor<T>> visitorIterationStrategyFactory = singleVisitorStrategyFactoryFactory.instantiateFactory();
                visitorIterationStrategyFactory.registerVisitor(new IIterationVisitor<IIterationVisitor<T>>() {
                    @Override
                    public void visit(IIterationVisitor<T> visitor) {
                        visitor.visit(element);
                    }
                });
                visitorIterationStrategyFactory.setIterationProvider(iterationContext.getIterationVisitors());
                try {
                    IIterationStrategy<IIterationVisitor<T>> visitorIterationStrategy = visitorIterationStrategyFactory.instantiateStrategy();
                    visitorIterationStrategy.performIterationSolution();
                } catch (IllegalValueException e) {
                    e.printStackTrace();
                }
            }
        });
        singleVisitorStrategyFactory.setIterationProvider(iterationContext.getIterationProvider());
        try {
            IIterationStrategy<T> iterationStrategy = singleVisitorStrategyFactory.instantiateStrategy();
            iterationStrategy.performIterationSolution();
        } catch (IllegalValueException e) {
            throw new RuntimeException(e);
        } catch (IterationExitException ignored) {
            // NO-OP
        }
    }

}
