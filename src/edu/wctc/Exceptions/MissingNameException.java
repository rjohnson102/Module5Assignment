package edu.wctc.Exceptions;

public class MissingNameException extends Exception {
    public MissingNameException(String nameType){
        super("Name cannot be Empty");
    }
}
