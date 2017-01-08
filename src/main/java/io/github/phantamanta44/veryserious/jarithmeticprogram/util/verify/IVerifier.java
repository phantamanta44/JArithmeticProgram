package io.github.phantamanta44.veryserious.jarithmeticprogram.util.verify;

public interface IVerifier<T> {

    void testValidity(T value) throws IllegalValueException;

}
