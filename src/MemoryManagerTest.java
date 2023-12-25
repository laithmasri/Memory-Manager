import student.TestCase;

/**
 * This is the test class for the Memory Manager
 * 
 * @author laith
 * @author james
 * @version 11/9
 */
public class MemoryManagerTest extends TestCase {
    private MemoryManager memoryManager;
    // private Handle handle;
    private byte[] memorySpace;

    /**
     * Sets up the tests that follow. In general, used for initialization
     */
    public void setUp() {
        /*
         * memoryManager = new MemoryManager(8);
         * handle = new Handle();
         */
        // handle = new Handle(2, 2);
        memoryManager = new MemoryManager(16);
        memorySpace = new byte[16];
    }


    /**
     * This tests the resize method.
     */
    public void testResize() {
        assertEquals(32, memoryManager.resize());
        assertEquals(64, memoryManager.resize());
    }
    
    /**
     * More tests
     */
    public void testRestOfMethods()
    {
        Handle handle = null;
        assertEquals(-1, memoryManager.get(memorySpace, handle, 0));
        handle = new Handle(2, 4);
        memoryManager.remove(handle);
        assertEquals(4, memoryManager.length(handle));
        assertEquals(0, memoryManager.get(memorySpace, handle, 0));
    }

// public void testInsert() {
// // Test Case 1: Insert a block into an empty memory space
// Handle handle1 = memoryManager.insert(memorySpace, 8);
// assertNotNull(handle1);
// assertEquals(0, handle1.getStart());
// assertEquals(8, handle1.getLength());
//
// // Test Case 2: Insert a block larger than available memory
// //Handle handle2 = memoryManager.insert(memorySpace, 32);
// //assertNull(handle2);
//
// // Test Case 3: Insert multiple blocks into the memory space
// Handle handle3_1 = memoryManager.insert(memorySpace, 4);
// assertNotNull(handle3_1);
// assertEquals(0, handle3_1.getStart());
// assertEquals(4, handle3_1.getLength());
//
// Handle handle3_2 = memoryManager.insert(memorySpace, 6);
// assertNotNull(handle3_2);
// assertEquals(0, handle3_2.getStart());
// assertEquals(6, handle3_2.getLength());
//
// // Test Case 4: Insert a block when there's
// not enough memory available
// //Handle handle4 = memoryManager.insert(memorySpace, 10);
// //assertNull(handle4);
// }
// /**
// * Get code coverage of the class declaration.
// */
// public void testInsert() {
// assertNull(memoryManager.insert(new byte[16], 32));
//
// // Test case 2: Insert when there is enough memory
// Handle handle1 = memoryManager.insert(new byte[8], 8);
//
// //assertEquals(1, memoryManager.getFreeBlockSize());
// assertNotNull(handle1);
//
// // Test case 3: Insert a larger block that needs to be split
// Handle handle2 = memoryManager.insert(new byte[16], 16);
// assertNotNull(handle2);
//
// // Test case 4: Insert a smaller block that doesn't need splitting
// Handle handle3 = memoryManager.insert(new byte[4], 4);
// assertNotNull(handle3);
// // test inserstion works
// /**
// * int dataSize = data.length();
// * byte[] data = "OBJ".getBytes();
// * handle = database.insert(data, dataSize);
// *
// * assertEquals("Successfully inserted record with ID "
// * + handle.getRecordId(), handle.getMessage());
// *
// * assertEquals(dataSize, memoryManeger.length());
// */
// memoryManager.insert(null, 0);
// }
//
//// /**
//// * test duplicate
//// */
//// public void testDuplicateInsertion() {
//// /**
//// * byte[] data = "OBJ".getBytes(); // Replace with your test data
//// * int dataSize = data.length;
//// *
//// * // Insert the same data twice to simulate a duplicate insertion
//// * database.insert(data, dataSize);
//// * handle = database.insert(data, dataSize);
//// *
//// * // Check if the insertion failed due to duplication
//// * assertTrue(handle.getMessage().startsWith(
//// * "Insert FAILED - There is already a record with ID"));
//// * }
//// */
//
//
// /**
// * Get code coverage of the class declaration.
// */
// public void testLength() {
// // Handle theHandle = null;
// assertEquals(0, memoryManager.length(handle));
//
// }
//
//
// /**
// * Get code coverage of the class declaration.
// */
// public void testRemove() {
// /**
// * byte[] data = "Sample Data\n".getBytes(); // Replace with your test
// * data
// * int dataSize = data.length;
// *
// * // Insert a record
// * handle = memoryManager.insert(data, dataSize);
// *
// * // Remove the inserted record
// * memoryManager.remove(handle);
// *
// * // Check if the record has been removed
// * assertEquals(-1, memoryManager.length(handle));
// */
// memoryManager.remove(handle);
// }
//
//
// /**
// * Get code coverage of the class declaration.
// */
// public void testGet() {
// /**
// * byte[] data = "Sample Data\n".getBytes(); // Replace with your test
// * data
// * int dataSize = data.length;
// *
// * // Insert a record
// * handle = memoryManager.insert(data, dataSize);
// *
// * // Retrieve the data from the inserted record
// * byte[] retrievedData = new byte[dataSize];
// * int copiedSize = memoryManager.get(
// retrievedData, handle, dataSize);
// *
// * // Check if the retrieved data matches the original data
// * assertEquals(dataSize, copiedSize);
// */
// assertEquals(0, memoryManager.get(null, handle, 0));
// Handle newHandle = null;
// assertEquals(-1, memoryManager.get(null, newHandle, 0));
//
// }
//
//
// /**
// * Get code coverage of the class declaration.
// */
// public void testDump() {
// memoryManager.dump();
// }

}
