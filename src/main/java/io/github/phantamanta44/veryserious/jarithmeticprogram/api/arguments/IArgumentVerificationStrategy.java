package io.github.phantamanta44.veryserious.jarithmeticprogram.api.arguments;

import io.github.phantamanta44.veryserious.jarithmeticprogram.util.verify.IVerifier;

public interface IArgumentVerificationStrategy {

    IVerifier<String[]> generateVerificationSolution();

}
