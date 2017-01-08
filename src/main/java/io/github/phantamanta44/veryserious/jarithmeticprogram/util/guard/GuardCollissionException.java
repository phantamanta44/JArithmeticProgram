package io.github.phantamanta44.veryserious.jarithmeticprogram.util.guard;

public class GuardCollissionException extends Exception {

    public GuardCollissionException() {
        super("Guard already exists within this operation set!");
    }

}
