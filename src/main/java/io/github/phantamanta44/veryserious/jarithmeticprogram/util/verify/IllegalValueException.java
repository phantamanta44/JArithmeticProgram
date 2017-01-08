package io.github.phantamanta44.veryserious.jarithmeticprogram.util.verify;

public class IllegalValueException extends Exception {

    private final Object value;

    public IllegalValueException(Object value) {
        this(value, "Illegal value: " + value.toString());
    }

    public IllegalValueException(Object value, String message) {
        super(message);
        this.value = value;
    }

    public Object getValue() {
        return value;
    }

}
