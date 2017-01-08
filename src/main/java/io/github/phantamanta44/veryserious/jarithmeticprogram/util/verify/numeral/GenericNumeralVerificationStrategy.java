package io.github.phantamanta44.veryserious.jarithmeticprogram.util.verify.numeral;

import io.github.phantamanta44.veryserious.jarithmeticprogram.util.guard.*;
import io.github.phantamanta44.veryserious.jarithmeticprogram.util.verify.IVerifier;
import io.github.phantamanta44.veryserious.jarithmeticprogram.util.verify.IllegalValueException;
import io.github.phantamanta44.veryserious.jarithmeticprogram.util.verify.equality.EqualityVerification;
import io.github.phantamanta44.veryserious.jarithmeticprogram.util.verify.numeral.context.DefaultNumeralVerificationContextFactory;
import io.github.phantamanta44.veryserious.jarithmeticprogram.util.verify.numeral.context.INumeralVerificationContext;
import io.github.phantamanta44.veryserious.jarithmeticprogram.util.verify.numeral.context.INumeralVerificationContextFactory;

public class GenericNumeralVerificationStrategy implements INumeralVerificationStrategy {

    @Override
    public IVerifier<String> generateVerificationSolution() {
        return new IVerifier<String>() {
            @Override
            public void testValidity(String value) throws IllegalValueException {
                try {
                    INumeralVerificationContextFactory contextFactory = new DefaultNumeralVerificationContextFactory();
                    final INumeralVerificationContext verificationContext = contextFactory.instantiateVerificationContext();
                    IGuardedOperationSet<Character> guardedOperationSet = GuardedOperations.getInstance().createOperationSet();
                    guardedOperationSet.registerGuardedOperation(new IGuard<Character>() {
                        @Override
                        public boolean shouldFallThrough(Character value) {
                            return !Character.isDigit(value);
                        }
                    }, new IGuardedOperation<Character>() {
                        @Override
                        public void performOperation(Character value) {
                            // NO-OP
                        }
                    });
                    guardedOperationSet.registerGuardedOperation(new IGuard<Character>() {
                        @Override
                        public boolean shouldFallThrough(Character value) {
                            try {
                                EqualityVerification.getInstance().verifyEquality(value, '.');
                                return false;
                            } catch (IllegalValueException e) {
                                return true;
                            }
                        }
                    }, new IGuardedOperation<Character>() {
                        @Override
                        public void performOperation(Character value) {
                            verificationContext.decimal();
                        }
                    });
                    guardedOperationSet.registerGuardedOperation(new IGuard<Character>() {
                        @Override
                        public boolean shouldFallThrough(Character value) {
                            return false;
                        }
                    }, new IGuardedOperation<Character>() {
                        @Override
                        public void performOperation(Character value) {
                            verificationContext.fail("Character is not a digit!");
                        }
                    });
                    for (int stringIndex = 0; stringIndex < value.length(); stringIndex++) {
                        char charAt = value.charAt(stringIndex);
                        guardedOperationSet.resolveOperation(charAt);
                    }
                } catch (GuardCollissionException e) {
                    throw new RuntimeException(e);
                }
            }
        };
    }

}
