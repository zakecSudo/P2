package files.vaje03;

public class Vaje03_moja {


    public static void main(String [] args) {
        /*
        izpisiZnak16bit((short)0b1001111110011111);
        System.out.println("");
        izpisiNiz16bit("Programiranje je zakon");
        System.out.println("");
        izpisiZnak64bit(0b1010010101111110001111001111111111011011011111100011110000011000L);
        System.out.println("");
        izpisiNiz64bit("Juhej");
        */
    }

    private static final char znak = '\u2B1B'; // Square character ⬛
    private static final char blank = '\u2B1C'; // Empty Square character ⬜
    private static final char[] abeceda = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', ' '};
    private static final short[] abeceda16bit = {
            (short) 0b1001111110011111, // a
            (short) 0b0101101101010011, // b
            (short) 0b1111000100011111, // c
            (short) 0b0111100110010111, // d
            (short) 0b1111000101111111, // e
            (short) 0b0001011100011111, // f
            (short) 0b1111100100011111, // g
            (short) 0b1001111110011001, // h
            (short) 0b1111001000101111, // i
            (short) 0b1111100110001111, // j
            (short) 0b1001010100111101, // k
            (short) 0b1111000100010001, // l
            (short) 0b1001100111011111, // m
            (short) 0b1001100111011011, // n
            (short) 0b1111100110011111, // o
            (short) 0b0001111110011111, // p
            (short) 0b1111110110011111, // q
            (short) 0b0101111110011111, // r
            (short) 0b1110111100011111, // s
            (short) 0b0010001000101111, // t
            (short) 0b1111100110011001, // u
            (short) 0b0110100110011001, // v
            (short) 0b1111110110011001, // w
            (short) 0b1001011001101001, // x
            (short) 0b0010111110011001, // y
            (short) 0b1111001001001111, // z
            (short) 0b0110100110010110, // 0
            (short) 0b1111010001000110, // 1
            (short) 0b1111001001000111, // 2
            (short) 0b1111100011101111, // 3
            (short) 0b1000111110011001, // 4
            (short) 0b0110011100011111, // 5
            (short) 0b1111100111110001, // 6
            (short) 0b1000100010001111, // 7
            (short) 0b1110101111010111, // 8
            (short) 0b1000111110011111, // 9
            (short) 0b0000000000000000, // _
    };
    private static final long[] abeceda64bit = {
            0b1110011101000010010000100111111001000010010000100010010000011000L, // a
            0b0111111110000010100000101000001001111110001000100100001000111111L, // b
            0b0011110001000010100000010000001000000011000000101000010001111100L, // c
            0b0011111101000010100000101000001010000010100000100100001000111111L, // d
            0b1111111110000010000000100000001000001110000000101000001011111111L, // e
            0b0000011100000010000100100001111000010010100000101000001011111111L, // f
            0b0111110010000010100000011000100111111001000000011000001011111100L, // g
            0b1110011101000010010000100100001001111110010000100100001011100111L, // h
            0b1111111100001000000010000000100000001000000010000000100011111111L, // i
            0b0001111000100001001000010010001100100000001000000010000011111100L, // j
            0b1110011101000010001000100001001000001110000100100010001011110111L, // k
            0b1111111110000010100000100000001000000010000000100000001000000111L, // l
            0b1110011101000010010000100100001001001010010010100101011011100011L, // m
            0b1110011101000010010000100110001001010010010010100100011011100011L, // n
            0b0011110001000010100000011000000110000001100000010100001000111100L, // o
            0b0000011100000010000000100111111010000010100000101000001001111111L, // p
            0b0000100001111110100010011000000110000001100000011000000101111110L, // q
            0b1110011101000010001000100111111010000010100000101000001001111111L, // r
            0b0111110110000011100000010100000000111110100000011100000110111110L, // s
            0b0011100000010000000100000001000000010000000100001001000111111111L, // t
            0b0111111010000001100000011000000110000001100000011000000111100111L, // u
            0b0001000000101000001001000100010001000010010000100100001011100111L, // v
            0b0011010001001010010010100100101001000010010000100100001011100111L, // w
            0b1110011101000010001001000010010000011000001001000100001011100111L, // x
            0b0011100000010000000100000001000000101000001001000100001011100111L, // y
            0b1111111110000010100001000000100000010000001000010100000111111111L, // z
            0b0011110001000010100001011000100110010001101000010100001000111100L, // 0
            0b1111111100001000000010000000100000001000000010000000101000001100L, // 1
            0b1111111110000001100001100001100001100000100000001000000101111110L, // 2
            0b0111111010000001100000011000000001110000100000011000000101111110L, // 3
            0b1110000001000000111111110100001001000100010010000101000001100000L, // 4
            0b0111111010000001100000011000000001111111000000011000000111111111L, // 5
            0b0111111010000001100000011000000101111111000000011000000101111110L, // 6
            0b0001110000001000000010000001000000100000010000001000000111111111L, // 7
            0b0111111010000001100000011000000101111110100000011000000101111110L, // 8
            0b0111111010000001100000001111111010000001100000011000000101111110L, // 9
            0b0000000000000000000000000000000000000000000000000000000000000000L, // _
            0b0011110001000010100111011010000110010101100101010100001000111100L, // :D
            0b1010010101111110001111001111111111011011011111100011110000011000L, // DD
    };

