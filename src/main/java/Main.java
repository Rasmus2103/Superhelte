import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Database database = new Database();

        System.out.println("Velkommen til Superhelte programmet");
        System.out.println("Her kan du tilføje din egen Superhelt");

        Scanner sc = new Scanner(System.in);

        int n;
        System.out.println("\nIndtast Superhelten rigtige navn her: ");
        String name = sc.nextLine();

        System.out.println("Indtast superheltenavnet her: ");
        String superHeroName = sc.nextLine();

        System.out.println("Indtast din helts superkræfter her: ");
        String power = sc.nextLine();

        System.out.println("Indtast de år de blev udgivet her: ");
        int year = sc.nextInt();

        System.out.println(("Indtast din helts styrke niveau her: "));
        double strength = sc.nextDouble();

        System.out.println("Skriv din helts oprindelseshistorie her: ");
        String origin = sc.next();

        database.addSuperhero(name, superHeroName, power, year, strength, origin);
    }
}
