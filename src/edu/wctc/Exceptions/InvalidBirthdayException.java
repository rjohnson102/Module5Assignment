package edu.wctc.Exceptions;

public class InvalidBirthdayException extends Exception {
    public InvalidBirthdayException(int year, int month, int day){
        super("Date not valid: " + year + "/" + String.format("%02d",month) + "/" + String.format("%02d",day));
    }
}
