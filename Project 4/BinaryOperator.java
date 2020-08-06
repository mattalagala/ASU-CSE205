//*********************************************************************************************
// CLASS: BinaryOperator (BinaryOperator.java)
//
// CSE205 Object Oriented Programming and Data Structures, Summmer B 2020
// Project Number: 4
//
// AUTHOR: Matthew Alagala, malagala, malagala@asu.edu
//*********************************************************************************************

/**
 * BinaryOperator is the superclass of all binary operators.
 */
public abstract class BinaryOperator extends Operator {

    public BinaryOperator() {
    }

    /**
     * Called to evaluate the operator.
     */
    public abstract Operand evaluate(Operand pLhsOperand, Operand pRhsOperand);

    /**
     * Returns true since all subclasses of BinaryOperator are binary operators.
     */
    @Override
    public boolean isBinaryOperator() {
        return true;
    }

}
