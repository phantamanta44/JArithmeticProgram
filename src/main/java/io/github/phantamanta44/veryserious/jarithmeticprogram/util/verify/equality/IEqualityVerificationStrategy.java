package io.github.phantamanta44.veryserious.jarithmeticprogram.util.verify.equality;

import io.github.phantamanta44.veryserious.jarithmeticprogram.util.verify.IVerifier;

public interface IEqualityVerificationStrategy<A, B> {

    IVerifier<EqualityTestContainer<A, B>> generateVerificationSolution();

}
