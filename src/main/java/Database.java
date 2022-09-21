import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Database {
    private ArrayList<Helt> helte = new ArrayList<>();

    public Database() {
        helte.add(new Helt("Clark Kent", "Supermand", "Laserøjne", 1938, 9.7, "Blev sendt væk da Krypton eksploderet, og han endte på Jorden.", false));
        helte.add(new Helt("Peter Parker", "Spider Man", "Edderkoppekræfter", 1968, 8.6, "Han blev bidt af en radioaktiv edderkop.", true));
        helte.add(new Helt("Bruce Wayne", "Batman", "Gadgets", 1938, 8.6, "Hans forældre blev dræbt, han trænede hårdt, og blev til Batman.", true));

        //helte = new ArrayList<Helt>(List.of(h1, h2, h3));
    }
    UserInterface ui;
    Scanner sc;

    public void addSuperhero(String name, String superHeroName, String power, int year, double strength, String orgin, boolean human) {
        helte.add(new Helt(name, superHeroName, power, year, strength, orgin, human));
    }

    public void addSuperhero (String name, String power, int year, double strength, String origin, boolean human) {
         helte.add(new Helt(name, power, year, strength, origin, human));
    }

    //Menu for at vælge at oprette en superhelt eller gå tilbage til startmenuen
    public void userChoiceCreate() {
        sc = new Scanner(System.in);
        ui = new UserInterface();
        System.out.println("1 Opret en superhelt" +
                "\n9 Tilbage til menuen");

        int choice = sc.nextInt();
        if (choice == 1) {
            createAndAddHero();
        }
        else if(choice == 9) {
            ui.startProgram();
        }
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

            //Laver superHeroName til null, da den starter med ikke have nogen værdi
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
                    System.out.println(Color.RED + "Dit input kan ikke registeres, indtast igen" + Color.RESET);
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
            while(!sc.hasNextInt()) {
                String text = sc.next();
                System.out.println("Du må ikke skrive " + text + ", det skal være tal");
            }
            int year = sc.nextInt();

            System.out.println(("\nIndtast din helts styrke niveau her: "));
            while (!sc.hasNextDouble()) {
                String text = sc.next();
                System.out.println(Color.RED + "Du må ikke indtaste " + text + ", det skal være kommatal" + Color.RESET);
            }
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

    //Kommer frem med 6 søgemuligheder for at finde en superhelt
    public void searchForHero() {
        sc = new Scanner(System.in);
        ui = new UserInterface();

        System.out.println("Du kan her søge på Superhelte");
        System.out.println("\n1 Søg efter navn " +
                            "\n2 Søg efter superheltenavn" +
                            "\n3 Søg efter power" +
                            "\n4 Søg efter udgivelsesår" +
                            "\n5 Søg efter styrkeniveau" +
                            "\n6 Søg efter oprindelseshistorie" +
                            "\n9 Tilbage til menuen");
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
        if(choice == 9) {
            ui.startProgram();
        }

    }

    private void searchByname() {
        sc = new Scanner(System.in);

        System.out.println("Du kan nu søge efter navn");
        String name = sc.nextLine();
        boolean fundet = false;
        for(Helt helt : helte) {
            if(helt.getName().toLowerCase().contains(name.toLowerCase())) {
                System.out.println("Din søgning på " + Color.GREEN + name + Color.RESET + " gav disse resultater " + helt + "\n");
                fundet = true;
                searchForHero();
            }
        }
        if(!fundet) {
            System.out.println(Color.RED + "Kunne ikke finde " + name + " i databasen" + Color.RESET);
            searchByname();
        }
    }

    //Kan søge navnet på superhelten
    private void searchBySuperName() {
        sc = new Scanner(System.in);

        System.out.println("Du kan nu søge efter superheltenavnet");
        String name = sc.nextLine();
        boolean fundet = false;
        for(Helt helt : helte) {
            if(helt.getSuperHeroName().toLowerCase().contains(name.toLowerCase())) {
                System.out.println("Din søgning på " + name + " gav disse resultater " + helt + "\n");
                fundet = true;
                searchForHero();
            }
        }
        if(!fundet) {
            System.out.println("Kunne ikke finde " + name + " i databasen");
            searchBySuperName();
        }
    }

    //Kan søge efter superheltens superheltenavn
    private void searchByPower() {
        sc = new Scanner(System.in);

        System.out.println("Du kan nu søge efter superkræfter");
        String name = sc.nextLine();
        boolean fundet = false;
        for(Helt helt : helte) {
            if(helt.getPower().toLowerCase().contains(name.toLowerCase())) {
                System.out.println("Din søgning på " + name + " gav disse resultater " + helt + "\n");
                fundet = true;
                searchForHero();
            }
        }
        if(!fundet) {
            System.out.println("Kunne ikke finde " + name + " i databasen");
            searchByPower();
        }
    }

    //Kan søge efter udgivelsesår
    private void searchByYear() {
        sc = new Scanner(System.in);

        System.out.println("Du kan nu søge efter udgivelsesår");
        int year = sc.nextInt();
        boolean fundet = false;
        for(Helt helt : helte) {
            if(helt.getYear() == year) {
                System.out.println("Din søgning på " + year + " gav disse resultater " + helt + "\n");
                fundet = true;
                searchForHero();
            }
        }
        if(!fundet) {
            System.out.println("Kunne ikke finde " + year + " i databasen");
            searchByYear();
        }
    }

    //Kan søge efter styrkeniveau
    private void searchByStrength() {
        sc = new Scanner(System.in);

        System.out.println("Du kan nu søge efter styrkeniveau");
        double strength = sc.nextDouble();
        boolean fundet = false;
        for(Helt helt : helte) {
            if(helt.getStrength() == strength) {
                System.out.println("Din søgning på " + strength + " gav disse resultater " + helt + "\n");
                fundet = true;
                searchForHero();
            }
        }
        if(!fundet) {
            System.out.println("Kunne ikke finde " + strength + " i databasen");
            searchByStrength();
        }
    }

    //Kan søge efter oprindelseshistorie
    private void searchByOrigin() {
        sc = new Scanner(System.in);

        System.out.println("Du kan nu søge efter oprindelseshistorie");
        String orgin = sc.nextLine();
        boolean fundet = false;
        for(Helt helt : helte) {
            if(helt.getOrigin().toLowerCase().contains(orgin.toLowerCase())) {
                System.out.println("Din søgning på " + orgin + " gav disse resultater " + helt + "\n");
                fundet = true;
                searchForHero();
            }
        }
        if(!fundet) {
            System.out.println("Kunne ikke finde " + orgin + " i databasen");
            searchByOrigin();
        }
    }

    public void userChoiceEdit() {
        sc = new Scanner(System.in);
        ui = new UserInterface();
        System.out.println("1 Redigere en superhelt" +
                        "\n9 Tilbage til menuen");

        int choice = sc.nextInt();
        if (choice == 1) {
            editTool();
        }
        else if(choice == 9) {
            ui.startProgram();
        }
    }

    //Kan rette informationerne om alle de oprettet superhelte
    public void editTool() {
        sc = new Scanner(System.in);

        for(int i = 0; i < getHelte().size(); i++) {
            System.out.println(i + 1 + " Helt: " + getHelte().get(i));
        }

        System.out.println("Indtast nr på den superhelt der skal redigeres:");
        int nr = sc.nextInt();
        sc.nextLine();

        Helt retHelt = null;
        if(nr-1 >= helte.size()) {
            System.out.println(Color.RED + "Nr. " + nr + " findes ikke i databasen" + Color.RESET);
            userChoiceEdit();
        } else {
            retHelt = helte.get(nr - 1);

            //Helt retHelt = getHelte().get(nr - 1);
            System.out.println("Ret helt: " + retHelt);

            System.out.println("Rediger data og tryk ENTER. Hvis data ikke skal redigeres tryk ENTER ");

            System.out.println("Navn: " + retHelt.getName());
            String newName = sc.nextLine();
            if (!newName.isEmpty()) {
                retHelt.setName(newName);
            }

            System.out.println("Superhelte navn: " + retHelt.getSuperHeroName());
            String newSuperName = sc.nextLine();
            if (!newSuperName.isEmpty()) {
                retHelt.setSuperHeroName(newSuperName);
            }

            System.out.println("Superkræfter: " + retHelt.getPower());
            String newPower = sc.nextLine();
            if (!newPower.isEmpty()) {
                retHelt.setPower(newPower);
            }

            System.out.println("Udgivelsesår: " + retHelt.getYear());
            String newYear = sc.nextLine();
            if (!newYear.isEmpty()) {
                retHelt.setYear(Integer.parseInt(newYear));
            }

            System.out.println("Styrkeniveau: " + retHelt.getStrength());
            String newStrength = sc.nextLine();
            if (!newStrength.isEmpty()) {
                retHelt.setStrength(Double.parseDouble(newStrength));
            }

            System.out.println("Oprindelses historie " + retHelt.getOrigin());
            String newOrigin = sc.nextLine();
            if (!newOrigin.isEmpty()) {
                retHelt.setOrigin(newOrigin);
            }
        }
    }

    public void deleteHero() {
        sc = new Scanner(System.in);
        ui = new UserInterface();

        System.out.println("Vælg en helt du gerne vil have slettet");
        for(Helt helt: helte) {
            System.out.println(helte.indexOf(helt) + 1 + ". " + helt.getName());
        }
        int choice1 = readInt();
        System.out.println("Er du sikker på du gerne vil slette " + helte.get(choice1 -1).getName() + " \n1 Slet " +
                            helte.get(choice1 -1).getName() + "\n2. Fortryd");

        int choice2 = readInt();
        if(choice2 == 1) {
            ui.startProgram();
        }
        else if(choice2 == 2) {
            ui.startProgram();
        }
        else {
            System.out.println("Dit input er ikke gyldigt");
            deleteHero();
        }
    }

    public int readInt() {
        while(!sc.hasNextInt()) {
            String text = sc.next();
            System.out.println(text + " er ugyldig input, prøv igen");
        }
        int result;
        result = sc.nextInt();
        sc.nextLine();
        return result;
    }


    public ArrayList<Helt> getHelte() {
        return helte;
    }

}