package calculator.operand;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class OperandFactoryImpl implements IOperandFactory {

  private static OperandFactoryImpl instance = new OperandFactoryImpl();

  private final Set<Character> operands = new HashSet<>();

  private OperandFactoryImpl() {
    operands.add('0');
    operands.add('1');
    operands.add('2');
    operands.add('3');
    operands.add('4');
    operands.add('5');
    operands.add('6');
    operands.add('7');
    operands.add('8');
    operands.add('9');
  }

  @Override
  public boolean isValid(char operand) {
    return operands.contains(operand);
  }

  @Override
  public Collection<Character> getOperands() {
    return operands;
  }

  @Override
  public IOperand build(String valueAsStr) {
    return new Operand(valueAsStr);
  }

  public static OperandFactoryImpl getInstance() {
    return instance;
  }
}
