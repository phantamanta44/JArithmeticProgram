package io.github.phantamanta44.veryserious.jarithmeticprogram.util.verify.numeral.context;

public class DefaultNumeralVerificationContextFactory implements INumeralVerificationContextFactory {

    @Override
    public INumeralVerificationContext instantiateVerificationContext() {
        return new StandardNumeralVerificationContext();
    }

}
