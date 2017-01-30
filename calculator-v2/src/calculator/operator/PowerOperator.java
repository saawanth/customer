package calculator.operator;

public class PowerOperator implements IOperator, Comparable<IOperator> {

  private final char operator = '^';
  private final int orderOfPrecedence = 3;

  private static PowerOperator instance = new PowerOperator();

  private PowerOperator() {}

  public char getOperator() {
    return operator;
  }

  public int getOrderOfPrecedence() {
    return orderOfPrecedence;
  }


  @Override
  public double eval(double operand1, double operand2) {
    return Math.pow(operand1, operand2);
  }

  @Override
  public int compareTo(IOperator o) {
    if (orderOfPrecedence > o.getOrderOfPrecedence()) {
      return 1;
    } else if (orderOfPrecedence < o.getOrderOfPrecedence()) {
      return -1;
    } else {
      return 0;
    }
  }


  public static PowerOperator getInstance() {
    return instance;
  }
}
