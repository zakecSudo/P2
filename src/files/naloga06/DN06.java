
package naloga06;

import edu.princeton.cs.introcs.StdDraw;
import java.awt.*;
import java.util.Random;

public class DN06 {
    public static void main(String[] args) {
        StdDraw.setScale(0,10000);
        Random rnd = new Random();
        for(int i = 0; i < 12; i++) {
            int x = rnd.nextInt(10000);
            int y = rnd.nextInt(10000);
            int velikost = rnd.nextInt(100) + 1000;
            korona(x, y, velikost);
        }
    }

    static void korona(double x, double y, int velikost) {
        StdDraw.setPenColor(Color.RED);
        StdDraw.filledCircle(x,y,velikost);
        Random rnd = new Random();
        int steviloMolekul = (rnd.nextInt(10) + 25);
        for(int i =  0; i < steviloMolekul; i++) {
            double xCrtica = ((double) rnd.nextInt(2 * velikost - 10)) + (x - velikost + 5);
            double yCrtica = ((double) rnd.nextInt(2 * velikost - 10)) + (y - velikost + 5);
            double razdalja = Math.sqrt(Math.pow(Math.abs(xCrtica - x), 2) + Math.pow(Math.abs(yCrtica - y), 2));
            double dolzina = ((double) rnd.nextInt(velikost / 2)) + (velikost / 2);
            if(xCrtica > x && yCrtica > y) {
                double kot = Math.acos((xCrtica - x) / razdalja);
                narisiCrto(xCrtica, yCrtica, dolzina, kot);
            }
            if(xCrtica < x && yCrtica > y) {
                double kot = Math.PI - Math.acos(Math.abs(xCrtica - x) / razdalja);
                narisiCrto(xCrtica, yCrtica, dolzina, kot);
            }
            if(xCrtica < x && yCrtica < y) {
                double kot = Math.acos(Math.abs(xCrtica - x) / razdalja) + Math.PI;
                narisiCrto(xCrtica, yCrtica, dolzina, kot);
            }
            if(xCrtica > x && yCrtica < y) {
                double kot = 2 * Math.PI -  Math.acos(Math.abs(xCrtica - x) / razdalja);
                narisiCrto(xCrtica, yCrtica, dolzina, kot);
            }
        }

    }
    static void narisiCrto(double x0, double y0, double dolzina, double kot) {
        Random rnd = new Random();
        double debelina  = ((double) (rnd.nextInt(50) + 100)) / 10000;
        StdDraw.setPenColor(Color.gray);
        StdDraw.setPenRadius(debelina);
        double x = x0 + (dolzina * Math.cos(kot));
        double y = y0 + (dolzina * Math.sin(kot));
        StdDraw.line(x0, y0, x, y);
        StdDraw.filledCircle(x, y, dolzina / 5);

    }
}
