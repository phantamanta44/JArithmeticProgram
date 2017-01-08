package io.github.phantamanta44.veryserious.jarithmeticprogram.impl.output;

import java.io.IOException;

public class StandardProgramOutputStrategy extends StdioProgramOutputStrategy {

    public StandardProgramOutputStrategy() {
        super(System.out);
    }

    @Override
    public void performTextualOutputSolution(String output) throws IOException {
        super.performTextualOutputSolution(output + "\n");
    }

}
