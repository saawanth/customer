package calculator.operand;

import java.util.Collection;


public interface IOperandFactory {

  public boolean isValid(char operand);

  public Collection<Character> getOperands();

  public IOperand build(String operand);
}
