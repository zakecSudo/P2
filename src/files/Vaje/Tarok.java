
import java.util.Random;

public class Tarok {
    private static final int ST_KART = 54;
    private static final int STOLPCI = 8;

    private static final char pik  = '\u2660';  // ♠
    private static final char kriz = '\u2663';  // ♣
    private static final char srce = '\u2665';  // ♥
    private static final char karo = '\u2666';  // ♦

    private static char barve[]      = {srce, karo, kriz, pik};
    private static int prazneRdece[] = {1, 2, 3, 4};
    private static int prazneCrne[]  = {10, 9, 8, 7};
    private static String figure[]   = {"Fant", "Kaval", "Dama", "Kralj"};
    private static String taroki[]   = {"I", "II", "III", "IIII", "V", "VI", "VII",
            "VIII", "IX", "X", "XI", "XII", "XIII", "XIV",
            "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
            "XXI", "SKIS"};

    public static void main(String[] args) {
        //izpisi(figure);
        /*
        String[] kupcek = ustvariKarte();
        izpisi(kupcek);
        System.out.println("");
        izpisi(premesajKarte(kupcek, 100000));
        System.out.println(vrednostKarte("♦Kaval"));
        System.out.println("");
        System.out.printf("Skupna vrednost kart (preprosto stetje): %d \n", preprostoStetje(kupcek));
         */
        String[] kupcek = ustvariKarte();
        premesajKarte(kupcek, 500);
        int meja = 25;
        System.out.println("Prvi kup kart:");
        int kupcek1 = natancnoStetje(kupcek, 0, meja, true);
        System.out.printf("Natancno stetje 1. kupa kart: %d\n", kupcek1);
        System.out.println();
        System.out.println("Drugi kup kart:");
        int kupcek2 = natancnoStetje(kupcek, meja, ST_KART, true);
        System.out.printf("Natancno stetje 2. kupa kart: %d\n", kupcek2);
        System.out.printf("\nSkupaj oba kupa kart: %d\n", kupcek1 + kupcek2);
    }


