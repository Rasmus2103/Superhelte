import java.util.Scanner;

public class UserInterface {

        Scanner sc = new Scanner(System.in);

        //Gør det muligt at hente informationer fra Database classen
        Database database = new Database();

        public void startProgram() {
            int menu;

            System.out.println("Velkommen til Superhelte programmet");
            System.out.println("Her kan du tilføje din en eksisterende Superhelt eller lave din hel egen");
            System.out.println("""
                    ------------------------------------------------""");

            //Menuen dukker frem med 2 muligheder opret og afslut
            // do while gør at man har muligheden for at indtaste igen, hvis man ikke indtaster 1 & 9
            do {
                System.out.println("\nVælg en af valgmulighederne " +
                        "\n1 Opret en Superhelt " +
                        "\n2 Se alle superhelte " +
                        "\n3 Find en superhelt" +
                        "\n9 Afslut programmet");
                menu = sc.nextInt();

                //Laver en ny linje for at undgå scannerbug
                sc.nextLine();

                if (menu == 1) {
                    database.createAndAddHero();
                } else if (menu == 2) {
                    for (Helt helte : database.getHelte()) {
                        System.out.println(helte);
                    }
                } else if (menu == 3) {
                    database.searchForHero();
                } else if (menu == 9) {
                    System.out.println("Vi ses");
                    System.exit(0);
                } else {
                    System.out.println("Dit input er ikke gyldigt");
                }
            } while (menu != 9);

            /*switch (menu) {
                case 1:
                    database.createAndAddHero();
                    break;
                case 9:
                    System.out.println("Vi ses");
                    break;
                default:
                    System.out.println("Dit valg er ikke gyldigt");
                    break;
            }*/
        }
}
