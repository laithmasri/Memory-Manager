import student.TestCase;

/**
 * This is the testing class for the hash table
 * 
 * @author laith
 * @author james
 * @version 11/9
 */
public class HashTableTest extends TestCase {
    private HashTable theTable;
    private Record rec01;
    private Record rec02;
    private Record rec03;
    private Record rec04;
    private Record rec05;
    private Record rec06;
    private Record rec07;
    private Record rec16;
    private Record rec09;
    private Record rec15;
    private Record rec17;
    private Record rec63;
    private String[] keys;

    /**
     * This is the setup method.
     */
    public void setUp() {
        theTable = new HashTable(8);
        rec01 = new Record(1);
        rec02 = new Record(2);
        rec03 = new Record(3);
        rec04 = new Record(4);
        rec05 = new Record(5);
        rec06 = new Record(6);
        rec07 = new Record(7);
        rec09 = new Record(9);
        rec15 = new Record(15);
        rec16 = new Record(16);
        rec17 = new Record(17);
        rec63 = new Record(63);
    }


    /**
     * This case tests when we insert into an empty
     * hash table.
     */
    public void testInsertEmpty() {
        assertEquals(1, theTable.insert(rec01));
    }


    /**
     * This case test when we insert into an
     * occupied position.
     */
    public void testInsertNotEmpty() {
        theTable.insert(rec01);
        assertEquals(1, theTable.getNumOfEntries());
        assertEquals(2, theTable.insert(rec02));
        assertEquals(3, theTable.insert(rec03));
        Record rec10 = new Record(10);
        assertEquals(5, theTable.insert(rec10));
    }


    /**
     * testing case for inserting into a half
     * full hash table.
     */
    public void testInsertHalfCapacity() {
        theTable.insert(rec01);
        theTable.insert(rec02);
        theTable.insert(rec03);
        theTable.insert(rec04);
        assertEquals(8, theTable.getSize());

        // theTable.insert(rec05);
        assertEquals(5, theTable.insert(rec05));
        assertEquals(16, theTable.getSize());
        assertEquals(15, theTable.insert(rec15));
        assertEquals(0, theTable.insert(rec16));
        // assertEquals(7, theTable.insert(rec17));
        assertEquals(6, theTable.insert(rec63));
    }


    /**
     * test case when there is a duplicate id.
     */
    public void testDuplicate() {
        theTable.insert(rec01);

        Record duplicateRec = new Record(1);
        assertEquals(-1, theTable.insert(duplicateRec));

    }


    /**
     * testing edge cases to insert.
     */
    public void testInsertEdge() {
        theTable.insert(rec07);
        assertEquals(2, theTable.insert(rec15));
    }


    /**
     * testing when inserting into a tombstone.
     */
    public void testInsertTombstone() {
        theTable.insert(rec01);
        theTable.insert(rec02);
        theTable.insert(rec03);
        theTable.insert(rec04);
        theTable.delete(3);
        Record rec11 = new Record(11);
        assertEquals(3, theTable.insert(rec11));
        assertTrue(theTable.delete(11));
        assertFalse(theTable.search(11));
        assertEquals(3, theTable.insert(rec11));
        assertTrue(theTable.search(11));
    }


    /**
     * testing when inserting tombstone again.
     */
    public void testInsertTombstone02() {
        theTable.insert(rec01);
        theTable.insert(rec02);
        theTable.insert(rec03);
        Record rec11 = new Record(11);
        assertEquals(6, theTable.insert(rec11));
    }


    /**
     * testing the rehash method.
     */
    public void testRehash() {
        assertEquals(1, theTable.insert(rec01));
        assertEquals(2, theTable.insert(rec02));
        assertEquals(3, theTable.insert(rec03));
        assertEquals(4, theTable.insert(rec04));
        assertEquals(5, theTable.insert(rec05));
        assertEquals(0, theTable.insert(rec16));
        assertEquals(7, theTable.insert(rec17));
    }


    /**
     * testing the delete method in certain cases.
     */
    public void testDelete01() {
        theTable.insert(rec01);
        theTable.insert(rec02);
        theTable.insert(rec03);
        theTable.insert(rec04);
        assertTrue(theTable.delete(1));
        assertFalse(theTable.delete(1));
        assertTrue(theTable.delete(4));
        assertFalse(theTable.delete(4));
        assertFalse(theTable.delete(6));
    }


    /**
     * testing the delete method in certain cases.
     */
    public void testDelete02() {
        theTable.insert(rec01);
        assertEquals(4, theTable.insert(rec09));
        assertTrue(theTable.delete(1));
        assertTrue(theTable.delete(9));
    }


    /**
     * testing the delete method in certain cases.
     */
    public void testDelete03() {
        theTable.insert(rec01);
        theTable.insert(rec06);
        theTable.insert(rec09);
        assertEquals(3, theTable.insert(rec17));
        assertTrue(theTable.delete(17));
    }


    /**
     * testing the delete method in empty table.
     */
    public void testDeleteEmpty() {
        assertFalse(theTable.delete(0));
    }


    /**
     * testing the search method in certain cases.
     */
    public void testSearch01() {
        theTable.insert(rec01);
        theTable.insert(rec02);
        theTable.insert(rec03);
        theTable.insert(rec04);
        assertTrue(theTable.search(1));
        assertTrue(theTable.search(2));
        assertTrue(theTable.search(4));
        assertFalse(theTable.search(6));
        assertFalse(theTable.search(12));
    }


    /**
     * testing the search method in certain cases.
     */
    public void testSearch02() {
        theTable.insert(rec01);
        theTable.insert(rec06);
        theTable.insert(rec09);
        assertEquals(3, theTable.insert(rec17));
        assertTrue(theTable.search(17));
    }


