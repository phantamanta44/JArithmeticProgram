package io.github.phantamanta44.veryserious.jarithmeticprogram.util.verify.numeral.context;

public class StandardNumeralVerificationContext implements INumeralVerificationContext {

    private boolean decimal = false;

    @Override
    public void decimal() {
        if (!decimal) {
            decimal = true;
        } else {
            fail("Multiple decimal points!");
        }
    }

    @Override
    public void fail(String reason) {
        throw new IllegalStateException(reason);
    }

}
