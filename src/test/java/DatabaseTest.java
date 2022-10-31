import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DatabaseTest {
    //Arrange
    //Act
    //Assert
    //Helt helt;
    Database database;
    Helt testHelt1;
    Helt testHelt2;
    Helt testHelt3;


    @BeforeEach
    void setUp() {
        Database database = new Database();

        testHelt1 = new Helt("Clark Kent", "Supermand", "Laserøjne", 1938, 9.7, "Blev sendt væk da Krypton eksploderet, og han endte på Jorden.", false);
        testHelt2 = new Helt("Peter Parker", "Spider Man", "Edderkoppekræfter", 1968, 8.6, "Han blev bidt af en radioaktiv edderkop.", true);
        testHelt3 = new Helt("Bruce Wayne", "Batman", "Gadgets", 1938, 8.6, "Hans forældre blev dræbt, han trænede hårdt, og blev til Batman.", true);

        database.getHelte().add(testHelt1);
        database.getHelte().add(testHelt2);
        database.getHelte().add(testHelt3);
    }


    @Test
    void addSuperhero() {
        //Arrange
        Database database = new Database();

        //Act
        database.addSuperhero("Rasmus", "Super Rasmus", "Kodning",1999, 9.7, "sdjifdsbfdsiof", true);
        //assertEquals(længde, database.getHelte().size());
        //Assert
        //assertEquals(database.getHelte().size(), 1); //Tjekker om der er 1 objekt i ArrayListen
        assertTrue(database.getHelte().size() > 3);
        assertNotEquals(database.getHelte().get(3), null);
    }

    @Test
    void testAddSuperhero() {

    }

    @Test
    void userChoiceCreate() {

    }

    @Test
    void createAndAddHero() {
        Database database = new Database();

        //Arrange
        int expectedLength = 3;
        int actualLength = 4;

        //Act
        database.addSuperhero("Rasmus", "Super Rasmus", "Kodning",1999, 9.7, "sdjifdsbfdsiof", true);

        //Assert
        assertEquals(expectedLength, actualLength, database.getHelte().size());
    }

    @Test
    void searchForHero() {
        String name = "Clark Kent";
        assertEquals(name, testHelt1.getName());
    }

    @Test
    void userChoiceEdit() {
    }

    @Test
    void editTool() {
    }

    @Test
    void getHelte() {

        String expectedName = "Clark Kent";

        String actualName = testHelt1.getName();

        assertEquals(actualName, expectedName);
    }

    @Test
    void deleteHero() {

        int expectedValueOfDeletion = 2;
        String expectedNameOfNewIndex0 = "Clark Kent";

        database.deleteHero();

        assertAll("Tester om Spider Man er slettet og Supermand nu står i første index (0)",
                () -> assertEquals(expectedValueOfDeletion, database.getHelte().size()),
                () -> assertEquals(expectedNameOfNewIndex0, database.getHelte().get(0).getName()));

    }
}