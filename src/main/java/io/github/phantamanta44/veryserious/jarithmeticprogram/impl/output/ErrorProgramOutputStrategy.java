package io.github.phantamanta44.veryserious.jarithmeticprogram.impl.output;

import io.github.phantamanta44.veryserious.jarithmeticprogram.api.output.IProgramOutputStrategy;

import java.io.IOException;

public class ErrorProgramOutputStrategy extends StdioProgramOutputStrategy {

    public ErrorProgramOutputStrategy() {
        super(System.err);
    }

    @Override
    public void performTextualOutputSolution(String output) throws IOException {
        super.performTextualOutputSolution(output + "\n");
    }

}
