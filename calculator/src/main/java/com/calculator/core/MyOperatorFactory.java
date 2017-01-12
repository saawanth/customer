package com.calculator.core;

import java.util.List;

/*
 * 
 * */

public enum MyOperatorFactory implements OperatorFactory {
  INSTANCE;

  public boolean isValidOperator(char operator) {
    for (Operator op : Operator.values()) {
      if (op.getOperator() == operator) {
        return true;
      }
    }
    return false;
  }

  @Override
  public int compareOpPrecedence(char operator1, char operator2) {
    Operator op1Enum = Operator.getOperator(operator1);
    Operator op2Enum = Operator.getOperator(operator2);

    if (op1Enum.getOrderOfPref() < op2Enum.getOrderOfPref()) {
      return -1;
    } else if (op1Enum.getOrderOfPref() > op2Enum.getOrderOfPref()) {
      return 1;
    } else {
      return 0;
    }
  }

  private boolean isOpForAddition(String operator) {
    if (String.valueOf(Operator.ADD.getOperator()).equals(operator)) {
      return true;
    }
    return false;
  }

  private boolean isOpForSubtraction(String operator) {
    if (String.valueOf(Operator.SUBTRACT.getOperator()).equals(operator)) {
      return true;
    }
    return false;
  }

  private boolean isOpForMultiplicaton(String operator) {
    if (String.valueOf(Operator.MULTIPLY.getOperator()).equals(operator)) {
      return true;
    }
    return false;
  }

  private boolean isOpForDivision(String operator) {
    if (String.valueOf(Operator.DIVIDE.getOperator()).equals(operator)) {
      return true;
    }
    return false;
  }

  private boolean isOpForModulus(String operator) {
    if (String.valueOf(Operator.MODULUS.getOperator()).equals(operator)) {
      return true;
    }
    return false;
  }

  private boolean isOpForPower(String operator) {
    if (String.valueOf(Operator.POWER.getOperator()).equals(operator)) {
      return true;
    }
    return false;
  }

  public double evaluate(String operator, String operand1, String operand2) {
    double result = 0;

    if (isOpForAddition(operator)) {
      result = Double.parseDouble(operand1) + Double.parseDouble(operand2);
    } else if (isOpForSubtraction(operator)) {
      result = Double.parseDouble(operand1) - Double.parseDouble(operand2);
    } else if (isOpForMultiplicaton(operator)) {
      result = Double.parseDouble(operand1) * Double.parseDouble(operand2);
    } else if (isOpForDivision(operator)) {
      result = Double.parseDouble(operand1) / Double.parseDouble(operand2);
    } else if (isOpForModulus(operator)) {
      result = Double.parseDouble(operand1) % Double.parseDouble(operand2);
    } else if (isOpForPower(operator)) {
      result = Math.pow(Double.parseDouble(operand1), Double.parseDouble(operand2));
    }

    return result;
  }

  @Override
  public List<String> getOperators() {
    return Operator.getOperators();
  }
}
