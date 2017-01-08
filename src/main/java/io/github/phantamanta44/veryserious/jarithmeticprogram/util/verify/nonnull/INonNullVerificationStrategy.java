package io.github.phantamanta44.veryserious.jarithmeticprogram.util.verify.nonnull;

import io.github.phantamanta44.veryserious.jarithmeticprogram.util.verify.IVerifier;

public interface INonNullVerificationStrategy<T> {

    IVerifier<T> generateVerificationSolution();

}
