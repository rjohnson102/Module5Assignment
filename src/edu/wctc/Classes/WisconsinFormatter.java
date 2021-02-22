package edu.wctc.Classes;

import edu.wctc.Interfaces.DriversLicenseFormatter;

public class WisconsinFormatter implements DriversLicenseFormatter {
    /*Uses the getter methods of the driver's license object to retrieve the components of the license number.
     Returns them in a String in the format of SSSS-FFFY-YDDD-NN*/
    @Override
    public String formatLicenseNumber(DriversLicense driversLicense) {
        String tempYY = String.valueOf(driversLicense.getYY());
        String YY = tempYY.substring(tempYY.length()-2, tempYY.length()-1) + "-" + tempYY.substring(tempYY.length()-1);
        return String.valueOf(driversLicense.getSSSS() + "-" + driversLicense.getFFF() + YY + String.format("%03d",driversLicense.getDDD()) + "-" + String.format("%02d",driversLicense.getNN()));
    }


}
