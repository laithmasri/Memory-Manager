import student.TestCase;

/**
 * Test class for the Record class.
 * 
 * @author laith
 * @author james
 * @version 11/9
 */
public class RecordTest extends TestCase {
    private Record record;

    /**
     * This is the setup method.
     */
    public void setUp() {
        record = new Record(1);
    }


    /**
     * tests the get id method.
     */
    public void testGetId() {
        assertEquals(1, record.getId());
    }


    /**
     * tests the set id method.
     */
    public void testSetId() {
        record.setId(0);
        assertEquals(0, record.getId());
    }


    /**
     * test more constructors
     */
    public void testRecord() {
        Record record01 = new Record(2, new Handle(2, 2));
        short x = 0;
        short y = 0;
        String[] keywords = new String[2];
        keywords[0] = "laith";
        keywords[1] = "james";
        Record record02 = new Record(2, "", "", 2, x, y, 2, keywords, "");
        String string = "ID: 2, Title: \n"
            + "Date: , Length: 2, X: 0, Y: 0, Cost: 2\n" + "Description: \n"
            + "Keywords: laith, james";
        assertEquals(string, record02.toString());
    }
}
