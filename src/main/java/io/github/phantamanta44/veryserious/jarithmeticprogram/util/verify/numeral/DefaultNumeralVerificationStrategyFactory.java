package io.github.phantamanta44.veryserious.jarithmeticprogram.util.verify.numeral;

public class DefaultNumeralVerificationStrategyFactory implements INumeralVerificationStrategyFactory {

    @Override
    public INumeralVerificationStrategy instantiateStrategy() {
        return new GenericNumeralVerificationStrategy();
    }

}
