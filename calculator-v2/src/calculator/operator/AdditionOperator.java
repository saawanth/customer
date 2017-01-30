package calculator.operator;

public class AdditionOperator implements IOperator, Comparable<IOperator> {

  private final char operator = '+';
  private final int orderOfPrecedence = 1;

  private static AdditionOperator instance = new AdditionOperator();

  private AdditionOperator() {}

  public char getOperator() {
    return operator;
  }

  public int getOrderOfPrecedence() {
    return orderOfPrecedence;
  }

  public static AdditionOperator getInstance() {
    return instance;
  }

  @Override
  public double eval(double operand1, double operand2) {
    return operand1 + operand2;
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
    return "AdditionOperator [operator=" + operator + ", orderOfPrecedence=" + orderOfPrecedence
        + "]";
  }
}
