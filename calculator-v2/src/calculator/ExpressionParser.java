package calculator;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import calculator.operand.IOperandFactory;
import calculator.operator.IOperator;
import calculator.operator.IOperatorFactory;

public class ExpressionParser {

  private final IOperatorFactory operatorFactory;
  private final IOperandFactory operandFactory;

  public ExpressionParser(IOperatorFactory operatorFactory, IOperandFactory operandFactory) {
    this.operatorFactory = operatorFactory;
    this.operandFactory = operandFactory;
  }

  public List<IElement> infixToPostfix(String infixExp) {
    LinkedList<IElement> postfixExpression = new LinkedList<IElement>();
    Stack<IOperator> operatorStack = new Stack<IOperator>();

    if (infixExp != null && !infixExp.trim().equals("")) {
      String parsedNum = "";
      for (int i = 0; i < infixExp.length(); i++) {
        char expChar = infixExp.charAt(i);
        if (operatorFactory.isValid(expChar)) {
          parsedNum = recordOperand(postfixExpression, parsedNum);
          IOperator opThis = operatorFactory.getOperator(expChar);
          if (operatorStack.isEmpty()) {
            operatorStack.push(opThis);
          } else {
            IOperator optTop = operatorStack.pop();
            if (optTop.compareTo(opThis) >= 0) {
              postfixExpression.add(optTop);
            } else {
              operatorStack.push(optTop);
            }
            operatorStack.push(opThis);
          }
        } else if (operandFactory.isValid(expChar)) {
          parsedNum += expChar;
        }
      }
      parsedNum = recordOperand(postfixExpression, parsedNum);

      while (!operatorStack.isEmpty()) {
        IOperator operator = operatorStack.pop();
        postfixExpression.add(operator);
      }
    }

    return postfixExpression;
  }

  private String recordOperand(LinkedList<IElement> postFixElements, String parsedOperand) {
    if (parsedOperand != null && !parsedOperand.equals("")) {
      postFixElements.add(operandFactory.build(parsedOperand));
      parsedOperand = "";
    }
    return parsedOperand;
  }
}
