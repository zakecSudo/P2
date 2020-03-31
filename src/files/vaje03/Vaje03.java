package files.vaje03;

public class Vaje03 {
    public static final char znak = '\u2B1B'; // Square character
    public static final char blank = '\u2B1C'; // Empty square character

    public static final char[] abeceda = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', ' '};
    public static final short[] abeceda16bit = {
            (short)0b1001111110011111,
            (short)0b0101101101010011,
            (short)0b1111000100011111,
            (short)0b0111100110010111,
            (short)0b1111000101111111,
            (short)0b0001011100011111,
            (short)0b1111100100011111,
            (short)0b1001111110011001,
            (short)0b1111001000101111,
            (short)0b1111100110001111,
            (short)0b1001010100111101,
            (short)0b1111000100010001,
            (short)0b1001100111011111,
            (short)0b1001100111011011,
            (short)0b1111100110011111,
            (short)0b0001111110011111,
            (short)0b1111110110011111,
            (short)0b0101111110011111,
            (short)0b1110111100011111,
            (short)0b0010001000101111,
            (short)0b1111100110011001,
            (short)0b0110100110011001,
            (short)0b1111110110011001,
            (short)0b1001011001101001,
            (short)0b0010111110011001,
            (short)0b1111001001001111,
            (short)0b0110100110010110,
            (short)0b1111010001000110,
            (short)0b1111001001000111,
            (short)0b1111100011101111,
            (short)0b1000111110011001,
            (short)0b0110011100011111,
            (short)0b1111100111110001,
            (short)0b1000100010001111,
            (short)0b1110101111010111,
            (short)0b1000111110011111,
            0
    };
    public static final long[] abeceda64bit = {
            0b1110011101000010010000100111111001000010010000100010010000011000L,
            0b0111111110000010100000101000001001111110001000100100001000111111L,
            0b0011110001000010100000010000000100000001100000010100001000111100L,
            0b0011111101000010100000101000001010000010100000100100001000111111L,
            0b1111111110000010000000100000001000001110000000101000001011111111L,
            0b0000011100000010000100100001111000010010100000101000001011111111L,
            0b0111110010000010100000011000100111111001000000011000001011111100L,
            0b1110011101000010010000100100001001111110010000100100001011100111L,
            0b1111111100001000000010000000100000001000000010000000100011111111L,
            0b0001111000100001001000010010001100100000001000000010000011111100L,
            0b1110011101000010001000100001001000001110000100100010001011110111L,
            0b1111111110000010100000100000001000000010000000100000001000000111L,
            0b1110011101000010010000100100001001001010010010100101011011100011L,
            0b1110011101000010010000100110001001010010010010100100011011100011L,
            0b0011110001000010100000011000000110000001100000010100001000111100L,
            0b0000011100000010000000100111111010000010100000101000001001111111L,
            0b0000100001111110100010011000000110000001100000011000000101111110L,
            0b1110011101000010001000100111111010000010100000101000001001111111L,
            0b0111110110000011100000010100000000111110100000011100000110111110L,
            0b0011100000010000000100000001000000010000000100001001000111111111L,
            0b0111111010000001100000011000000110000001100000011000000111100111L,
            0b0001000000101000001001000100010001000010010000100100001011100111L,
            0b0011010001001010010010100100101001000010010000100100001011100111L,
            0b1110011101000010001001000010010000011000001001000100001011100111L,
            0b0011100000010000000100000001000000101000001001000100001011100111L,
            0b1111111110000010100001000000100000010000001000010100000111111111L,
            0b0011110001000010100001011000100110010001101000010100001000111100L,
            0b1111111100001000000010000000100000001000000010000000101000001100L,
            0b1111111110000001100001100001100001100000100000001000000101111110L,
            0b0111111010000001100000011000000001110000100000011000000101111110L,
            0b1110000001000000111111110100001001000100010010000101000001100000L,
            0b0111111010000001100000011000000001111111000000011000000111111111L,
            0b0111111010000001100000011000000101111111000000011000000101111110L,
            0b0001110000001000000010000001000000100000010000001000000111111111L,
            0b0111111010000001100000011000000101111110100000011000000101111110L,
            0b0111111010000001100000001111111010000001100000011000000101111110L,
            0
    };

    public static void main (String[] args) {
        izpisiZnak16bit((short)0b1001111110011111);
        System.out.println();
        izpisiNiz16bit(new short[] {(short)0b0001011100011111, (short)0b0101111110011111, (short)0b1111001000101111});
        System.out.println();
        izpisiNiz16bit("Programiranje je zakon");
        System.out.println();

        izpisiZnak64bit(0b1110011101000010010000100111111001000010010000100010010000011000L);
        System.out.println();
        izpisiNiz64bit(new long[] {0b0000011100000010000000100111111010000010100000101000001001111111L, 0b1111111110000001100001100001100001100000100000001000000101111110L});
        System.out.println();
        izpisiNiz64bit("Juhej");
        System.out.println();

        izpisiZnak64bit(4342206308063461948L);
        System.out.println();
        izpisiZnak64bit(-6521708140789089256L);
        System.out.println("---------------------------------------------------------------------------------");
        izpisiNiz64bit("1 čips2 jajca");
        System.out.println("---------------------------------------------------------------------------------");
//        izpisiNiz16bit(abeceda16bit);
//        izpisiNiz64bit(abeceda64bit);
    }

    public static void izpisiZnak16bit (short kodaZnaka)  {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (kodaZnaka % 2 == 0) System.out.print(blank);
                else System.out.print(znak);
                kodaZnaka >>= 1;
            }
            System.out.println();
        }
    }

    public static void izpisiNiz16bit (short[] nizZnakov) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < nizZnakov.length; j++) {
                for (int k = 0; k < 4; k++) {
                    if (nizZnakov[j] % 2 == 0) System.out.print(blank);
                    else System.out.print(znak);
                    nizZnakov[j] >>= 1;
                }
                System.out.print(blank);
            }
            System.out.println();
        }
    }

    public static int getChar (char c) {
        for (int i = 0; i < abeceda.length; i++) {
            if (c == abeceda[i]) return i;
        }
        return abeceda.length - 1; // If char is not found return blank char
    }

    public static void izpisiNiz16bit (String nizZnakov) {
        nizZnakov = nizZnakov.toLowerCase();
        short[] nizZnakovChars = new short[nizZnakov.length()];
        for (int i = 0; i < nizZnakov.length(); i++) {
            nizZnakovChars[i] = abeceda16bit[getChar(nizZnakov.charAt(i))];
        }
        izpisiNiz16bit(nizZnakovChars);
    }

    public static void izpisiZnak64bit (long kodaZnaka) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (kodaZnaka % 2 == 0) System.out.print(blank);
                else System.out.print(znak);
                kodaZnaka >>= 1;
            }
            System.out.println();
        }
    }

    public static void izpisiNiz64bit (long[] nizZnakov) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < nizZnakov.length; j++) {
                for (int k = 0; k < 8; k++) {
                    if (nizZnakov[j] % 2 == 0) System.out.print(blank);
                    else System.out.print(znak);
                    nizZnakov[j] >>= 1;
                }
                System.out.print(blank);
            }
            System.out.println();
        }
    }

     public static void izpisiNiz64bit(String nizZnakov) {
        nizZnakov = nizZnakov.toLowerCase();
        long[] nizZnakovLongs = new long[nizZnakov.length()];
        for (int i = 0; i < nizZnakov.length(); i++) {
            nizZnakovLongs[i] = abeceda64bit[getChar(nizZnakov.charAt(i))];
        }
        izpisiNiz64bit(nizZnakovLongs);
    }
}
