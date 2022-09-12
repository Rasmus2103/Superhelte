public class Helte {

    private String name;
    private String superHeroName;
    private String power;
    private int year;
    private double strength;
    private String origin;
    private boolean human;

    public Helte(String name, String superheroName, String power, int year, double strength, String origin, boolean human) {
        this.name = name;
        this.superHeroName = superheroName;
        this.power = power;
        this.year = year;
        this.human = human;
        this.strength = strength;
        this.origin = origin;
    }

    public Helte(String name, String power, int year, double strength, String origin, boolean human) {
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

    public void setName() {
        this.name = name;
    }

    public String getSuperHeroName() {
        return superHeroName;
    }

    public String getPower() {
        return power;
    }

    public int getYear() {
        return year;
    }

    public void setYear() {
        this.year = year;
    }

    public double getStrength() {
        return strength;
    }

    public String getOrigin() {
        return origin;
    }

    public boolean getHuman() {
        return human;
    }

}
