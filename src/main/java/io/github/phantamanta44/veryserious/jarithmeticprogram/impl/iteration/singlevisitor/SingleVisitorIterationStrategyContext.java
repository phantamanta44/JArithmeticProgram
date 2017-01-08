package io.github.phantamanta44.veryserious.jarithmeticprogram.impl.iteration.singlevisitor;

import io.github.phantamanta44.veryserious.jarithmeticprogram.util.iteration.IIterationVisitor;
import io.github.phantamanta44.veryserious.jarithmeticprogram.util.verify.IllegalValueException;
import io.github.phantamanta44.veryserious.jarithmeticprogram.util.verify.nonnull.NonNullVerification;

public class SingleVisitorIterationStrategyContext<T> {
    
    private IIterationVisitor<T> iterationVisitor;
    private Iterable<T> iterationProvider;

    public IIterationVisitor<T> getIterationVisitor() {
        return iterationVisitor;
    }

    public void setIterationVisitor(IIterationVisitor<T> iterationVisitor) {
        this.iterationVisitor = iterationVisitor;
    }

    public Iterable<T> getIterationProvider() {
        return iterationProvider;
    }

    public void setIterationProvider(Iterable<T> iterationProvider) {
        this.iterationProvider = iterationProvider;
    }

    public void checkValidity() throws IllegalValueException {
        NonNullVerification nonNullVerifier = NonNullVerification.getInstance();
        nonNullVerifier.verifyNonNull(iterationVisitor);
        nonNullVerifier.verifyNonNull(iterationProvider);
    }
    
}
