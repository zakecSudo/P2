
package naloga05;

import java.io.File;
import java.util.Random;
import java.util.Scanner;

public class DN05 {
    public static void main(String[] args) throws Exception {
        //preberiLabirint(args[0]);
        //izrisiLabirint(preberiLabirint(args[0]));
        //preberiResitev(args[1]);
        //preveriResitev(preberiLabirint(args[0]), preberiResitev(args[1]));
        izrisiLabirint(narediLabirint(10,10, 1));

    }

    public static int[][] preberiLabirint(String ime) throws Exception {
        String[] dimenzije = ime.split("[_.]");
        int sirina = Integer.parseInt(dimenzije[1]);
        int visina = Integer.parseInt(dimenzije[2]);
        int[][] labirint = new int[2 * visina - 1][2 * sirina - 1];
        Scanner datoteka = new Scanner(new File(ime));
        for (int i = 0; i < (2 * visina - 1); i++) {
            for (int a = 0; a < (2 * sirina - 1); a++) {
                labirint[i][a] = datoteka.nextInt();
            }
        }
        return labirint;
    }

    public static void izrisiLabirint(int[][] labirint) {
        StringBuffer zadnja = new StringBuffer("");
        for (int b = 0; b < (labirint[0].length + 2); b++) {
            zadnja.append("# ");
        }
        zadnja.deleteCharAt(zadnja.length() - 1);
        System.out.println(zadnja);
        for (int i = 0; i < labirint.length; i++) {
            System.out.print("#");
            for (int a = 0; a < labirint[0].length; a++) {
                if (labirint[i][a] == 0)
                    System.out.print(" #");
                else
                    System.out.print("  ");
            }
            System.out.println(" #");
        }
        zadnja.setCharAt((labirint[0].length * 2), ' ');
        System.out.println(zadnja);
    }
    public static int[] preberiResitev(String ime) throws Exception {
        Scanner resitev = new Scanner(new File(ime));
        String vBesedi = "";
        while(resitev.hasNext()) {
            vBesedi = vBesedi + resitev.nextInt();
        }
        int[] tabela = new int[vBesedi.length()];
        for(int i = 0; i < vBesedi.length(); i++) {
            int stevilo = vBesedi.charAt(i);
            tabela[i] = (int) (vBesedi.charAt(i) - '0');
        }
        return tabela;
    }
    static boolean preveriResitev(int[][] labirint, int [] resitev) {
        int x = 0;
        int y = 0;
        for(int i = 0; i < resitev.length; i++) {
            if(0 <= x && x <= labirint[0].length && 0 <= y && y <= labirint.length && labirint[y][x] == 1) {
                if(resitev[i] == 3)
                    x -= 1;
                if(resitev[i] == 4)
                    x += 1;
                if(resitev[i] == 5)
                    y -= 1;
                if(resitev[i] == 6)
                    y += 1;
            } else {
                System.out.println("Nepravilna resitev!");
                return false;
            }

        }
        System.out.println("Pravilna resitev!");
        return true;
    }
    public static int nakljucnoMed(int min, int max) {
        if(max - min == 0)
            return 0;
        else
            return new Random().nextInt(max - min) + min;
    }
    public static int[][] narediLabirint(int sirina, int visina, double verjetnost) {
        int[][] labirint = new int[2 * visina - 1][2 * sirina - 1];
        // 1.korak
        for(int i = 0; i < labirint.length; i++) {
            for(int a = 0; a < labirint[0].length; a++) {
                labirint[i][a] = 1;
            }
        }
        Random rnd = new Random();
        int nakljucnoStSirina = rnd.nextInt(2 * sirina - 1);
        int nakljucnoStVisina = rnd.nextInt(2 * visina - 1);
        if(2 * sirina - 1 <= 2) {
            if(2 * sirina - 1 == 1)
                nakljucnoStSirina = 0;
            else
                nakljucnoStSirina = 1;
        }
        if(2 * visina - 1 <= 2) {
            if(2 * visina - 1 == 1)
                nakljucnoStVisina = 0;
            else
                nakljucnoStVisina = 1;
        }
        while(nakljucnoStSirina % 2 == 0 && 2 * sirina - 1 > 2 || nakljucnoStVisina % 2 == 0 && 2 * visina - 1 > 2) {
            if(nakljucnoStSirina % 2 == 0)
                nakljucnoStSirina = rnd.nextInt(2 * sirina - 1);
            if(nakljucnoStVisina % 2 == 0)
                nakljucnoStVisina = rnd.nextInt(2 * visina - 1);
        }
        // 2.korak
        for(int c = 0; c < 2 * visina - 1; c++ ) {
            labirint[c][nakljucnoStSirina] = 0;
        }
        for(int d = 0; d < 2 * sirina - 1; d++) {
            labirint[nakljucnoStVisina][d] = 0;
        }
        // 3.korak
        int sodoSirina;
        int sodoVisina;
        //Pokoncni zgoraj
        if((rnd.nextInt(100) + 1) <= verjetnost * 100) {
            sodoVisina = nakljucnoMed(0, nakljucnoStVisina);
            if(sodoVisina == 1)
                sodoVisina = 0;
            else {
                while (sodoVisina % 2 == 1) {
                    sodoVisina = nakljucnoMed(0, nakljucnoStVisina);
                }
            }
            labirint[sodoVisina][nakljucnoStSirina] = 1;
        }
        //Pokoncni spodaj
        if((rnd.nextInt(100) + 1) <= verjetnost * 100) {
            sodoVisina = nakljucnoMed(nakljucnoStVisina + 1, 2 * visina);
            if(sodoVisina == 1)
                sodoVisina = 0;
            else {
                while (sodoVisina % 2 == 1) {
                    sodoVisina = nakljucnoMed(nakljucnoStVisina + 1, 2 * visina);
                }
            }
            labirint[sodoVisina][nakljucnoStSirina] = 1;
        }
        //Vodoravni levo
        if((rnd.nextInt(100) + 1) <= verjetnost * 100) {
            sodoSirina = nakljucnoMed(0, nakljucnoStSirina);
            if(sodoSirina == 1)
                sodoSirina = 0;
            else {
                while (sodoSirina % 2 == 1) {
                    sodoSirina = nakljucnoMed(0, nakljucnoStSirina);
                }
            }
            labirint[nakljucnoStVisina][sodoSirina] = 1;
        }
        //Vodoravni desno
        if((rnd.nextInt(100) + 1) <= verjetnost * 100) {
            sodoSirina = nakljucnoMed(nakljucnoStSirina + 1, 2 * sirina);
            if(sodoSirina == 1)
                sodoSirina = 0;
            else {
                while (sodoSirina % 2 == 1) {
                    sodoSirina = nakljucnoMed(nakljucnoStSirina + 1, 2 * sirina);
                }
            }
            labirint[nakljucnoStVisina][sodoSirina] = 1;
        }
        // 4.korak
        izrisiLabirint(labirint);
        rekurzija(labirint, nakljucnoStSirina, nakljucnoStVisina, visina, sirina, verjetnost);
        return labirint;
    }


