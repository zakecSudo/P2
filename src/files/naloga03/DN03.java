package naloga03;

//Mogoče sem preveč zakompliciral zadevo :D
public class DN03 {
    public static void main (String [] args) {
        if (args.length != 2) {
            System.out.println("Uporaba: java DN03 n m");
            System.exit(0);
        }
        int min = Integer.parseInt(args[0]);
        int max = Integer.parseInt(args[1]);
        int maxClenov = 0;
        for(int i = min; i <= max; i++) {
            if(i % 2 == 0) {
                int racunanec = i;
                int stClenov = 1;
                while(racunanec != 1) {
                    if(racunanec % 2 == 0) {
                        racunanec = racunanec / 2;
                    } else {
                        racunanec = 3 * racunanec + 1;
                    }
                    stClenov ++;
                }
                if(stClenov > maxClenov)
                    maxClenov = stClenov;
            }
            if(i % 2 == 1) {
                int racunanec = i;
                int stClenov = 1;
                while(racunanec != 1) {
                    if(racunanec % 2 == 0) {
                        racunanec = racunanec / 2;
                    } else {
                        racunanec = 3 * racunanec + 1;
                    }
                    stClenov ++;
                }
                if(stClenov > maxClenov)
                    maxClenov = stClenov;
            }
        }
        System.out.printf("Najdaljse Collatzovo zaporedje pri %d <= i <= %d ima %d clenov.", min, max, maxClenov);
    }
}
