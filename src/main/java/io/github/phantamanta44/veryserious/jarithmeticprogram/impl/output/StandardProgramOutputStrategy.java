package io.github.phantamanta44.veryserious.jarithmeticprogram.impl.output;

import java.io.IOException;
import java.io.OutputStream;

public class StandardProgramOutputStrategy extends StdioProgramOutputStrategy {

    public StandardProgramOutputStrategy(OutputStream outputStream) {
        super(System.out);
    }

    @Override
    public void performTextualOutputSolution(String output) throws IOException {
        super.performTextualOutputSolution(output + "\n");
    }

}
