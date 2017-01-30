package calculator.operator;

import calculator.IElement;

public interface IOperator extends IElement {

  public char getOperator();

  public int getOrderOfPrecedence();

  public double eval(double operand1, double operand2);

  public int compareTo(IOperator opThis);

}
