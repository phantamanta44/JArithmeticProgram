package io.github.phantamanta44.veryserious.jarithmeticprogram.api.output;

import java.io.IOException;

public interface IProgramOutputStrategy {

    void performTextualOutputSolution(String output) throws IOException;

    void performBinaryOutputSolution(byte[] output) throws IOException;

}
