//*********************************************************************************************
// CLASS: Operator (Operator.java)
//
// CSE205 Object Oriented Programming and Data Structures, Summmer B 2020
// Project Number: 4
//
// AUTHOR: Matthew Alagala, malagala, malagala@asu.edu
//*********************************************************************************************

/** * Operator is the superclass of all binary and unary operators. */
public abstract class Operator extends Token {

    public Operator() {

    }

    public boolean isBinaryOperator() {
        return true;
    }

    public int precedence() {
        return 2;
    }

    public int stackPrecedence() {

        return 2;
    }
}
