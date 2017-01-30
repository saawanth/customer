package calculator.operator;

import java.util.Collection;


public interface IOperatorFactory {

  public boolean isValid(char operator);

  public Collection<IOperator> getOperators();

  public IOperator getOperator(char operator);

}
