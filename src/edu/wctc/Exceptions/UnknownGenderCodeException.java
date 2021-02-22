package edu.wctc.Exceptions;


public class UnknownGenderCodeException extends Exception {
    public UnknownGenderCodeException(char genderCode){
        super("Gender not Valid: " + genderCode +". Please Enter M or F");
    }
}
