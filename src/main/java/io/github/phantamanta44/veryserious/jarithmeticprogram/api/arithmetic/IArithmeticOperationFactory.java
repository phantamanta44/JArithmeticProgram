package io.github.phantamanta44.veryserious.jarithmeticprogram.api.arithmetic;

public interface IArithmeticOperationFactory {

    <I extends Number, O extends Number> IArithmeticOperation<I, O> instantiate();

}
