public class Temperature
{
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
