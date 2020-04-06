
import edu.princeton.cs.introcs.StdDraw;
import java.awt.*;

public class DN07 {
    public static void main(String[] args) {
        int [] t = new int[args.length];
        int visina = 0;
        for(int i = 0; i < args.length; i++) {
            visina = Integer.parseInt(args[i]);
            t[i] = visina;
        }
        narisiStolpce(t);

    }

    static void narisiStolpce(int[] visine) {
        StdDraw.setScale(0, 1);
        double najVisina = 0;
        for(int i = 0;  i < visine.length; i++) {
            if(visine[i] > najVisina) {
                najVisina = visine[i];
            }
        }
        double kolicnikVisine = (0.8 * 0.95) / najVisina;
        double dimenzijaTabele = 0.8;
        double sirina = dimenzijaTabele / (visine.length + 1);
        double presledek = sirina / (visine.length + 1);
        StdDraw.square(0.5, 0.5, dimenzijaTabele / 2);
        double x = (1 - dimenzijaTabele) / 2;
        double y = (1 - dimenzijaTabele) / 2;
        int a = 0;
        while(a < visine.length) {
            for(int b = 0;b < 3; b++) {
                if(a < visine.length) {
                    switch (b) {
                        case 0:
                            x += (presledek + sirina / 2);
                            StdDraw.setPenColor(Color.red);
                            narisiPravokotnik(x,y,sirina,visine[a],kolicnikVisine);
                            x += (sirina / 2);
                            a++;
                            break;
                        case 1:
                            x += (presledek + sirina / 2);
                            StdDraw.setPenColor(Color.yellow);
                            narisiPravokotnik(x,y,sirina,visine[a],kolicnikVisine);
                            x += (sirina / 2);
                            a++;
                            break;
                        case 2:
                            x += (presledek + sirina / 2);
                            StdDraw.setPenColor(Color.blue);
                            narisiPravokotnik(x,y,sirina,visine[a],kolicnikVisine);
                            x += (sirina / 2);
                            a++;
                            break;
                    }
                }
                else {
                    break;
                }
            }
        }
    }

    static void narisiPravokotnik(double x, double y, double sirina, double visina, double kolicnik) {
        double pravokotnikVisina = kolicnik * visina;
        double test = y + (pravokotnikVisina / 2);
        StdDraw.filledRectangle(x, y  + (pravokotnikVisina / 2), sirina / 2, pravokotnikVisina / 2);

    }
}
