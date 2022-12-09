public class Main
{
    public static void main(String[] args)
    {
        printDistance(13.85, 40);

        printDistance(26.42, 3.5);

        printDistance(5, 20.5);

        printDistance(0, 0);

        printTitle("welcome to the marathon!");

        printTitle("It's TIME for THE 5k!");

        printTitle("runners, take your marks...");

        printTitle("2 MILES TO GO!");

        printTitle("water break in 0.5 miles");
    }

    public static void printDistance(double miles, double km) {
        System.out.println(RaceUtility.milesToKm(miles));
        System.out.println(RaceUtility.kmToMiles(km));
    }

    public static void printTitle(String title) {
        System.out.println(RaceUtility.makeProper(title));
    }
}


