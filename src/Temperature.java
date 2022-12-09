public class Temperature
{
    public static final int FREEZING_TEMP_F = 32;
    private static double highestTrackedTempF = 0;
    private static double lowestTrackedTempF = 0;
    private static boolean flag = false;

    private double highTemp;
    private double lowTemp;
    private String tempScale;

    // Precondition: scale must be: "F" or "C"; anything else will default to "F"
    public Temperature(double high, double low, String scale)
    {
        highTemp = high;
        lowTemp = low;

        if (scale.equals("F") || scale.equals("C"))
        {
            tempScale = scale;
        }
        else
        {
            tempScale = "F";
        }


        if (scale.equals("C")) {
            if (flag == false) {
                highestTrackedTempF = convertCtoF(highTemp);
                lowestTrackedTempF = convertCtoF(lowTemp);
                flag = true;
            }
            if (convertCtoF(highTemp) > highestTrackedTempF) {
                highestTrackedTempF = convertCtoF(highTemp);
            }
            if (convertCtoF(lowTemp) < lowestTrackedTempF) {
                lowestTrackedTempF = convertCtoF(lowTemp);
            }
        } else {
            if (flag == false) {
                highestTrackedTempF = highTemp;
                lowestTrackedTempF = lowTemp;
                flag = true;
            }
            if (highTemp > highestTrackedTempF) {
                highestTrackedTempF = highTemp;
            }
            if (lowTemp < lowestTrackedTempF) {
                lowestTrackedTempF = lowTemp;
            }
        }
    }

    // 1. Add your two static methods here:
    public static double convertCtoF(double temp) {
        return ((temp*1.8) + 32);
    }

    public static double convertFtoC(double temp) {
        return ((temp-32)/1.8);
    }
    // 2. Add your two instance methods here:

    public void changeToC() {
        if (tempScale.equals("F")) {
            highTemp = convertFtoC(highTemp);
            lowTemp = convertFtoC(lowTemp);
            tempScale = "C";
        }
    }

    public void changeToF() {
        if (tempScale.equals("C")) {
            highTemp = convertCtoF(highTemp);
            lowTemp = convertCtoF(lowTemp);
            tempScale = "F";
        }
    }


    // 3. Add your private static helper rounding "utility" method here:

    private static double roundToNearestTenth(double num) {
        if (num % .1 >= .05) {
            return (Math.ceil(num * 10) / 10);
        } else return (double) ((int) (num * 10)) /10;
    }

    // 4. Complete the toString method below (using your static helper method)
    //    so it returns a String that prints like:

    //    High Temperature: 67.4 F (or C)
    //    Low Temperature: 58.3 F (or C)

    public boolean belowFreezing() {
        if (tempScale.equals("C")) {
            return (convertCtoF(lowTemp) < FREEZING_TEMP_F);
        } else {
            return (lowTemp < FREEZING_TEMP_F);
        }
    }

    public static boolean sawFreezing() {
            return (lowestTrackedTempF < FREEZING_TEMP_F);
    }

    public static double getHighestTrackedTempF() {
        return highestTrackedTempF;
    }

    public static double getLowestTrackedTempF() {
        return lowestTrackedTempF;
    }

    public double getHighTemp() {
        return highTemp;
    }

    public double getLowTemp() {
        return lowTemp;
    }

    public String getTempScale() {
        return tempScale;
    }

    public String toString()
    {
        if (tempScale.equals("F")) {
            changeToF();
            return ("High Temperature: " + roundToNearestTenth(highTemp)) + " F (or " + roundToNearestTenth(convertFtoC(highTemp)) + " C)\n" +
                    "Low Temperature: " + roundToNearestTenth(lowTemp) + " F (or " + roundToNearestTenth(convertFtoC(lowTemp)) + " C)";
        } else {
            changeToC();
            return ("High Temperature: " + roundToNearestTenth(highTemp)) + " C (or " + roundToNearestTenth(convertCtoF(highTemp)) + " F)\n" +
                    "Low Temperature: " + roundToNearestTenth(lowTemp) + " C (or " + roundToNearestTenth(convertCtoF(lowTemp)) + " F)";
        }

    }
}
