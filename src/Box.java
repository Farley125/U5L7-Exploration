public class Box
{
    private double length;
    private double width;
    private double height;

    public Box(double l, double w, double h)
    {
        length = l;
        width = w;
        height = h;
    }

    public static double feetToInches(double feet)
    {
        return feet * 12;
    }

    public static double metersToInches(double meters)
    {
        double metersToFeet = meters * 3.2808399;
        double inches = feetToInches(metersToFeet);
        return inches;
    }

    public double volume()
    {
        return length * width * height;
    }

    public String toString()
    {
        return "L = " + length + ", W = " + width + ", H = " + height;
    }
}

