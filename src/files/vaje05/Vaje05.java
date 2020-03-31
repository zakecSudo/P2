package vaje05;

import vaje03.Vaje03;
import java.util.Scanner;

public class Vaje05 {
    public static void main(String[] args) {
        /*
        Seznam.narediSeznam(5);
        Seznam.dodajNaSeznam("cips");
        Seznam.dodajNaSeznam("mleko");
        Seznam.dodajNaSeznam("jajca");
        Seznam.odstraniIzSeznama(2);
        Seznam.izpisiSeznam();
        System.out.println(Seznam.spisek());
        Seznam.izpisiSeznam64Bit();
        */
        Scanner vhod = new Scanner(System.in);
        char kontrola = '0';
        System.out.println("h: pomoc, q: izhod");
        while(kontrola != 'q') {
            kontrola = vhod.next().charAt(0);
            System.out.println("");
            switch (kontrola) {
                case '1':
                    System.out.print("Vnesi dolžino seznama: ");
                    int stevilo = vhod.nextInt();
                    Seznam.narediSeznam(stevilo);
                    break;

                case '2':
                    System.out.print("Zapiši element: ");
                    String potrebscina = vhod.next();
                    Seznam.dodajNaSeznam(potrebscina);
                    break;

                case '3':
                    System.out.print("Odstrani element: ");
                    int odstrani = vhod.nextInt();
                    Seznam.odstraniIzSeznama(odstrani);
                    break;

                case '4':
                    Seznam.izpisiSeznam();
                    break;

                case '5':
                    Seznam.izpisiSeznam64Bit();
                    break;

                case 'h':
                    izpisiNavodila();
                    break;
            }
        }
    }

    public static void izpisiNavodila(){
            System.out.println("Navodila:\n" +
                    "1: naredi seznam, 2: dodaj element, 3: odstrani element, 4: izpiši seznam, 5: izpiši 64 bitno, q: izhod, h: pomoč");
    }
}

class Seznam {

    private static String[] seznam; // = {"mleko", "cokolada", "jajca", "ribe", "maslo"};
    private static int dolzina = 0;

    /**
     * Inicializira seznam z tabelo dolzine n.
     * @param n
     */
    public static void narediSeznam(int n){
        if(seznam == null) {
            seznam = new String[n];
            dolzina = seznam.length;
        } else
            System.out.printf("Seznam z dolžino %d je ze narejen.\n", dolzina);
    }


    public static void dodajNaSeznam(String element){
        if(seznam == null) {
            System.out.println("Seznam še ni narejen.");
        } else {
            int mesto = 0;
            while (mesto < seznam.length && seznam[mesto] != null) {
                mesto++;
            }
            if (seznam[seznam.length - 1] != null)
                System.out.println("Sezman je poln. Element ni bil dodan.");
            else {
                seznam[mesto] = element;
                dolzina++;
            }
        }
    }

    public static void odstraniIzSeznama(int mesto) {
        if(seznam[mesto] == null) {
            System.out.printf("Na mestu %d ni elementa.", mesto);
        } else {
            mesto--;
            while(mesto + 1 < seznam.length) {
                seznam[mesto] = seznam[mesto + 1];
                mesto++;
            }
            seznam[seznam.length - 1] = null;
            dolzina--;
        }
    }

    public static void izpisiSeznam(){
        System.out.println("Na seznamu so sledeči elementi:");
        if(seznam == null || seznam[0] == null)
            System.out.println("Na seznamu ni elemntov.");
        else {
            int i = 0;
            while(i < seznam.length && seznam[i] != null) {
                System.out.println("");
                System.out.printf("%d: %s", i + 1, seznam[i]);
                i++;
            }
        }
        System.out.println("");
    }
    public static String[] spisek() {
        int a = 0;
        while(a < seznam.length && seznam[a] != null) {
            a++;
        }
        String[] trgovina = new String[a++];
        int i = 0;
        while(i < seznam.length && seznam[i] != null) {
            trgovina[i] = ((i + 1) + " " + seznam[i]);
            i++;
        }
        return trgovina;
    }

    public static void izpisiSeznam64Bit(){
        if(seznam == null)
            System.out.println("Na seznamu ni elemntov.");
        else {
            System.out.println("Na seznamu so sledeči elementi:");
            String[] trgovina = spisek();
            for(int i = 0; i < trgovina.length; i++) {
                System.out.println("");
                vaje03.Vaje03.izpisiNiz64bit(trgovina[i]);
            }
        }
    }
}