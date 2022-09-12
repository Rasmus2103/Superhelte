public class Helte {

    private String name;
    private String superHeroName;
    private String power;
    private int year;
    private double strength;
    private String origin;

    public Helte(String name, String superheroName, String power, int year, double strength, String origin) {
        this.name = name;
        this.superHeroName = superheroName;
        this.power = power;
        this.year = year;
        this.strength = strength;
        this.origin = origin;
    }

    public String getName() {
        return name;
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

    public double getStrength() {
        return strength;
    }

    public String getOrigin() {
        return origin;
    }

}
