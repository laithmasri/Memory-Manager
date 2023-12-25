import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import student.TestCase;

/**
 * This is the testing class for the file reader.
 * 
 * @author laith
 * @author james
 * @version 11/9
 */
public class FileReaderTest extends TestCase {

    private FileReader fileReader;

    /**
     * This sets up the testing cases.
     */
    public void setUp() throws FileNotFoundException {
        // File fileName = new File("P1Sample_input.txt");
        fileReader = new FileReader(512, 4, "P1Sample_input.txt");
    }


    /**
     * This method tests if the file reader is working fine.
     */
    public void testFileReader() throws IOException {
        String ans = systemOut().getHistory();
        String output = FileReader.readFile("P1Sample_output.txt");
        assertEquals(ans, output);
    }
}
