import java.util.Random;
import java.util.Scanner;

public final class MonteCarlo {

    public static boolean pointIsInCircle(double x, double y) {
        double squared = Math.pow(1 - x, 2) + Math.pow(1 - y, 2);
        double radius = Math.sqrt(squared);

        if (radius < 1) {
            return true;
        } else {
            return false;
        }
    }

    public static int numberOfPointsInCircle(int n) {
        Random ran_num = new Random();

        int counter = 0;
        int pointer = 0;

        while (counter < n) {
            double x_cor = ran_num.nextDouble() * 2;
            double y_cor = ran_num.nextDouble() * 2;

            if (pointIsInCircle(x_cor, y_cor) == true) {
                pointer++;
            }

            counter++;
        }

        return pointer;
    }

    public static void main(String[] args) {

        Scanner num_scan = new Scanner(System.in);
        System.out.println("Number of points: ");
        int n = num_scan.nextInt();

        int ptsInInterval = n;

        int ptsInSubinterval = numberOfPointsInCircle(n);

        double estimate = (100.0 * ptsInSubinterval) / ptsInInterval;
        System.out.println("Estimate of percentage: " + estimate + "%");
        /*
         * Close input and output streams
         */
    }

}