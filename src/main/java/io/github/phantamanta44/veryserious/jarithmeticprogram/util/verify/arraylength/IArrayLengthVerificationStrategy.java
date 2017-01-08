package io.github.phantamanta44.veryserious.jarithmeticprogram.util.verify.arraylength;

import io.github.phantamanta44.veryserious.jarithmeticprogram.util.verify.IVerifier;

public interface IArrayLengthVerificationStrategy<T> {

    IVerifier<T[]> generateVerificationSolution();

}
