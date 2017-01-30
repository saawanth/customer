package calculator.operator;

public class MultiplicationOperator implements IOperator, Comparable<IOperator> {

  private static MultiplicationOperator instance = new MultiplicationOperator();

  private final char operator = '*';
  private final int orderOfPrecedence = 2;

  private MultiplicationOperator() {}

  public char getOperator() {
    return operator;
  }

  public int getOrderOfPrecedence() {
    return orderOfPrecedence;
  }

  public static MultiplicationOperator getInstance() {
    return instance;
  }

  @Override
  public double eval(double operand1, double operand2) {
    return operand1 * operand2;
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

  @Override
  public String toString() {
    return "MultiplicationOperator [operator=" + operator + ", orderOfPrecedence="
        + orderOfPrecedence + "]";
  }
}
