package io.github.phantamanta44.veryserious.jarithmeticprogram.api.arithmetic;

public interface IArithmeticOperation<I extends Number, O extends Number> {

    O applyArithmeticOperation(I value);

}
