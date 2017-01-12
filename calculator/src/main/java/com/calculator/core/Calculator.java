package com.calculator.core;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Calculator is the core class that has the logic to parse and evaluate the expression based on the
 * operators.
 * 
 * Steps to evaluate the expression 1. First convert the given infix expression to postfix. 2.
 * Evaluate the postfix expression based on the operands. 3. Post the result.
 *
 */
public class Calculator {

  private final OperatorFactory operatorFactory;

  /**
   * Calculator needs an operator factory that will take care of the operators. Extensibility is
   * achieved by passing operator factory.
   */
  public Calculator(OperatorFactory operatorFactory) {
    super();
    this.operatorFactory = operatorFactory;
  }

  public double evaluate(String expression) {
    System.out.println("infix " + expression);

    LinkedList<ExpElement> postFixExpElems = convertInfixToPostfixExp(expression);

    return evalutePostfixExp(postFixExpElems);
  }

  private LinkedList<ExpElement> convertInfixToPostfixExp(String expression) {
    LinkedList<ExpElement> postFixExpElems = new LinkedList<ExpElement>();
    Stack<Character> opStack = new Stack<Character>();

    if (expression != null && !expression.trim().equals("")) {
      String parsedNum = "";
      for (int i = 0; i < expression.length(); i++) {
        char expChar = expression.charAt(i);
        if (expChar == ' ') {
          parsedNum = recordParsedNum(postFixExpElems, parsedNum);

        } else if (operatorFactory.isValidOperator(expChar)) {
          parsedNum = recordParsedNum(postFixExpElems, parsedNum);

          Character opThis = expChar;
          if (opStack.isEmpty()) {
            opStack.push(opThis);
          } else {
            Character optTop = opStack.pop();
            if (operatorFactory.compareOpPrecedence(optTop, opThis) >= 0) {
              postFixExpElems.add(new ExpElement(String.valueOf(optTop), true));
            } else {
              opStack.push(optTop);
            }
            opStack.push(opThis);
          }

          parsedNum = recordParsedNum(postFixExpElems, parsedNum);
        } else {
          parsedNum += expChar;
        }
      }

      parsedNum = recordParsedNum(postFixExpElems, parsedNum);

      while (!opStack.isEmpty()) {
        Character op = opStack.pop();
        postFixExpElems.add(new ExpElement(String.valueOf(op), true));
      }
    }

    System.out.print("postfix ");
    for (ExpElement expElem : postFixExpElems) {
      System.out.print(expElem.getElement());
    }
    System.out.println();
    return postFixExpElems;
  }

  private String recordParsedNum(LinkedList<ExpElement> postFixExpElems, String parsedNum) {
    if (parsedNum != null && !parsedNum.equals("")) {
      ExpElement elem = new ExpElement(parsedNum, false);
      postFixExpElems.add(elem);
      parsedNum = "";
    }
    return parsedNum;
  }

  private double evalutePostfixExp(LinkedList<ExpElement> postFixExpElems) {
    Stack<ExpElement> postFixOperands = new Stack<ExpElement>();
    for (ExpElement expElem : postFixExpElems) {
      if (!expElem.isOperator()) {
        postFixOperands.push(expElem);
      } else {
        ExpElement elem1 = postFixOperands.pop();
        ExpElement elem2 = postFixOperands.pop();
        double result =
            operatorFactory.evaluate(expElem.getElement(), elem1.element, elem2.getElement());
        postFixOperands.push(new ExpElement(String.valueOf(result), false));
      }
    }

    String resultStr = postFixExpElems.isEmpty() ? null : postFixOperands.pop().getElement();

    if (resultStr != null) {
      return Double.parseDouble(resultStr);
    }
    return 0;
  }

  private static class ExpElement {
    private final String element;
    private final boolean isOperator;

    ExpElement(String element, boolean isOperator) {
      super();
      this.element = element;
      this.isOperator = isOperator;
    }

    public String getElement() {
      return element;
    }

    public boolean isOperator() {
      return isOperator;
    }
  }

}
