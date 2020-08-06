//*********************************************************************************************
// CLASS: Operand (Operand.java)
//
// CSE205 Object Oriented Programming and Data Structures, Summmer B 2020
// Project Number: 4
//
// AUTHOR: Matthew Alagala, malagala, malagala@asu.edu
//*********************************************************************************************

/** * An operand is a numeric value represented as a Double. */
public class Operand extends Token {
    private Double mValue;

    public Operand(Double pValue) {
        setValue(pValue);
    }

    public Double getValue() {
        return mValue;
    }

    public void setValue(Double pValue) {
        mValue = pValue;
    }
}