public class Database {

    private Helte[] database = new Helte[5];
    int n = 0;

    public void addSuperhero(String name, String superHeroName, String power, int year, double strength, String orgin) {
        Helte super1 = new Helte(name, superHeroName, power, year, strength, orgin);
        database[n] = super1;
        n++;
    }

}
