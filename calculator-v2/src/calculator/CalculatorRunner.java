package calculator;

import calculator.operand.IOperandFactory;
import calculator.operand.OperandFactoryImpl;
import calculator.operator.IOperatorFactory;
import calculator.operator.OperatorFactoryImpl;


public class CalculatorRunner {

  public static void main(String[] args) {
    IOperandFactory operandFactory = OperandFactoryImpl.getInstance();
    IOperatorFactory operatorFactory = OperatorFactoryImpl.getInstance();

    ScientificCalculator scCalculator = new ScientificCalculator(operatorFactory, operandFactory);
    System.out.println(scCalculator.calc("15+6*9"));
    System.out.println(scCalculator.calc("15*5+6*9"));
    System.out.println(scCalculator.calc("2*8+2*8"));
    System.out.println(scCalculator.calc("2*8-8"));
    System.out.println(scCalculator.calc("2*8-8/2"));
    System.out.println(scCalculator.calc("2^8"));
    System.out.println(scCalculator.calc("2*8+2^8"));
  }
}
