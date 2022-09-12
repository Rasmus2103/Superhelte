import java.util.Scanner;

public class Database {

    private Helte[] database = new Helte[5];
    int n = 0;

    Scanner sc;

    public void addSuperhero(String name, String superHeroName, String power, int year, double strength, String orgin, boolean human) {
        //Helte super1 = new Helte(name, superHeroName, power, year, strength, orgin, human);
        database[n] = new Helte(name, superHeroName, power, year, strength, orgin, human);
        n++;
    }

    public void addSuperhero (String name, String power, int year, double strength, String origin, boolean human) {
        database[n] = new Helte(name, power, year, strength, origin, human);
        n++;
    }

    public void createAndAddHero() {
        if(n > database.length) {
            System.out.println("Du kan ikke tilføje flere helte");
        } else {
            sc = new Scanner(System.in);
            System.out.println("Tilføj en Superhelt");

            System.out.println("\nIndtast Superhelten rigtige navn her: ");
            String name = sc.nextLine();

            System.out.println("\n Har din helt et superheltenavn? \nTast 1 for ja \n Tast 2 for nej");
            int svar = sc.nextInt();
            sc.nextLine();

            String superHeroName = null;

            if(svar == 1) {
                System.out.println("\nIndtast superheltenavnet her: ");
                superHeroName = sc.nextLine();
            }

            System.out.println("\nIndtast din helts superkræfter her: ");
            String power = sc.nextLine();

            //Tjekker om ens helt er et menneske
            System.out.println("\nEr din superhelt menneske? :");
            boolean isHuman = true;
            int choice;
            do {
                System.out.println("\n Indtast 1 for ja\nIndtast 2 for nej");
                choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        isHuman = true;
                        break;
                    case 2:
                        isHuman = false;
                        break;
                    default:
                        System.out.println("Dit input kunne ikke registeres, indtast igen");
                }
            } while(choice != 1 && choice != 2);

            sc.nextLine();

            System.out.println("\nIndtast de år de blev udgivet her: ");
            int year = sc.nextInt();

            System.out.println(("\nIndtast din helts styrke niveau her: "));
            double strength = sc.nextDouble();

            System.out.println("\nSkriv din helts oprindelseshistorie her: ");
            String origin = sc.next();

            if(superHeroName == null) {
                addSuperhero(name, power, year, strength, origin, isHuman);
                System.out.println("\nDu har tilføjet " + name + " til databasen");
            } else {
                addSuperhero(name, superHeroName, power, year, strength, origin, isHuman);
                System.out.println("\nDu har tilføjet " + name + "også kaldet for " + superHeroName + " til databasen");
            }



        }
    }

}
