import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Database {
    private ArrayList<Helt> helte;

    public Database() {
        Helt h1 = new Helt("Clark Kent", "Supermand", "Laserøjne", 1938, 9.7, "dfsdfsdfdsdf", false);
        Helt h2 = new Helt("Peter Parker", "Spider Man", "Edderkoppekræfter", 1968, 8.6, "klkkjoasij", true);

        helte = new ArrayList<Helt>(List.of(h1, h2));
    }

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

    public void searchForHero() {
        sc = new Scanner(System.in);
        System.out.println("Du kan her søge på Superhelte");
        System.out.println("\n1 Søg efter navn " +
                            "\n2 Søg efter superheltenavn" +
                            "\n3 Søg efter power" +
                            "\n4 Søg efter udgivelsesår" +
                            "\n5 Søg efter styrkeniveau" +
                            "\n6 Søg efter oprindelseshistorie");
        int choice = sc.nextInt();
        if(choice == 1) {
            searchByname();
        }
        if(choice == 2) {
            searchBySuperName();
        }
        if(choice == 3) {
            searchByPower();
        }
        if(choice == 4) {
            searchByYear();
        }
        if(choice == 5) {
            searchByStrength();
        }
        if(choice == 6) {
            searchByOrigin();
        }

    }

    private void searchByname() {
        sc = new Scanner(System.in);

        System.out.println("Du kan nu søge efter navn");
        String name = sc.nextLine();
        boolean fundet = false;
        for(Helt helt : helte) {
            if(helt.getName().toLowerCase().contains(name.toLowerCase())) {
                System.out.println("Din søgning på " + name + " gav disse resultater " + helt + "\n");
                fundet = true;
            }
        }
        if(!fundet) {
            System.out.println("Kunne ikke finde " + name + " i databasen");
        }
    }

    private void searchBySuperName() {
        sc = new Scanner(System.in);

        System.out.println("Du kan nu søge efter superheltenavnet");
        String name = sc.nextLine();
        boolean fundet = false;
        for(Helt helt : helte) {
            if(helt.getSuperHeroName().toLowerCase().contains(name.toLowerCase())) {
                System.out.println("Din søgning på " + name + " gav disse resultater " + helt + "\n");
                fundet = true;
            }
        }
        if(!fundet) {
            System.out.println("Kunne ikke finde " + name + " i databasen");
        }
    }

    private void searchByPower() {
        sc = new Scanner(System.in);

        System.out.println("Du kan nu søge efter superkræfter");
        String name = sc.nextLine();
        boolean fundet = false;
        for(Helt helt : helte) {
            if(helt.getPower().toLowerCase().contains(name.toLowerCase())) {
                System.out.println("Din søgning på " + name + " gav disse resultater " + helt + "\n");
                fundet = true;
            }
        }
        if(!fundet) {
            System.out.println("Kunne ikke finde " + name + " i databasen");
        }
    }

    private void searchByYear() {
        sc = new Scanner(System.in);

        System.out.println("Du kan nu søge efter udgivelsesår");
        int year = sc.nextInt();
        boolean fundet = false;
        for(Helt helt : helte) {
            if(helt.getYear() == year) {
                System.out.println("Din søgning på " + year + " gav disse resultater " + helt + "\n");
                fundet = true;
            }
        }
        if(!fundet) {
            System.out.println("Kunne ikke finde " + year + " i databasen");
        }
    }

    private void searchByStrength() {
        sc = new Scanner(System.in);

        System.out.println("Du kan nu søge efter styrkeniveau");
        double strength = sc.nextDouble();
        boolean fundet = false;
        for(Helt helt : helte) {
            if(helt.getStrength() == strength) {
                System.out.println("Din søgning på " + strength + " gav disse resultater " + helt + "\n");
                fundet = true;
            }
        }
        if(!fundet) {
            System.out.println("Kunne ikke finde " + strength + " i databasen");
        }
    }

    private void searchByOrigin() {
        sc = new Scanner(System.in);

        System.out.println("Du kan nu søge efter oprindelseshistorie");
        String orgin = sc.nextLine();
        boolean fundet = false;
        for(Helt helt : helte) {
            if(helt.getOrigin().toLowerCase().contains(orgin.toLowerCase())) {
                System.out.println("Din søgning på " + orgin + " gav disse resultater " + helt + "\n");
                fundet = true;
            }
        }
        if(!fundet) {
            System.out.println("Kunne ikke finde " + orgin + " i databasen");
        }
    }


    public ArrayList<Helt> getHelte() {
        return helte;
    }

}