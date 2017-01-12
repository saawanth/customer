package com.calculator.core;

import java.util.List;

/**
 *
 * Operator factory interface is provided to have an ability to customize the 
 * 1. Ability of calculator to take new operators.
 * 2. Customize the operators.
 *
 */
public interface OperatorFactory {

  public boolean isValidOperator(char operator);

  public int compareOpPrecedence(char operator1, char operator2);

  public double evaluate(String operator, String operand1, String operand2);

  public List<String> getOperators();
}
