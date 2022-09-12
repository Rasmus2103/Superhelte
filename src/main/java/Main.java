import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Database database = new Database();

        Scanner sc = new Scanner(System.in);

        int menu;

        System.out.println("Velkommen til Superhelte programmet");
        System.out.println("Her kan du tilføje din egen Superhelt");

        //Menuen dukker frem med 2 muligheder opret og exit
        do {
            System.out.println("Vælg en af en valgmuligheder \n1 Opret en Superhelt \n9 Forlad");
            menu = sc.nextInt();

            //Laver en ny linje for at undgå scannerbug
            sc.nextLine();
            switch (menu) {
                case 1:
                    database.createAndAddHero();
                    break;
                case 9:
                    System.out.println("Vi ses");
                    break;
                default:
                    System.out.println("Dit valg er ikke gyldigt");
                    break;
            }
        } while (menu != 9);

    }
}
