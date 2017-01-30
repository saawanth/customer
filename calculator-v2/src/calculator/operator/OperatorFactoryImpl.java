package calculator.operator;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


public class OperatorFactoryImpl implements IOperatorFactory {

  private static OperatorFactoryImpl instance = new OperatorFactoryImpl();

  private Map<Character, IOperator> operatorsMap = new HashMap<>();

  private OperatorFactoryImpl() {
    operatorsMap.put(AdditionOperator.getInstance().getOperator(), AdditionOperator.getInstance());
    operatorsMap.put(SubtractionOperator.getInstance().getOperator(),
        SubtractionOperator.getInstance());
    operatorsMap.put(MultiplicationOperator.getInstance().getOperator(),
        MultiplicationOperator.getInstance());
    operatorsMap.put(DivisionOperator.getInstance().getOperator(), DivisionOperator.getInstance());
    operatorsMap.put(PowerOperator.getInstance().getOperator(), PowerOperator.getInstance());
  }

  @Override
  public boolean isValid(char operator) {
    return operatorsMap.containsKey(operator);
  }

  @Override
  public Collection<IOperator> getOperators() {
    return operatorsMap.values();
  }

  @Override
  public IOperator getOperator(char operator) {
    return operatorsMap.get(operator);
  }

  public static OperatorFactoryImpl getInstance() {
    return instance;
  }

}
