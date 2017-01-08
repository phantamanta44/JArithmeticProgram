package io.github.phantamanta44.veryserious.jarithmeticprogram.api.output;

public interface IProgramOutputStrategyFactory {

    void setOutputType(ProgramOutputType type);

    IProgramOutputStrategy instantiateStrategy();

}
