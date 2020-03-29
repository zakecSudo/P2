package naloga04;//To nalogo sem pošteno zakompliciral :D

public class DN04 {


    public static void main(String [] args) {
        String primerjalec = izpisiAje(args[0].length());
        while(vsotaBSD(args[0]) != vsotaBSD(primerjalec)) {
            primerjalec = menjaj(primerjalec);
        }
        if(vsotaBSD(args[0]) == vsotaBSD(primerjalec))
            System.out.println(primerjalec);

    }

    public static String menjaj(String menjalec) {
        int i = 1;
        while (true) {
            if(i >= 2 && menjalec.charAt(menjalec.length() - i) != 'z') {
                char crka = novaCrka(menjalec.charAt(menjalec.length() - i));
                String vrni_1 = zamenjaj(menjalec, crka, (menjalec.length() - i));
                vrni_1 = vrni_1.substring(0, ((menjalec.length() - i) + 1)) + izpisiAje(((menjalec.length() - 1) - (menjalec.length() - i)));
                return vrni_1;

            }
            if (menjalec.charAt(menjalec.length() - i) != 'z') {
                char crka = novaCrka(menjalec.charAt(menjalec.length() - i));
                String vrni = zamenjaj(menjalec, crka, (menjalec.length() - i));
                return vrni;
            } else {
                i++;
            }
        }
    }
    public static String zamenjaj(String zamenjanec, char zamenjalka, int mesto) {
        String prvi = zamenjanec.substring(0, mesto);
        String drugi = zamenjanec.substring((mesto + 1), (zamenjanec.length()));
        String nova = prvi + zamenjalka + drugi;
        return nova;
    }
    public static char novaCrka(char crka) {
        if (crka == 'z')
                return 'a';
        else {
            char naslednja = (char) (crka + 1);
            return naslednja;
        }
    }
    public static String izpisiAje(int mesta) {
        String rezultat = "";
        for(int i = 0; i < mesta; i++) {
                rezultat += "a";
        }
        return rezultat;
    }
    public static int vsotaBSD(String niz) {
        int checksum = 0;
        for (int i = 0; i<niz.length(); i++) {
            checksum = (checksum >> 1) + ((checksum & 1) << 15);
            checksum += niz.charAt(i);
            checksum &= 0xffff;
        }
        return checksum;
    }
}
