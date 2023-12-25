import student.TestCase;

/**
 * DataBaseTest
 * 
 * * @author laith
 * 
 * @author james
 * @version 11/9
 */
public class DataBaseTest extends TestCase {
    private String[] keys;
    private DataBase dataBase;

    /**
     * Sets up the test case.
     */
    public void setUp() {
        dataBase = new DataBase(8, 8);
        keys = new String[4];
        keys[0] = "";
        keys[1] = "";
        keys[2] = "";
        keys[3] = "";
    }


    /**
     * Test case for insert method.
     */
    public void testInsert() {
        short x = 0;
        short y = 0;
        assertEquals(2, dataBase.insert(2, "", "", 0, x, y, 0, keys, ""));
    }


    /**
     * Test case for delete method.
     */
    public void testDelete() {
        short x = 0;
        short y = 0;
        assertEquals(2, dataBase.insert(2, "", "", 0, x, y, 0, keys, ""));
        assertTrue(dataBase.delete(2));
    }


    /**
     * Test case for search method.
     */
    public void testSearch() {
        short x = 0;
        short y = 0;
        assertEquals(2, dataBase.insert(2, "", "", 0, x, y, 0, keys, ""));
        assertTrue(dataBase.search(2));
    }


    /**
     * Test case for print method.
     */
    public void testPrint() {
        dataBase.printHashTable();
        dataBase.printBlock();
    }
}
