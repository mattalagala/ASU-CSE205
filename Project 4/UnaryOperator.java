//*********************************************************************************************
// CLASS: UnaryOperator (UnaryOperator.java)
//
// CSE205 Object Oriented Programming and Data Structures, Summmer B 2020
// Project Number: 4
//
// AUTHOR: Matthew Alagala, malagala, malagala@asu.edu
//*********************************************************************************************

/**
 * UnaryOperator is the superclass of all unary operators.
 */
public abstract class UnaryOperator extends Operator {

    public UnaryOperator() {
    }

    /**
     * Called to evaluate the operator.
     */
    public abstract Operand evaluate(Operand pOperand);

    /**
     * Returns false since all subclasses of UnaryOperator are unary operators.
     */
    @Override
    public boolean isBinaryOperator() {
        return false;
    }

}
