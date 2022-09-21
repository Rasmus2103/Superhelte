import java.util.Scanner;

public class UserInterface {

        Scanner sc = new Scanner(System.in);

        //Gør det muligt at hente informationer fra Database classen
        Database database = new Database();

        public void startProgram() {
            int menu;

            System.out.println(Color.CYAN + "Velkommen til Superhelte programmet" + Color.RESET);
            System.out.println(Color.CYAN + "Her kan du tilføje en eksisterende Superhelt eller lave din hel egen" + Color.RESET);
            System.out.println(Color.CYAN + """
                    ------------------------------------------------""" + Color.RESET);

            //Menuen dukker frem med 5 muligheder
            // do while gør at man har muligheden for at indtaste igen, hvis man ikke indtaster 1 & 9
            do {
                System.out.println(Color.CYAN + "\nVælg en af valgmulighederne " +
                        "\n1 Opret en Superhelt " +
                        "\n2 Se alle superhelte " +
                        "\n3 Find en superhelt" +
                        "\n4 Ret en superhelt" +
                        "\n5 Slet en superhelt" +
                        "\n9 Afslut programmet" + Color.RESET);
                menu = sc.nextInt();

                //Laver en ny linje for at undgå scannerbug
                sc.nextLine();

                if (menu == 1) {
                    database.userChoiceCreate();
                } else if (menu == 2) {
                    for (Helt helte : database.getHelte()) {
                        System.out.println(helte);
                    }
                } else if (menu == 3) {
                    database.searchForHero();
                } else if(menu == 4) {
                    database.userChoiceEdit();
                } else if(menu == 5) {
                    database.deleteHero();
                }
                else if (menu == 9) {
                    System.out.println(Color.GREEN + "Vi ses" + Color.RESET);
                    System.exit(0);
                } else {
                    System.out.println(Color.RED + "Dit input er ikke gyldigt" + Color.RESET);
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
