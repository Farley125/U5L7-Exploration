public class Main
    {
        public static void main(String[] args)
        {
            double high = 78.5;
            double low = 54.6;

            // test constructors
            Temperature temp1 = new Temperature(high, low, "F");

            System.out.println(temp1);
            System.out.println("-----");

            Temperature temp2 = new Temperature(23.92, 14.95, "C");

            System.out.println(temp2);
            System.out.println("-----");

            // anything other than "C" or "F" defaults to "F"
            Temperature temp3 = new Temperature(57.53, 38.65, "K");

            System.out.println(temp3);
            System.out.println("-----");

            // --- test instance methods ---

            // change to C
            temp1.changeToC();
            System.out.println(temp1);

            // already C so do nothing:
            temp1.changeToC();
            System.out.println(temp1);
            System.out.println("-----");

            // change to F
            temp1.changeToF();
            System.out.println(temp1);

            // already F so do nothing:
            temp1.changeToF();
            System.out.println(temp1);
            System.out.println("-----");

            // --- test static methods ---
            double celciusTemp = Temperature.convertFtoC(78.5);
            System.out.println(celciusTemp);

            double fahrenheitTemp = Temperature.convertCtoF(12.6);
            System.out.println(fahrenheitTemp);
        }
    }
