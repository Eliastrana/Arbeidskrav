import java.util.*;

public class Metoder {

    Random random = new Random();

    public int nesteHeltall(double lav, double hoy) {
        double result = random.nextDouble(hoy-lav) + lav +1; //+1 to get the top value     
            return (int)(result);
      }

    public double nesteDesimaltall(double lav, double hoy) {
        double result = random.nextDouble(hoy-lav) + lav;
            return (result);
      }

    }
