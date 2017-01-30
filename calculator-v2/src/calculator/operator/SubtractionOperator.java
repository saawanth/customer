package calculator.operator;

public class SubtractionOperator implements IOperator, Comparable<IOperator> {

  private final char operator = '-';
  private final int orderOfPrecedence = 1;

  private static SubtractionOperator instance = new SubtractionOperator();

  private SubtractionOperator() {}

  public char getOperator() {
    return operator;
  }

  public int getOrderOfPrecedence() {
    return orderOfPrecedence;
  }

  public static SubtractionOperator getInstance() {
    return instance;
  }

  @Override
  public double eval(double operand1, double operand2) {
    return operand1 - operand2;
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
}
