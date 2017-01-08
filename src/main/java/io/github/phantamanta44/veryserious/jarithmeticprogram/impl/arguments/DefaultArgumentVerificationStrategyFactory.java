package io.github.phantamanta44.veryserious.jarithmeticprogram.impl.arguments;

import io.github.phantamanta44.veryserious.jarithmeticprogram.api.arguments.IArgumentVerificationStrategy;
import io.github.phantamanta44.veryserious.jarithmeticprogram.api.arguments.IArgumentVerificationStrategyFactory;

public class DefaultArgumentVerificationStrategyFactory implements IArgumentVerificationStrategyFactory {

    @Override
    public IArgumentVerificationStrategy instantiateStrategy() {
        return new StandardArgumentVerificationStrategy();
    }

}
