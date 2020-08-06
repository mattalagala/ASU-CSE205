//*********************************************************************************************
// CLASS: NegOperator (NegOperator.java)
//
// CSE205 Object Oriented Programming and Data Structures, Summmer B 2020
// Project Number: 4
//
// AUTHOR: Matthew Alagala, malagala, malagala@asu.edu
//*********************************************************************************************

/**
 * Represents the negation operator which is a specific type of unary operator.
 */
public class NegOperator extends BinaryOperator {

    public NegOperator() {
    }

    /**
     * Returns the sum of the left-hand side operand and the right-hand side
     * operand.
     */
    @Override
    public Operand evaluate(Operand pLhsOperand, Operand pRhsOperand) {
        return new Operand(pLhsOperand.getValue() + pRhsOperand.getValue());
    }

    /**
     * Returns the normal precedence level of this operator.
     */
    @Override
    public int precedence() {
        return 4;
    }

    /**
     * Returns the precedence level of this operator when on it is on the operator
     * stack.
     */
    @Override
    public int stackPrecedence() {
        return 4;
    }

}