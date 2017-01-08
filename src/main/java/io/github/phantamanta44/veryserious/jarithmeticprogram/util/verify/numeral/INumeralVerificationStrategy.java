package io.github.phantamanta44.veryserious.jarithmeticprogram.util.verify.numeral;

import io.github.phantamanta44.veryserious.jarithmeticprogram.util.verify.IVerifier;

public interface INumeralVerificationStrategy {

    IVerifier<String> generateVerificationSolution();

}
