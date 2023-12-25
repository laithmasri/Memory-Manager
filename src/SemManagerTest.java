import java.io.FileNotFoundException;
import java.io.IOException;
import student.TestCase;

/**
 * @author {Laith Al-Masri}
 * @version 11/9
 */
public class SemManagerTest extends TestCase {

    private String[] correctValue;
    private String[] oneWrong01;
    private String[] oneWrong02;
    private String[] bothWrong;
    private String[] lessCommands;
    private String[] moreCommands;

    /**
     * Sets up the tests that follow. In general, used for initialization
     */
    public void setUp() {
        correctValue = new String[3];
        correctValue[0] = "512";
        correctValue[1] = "64";
        correctValue[2] = "test.txt";

        oneWrong01 = new String[3];
        oneWrong01[0] = "512";
        oneWrong01[1] = "63";
        oneWrong01[2] = "test.txt";

        oneWrong02 = new String[3];
        oneWrong02[0] = "512";
        oneWrong02[1] = "63";
        oneWrong02[2] = "test.txt";

        bothWrong = new String[3];
        bothWrong[0] = "511";
        bothWrong[1] = "63";
        bothWrong[2] = "test.txt";

        lessCommands = new String[2];
        lessCommands[0] = "512";
        lessCommands[1] = "64";

        moreCommands = new String[4];
        moreCommands[0] = "512";
        moreCommands[1] = "64";
        moreCommands[2] = "test.txt";
        moreCommands[3] = "test.txt";
    }


    /**
     * Get code coverage of the class declaration.
     * 
     * @throws FileNotFoundException
     * @throws NumberFormatException
     */
    public void testMInitx() throws FileNotFoundException {
        SemManager sem = new SemManager();
        assertNotNull(sem);
        // SemManager.main(null);
    }


    /**
     * This test case checks if the output
     * value is the same as what is expected.
     * 
     * @throws IOException
     */
    public void testMain() throws IOException {
        String[] args = new String[3];
        args[0] = "512";
        args[1] = "4";
        args[2] = "P1Sample_input.txt";
        SemManager.main(args);
        String output = systemOut().getHistory();
        String referenceOutput = FileReader.readFile("P1Sample_output.txt");
        assertEquals(referenceOutput, output);
    }


    /**
     * This tests corrects commands
     * 
     * @throws FileNotFoundException
     */
    public void testMainCorrect() throws FileNotFoundException {
        SemManager.main(correctValue);
        String output = systemOut().getHistory();
        assertEquals("", output);
    }


    /**
     * This tests one corrects commands
     * 
     * @throws FileNotFoundException
     */
    public void testMainOneCorrect() throws FileNotFoundException {
        SemManager.main(oneWrong01);
        String output = systemOut().getHistory();
        assertEquals("Wrong commands.", output);
    }


    /**
     * This tests one corrects commands
     * 
     * @throws FileNotFoundException
     */
    public void testMainOneCorrect02() throws FileNotFoundException {
        SemManager.main(oneWrong02);
        String output = systemOut().getHistory();
        assertEquals("Wrong commands.", output);
    }


    /**
     * This tests both wrong commands
     * 
     * @throws FileNotFoundException
     */
    public void testMainBothWrong() throws FileNotFoundException {
        SemManager.main(bothWrong);
        String output = systemOut().getHistory();
        assertEquals("Wrong commands.", output);
    }


    /**
     * This tests less commands
     * 
     * @throws FileNotFoundException
     */
    public void testMainLessCommands() throws FileNotFoundException {
        SemManager.main(lessCommands);
        String output = systemOut().getHistory();
        assertEquals("Wrong commands.", output);
    }


    /**
     * This tests more commands
     * 
     * @throws FileNotFoundException
     */
    public void testMainMoreCommands() throws FileNotFoundException {
        SemManager.main(moreCommands);
        String output = systemOut().getHistory();
        assertEquals("Wrong commands.", output);
    }
}
