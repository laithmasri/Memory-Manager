
/**
 * This is the hash table class.
 * 
 * @author laith
 * @author james
 * @version 11/9
 */
public class HashTable {
    private int size;
    private int numOfSem;
    private Record[] array;
    // private Integer[] keys;

    /**
     * This is the constructor for the class.
     * 
     * @param theSize
     *            represents the size of the array
     */
    public HashTable(int theSize) {
        size = theSize;
        numOfSem = 0;
        array = new Record[size];
        // keys = new Integer[50];
    }


    /**
     * This is the insert method
     * 
     * @param newRecord
     *            represents a new record object
     * @return The position where the record was inserted.
     */
    public int insert(Record newRecord) {
        int id = newRecord.getId();
        for (int x = 0; x < array.length; x++) {
            if ((array[x] != null) && array[x].getId() == id) {
                return -1;
            }
        }
        if (numOfSem > 0) {
            if ((size / 2) == numOfSem) {
                array = rehash();
            }
        }
        int hashValue = id % size;
        while (array[hashValue] != null) {
            if (array[hashValue].getId() == -1) {
                array[hashValue] = newRecord;
                numOfSem++;
                return hashValue;
            }
            hashValue += (((id / size) % (size / 2)) * 2) + 1;
            hashValue = hashValue % size;
        }
        array[hashValue] = newRecord;
        numOfSem++;
        return hashValue;
    }

    /**
     * This is the delete method
     * 
     * @param id
     *            represents the id of the record
     *            to be deleted.
     * @return True if the record was deleted
     *         and false if it was not.
     */
    public boolean delete(int id) {
        boolean deleted = false;
        int hashValue = id % size;
        if (array[hashValue] == null) {
            return deleted;
        }
        if (array[hashValue].getId() == id) {
            deleted = true;
            Record tombstone = new Record(-1);
            array[hashValue] = tombstone;
            numOfSem--;
        }
        else {
            while ((array[hashValue].getId() != id)) {
                hashValue += (((id / size) % (size / 2)) * 2) + 1;
                hashValue = hashValue % size;

                if (array[hashValue] == null) {
                    return deleted;
                }
            }
            deleted = true;
            Record tombstone = new Record(-1);
            array[hashValue] = tombstone;
            numOfSem--;
        }
        return deleted;
    }


    /**
     * This is the search method.
     * 
     * @param id
     *            represents the id of the record
     *            that will be looked for.
     * @return True if the record was found
     *         and false if it was not.
     */
    public boolean search(int id) {
        boolean found = false;
        int hashValue = id % size;
        if (array[hashValue] == null) {
            return found;
        }
        if (array[hashValue].getId() == id) {
            found = true;

        }
        else {
            while ((array[hashValue].getId() != id)) {
                hashValue += (((id / size) % (size / 2)) * 2) + 1;
                hashValue = hashValue % size;
                if (array[hashValue] == null) {
                    return found;
                }
            }
            
            found = true;
        }
        return found;
    }


    /**
     * This is the rehash method.
     * 
     * @return The array with the new double size.
     */
    private Record[] rehash() {
        Record[] newArray = new Record[(array.length) * 2];
        size = (array.length) * 2;
        for (int x = 0; x < array.length; x++) {
            if (array[x] != null) {
                if (array[x].getId() > -1) {
                    int id = array[x].getId();
                    int hashValue = id % size;
                    while (newArray[hashValue] != null) {
                        hashValue += (((id / size) % (size / 2)) * 2) + 1;
                        hashValue = hashValue % size;
                    }
                    newArray[hashValue] = array[x];
                }
            }
        }
        System.out.println("Hash table expanded to " + size + " records");
        return newArray;
    }


    /**
     * This is the print method, where the
     * items in the hash table get printed.
     * 
     * @return True always when called.
     */
    public boolean printHashTable() {
        System.out.println("Hashtable:");
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                continue;
            }
            else if (array[i].getId() == -1) {
                System.out.println(i + ": TOMBSTONE");
            }
            else {
                System.out.println(i + ": " + array[i].getId());
            }
        }
        System.out.println("total records: " + numOfSem);
        return true;
    }


    /**
     * This is a getter method for the size of the
     * hash table.
     * 
     * @return the size of the hash table.
     */
    public int getSize() {
        return size;
    }


    /**
     * This is a getter method for the number
     * of entries in the table.
     * 
     * @return the number of entries in the table.
     */
    public int getNumOfEntries() {
        return numOfSem;
    }
}