    /**
     * testing the search method in certain cases.
     */
    public void testSearch03() {
        theTable.insert(rec01);
        theTable.insert(rec02);
        assertTrue(theTable.search(1));
        assertFalse(theTable.search(9));
        theTable.insert(rec09);
        assertTrue(theTable.search(9));
        theTable.insert(rec03);
        theTable.insert(rec04);
        theTable.insert(rec05);
        theTable.insert(rec06);
        theTable.insert(rec07);

        assertTrue(theTable.search(1));
        assertTrue(theTable.search(9));
        theTable.delete(1);
        assertFalse(theTable.search(1));
        assertEquals(1, theTable.insert(rec01));
        assertTrue(theTable.search(1));
    }


    /**
     * testing the search method in certain cases.
     */
    public void testSearch04() {
        assertEquals(1, theTable.insert(rec09));
        theTable.insert(rec02);
        theTable.insert(rec07);
        assertFalse(theTable.search(15));
        assertEquals(5, theTable.insert(rec15));
        theTable.delete(7);
        assertTrue(theTable.search(15));
        assertEquals(7, theTable.insert(rec07));

    }


    /**
     * testing the search method in empty table
     */
    public void testSearchEmpty() {
        assertFalse(theTable.search(2));
        theTable.insert(rec02);
        assertTrue(theTable.search(2));
        theTable.delete(2);
        assertFalse(theTable.search(2));
    }


    /**
     * testing rehash in certain case.
     */
    public void testRehash01() {
        theTable.insert(rec01);
        theTable.insert(rec02);
        theTable.insert(rec03);
        theTable.insert(rec04);
        theTable.delete(1);
        theTable.insert(rec06);
        theTable.insert(rec09);
        Record rec22 = new Record(22);
        Record rec38 = new Record(38);
        assertEquals(12, theTable.insert(rec22));
        assertEquals(11, theTable.insert(rec38));
        assertEquals(0, theTable.insert(rec16));
    }


    /**
     * testing the print hash table method
     */
    public void testPrintHashTable() {
        theTable.insert(rec01);
        theTable.insert(rec02);
        theTable.insert(rec03);
        theTable.insert(rec04);
        theTable.printHashTable();
        String message = "Hashtable:\r\n" + "1: 1\r\n" + "2: 2\r\n" + "3: 3\r\n"
            + "4: 4\r\n" + "total records: 4\r\n";
        assertEquals(message, systemOut().getHistory());

    }


    /**
     * test printHash
     */
    public void testPrintEmptyHashTable() {
        theTable.printHashTable();
        String ansEmpty = "Hashtable:\r\n" + "total records: 0\r\n";
        assertEquals(ansEmpty, systemOut().getHistory());
    }


    /**
     * test printHash
     */
    public void testPrintEmptyHashTableWithTombstone() {
        theTable.insert(rec01);
        theTable.insert(rec02);
        theTable.delete(1);
        theTable.printHashTable();
        String ansTomb = "Hashtable:\r\n" + "1: TOMBSTONE\r\n" + "2: 2\r\n"
            + "total records: 1\r\n";
        assertEquals(ansTomb, systemOut().getHistory());

    }


    /**
     * testing the rehash method in certain cases.
     */
    public void testRehash02() {
        assertEquals(1, theTable.insert(rec01));
        assertEquals(4, theTable.insert(rec09));
        assertEquals(5, theTable.insert(rec04));
        assertEquals(6, theTable.insert(rec05));
        assertEquals(7, theTable.insert(rec07));
        Record rec10 = new Record(10);
        assertEquals(10, theTable.insert(rec10));
        theTable.delete(1);
        theTable.delete(9);
        Record rec13 = new Record(13);
        assertEquals(13, theTable.insert(rec13));
        //Record rec16 = new Record(16);
        assertEquals(0, theTable.insert(rec16));
        Record rec20 = new Record(20);
        assertEquals(3, theTable.insert(rec03));
        assertTrue(theTable.delete(3));
        assertEquals(3, theTable.insert(rec20));
        assertTrue(theTable.search(20));
        assertTrue(theTable.delete(20));
        assertFalse(theTable.search(20));
        assertFalse(theTable.delete(20));
        assertEquals(1, theTable.insert(rec17));
        assertEquals(9, theTable.insert(rec09));
        theTable.printHashTable();
        String message = "Successfully inserted record with ID 1\r\n"
            + "Successfully inserted record with ID 2\r\n"
            + "Successfully inserted record with ID 3\r\n"
            + "Successfully inserted record with ID 4\r\n" + "Hashtable:\r\n"
            + "1: 1\r\n" + "2: 2\r\n" + "3: 3\r\n" + "4: 4\r\n"
            + "total records: 4\r\n";
        // assertEquals(message, systemOut().getHistory());
    }


    /**
     * testing the rehash method in certain cases.
     */
    public void testRehash03() {
        assertEquals(1, theTable.insert(rec01));
        theTable.insert(new Record(9));
        theTable.insert(new Record(25));
        theTable.insert(new Record(13));
        theTable.insert(new Record(14));
        theTable.insert(new Record(15));
        theTable.insert(new Record(16));
        theTable.insert(new Record(31));
        theTable.printHashTable();
    }


    /**
     * testing the search method in certain cases.
     */
    public void testSearch() {
        theTable.insert(rec01);
        theTable.insert(rec02);
        theTable.insert(rec03);
        theTable.insert(new Record(10));
        assertTrue(theTable.delete(2));
        assertFalse(theTable.search(2));
    }
}
