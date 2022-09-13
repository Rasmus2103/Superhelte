import java.util.ArrayList;
import java.util.Scanner;

public class Database {

    //private Helte[] database = new Helte[5];
    private ArrayList<Helt> helte = new ArrayList();
    //int n = 0;

    Scanner sc;

    public void addSuperhero(String name, String superHeroName, String power, int year, double strength, String orgin, boolean human) {
        helte.add(new Helt(name, superHeroName, power, year, strength, orgin, human));
    }

    public void addSuperhero (String name, String power, int year, double strength, String origin, boolean human) {
         helte.add(new Helt(name, power, year, strength, origin, human));
    }

    //Oprettelse af Superhelte
    public void createAndAddHero() {
        //Tjekker om oprettelsen overskrider det maksimale i helte arrayet
        /*if(n > database.length) {
            System.out.println("Du kan ikke tilføje flere helte");
        }*/
            sc = new Scanner(System.in);
            System.out.println("Du kan nu tilføje en Superhelt");

            System.out.println("\nIndtast Superhelten rigtige navn her: ");
            String name = sc.nextLine();

            System.out.println("\n Har din helt et superheltenavn? \nTast 1 for ja \n Tast 2 for nej");
            int svar = sc.nextInt();
            sc.nextLine();

            //Laver superHeroName til null da den starter med ikke have nogen værdi
            String superHeroName = null;

            //Tilføjer et superheltenavn hvis man taster 1, hvilket giver den en værdi
            if(svar == 1) {
                System.out.println("\nIndtast superheltenavnet her: ");
                superHeroName = sc.nextLine();
            }

            System.out.println("\nIndtast din helts superkræfter her: ");
            String power = sc.nextLine();

            //Tjekker om ens helt er et menneske
            System.out.println("\nEr din superhelt et menneske? :");
            boolean isHuman = true;
            int choice = 0;
            while(choice != 1 && choice != 2) {
                System.out.println("\n Indtast 1 for ja\nIndtast 2 for nej");
                choice = sc.nextInt();
                if(choice == 1) {
                    isHuman = true;
                }
                else if(choice == 2) {
                    isHuman = false;
                } else {
                    System.out.println("Dit input kan ikke registeres, indtast igen");
                }

                /*switch (choice) {
                    case 1:
                        isHuman = true;
                        break;
                    case 2:
                        isHuman = false;
                        break;
                    default:
                        System.out.println("Dit input kunne ikke registeres, indtast igen");
                }*/
            }

            sc.nextLine();

            System.out.println("\nIndtast de år de blev udgivet her: ");
            int year = sc.nextInt();

            System.out.println(("\nIndtast din helts styrke niveau her: "));
            double strength = sc.nextDouble();

            System.out.println("\nSkriv din helts oprindelseshistorie her: ");
            String origin = sc.next();

            //Tjekker om helten har et superheltenavn
            if(superHeroName == null) {
                addSuperhero(name, power, year, strength, origin, isHuman);
                System.out.println("\nDu har tilføjet " + name + " til databasen");
            } else {
                addSuperhero(name, superHeroName, power, year, strength, origin, isHuman);
                System.out.println("\nDu har tilføjet " + name + " også kaldet for " + superHeroName + " til databasen");
            }

    }

    public ArrayList<Helt> getHelte() {
        return helte;
    }

}