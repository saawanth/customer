package com.calculator.core;

import java.util.ArrayList;
import java.util.List;

/**
 * Operator enum has a char to identify an operator and an integer value to capture the precedence.
 *
 */

public enum Operator {

  ADD('+', 0), SUBTRACT('-', 0), MULTIPLY('*', 1), DIVIDE('/', 1), MODULUS('%', 1), POWER('^', 2);

  private char operator;
  private int orderOfPrecedence;

  private Operator(char operator, int orderOfPref) {
    this.operator = operator;
    this.orderOfPrecedence = orderOfPref;
  }

  public char getOperator() {
    return operator;
  }

  public void setOperator(char operator) {
    this.operator = operator;
  }

  public int getOrderOfPref() {
    return orderOfPrecedence;
  }

  public void setOrderOfPref(int orderOfPref) {
    this.orderOfPrecedence = orderOfPref;
  }

  public static Operator getOperator(char opChar) {
    for (Operator op : values()) {
      if (op.getOperator() == opChar) {
        return op;
      }
    }
    return null;
  }

  public static Operator getOperator(String opCharStr) {
    for (Operator op : values()) {
      if (opCharStr.equals(String.valueOf(op.getOperator()))) {
        return op;
      }
    }
    return null;
  }

  public static List<String> getOperators() {
    List<String> operators = new ArrayList<>();
    for (Operator op : values()) {
      operators.add(String.valueOf(op.getOperator()));
    }
    return operators;
  }

}
