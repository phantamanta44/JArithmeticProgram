package io.github.phantamanta44.veryserious.jarithmeticprogram.impl.output;

import io.github.phantamanta44.veryserious.jarithmeticprogram.api.output.IProgramOutputStrategy;
import io.github.phantamanta44.veryserious.jarithmeticprogram.util.verify.IllegalValueException;
import io.github.phantamanta44.veryserious.jarithmeticprogram.util.verify.nonnull.NonNullVerification;

import java.io.IOException;
import java.io.OutputStream;

public abstract class StdioProgramOutputStrategy implements IProgramOutputStrategy {

    private final OutputStream outputStream;

    public StdioProgramOutputStrategy(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    @Override
    public void performTextualOutputSolution(String output) throws IOException {
        try {
            NonNullVerification.getInstance().verifyNonNull(output);
        } catch (IllegalValueException e) {
            throw new NullPointerException();
        }
        performBinaryOutputSolution(output.getBytes());
    }

    @Override
    public void performBinaryOutputSolution(byte[] output) throws IOException {
        outputStream.write(output);
        outputStream.flush();
    }

}
