public class Helt {

    private String name;
    private String superHeroName;
    private String power;
    private int year;
    private double strength;
    private String origin;
    private boolean human;

    public Helt(String name, String superheroName, String power, int year, double strength, String origin, boolean human) {
        this.name = name;
        this.superHeroName = superheroName;
        this.power = power;
        this.year = year;
        this.human = human;
        this.strength = strength;
        this.origin = origin;
    }

    public Helt(String name, String power, int year, double strength, String origin, boolean human) {
        this.name = name;
        this.power = power;
        this.year = year;
        this.human = human;
        this.strength = strength;
        this.origin = origin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSuperHeroName() {
        return superHeroName;
    }

    public void setSuperHeroName(String superHeroName) {
        this.superHeroName = superHeroName;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getStrength() {
        return strength;
    }

    public void setStrength(double strength) {
        this.strength = strength;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public boolean getHuman() {
        return human;
    }

    public void setHuman() {
        this.human = human;
    }

    public String toString() {
        String text;
        if(human)
            text = "Ja";
        else
            text = "Nej";
        return Color.GREEN + "\nNavn: " + name +
                "\nSuperheltnavn: " + superHeroName +
                "\nSuperkræft: " + power +
                "\nUdgivelses år: " + year +
                "\nStyrkeniveau: " + strength +
                "\nOprindelses historie: " + origin +
                "\nMenneske: " + text + "\n" + Color.RESET;
    }

}
