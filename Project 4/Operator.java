//**************************************************************************************************************
// CLASS: Operator
//
// AUTHOR
// Kevin R. Burger (burgerk@asu.edu)
// Computer Science & Engineering Program
// Fulton Schools of Engineering
// Arizona State University, Tempe, AZ 85287-8809
// http://www.devlang.com
//**************************************************************************************************************

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
