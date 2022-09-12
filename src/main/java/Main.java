import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Database database = new Database();

        Scanner sc = new Scanner(System.in);

        int menu;

        System.out.println("Velkommen til Superhelte programmet");
        System.out.println("Her kan du tilføje din egen Superhelt");

        do {
            System.out.println("Vælg en af en valgmuligheder \n1 Opret en Superhelt \n9 Forlad");
            menu = sc.nextInt();

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

        /*System.out.println("\nIndtast Superhelten rigtige navn her: ");
        String name = sc.nextLine();

        System.out.println("\nIndtast superheltenavnet her: ");
        String superHeroName = sc.nextLine();

        System.out.println("\nIndtast din helts superkræfter her: ");
        String power = sc.nextLine();

        System.out.println("\nIndtast de år de blev udgivet her: ");
        int year = sc.nextInt();

        System.out.println(("\nIndtast din helts styrke niveau her: "));
        double strength = sc.nextDouble();

        System.out.println("\nSkriv din helts oprindelseshistorie her: ");
        String origin = sc.next();

        System.out.println("\nEr din superhelt menneske? :");
        boolean human = sc.hasNext();*/

        //database.addSuperhero(name, superHeroName, power, year, strength, origin, human);
    }
}
