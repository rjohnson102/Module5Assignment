package edu.wctc.Classes;

import edu.wctc.Exceptions.InvalidBirthdayException;
import edu.wctc.Exceptions.UnknownGenderCodeException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MonthDayGenderUtility {
    private final int MOD_MALE = 0;
    private final int MOD_FEMALE = 500;
    private final char CODE_MALE = 'M';
    private final char CODE_FEMALE = 'F';

    public int encodeMonthDayGender(int year, int month, int day, char genderCode) throws UnknownGenderCodeException, InvalidBirthdayException {
        /*If the gender code does not match one of the constants,
        an UnknownGenderCodeException is thrown.
        If the year, month, and day of birth do not constitute a valid date
        (such as February 31st or December 47th), an InvalidBirthdayException is thrown.
        Returns (month - 1) * 40 + day + genderModConstant.
         */
        int genderModConstant = -1;
        String temp = String.valueOf(year + "" + String.format("%02d",month) + "" + String.format("%02d",day));
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");

        if(genderCode != CODE_FEMALE && genderCode != CODE_MALE){
            throw new UnknownGenderCodeException(genderCode);
        }
        try {
            dateFormat.setLenient(false);
            dateFormat.parse(temp);

        } catch (Exception e) {
            throw new InvalidBirthdayException(year, month, day);
        }
        if(genderCode == CODE_MALE){
            genderModConstant = MOD_MALE;
        }
        else if(genderCode == CODE_FEMALE){
            genderModConstant = MOD_FEMALE;
        }
        if(genderModConstant != -1){
            return ((month-1) * 40 + day) + genderModConstant;
        }
        else{
            return genderModConstant;
        }
    }
}
