package io.github.phantamanta44.veryserious.jarithmeticprogram.impl.arguments;

import io.github.phantamanta44.veryserious.jarithmeticprogram.api.arguments.IArgumentVerificationStrategy;
import io.github.phantamanta44.veryserious.jarithmeticprogram.util.verify.IVerifier;
import io.github.phantamanta44.veryserious.jarithmeticprogram.util.verify.IllegalValueException;
import io.github.phantamanta44.veryserious.jarithmeticprogram.util.verify.arraylength.ArrayLengthVerification;
import io.github.phantamanta44.veryserious.jarithmeticprogram.util.verify.numeral.NumeralVerification;

public class StandardArgumentVerificationStrategy implements IArgumentVerificationStrategy {

    public IVerifier<String[]> generateVerificationSolution() {
        return new IVerifier<String[]>() {
            @Override
            public void testValidity(String[] value) throws IllegalValueException {
                ArrayLengthVerification.getInstance().verifyArrayLength(value, 2);
                NumeralVerification.getInstance().verifyNumeral(value[1]);
            }
        };
    }

}
