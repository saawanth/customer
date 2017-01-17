package com.calculator;

import com.calculator.core.Calculator;
import com.calculator.core.MyOperatorFactory;

/**
 * Startup class of the calculator.
 */
public class CalculatorlCmdLineRunner {

  public static void main(String[] args) {
    Calculator calculator = new Calculator(MyOperatorFactory.INSTANCE);
    System.out.println("result " + calculator.evaluate("4*3+8"));
    System.out.println("----------------");
    System.out.println("result " + calculator.evaluate("4+3*8"));
    System.out.println("----------------");
    System.out.println("result " + calculator.evaluate("2*7+4*9"));
    System.out.println("----------------");
    System.out.println("result " + calculator.evaluate("2*7+4^2"));
    System.out.println("----------------");
    System.out.println("result " + calculator.evaluate("1 + 1 - 4 * 4"));
    System.out.println("----------------");
    System.out.println("result " + calculator.evaluate("11 + 12 - 12 * 13"));
    System.out.println("----------------");
  }
}
