package io.github.phantamanta44.veryserious.jarithmeticprogram.api.input;

import io.github.phantamanta44.veryserious.jarithmeticprogram.util.verify.IllegalValueException;
import io.github.phantamanta44.veryserious.jarithmeticprogram.util.verify.equality.EqualityVerification;

public class NumeralType<T extends Number> {

    public static final NumeralType<Double> DOUBLE_NUMERAL_TYPE = new NumeralType<Double>(Double.TYPE);
    public static final NumeralType<Float> FLOAT_NUMERAL_TYPE = new NumeralType<Float>(Float.TYPE);
    public static final NumeralType<Integer> INTEGER_NUMERAL_TYPE = new NumeralType<Integer>(Integer.TYPE);

    private final Class<T> primitiveType;

    private NumeralType(Class<T> primitiveType) {
        this.primitiveType = primitiveType;
    }

    public Class<T> getPrimitiveType() {
        return primitiveType;
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof NumeralType) {
            try {
                EqualityVerification.getInstance().verifyEquality(
                        ((NumeralType)object).primitiveType.getName(),
                        primitiveType.getName()
                );
                return true;
            } catch (IllegalValueException e) {
                return false;
            }
        }
        return false;
    }

}
