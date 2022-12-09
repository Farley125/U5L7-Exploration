public class RaceUtility {
    public static double milesToKm(double miles) {
        return (miles * 1.60934);
    }

    public static double kmToMiles(double kilometers) {
        return (kilometers/1.60934);
    }

    public static String makeProper(String title) {
        String output = "";
        output += title.substring(0,1).toUpperCase();
        for (int i = 1; i < title.length(); i++) {
            if (title.charAt(i) == (' ')) {
                output += " " + title.substring(i+1,i+2).toUpperCase();
                i++;
            } else output += title.substring(i,i+1).toLowerCase();
        }
        return output;
    }
}
