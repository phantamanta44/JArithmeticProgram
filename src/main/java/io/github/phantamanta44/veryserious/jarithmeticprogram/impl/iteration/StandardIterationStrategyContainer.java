package io.github.phantamanta44.veryserious.jarithmeticprogram.impl.iteration;

import io.github.phantamanta44.veryserious.jarithmeticprogram.impl.iteration.singlevisitor.SingleVisitorIterationStrategyFactoryFactory;
import io.github.phantamanta44.veryserious.jarithmeticprogram.util.iteration.IIterationStrategy;
import io.github.phantamanta44.veryserious.jarithmeticprogram.util.iteration.IIterationStrategyFactory;
import io.github.phantamanta44.veryserious.jarithmeticprogram.util.iteration.IIterationVisitor;
import io.github.phantamanta44.veryserious.jarithmeticprogram.util.verify.IllegalValueException;
import io.github.phantamanta44.veryserious.jarithmeticprogram.util.verify.nonnull.NonNullVerification;

import java.util.LinkedList;

public class StandardIterationStrategyContainer<T> {

    private LinkedList<IIterationVisitor<T>> iterationVisitors;
    private Iterable<T> iterationProvider;

    public StandardIterationStrategyContainer() {
        this.iterationVisitors = new LinkedList<IIterationVisitor<T>>();
    }

    public Iterable<IIterationVisitor<T>> getIterationVisitors() {
        return iterationVisitors;
    }

    public void addIterationVisitor(IIterationVisitor<T> iterationVisitor) {
        iterationVisitors.add(iterationVisitor);
    }

    public void setIterationVisitors(Iterable<IIterationVisitor<T>> iterationVisitors) {
        this.iterationVisitors.clear();
        IIterationStrategyFactory<IIterationVisitor<T>> iterationStrategyFactory = SingleVisitorIterationStrategyFactoryFactory.getInstance().instantiateFactory();
        iterationStrategyFactory.registerVisitor(new IIterationVisitor<IIterationVisitor<T>>() {
            @Override
            public void visit(IIterationVisitor<T> element) {
                addIterationVisitor(element);
            }
        });
        iterationStrategyFactory.setIterationProvider(iterationVisitors);
        try {
            IIterationStrategy<IIterationVisitor<T>> iterationStrategy = iterationStrategyFactory.instantiateStrategy();
            iterationStrategy.performIterationSolution();
        } catch (IllegalValueException e) {
            throw new RuntimeException(e);
        }
    }

    public Iterable<T> getIterationProvider() {
        return iterationProvider;
    }

    public void setIterationProvider(Iterable<T> iterationProvider) {
        this.iterationProvider = iterationProvider;
    }

    public void checkValidity() throws IllegalValueException {
        NonNullVerification nonNullVerifier = NonNullVerification.getInstance();
        nonNullVerifier.verifyNonNull(iterationVisitors);
        nonNullVerifier.verifyNonNull(iterationProvider);
    }

}