    /*
    public static void izpisi(String [] tabela) {
        for(int i = 0; i < tabela.length; i++) {
            System.out.println(tabela[i]);
        }
    }

     */
    public static String[] ustvariKarte() {
        String[] karte = new String[ST_KART];
        int i = 0;
        for(int a = 0; a < barve.length; a++) {
            if (barve[a] == srce) {
                for (int b = 0; b < prazneRdece.length; b++) {
                    karte[i] = "" + srce + prazneRdece[b];
                    i++;
                }
                for (int c = 0; c < figure.length; c++) {
                    karte[i] = "" + srce + figure[c];
                    i++;
                }
            }
            if (barve[a] == karo) {
                for (int d = 0; d < prazneRdece.length; d++) {
                    karte[i] = "" + karo + prazneRdece[d];
                    i++;
                }
                for (int e = 0; e < figure.length; e++) {
                    karte[i] = "" + karo + figure[e];
                    i++;
                }
            }
            if (barve[a] == kriz) {
                for (int f = 0; f < prazneCrne.length; f++) {
                    karte[i] = "" + kriz + prazneCrne[f];
                    i++;
                }
                for (int g = 0; g < figure.length; g++) {
                    karte[i] = "" + kriz + figure[g];
                    i++;
                }
            }
            if (barve[a] == pik) {
                for (int h = 0; h < prazneCrne.length; h++) {
                    karte[i] = "" + pik + prazneCrne[h];
                    i++;
                }
                for (int j = 0; j < figure.length; j++) {
                    karte[i] = "" + pik + figure[j];
                    i++;
                }
            }
        }
        for(int a = 0; a < taroki.length; a++) {
            karte[i] = taroki[a];
            i++;
        }


    return karte;
    }
    /*
    public static void izpisi(String[] tabela) {
        for(int i = 0; i < tabela.length;) {
            for(int a = 0; a < STOLPCI; a++) {
                if (i < tabela.length) {
                    System.out.printf("%8s", tabela[i]);
                    i++;

                }

            }
            System.out.println("");
        }
    }
     */
    public static String[] premesajKarte(String[] kupcek, int kolikokrat) {
        Random rnd = new Random();
        for(int i = 0; i < kolikokrat; i++) {
            int prvoMesto = rnd.nextInt(kupcek.length);
            int drugoMesto = rnd.nextInt(kupcek.length);
            String karta = kupcek[drugoMesto];
            kupcek[drugoMesto] = kupcek[prvoMesto];
            kupcek[prvoMesto] = karta;
        }
    return kupcek;
    }
    public static boolean vsebuje(String[] tabela, String vrednost) {
        for(String s: tabela) {
            if(s.equals(vrednost))
                return true;
        }
        return false;
    }
    public static int[] vrednostKart() {
        String[] karte = ustvariKarte();
        int[] vrednosti = new int[karte.length];
        for(int i = 0; i < karte.length; i++) {
            String kartica;
            if(karte[i].charAt(0) == srce || karte[i].charAt(0) == karo || karte[i].charAt(0) == kriz || karte[i].charAt(0) == pik)
                kartica = karte[i].substring(1);
            else
                kartica = karte[i];
            if(vsebuje(figure, kartica) || vsebuje(taroki, kartica)) {
                vrednosti[i] = 1;
                if(kartica.equals("I") || kartica.equals("XXI") || kartica.equals("SKIS") || kartica.equals("Kralj"))
                    vrednosti[i] = 5;
                if(kartica.equals("Dama"))
                    vrednosti[i] = 4;
                if(kartica.equals("Kaval"))
                    vrednosti[i] = 3;
                if(kartica.equals("Fant"))
                    vrednosti[i] = 2;
            } else
                vrednosti[i] = 1;
        }
    return vrednosti;
    }
    public static int vrednostKarte(String karta) {
        int nekaj = 0;
        String[] karte = ustvariKarte();
        int[] vrednosti = new int[karte.length];
        for (int i = 0; i < karte.length; i++) {
            String kartica;
            if (karte[i].charAt(0) == srce || karte[i].charAt(0) == karo || karte[i].charAt(0) == kriz || karte[i].charAt(0) == pik)
                kartica = karte[i].substring(1);
            else
                kartica = karte[i];
            if (vsebuje(figure, kartica) || vsebuje(taroki, kartica)) {
                vrednosti[i] = 1;
                if (kartica.equals("I") || kartica.equals("XXI") || kartica.equals("SKIS") || kartica.equals("Kralj"))
                    vrednosti[i] = 5;
                if (kartica.equals("Dama"))
                    vrednosti[i] = 4;
                if (kartica.equals("Kaval"))
                    vrednosti[i] = 3;
                if (kartica.equals("Fant"))
                    vrednosti[i] = 2;
            } else
                vrednosti[i] = 1;

        }
        for (int a = 0; a < karte.length; a++) {
            if (karta.equals(karte[a]))
                nekaj = vrednosti[a];
        }
    return nekaj;
    }
    public static void izpisi(String[] tabela) {
        for(int i = 0; i < tabela.length;) {
            for(int a = 0; a < STOLPCI; a++) {
                if (i < tabela.length) {
                    System.out.printf("%8s (%d)", tabela[i], vrednostKarte(tabela[i]));
                    i++;

                }

            }
            System.out.println("");
        }
    }
    public static int preprostoStetje(String[] karte) {
        int vsota = 0;
        for(int i = 0; i < karte.length; i++) {
            vsota += vrednostKarte(karte[i]);
        }
        return vsota;
    }
    public static int natancnoStetje(String[] karte, int zacetek, int konec, boolean izpisuj) {
        int skupaj = 0;
        int i = zacetek;
        while(i < konec) {
            int sestevek = 0;
            String[] trije = new String[3];
            for (int a = 0; a < 3; a++) {
                if(i < konec) {
                    if (i < karte.length) {
                        trije[a] = karte[i];
                        sestevek += vrednostKarte(karte[i]);
                        i++;
                    }
                } else
                    trije[a] = "-";
            }
            if(vsebuje(trije, "-")) {
                sestevek -= 1;
            } else {
                sestevek -= 2;
            }
            skupaj += sestevek;
            if(izpisuj)
                System.out.printf("Trojka:%9s%9s%9s  #  %d \n", trije[0], trije[1], trije[2], sestevek);
        }
        return skupaj;
    }

}
