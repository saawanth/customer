package calculator.operand;

public class Operand implements IOperand {

  private double value;

  public Operand(String valueAsStr) {
    this.value = Double.valueOf(valueAsStr);
  }

  public Operand(double value) {
    this.value = value;
  }

  @Override
  public String getValueAsStr() {
    return String.valueOf(value);
  }

  @Override
  public double getValue() {
    return value;
  }

  @Override
  public String toString() {
    return "Operand [value=" + value + "]";
  }

}
