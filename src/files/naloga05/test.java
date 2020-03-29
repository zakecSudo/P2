
package naloga05;

import java.io.File;
import java.util.Random;
import java.util.Scanner;

public class test {
    //razdeljenLabirint = {0 sirina, 1 visina, 2 x koordinata zgornji levi kot, 3 y koordinata zgornji levi kot, 4 x koordinata spodnji desni kot, 5 y koordinata spodnji desni kot}
    public static int[][] razdeljenLabirint = new int[4][6];

    public static void main(String[] args) throws Exception {
        //preberiLabirint(args[0]);
        //izrisiLabirint(preberiLabirint(args[0]));
        //preberiResitev(args[1]);
        //preveriResitev(preberiLabirint(args[0]), preberiResitev(args[1]));
        //System.out.println("");
        int[][] labirint = narisiStene(10,10, 1);
        izrisiLabirint(labirint);
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
    /*
------------------------------------------------------------
    THIS METHOD IS USED FOR MAKING THE MAZE
------------------------------------------------------------
     */
    public static int[][] narisiStene(int sirina, int visina, double verjetnost) {
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
        //Nakljucno sodo stevilo v interavlu dimenzij
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
        labirint = rekurzija(labirint, nakljucnoStSirina, nakljucnoStVisina, visina, sirina, verjetnost);
        return labirint;
    }


    public static int[][] labirintOdDo(int[][] zamenjanec, int[][] drugi, int zgornjaX, int zgornjaY) {
        int x = 0;
        int y = 0;
        for(int i = zgornjaY; i < (zgornjaY + drugi.length); i++) {
            x = 0;
            for(int a = zgornjaX; a < (zgornjaX + drugi[0].length); a++) {
                zamenjanec[y][x] = drugi[i][a];
                x++;
            }
            y++;
        }
        return zamenjanec;
    }

    // 4.korak
    /*
------------------------------------------------------------
    THIS METHOD IS THE RECURSION
------------------------------------------------------------
     */
    public static int[][] rekurzija(int[][] labirint, int nakljucnoStSirina, int nakljucnoStVisina, int visina, int sirina, double verjetnost) {
        //kvadrati = {0 sirina, 1 visina, 2 x koordinata zgornji levi kot, 3 y koordinata zgornji levi kot, 4 x koordinata spodnji desni kot, 5 y koordinata spodnji desni kot}
        int[][]kvadrati = {{(nakljucnoStSirina + 1) / 2, (nakljucnoStVisina + 1) / 2, 0, 0, nakljucnoStSirina - 1, nakljucnoStVisina - 1}, //Levo zgoraj
                {(2 * sirina - 1) - (nakljucnoStSirina + 1), nakljucnoStSirina + 1, 0, nakljucnoStVisina - 1, 2 * sirina - 2}, //Desno zgoraj
                {nakljucnoStSirina, (2 * visina - 1) - (nakljucnoStVisina + 1), 0, nakljucnoStVisina + 1, nakljucnoStSirina - 1, 2 * visina - 2}, //Levo spodaj
                {(2 * sirina - 1) - (nakljucnoStSirina + 1), (2 * visina - 1) - (nakljucnoStVisina + 1), nakljucnoStSirina + 1, nakljucnoStVisina + 1, 2 * sirina -2, 2 * sirina - 2}}; //Desno spodaj

        if (sirina > 1 && visina > 1) {
            int x = 0;
            int y = 0;
            izrisiLabirint(labirint);
            int[][] kvadratek = narisiStene(kvadrati[0][0], kvadrati[0][1], verjetnost);
            for(int i = 0; i < kvadrati.length; i++) {
                System.out.println(".....................................");
                int s = kvadrati[i][3];
                int z =  kvadrati[i][5];
                for (int f = kvadrati[i][3]; f < kvadrati[i][5]; f++) {
                    x = 0;
                    for (int g = kvadrati[i][2]; g < kvadrati[i][4]; g++) {
                        labirint[f][g] = kvadratek[y][x];
                        x++;
                        izrisiLabirint(labirint);
                    }
                    y++;
                }
            }
        } else {
            return labirint;
        }
        return labirint;

    }
}
