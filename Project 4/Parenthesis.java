//*********************************************************************************************
// CLASS: Parenthesis (Parenthesis.java)
//
// CSE205 Object Oriented Programming and Data Structures, Summmer B 2020
// Project Number: 4
//
// AUTHOR: Matthew Alagala, malagala, malagala@asu.edu
//*********************************************************************************************

/**
 * Parenthesis is the superclass of LeftParen and RightParen. These are treated
 * as a weird sort of Operator because we need to be able to push LeftParens on
 * the operator stack when evaluating the expression.
 */
public abstract class Parenthesis extends Operator {

    public Parenthesis() {

    }

    /**
     * Parenthesiss are not really operators so return false.
     */
    @Override
    public boolean isBinaryOperator() {
        return false;
    }

}