package edu.wctc.Classes;


import edu.wctc.Exceptions.MissingNameException;
import org.apache.commons.codec.language.Soundex;

public class LastNameUtility {
    private Soundex soundex = new Soundex();

    public String encodeLastName(String lastName) throws MissingNameException {
        /*
        If the last name is blank, throws a MissingNameException.
        Returns the encoding of the last name generated by the Soundex algorithm.
        */
        if(lastName == null){
            throw new MissingNameException(lastName);
        }
        else{
            lastName = soundex.encode(lastName);
        }
        return lastName;
    }
}