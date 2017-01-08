package io.github.phantamanta44.veryserious.jarithmeticprogram.impl.output;

import io.github.phantamanta44.veryserious.jarithmeticprogram.api.output.IProgramOutputStrategy;
import io.github.phantamanta44.veryserious.jarithmeticprogram.api.output.ProgramOutputType;

public class ProgramOutputStrategyContext {

    public final ProgramOutputType type;

    private IProgramOutputStrategy strategy;

    public ProgramOutputStrategyContext(ProgramOutputType type) {
        this.type = type;
    }

    public void setStrategy(IProgramOutputStrategy strategy) {
        if (this.strategy == null) {
            this.strategy = strategy;
        } else {
            throw new IllegalStateException("Program output strategy already bound!");
        }
    }

    public IProgramOutputStrategy getStrategy() {
        if (strategy == null) {
            throw new IllegalStateException("No program output strategy bound!");
        }
        return strategy;
    }

}
