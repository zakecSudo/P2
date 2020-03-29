package naloga02;

public class DN02 {
    static void zvezdice (String [] tabela) {
        for(int i = 0; i < tabela.length; i += 1) {
            for (int stevec = 0; stevec < (tabela[i].length() + 4); stevec += 1) {
                System.out.print('*');
            }
            System.out.print(' ');
        }
        System.out.println('\n');
    }
    public static void main(String [] args) {
        zvezdice(args);
        for(int i = 0;i < args.length; i += 1) {
            System.out.print("* " + args[i] + " * ");
        }
        System.out.println('\n');
        zvezdice(args);
    }
}

