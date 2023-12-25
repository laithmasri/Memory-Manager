import student.TestCase;

/**
 * This is the testing class for the Handle.
 * 
 * @author laith
 * @author james
 * @version 11/9
 */
public class HandleTest extends TestCase {
    private Handle handle;

    /**
     * This sets up the test cases
     */
    public void setUp() {
        handle = new Handle(3, 5);
    }


    /**
     * This testing case checks if the getStart()
     * method works fine.
     */
    public void testGetStart() {
        assertEquals(3, handle.getStart());
    }


    /**
     * This testing case checks if the getLength()
     * method works fine.
     */
    public void testGetLength() {
        assertEquals(5, handle.getLength());
    }
}
