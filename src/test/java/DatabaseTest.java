import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.xml.crypto.Data;
import java.util.Arrays;

class DatabaseTest {
    //Arrange
    //Act
    //Assert
    Helt helt;

    @BeforeEach
    void setUp() {
        Database database = new Database();

        Helt testHelt1 = new Helt("Clark Kent", "Supermand", "Laserøjne", 1938, 9.7, "Blev sendt væk da Krypton eksploderet, og han endte på Jorden.", false);
        Helt testHelt2 = new Helt("Peter Parker", "Spider Man", "Edderkoppekræfter", 1968, 8.6, "Han blev bidt af en radioaktiv edderkop.", true);
        Helt testHelt3 = new Helt("Bruce Wayne", "Batman", "Gadgets", 1938, 8.6, "Hans forældre blev dræbt, han trænede hårdt, og blev til Batman.", true);

        database.getHelte().addAll(Arrays.asList(testHelt1, testHelt2, testHelt3));
    }

    @Test
    void addSuperhero() {
        //Arrange
        Database database = new Database();

        //Act
        database.addSuperhero("Clark Kent", "Supermand", "Laserøjne", 1938, 9.7, "kdfnsdkisgf", false);

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
        //Arrange
        Database database = new Database();

        //Act

    }

    @Test
    void searchForHero() {
        /*Database database = new Database();

        //Arrange
        int expectedListSizeNone = 0;
        int expectedListSizeOne = 1;
        int expectedListSizeMany = 3;

        //Act
        String testSearchWordNone = "Powerman";
        String testSearchWordOne = "Luke";
        String testSearchWordMany = "man";

        //Assert
        int testListSizeNone = database.searchForHero(testSearchWordNone).size();*/
    }

    @Test
    void userChoiceEdit() {
    }

    @Test
    void editTool() {
    }

    @Test
    void getHelte() {
        Database database = new Database();

        String expectedName = "Clark Kent";

        String actualName = helt.getName();

        assertEquals(actualName, expectedName);
    }

    @Test
    void deleteHero() {
        Database database = new Database();

        int expectedValueOfDeletion = 2;
        String expectedNameOfNewIndex0 = "Clark Kent";

        database.deleteHero();

        assertAll("Tester om Spider Man er slettet og Supermand nu står i første index (0)",
                () -> assertEquals(expectedValueOfDeletion, database.getHelte().size()),
                () -> assertEquals(expectedNameOfNewIndex0, database.getHelte().get(0).getName()));

    }
}