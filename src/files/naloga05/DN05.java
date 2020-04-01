

import java.io.File;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class DN05 {
    //razdeljenLabirint = {0 sirina, 1 visina, 2 x koordinata zgornji levi kot, 3 y koordinata zgornji levi kot, 4 x koordinata spodnji desni kot, 5 y koordinata spodnji desni kot}
    public static int[][] razdeljenLabirint = new int[4][6];

    public static void main(String[] args) throws Exception {
        if(args.length == 2) {
           int[][] labirint = preberiLabirint(args[0]);
           izrisiLabirint(labirint);
           int[] resitev = preberiResitev(args[1]);
           preveriResitev(labirint, resitev);
        }
        if(args.length == 3) {
            int sirina = Integer.parseInt(args[0]);
            int visina = Integer.parseInt(args[1]);
            int verjetnost = Integer.parseInt(args[2]);
            int [][] nekaj = narediLabirint(sirina, visina, verjetnost);
            izrisiLabirint(nekaj);
            shraniLabirint(nekaj, "labirint");

        }

        //C:\Users\Zakec\Desktop
        /*
        int[][] labirint = narediLabirint(3,10, 1);
        izrisiLabirint(labirint);
        shraniLabirint(labirint, "C:\\Users\\Zakec\\Desktop\\test.txt");
        */
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

    // 4.korak
    /*
------------------------------------------------------------
    REKURZIJA
------------------------------------------------------------
     */
    public static int[][] rekurzija(int[][] labirint, int nakljucnoStSirina, int nakljucnoStVisina, int visina, int sirina, double verjetnost) {
        //kvadrati = {0 sirina, 1 visina, 2 x koordinata zgornji levi kot, 3 y koordinata zgornji levi kot, 4 x koordinata spodnji desni kot, 5 y koordinata spodnji desni kot}
        int[][]kvadrati = {{(nakljucnoStSirina + 1) / 2, (nakljucnoStVisina + 1) / 2, 0, 0, nakljucnoStSirina - 1, nakljucnoStVisina - 1}, //Levo zgoraj
                {(((2 * sirina - 1) - (nakljucnoStSirina + 1)) + 1) / 2, ((nakljucnoStVisina) + 1) / 2, nakljucnoStSirina + 1, 0, 2 * sirina - 2, nakljucnoStVisina - 1}, //Desno zgoraj
                {((nakljucnoStSirina) + 1) / 2, (((2 * visina - 1) - (nakljucnoStVisina + 1)) + 1) / 2, 0, nakljucnoStVisina + 1, nakljucnoStSirina - 1, 2 * visina - 2}, //Levo spodaj
                {(((2 * sirina - 1) - (nakljucnoStSirina + 1)) + 1) / 2, (((2 * visina - 1) - (nakljucnoStVisina + 1)) + 1) / 2, nakljucnoStSirina + 1, nakljucnoStVisina + 1, 2 * sirina - 2, 2 * visina - 2}}; //Desno spodaj

        if (sirina > 1 && visina > 1) {
            int x;
            int y;
            int i;
            int a;
            if(kvadrati[0][0] > 1 && kvadrati[0][1] > 1);
            int[][] leviZgoraj = narediLabirint(kvadrati[0][0], kvadrati[0][1], verjetnost);
            if(kvadrati[1][0] > 1 && kvadrati[1][1] > 1);
            int[][] desniZgoraj = narediLabirint(kvadrati[1][0], kvadrati[1][1], verjetnost);
            if(kvadrati[2][0] > 1 && kvadrati[2][1] > 1);
            int[][] leviSpodaj = narediLabirint(kvadrati[2][0], kvadrati[2][1], verjetnost);
            if(kvadrati[3][0] > 1 && kvadrati[3][1] > 1);
            int[][] desniSpodaj = narediLabirint(kvadrati[3][0], kvadrati[3][1], verjetnost);

            //Levi zgoraj
            y = 0;
            for(i = kvadrati[0][3]; i < kvadrati[0][5]; i++) {
                x = 0;
                for(a = kvadrati[0][2]; a < kvadrati[0][4]; a++) {
                    labirint[i][a] = leviZgoraj[y][x];
                    x++;
                }
                y++;
            }
            //Desni zgoraj
            y = 0;
            for(i = kvadrati[1][3]; i < kvadrati[1][5]; i++) {
                x = 0;
                for(a = kvadrati[1][2]; a < kvadrati[1][4]; a++) {
                    labirint[i][a] = desniZgoraj[y][x];
                    x++;
                }
                y++;
            }
            //Levi spodaj
            y = 0;
            for(i = kvadrati[2][3]; i < kvadrati[2][5]; i++) {
                x = 0;
                for(a = kvadrati[2][2]; a < kvadrati[2][4]; a++) {
                    labirint[i][a] = leviSpodaj[y][x];
                    x++;
                }
                y++;
            }
            //Desni spodaj
            y = 0;
            for(i = kvadrati[3][3]; i < kvadrati[3][5]; i++) {
                x = 0;
                for(a = kvadrati[3][2]; a < kvadrati[3][4]; a++) {
                    labirint[i][a] = desniSpodaj[y][x];
                    x++;
                }
                y++;
            }

        } else {
            return labirint;
        }
        return labirint;
    }
    public static void shraniLabirint(int[][] labirint, String ime) throws Exception{
        String datoteka = String.format("%s_%d_%d.txt", ime, (labirint[0].length + 1) / 2, (labirint.length + 1) / 2);
        PrintWriter vpisi = new PrintWriter(datoteka);
        for(int i = 0; i < labirint.length; i++) {
            for(int a = 0; a < labirint[0].length; a++) {
                vpisi.print(labirint[i][a]);
            }
            vpisi.println("");
        }
        vpisi.close();
    }


}
