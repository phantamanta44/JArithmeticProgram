package io.github.phantamanta44.veryserious.jarithmeticprogram.api.arithmetic;

public interface IArithmeticOperationFactory {

    <T extends Number> IArithmeticOperation<T> instantiate();

}
