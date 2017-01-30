package calculator;

import java.util.List;
import java.util.Stack;

import calculator.operand.IOperand;
import calculator.operand.IOperandFactory;
import calculator.operand.Operand;
import calculator.operator.IOperator;
import calculator.operator.IOperatorFactory;

public class ScientificCalculator implements ICalculator {

  private final ExpressionParser expressionParser;

  public ScientificCalculator(IOperatorFactory operatorFactory, IOperandFactory operandFactory) {
    expressionParser = new ExpressionParser(operatorFactory, operandFactory);
  }

  public double evalPostfixExpElements(List<IElement> postfixElems) {
    Stack<IOperand> postFixOperands = new Stack<IOperand>();
    for (IElement iElem : postfixElems) {
      if (iElem instanceof IOperand) {
        postFixOperands.push((IOperand) iElem);
      } else {
        IOperand operand2 = postFixOperands.pop();
        IOperand operand1 = postFixOperands.pop();
        IOperator operator = (IOperator) iElem;

        double result = operator.eval(operand1.getValue(), operand2.getValue());
        postFixOperands.push(new Operand(result));
      }
    }

    if (!postfixElems.isEmpty()) {
      return postFixOperands.pop().getValue();
    }
    return 0;
  }

  @Override
  public double calc(String expression) {
    List<IElement> postfixExpElems = expressionParser.infixToPostfix(expression);
    printPostfixExpElems(postfixExpElems);
    return evalPostfixExpElements(postfixExpElems);
  }

  private void printPostfixExpElems(List<IElement> postfixExpElems) {
    for (IElement elem : postfixExpElems) {
      System.out.println(elem);
    }
  }
}
