package com.irs.strategypatternexample;

/**
 * Interface de la estrategia de validación.
 * 
 * @author IRS
 * @version 1.0.0
 */
public interface ValidationStrategy {

    boolean execute(String s);
}
