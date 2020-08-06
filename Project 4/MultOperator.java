//*********************************************************************************************
// CLASS: MultOperator (MultOperator.java)
//
// CSE205 Object Oriented Programming and Data Structures, Summmer B 2020
// Project Number: 4
//
// AUTHOR: Matthew Alagala, malagala, malagala@asu.edu
//*********************************************************************************************

/**
 * Represents the multiplication operator which is a specific type of binary
 * operator.
 */
public class MultOperator extends BinaryOperator {

    public MultOperator() {
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
        return 3;
    }

    /**
     * Returns the precedence level of this operator when on it is on the operator
     * stack.
     */
    @Override
    public int stackPrecedence() {
        return 3;
    }

}