    // 4.korak
    public static int[][] rekurzija(int[][] labirint, int nakljucnoStSirina, int nakljucnoStVisina, int visina, int sirina, double verjetnost) {
        //kvadrati = {0 sirina, 1 visina, 2 x koordinata zgornji levi kot, 3 y koordinata zgornji levi kot, 4 x koordinata spodnji desni kot, 5 y koordinata spodnji desni kot}
        int[][]kvadrati = {{(nakljucnoStSirina + 1) / 2, (nakljucnoStVisina + 1) / 2, 0, 0, nakljucnoStSirina - 1, nakljucnoStVisina - 1}, //Levo zgoraj
                           {(2 * sirina - 1) - (nakljucnoStSirina + 1), nakljucnoStSirina + 1, 0, nakljucnoStVisina - 1, 2 * sirina - 2}, //Desno zgoraj
                           {nakljucnoStSirina, (2 * visina - 1) - (nakljucnoStVisina + 1), 0, nakljucnoStVisina + 1, nakljucnoStSirina - 1, 2 * visina - 2}, //Levo spodaj
                           {(2 * sirina - 1) - (nakljucnoStSirina + 1), (2 * visina - 1) - (nakljucnoStVisina + 1), nakljucnoStSirina + 1, nakljucnoStVisina + 1, 2 * sirina -2, 2 * sirina - 2}}; //Desno spodaj

        for(int e = 0; e < kvadrati.length; e++) {
            if (sirina > 1 && visina > 1) {
                int x = 0;
                int y = 0;
                int[][] kvadratek = narediLabirint(kvadrati[e][0], kvadrati[e][1], verjetnost);
                System.out.println(".....................................");
                izrisiLabirint(kvadratek);
                System.out.println("sirina kvadratka " + kvadratek[0].length);
                System.out.println("visina kvadratka " + kvadratek.length);
                for (int f = kvadrati[e][3]; f <= kvadrati[e][5]; f++) {
                    x = 0;
                    for (int g = kvadrati[e][2]; g <= kvadrati[e][4]; g++) {
                        System.out.println("x koordinata: " + g);
                        System.out.println("y koordinata: " + f);
                        System.out.println("kot x " + kvadrati[0][4]);
                        System.out.println("kot y " + kvadrati[0][5]);
                        System.out.println("Visina labirinta:" + labirint.length);
                        labirint[f][g] = kvadratek[y][x];
                        x++;
                    }
                    y++;
                    izrisiLabirint(labirint);
                }
                return labirint;
            } else {
                return labirint;
            }

        }
        return labirint;
    }
}