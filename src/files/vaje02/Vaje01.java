package files.vaje02;

public class Vaje01 {
    public static void main(String [] args) {
        izracunajPiLeibniz(2);
        izpisiPi(4);
        System.out.println("\n");
        vrniNLeibniz(4);
        System.out.println("\n");
        izracunajPiNilakantha(16384);
        System.out.println("\n");
        izpisiLeibNilak(4);
        System.out.println("\n");
        vrniNLeibNilak(4);
        System.out.println("\n");
        izracunajPiWallis(8);
        System.out.println("\n");
        izpisiVse(4);
        System.out.println("\n");
        vrniVse(4);
    }
    public static double izracunajPiLeibniz(int n) {
        double rezultat = 1;
        double stevec = 1;
        for(int i = 1; i < n; i++) {
            if(stevec > 0) {
                stevec = -1 * (stevec + 2);
            } else {
                stevec = -1 * (stevec - 2);
            }
            rezultat += 1 / stevec;
        }
        /* Komentar zaradi druge naloge
        System.out.println(4 * rezultat);
         */
        return (4 * rezultat);
    }
// DRUGA
    public static void izpisiPi(int n) {
        double stDecimalk = Math.pow(10, 6);
        double steviloPi = 0;
        int stevec = 1;
        double razlika = 0;
        System.out.println("       n    Math.PI              PI (Leibniz)          razlika ");
        System.out.println("-------------------------------------------------------------------------");
        while((Math.round(steviloPi * stDecimalk) / stDecimalk) != (Math.round(Math.PI * stDecimalk) / stDecimalk)) {
            steviloPi = izracunajPiLeibniz(stevec);
            razlika = Math.PI - steviloPi;
            if(razlika < 0)
                System.out.printf("%8d    %.15f    %.15f    %.15f\n", stevec, Math.PI, steviloPi, razlika);
            else
                System.out.printf("%8d    %.15f    %.15f    +%.15f\n", stevec, Math.PI, steviloPi, razlika);
            stevec = stevec * 2;
        }
    }

// TRETJA
    public static int vrniNLeibniz(int stMest) {
        double stDecimalk = Math.pow(10, stMest);
        double steviloPi = 0;
        int stevec = 1;
        while((int) (steviloPi * stDecimalk) != (int) (Math.PI * stDecimalk)) {
            steviloPi = izracunajPiLeibniz(stevec);
            stevec ++;
        }
        System.out.printf("Za izracun stevila PI = 3,141592653589793 na %d decimalk natancno moramo izracunati n clenov vrste:\n", stMest);
        System.out.println(" vrsta                 n    priblizek");
        System.out.println("---------------------------------------------");
        System.out.printf("Leibniz       %11d  %.15f", stevec - 1, steviloPi);
        System.out.println("\n");
        return stevec - 1;
    }
// ČETRTA
    public static double nekaVariacija(double stevilo) {
        double rezultat = 1;
        for(int i = 0; i < 3; i++) {
            rezultat *= stevilo;
            stevilo -= 1;
        }
    return rezultat;
    }
    public static double izracunajPiNilakantha(int n) {
        int ulomek = 4;
        double zacetek = -1;
        double steviloPi = 3;
        for (int i = 1; i < n; i++) {
            if (zacetek < 0)
                zacetek = 4 / (nekaVariacija(ulomek));
            else
                zacetek = -1 * (4 / (nekaVariacija(ulomek)));
            steviloPi += Math.round(zacetek * Math.pow(10, 15)) / Math.pow(10, 15);
            ulomek += 2;
        }
        return steviloPi;
    }
    public static void izpisiLeibNilak(int stMest) {
        double stDecimalk = Math.pow(10, stMest);
        double steviloPi = 0;
        double steviloPiNilak = 0;
        int stevec = 1;
        double razlika = 0;
        System.out.println("       n    Math.PI              PI (Leibniz)         PI (Nilakantha)          razlika ");
        System.out.println("-------------------------------------------------------------------------");
        while((((int) (steviloPi * stDecimalk)) / stDecimalk) != (((int) (Math.PI * stDecimalk)) / stDecimalk)) {
            steviloPi = izracunajPiLeibniz(stevec);
            steviloPiNilak = izracunajPiNilakantha(stevec);
            razlika = Math.PI - steviloPiNilak;
            if(razlika < 0)
                System.out.printf("%8d    %.15f    %.15f    %.15f    %.15f\n", stevec, Math.PI, steviloPi, steviloPiNilak, razlika);
            else
                System.out.printf("%8d    %.15f    %.15f    %.15f    +%.15f\n", stevec, Math.PI, steviloPi, steviloPiNilak, razlika);
            stevec = stevec * 2;
        }
    }
    public static void vrniNLeibNilak(int stMest) {
        double stDecimalk = Math.pow(10, stMest);
        double steviloPiLeib = 0;
        int stevecLeib = 1;
        while((int) (steviloPiLeib * stDecimalk) != (int) (Math.PI * stDecimalk)) {
            steviloPiLeib = izracunajPiLeibniz(stevecLeib);
            stevecLeib ++;
        }
        double steviloPiNilak = 0;
        int stevecNilak = 1;
        while((int) (steviloPiNilak * stDecimalk) != (int) (Math.PI * stDecimalk)) {
            steviloPiNilak = izracunajPiNilakantha(stevecNilak);
            stevecNilak++;
        }
        System.out.printf("Za izracun stevila PI = 3,141592653589793 na %d decimalk natancno moramo izracunati n clenov vrste:\n", stMest);
        System.out.println(" vrsta                 n    priblizek");
        System.out.println("---------------------------------------------");
        System.out.printf("Leibniz       %11d  %.15f\n", stevecLeib - 1, steviloPiLeib);
        System.out.printf("Nilakantha    %11d  %.15f", stevecNilak - 1, steviloPiNilak);
        System.out.println("\n");
    }
// PETA
    public static double produkt(int maxSt) {
        double sodo = maxSt - 1;
        double liho = maxSt - 2;
        double rezultat = (sodo * sodo) / (maxSt * liho);
        return rezultat;
    }
    public static double izracunajPiWallis(int n) {
        double rezultat = 1;
        int zacetek = 3;
        for (int i = 0; i < n; i++) {
            rezultat *= produkt(zacetek);
            zacetek += 2;
        }
        return 2 * rezultat;
    }
    public static void izpisiVse(int stMest) {
        double stDecimalk = Math.pow(10, stMest);
        double steviloPi = 0;
        double steviloPiNilak = 0;
        double steviloPiWalle = 0;
        int stevec = 1;
        double razlika = 0;
        System.out.println("       n    Math.PI              PI (Leibniz)         PI (Nilakantha)      PI (Wallis)           razlika ");
        System.out.println("-------------------------------------------------------------------------------------------------------------------");
        while((((int) (steviloPiWalle * stDecimalk)) / stDecimalk) != (((int) (Math.PI * stDecimalk)) / stDecimalk)) {
            steviloPi = izracunajPiLeibniz(stevec);
            steviloPiNilak = izracunajPiNilakantha(stevec);
            steviloPiWalle = izracunajPiWallis(stevec);
            razlika = Math.PI - steviloPiWalle;
            if(razlika < 0)
                System.out.printf("%8d    %.15f    %.15f    %.15f    %.15f    %.15f\n", stevec, Math.PI, steviloPi, steviloPiNilak, steviloPiWalle, razlika);
            else
                System.out.printf("%8d    %.15f    %.15f    %.15f    %.15f    +%.15f\n", stevec, Math.PI, steviloPi, steviloPiNilak, steviloPiWalle, razlika);
            stevec = stevec * 2;
        }
    }
    public static void vrniVse(int stMest) {
        double stDecimalk = Math.pow(10, stMest);
        double steviloPiLeib = 0;
        int stevecLeib = 1;
        while((int) (steviloPiLeib * stDecimalk) != (int) (Math.PI * stDecimalk)) {
            steviloPiLeib = izracunajPiLeibniz(stevecLeib);
            stevecLeib ++;
        }
        double steviloPiNilak = 0;
        int stevecNilak = 1;
        while((int) (steviloPiNilak * stDecimalk) != (int) (Math.PI * stDecimalk)) {
            steviloPiNilak = izracunajPiNilakantha(stevecNilak);
            stevecNilak++;
        }
        double steviloPiWalle = 0;
        int stevecWalle = 1;
        while((int) (steviloPiWalle * stDecimalk) != (int) (Math.PI * stDecimalk)) {
            steviloPiWalle = izracunajPiWallis(stevecWalle);
            stevecWalle++;
        }
        System.out.printf("Za izracun stevila PI = 3,141592653589793 na %d decimalk natancno moramo izracunati n clenov vrste:\n", stMest);
        System.out.println(" vrsta                 n    priblizek");
        System.out.println("---------------------------------------------");
        System.out.printf("Leibniz       %11d  %.15f\n", stevecLeib - 1, steviloPiLeib);
        System.out.printf("Nilakantha    %11d  %.15f\n", stevecNilak - 1, steviloPiNilak);
        System.out.printf("Wallis        %11d  %.15f", stevecWalle - 1, steviloPiWalle);
        System.out.println("\n");
    }
}
