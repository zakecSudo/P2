
package Kviz01;
import java.lang.Math;

public class kviz01 {
    public static void main(String[] args) {
        kalkulator(42, 13);
        obsegKroga(3, 4);
        double d = 5;
    }

    public void java() {
        System.out.println("   J    a   v     v  a");
        System.out.println("   J   a a   v   v  a a");
        System.out.println("J  J  aaaaa   V V  aaaaa  ");
        System.out.println(" JJ  a     a   V  a     a ");
    }

    public static void kalkulator(int a, int b) {
        if (b == 0) {
            System.out.println("Napaka: deljenje z 0");
        } else {
            System.out.printf("%d + %d = %d \n", a, b, a + b);
            System.out.printf("%d - %d = %d \n", a, b, a - b);
            System.out.printf("%d x %d = %d \n", a, b, a * b);
            System.out.printf("%d / %d = %d \n", a, b, a / b);
            System.out.printf("%d %% %d = %d \n", a, b, a % b);
        }
    }

    public static void krog(double r) {
        if(r < 0) {
            System.out.println("Napaka: negativen polmer.");
        } else {
            double obseg = 2 * Math.PI * r;
            double ploscina = Math.pow(r, 2) * Math.PI;
            System.out.printf("Obseg = %.2f\n", obseg);
            System.out.printf("Ploscina = %.2f", ploscina);
        }

    }

    public static void obsegKroga(double r, int d) {
        if(r < 0) {
            System.out.println("Napaka: negativen polmer");
        }
        else if(d < 0) {
            System.out.println("Napaka: negativen d");
        } else {
            double obseg = 2 * Math.PI * r;
            double ploscina = Math.pow(r, 2) * Math.PI;
            String obsegN = "%" + d + "d";
            System.out.printf("Obseg kroga s polmerom r=%.2f je " + "%." + d + "f\n", r, obseg);
            System.out.printf("Ploscina kroga s polmerom r=%.2f je " + "%." + d + "f\n" , r, ploscina);
        }
    }
}


