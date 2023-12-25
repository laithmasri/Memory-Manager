
/**
 * This is the data base, it is responsible
 * for linking the hash table and the memory
 * manager.
 * 
 * @author laith
 * @author james
 * @version 11/9
 */
public class DataBase {
    private HashTable table;
    private MemoryManager manager;

    /**
     * This is the constuctor for the DataBase class.
     * 
     * @param memSize
     *            The size of the memory
     * @param hashSize
     *            The size of the hash table
     */
    public DataBase(int memSize, int hashSize) {
        table = new HashTable(hashSize);
        manager = new MemoryManager(memSize);
    }


    /**
     * This is the insert method. It is responsible
     * for adding records to the hash table and
     * allocate memory for them.
     * 
     * @param id
     *            The id value of the seminar
     * @param title
     *            The title of the seminar
     * @param date
     *            The date of the seminar
     * @param length
     *            The length of the seminar
     * @param xCoord
     *            The x coordinate
     * @param yCoord
     *            The y coordinate
     * @param cost
     *            The cost of the seminar
     * @param keywords
     *            Keywords for the seminar
     * @param desc
     *            The description for the seminar
     * @return an int representing the location
     *         of the record.
     */
    public int insert(
        int id,
        String title,
        String date,
        int length,
        short xCoord,
        short yCoord,
        int cost,
        String[] keywords,
        String desc) {
        Record newRecord = new Record(id, title, date, length, xCoord, yCoord,
            cost, keywords, desc);
        return table.insert(newRecord);
// try
// {
// byte[] bytes = seminar.serialize();
// Handle handle = manager.insert(bytes, bytes.length);
// Record newRecord = new Record(id, handle);
//
// return table.insert(newRecord);
// //Seminar newSem = deserialize(newRecord.getHandle().getStart());
//
// }
// catch (Exception e)
// {
//
// e.printStackTrace();
// }
// return 0;
// Record newRecord = new Record(id);

    }


    /**
     * This is the delete method. It is responsible
     * for deleting the record from the hash table and
     * deallocating its memory.
     * 
     * @param id
     *            The id value of the seminar
     * @return True if the record got deleted
     *         and false if it did not.
     */
    public boolean delete(int id) {
        return table.delete(id);
    }


    /**
     * This is the search method. It is responsible
     * for searching for a record through the hash
     * table.
     * 
     * @param id
     *            The id value of the seminar
     * @return True if the seminar was found
     *         and false if it was not.
     */
    public boolean search(int id) {
        return table.search(id);
    }


    /**
     * This method prints the values inside the
     * hash table along with their indices.
     */
    public void printHashTable() {
        table.printHashTable();
    }


    /**
     * This method prints the freeblock list.
     */
    public void printBlock() {
        manager.dump();
        System.out.println("Freeblock List:");
    }
}
