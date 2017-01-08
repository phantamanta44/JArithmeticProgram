package io.github.phantamanta44.veryserious.jarithmeticprogram.api.arithmetic;

public interface IArithmeticOperation<T extends Number> {

    T applyArithmeticOperation(T valueA, T valueB);

}
