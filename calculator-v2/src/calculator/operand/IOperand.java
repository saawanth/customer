package calculator.operand;

import calculator.IElement;

public interface IOperand extends IElement {

  public String getValueAsStr();

  public double getValue();

}