    public static void izpisiZnak16bit(short kodaZnaka) {
        for(int a = 0; a < 4; a++) {
            for (int i = 0; i < 4; i++) {
                if ((Math.abs(kodaZnaka) % 2) == 1)
                    System.out.print(znak);
                else
                    System.out.print(blank);
                kodaZnaka = (short) (kodaZnaka >> 1);
            }
            System.out.println("");
        }
    }
// DRUGA

    public static void izpisiTabelo16bit(short[] nizZnakov) {
        for(int b = 0; b < 4; b++) {
            for(int a = 0; a < nizZnakov.length; a++) {
                for (int i = 0; i < 4; i++) {
                    if ((Math.abs(nizZnakov[a]) % 2) == 1)
                        System.out.print(znak);
                    else
                        System.out.print(blank);
                    nizZnakov[a] = (short) (nizZnakov[a] >> 1);
                }
                System.out.print(blank);
            }
            System.out.println("");
        }
    }

    public static void izpisiNiz16bit(String nizZnakov) {
        short tabela[] =  new short[nizZnakov.length()];
        int mesto = 0;
        for(int i = 0; i < nizZnakov.length(); i++) {
            int a = 0;
            boolean pravilen = true;
            while(pravilen) {
                if(Character.toLowerCase(nizZnakov.charAt(i)) == abeceda[a]) {
                    tabela[mesto] = abeceda16bit[a];
                    mesto++;
                    pravilen = false;
                }
                a++;
            }
        }
        izpisiTabelo16bit(tabela);
    }

    private static void izpisiZnak64bit(long kodaZnaka) {
        for(int a = 0; a < 8; a++) {
            for (int i = 0; i < 8; i++) {
                if ((Math.abs(kodaZnaka) % 2) == 1)
                    System.out.print(znak);
                else
                    System.out.print(blank);
                kodaZnaka = (long) (kodaZnaka >> 1);
            }
            System.out.println("");
        }
    }
//NALOGA IZPIŠI izpisiTabelo64bit VENDAR JE PREIMENOVANA ZARADI UPORABNOSTI
    private static void izpisiTabelo64bit(long [] nizZnakov) {
        for(int b = 0; b < 8; b++) {
            for(int a = 0; a < nizZnakov.length; a++) {
                for (int i = 0; i < 8; i++) {
                    if ((Math.abs(nizZnakov[a]) % 2) == 1)
                        System.out.print(znak);
                    else
                        System.out.print(blank);
                    nizZnakov[a] = (nizZnakov[a] >> 1);
                }
                System.out.print(blank);
            }
            System.out.println("");
        }
    }
    public static void izpisiNiz64bit(String nizZnakov) {
        long tabela[] =  new long[nizZnakov.length()];
        int mesto = 0;
        for(int i = 0; i < nizZnakov.length(); i++) {
            int a = 0;
            boolean pravilen = true;
            while(pravilen) {
                if(Character.toLowerCase(nizZnakov.charAt(i)) == abeceda[a]) {
                    tabela[mesto] = abeceda64bit[a];
                    mesto++;
                    pravilen = false;
                }
                a++;
            }
        }
        izpisiTabelo64bit(tabela);
    }

}

