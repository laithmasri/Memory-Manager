import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * This is the project parser.
 * It parses instructions from the
 * input file and calls specific
 * functions to satisfy the commands.
 * 
 * @author laith
 * @author james
 * @version 11/9
 */
public class FileReader {

    private Seminar seminar;
    private DataBase db;
    private Record[] recArray;

    // private HashTable table;

    /**
     * This is the constructor for the FileReader class.
     * 
     * @param memorySize
     *            The size of the memory
     * @param hashSize
     *            The size of the hash table
     * @param fileName
     *            The name of the input file
     */
    public FileReader(int memorySize, int hashSize, String fileName)
        throws FileNotFoundException {
        db = new DataBase(memorySize, hashSize);
        recArray = new Record[100];
        reader(fileName);
    }


    /**
     * The function parses in the file and calls
     * different functions from the data base class
     * depending on the parsed command and its attributes.
     * 
     * @param fileName
     *            The name of the input file
     * @throws FileNotFoundException
     */
    public void reader(String fileName) throws FileNotFoundException {
        Scanner file = new Scanner(new File(fileName));
        int numOfEntries = 0;
        while (file.hasNext()) {
            String command = "";
            int id = 0;
            String title = "";
            String dateTime = "";
            int length = 0;
            short xCoord = 0;
            short yCoord = 0;
            int cost = 0;
            String[] keywords = null;
            String desc = "";
            int counter = 1;
            String line = file.nextLine();
            if (line.contains("insert")) {

                if (counter == 1) {
                    Scanner word = new Scanner(line).useDelimiter(" \\s*");
                    command = word.next();
                    id = word.nextInt();
                    counter++;
                    line = file.nextLine();
                    word.close();
                }

                if (counter == 2) {
                    Scanner word = new Scanner(line).useDelimiter(" \\s*");
                    title = word.nextLine().trim();
                    counter++;
                    line = file.nextLine();
                    word.close();
                }
                if (counter == 3) {
                    Scanner word = new Scanner(line).useDelimiter(" \\s*");
                    dateTime = word.next();
                    length = word.nextInt();
                    xCoord = word.nextShort();
                    yCoord = word.nextShort();
                    cost = word.nextInt();
                    counter++;
                    line = file.nextLine();
                    word.close();
                }
                if (counter == 4) {
                    Scanner word = new Scanner(line).useDelimiter(" \\s*");
                    Scanner repeatScanning = new Scanner(line).useDelimiter(
                        " \\s*");
                    int keywordCounter = 0;
                    while (word.hasNext()) {
                        word.next();
                        keywordCounter++;
                    }
                    keywords = new String[keywordCounter];
                    for (int x = 0; x < keywordCounter; x++) {
                        keywords[x] = repeatScanning.next();
                    }
                    repeatScanning.close();
                    counter++;
                    line = file.nextLine();
                    word.close();
                }
                if (counter == 5) {
                    Scanner word = new Scanner(line).useDelimiter("\\s*");
                    desc = word.nextLine();
                    desc = desc.trim();
                    word.close();
                }
                seminar = new Seminar(id, title, dateTime, length, xCoord,
                    yCoord, cost, keywords, desc);
                Record record = new Record(id, title, dateTime, length, xCoord,
                    yCoord, cost, keywords, desc);

                int inserted = db.insert(id, title, dateTime, length, xCoord,
                    yCoord, cost, keywords, desc);
                if (inserted != -1) {
                    System.out.println("Successfully inserted record with ID "
                        + id);
                    System.out.println(seminar.toString());
                    try {
                        byte[] bytes = seminar.serialize();
                        System.out.println("Size: " + bytes.length);
                        recArray[numOfEntries] = record;
                        numOfEntries++;

                    }
                    catch (Exception e) {
                        System.out.println(e);
                    }
                }
                else {
                    System.out.println("Insert FAILED - There is already a "
                        + "record with ID " + id);
                }
            }
            else if (line.contains("search")) {
                Scanner word = new Scanner(line).useDelimiter(" \\s*");
                command = word.next();
                id = word.nextInt();
                word.close();
                boolean found = db.search(id);
                if (found) {
                    System.out.println("Found record with ID " + id + ":");
                    for (int x = 0; x < recArray.length; x++) {
                        if (recArray[x] != null) {
                            if (recArray[x].getId() == id) {
                                System.out.println(recArray[x].toString());
                            }
                        }

                    }
                }
                else {
                    System.out.println("Search FAILED -- "
                        + "There is no record with ID " + id);
                }
            }
            else if (line.contains("delete")) {
                Scanner word = new Scanner(line).useDelimiter(" \\s*");
                command = word.next();
                id = word.nextInt();
                word.close();
                boolean deleted = db.delete(id);
                if (deleted) {
                    System.out.println("Record with ID " + id
                        + " successfully deleted from the database");
                    for (int x = 0; x < recArray.length; x++) {
                        if (recArray[x] != null) {
                            if (recArray[x].getId() == id) {
                                recArray[x] = null;
                            }
                        }
                    }
                }
                else {
                    System.out.println(
                        "Delete FAILED -- There is no record with ID " + id);
                }
            }
            else if (line.contains("print")) {
                Scanner word = new Scanner(line).useDelimiter(" \\s*");
                command = word.next();
                String obj = word.next();
                if (obj.contains("hash")) {
                    db.printHashTable();
                }
                else if (obj.contains("block")) {
                    db.printBlock();
                }
                word.close();
            }
        }
        file.close();
    }


    /**
     * This method is used for testing the reader.
     * 
     * @param path
     *            The name of the file
     * @return The read string.
     * @throws IOException
     */
    public static String readFile(String path) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded);
    }
}
