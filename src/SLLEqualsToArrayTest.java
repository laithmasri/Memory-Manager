import java.util.Arrays;
import student.TestCase;

/**
 * 
 * Tests the equals and toArray methods of a singly linked list.
 * Taken from 2114.
 * 
 * @author Margaret Ellis (maellis1)
 * 
 * @author Jeff Robertson (thejar)
 * 
 * @version 03/19/2017
 *
 */
public class SLLEqualsToArrayTest extends TestCase {

    private SinglyLinkedList<String> emptyListA;
    private SinglyLinkedList<String> emptyListB;
    private SinglyLinkedList<String> smallListA;
    private SinglyLinkedList<String> smallListB;
    private SinglyLinkedList<String> bigListA;
    private SinglyLinkedList<String> bigListB;
    private SinglyLinkedList<String> linkedTest;
    private SinglyLinkedList<String> test;
    private String nullObject;

    /**
     * Initializes 2 empty lists, 2 lists with a small number of items, and 2
     * lists with a large number of items
     */
    public void setUp() {
        emptyListA = new SinglyLinkedList<String>();
        emptyListB = new SinglyLinkedList<String>();

        smallListA = new SinglyLinkedList<String>();
        smallListB = new SinglyLinkedList<String>();

        smallListA.add("soccer");
        smallListA.add("swimming");
        smallListA.add("gymnastics");

        smallListB.add("soccer");
        smallListB.add("swimming");
        smallListB.add("gymnastics");

        bigListA = new SinglyLinkedList<String>();

        for (int i = 0; i < 100; i++) {
            bigListA.add("sport" + i);
        }

        bigListB = new SinglyLinkedList<String>();
        for (int i = 0; i < 100; i++) {
            bigListB.add("sport" + i);
        }
        linkedTest = new SinglyLinkedList<String>();
        test = new SinglyLinkedList<String>();
        // to be explicit
        nullObject = null;
    }


    /**
     * Tests the equals method on an empty list
     */
    public void testEqualsEmptyList() {
        assertEquals(emptyListA, emptyListA);
        assertEquals(emptyListA, emptyListB);
        assertFalse(emptyListA.equals(nullObject));
        assertFalse(emptyListA.equals("soccer"));
        assertFalse(emptyListA.equals(smallListA));
        assertFalse(smallListA.equals(emptyListA));
        emptyListB.add("jump roping");
        assertFalse(emptyListA.equals(emptyListB));
        smallListA.clear();
        assertEquals(emptyListA, smallListA);
    }


    /**
     * Tests the equals method on a list with a small number of items in it
     */
    public void testEqualsSmallList() {
        assertEquals(smallListA, smallListA);
        assertEquals(smallListA, smallListB);
        assertFalse(smallListA.equals(nullObject));
        assertFalse(smallListA.equals("soccer"));
        assertFalse(smallListA.equals(bigListA));
        assertFalse(smallListA.equals(emptyListA));
        smallListB.add("jump roping");
        assertFalse(smallListA.equals(smallListB));

        // Make smallListA and smallListB differ in
        // content, but have the same size
        smallListA.add("rope jumping");
        assertFalse(smallListA.equals(smallListB));

        // Replace the last element in smallListA
        // to make smallListA and smallListB equal again
        smallListA.remove("rope jumping");
        smallListA.add("jump roping");
        assertEquals(smallListA, smallListB);
    }


    /**
     * Tests the equals method on a list with a large number of items in it
     */
    public void testEqualsBigList() {
        assertEquals(bigListA, bigListA);
        assertEquals(bigListA, bigListB);
        assertFalse(bigListA.equals(nullObject));
        assertFalse(bigListA.equals("soccer"));
        assertFalse(bigListA.equals(smallListA));
        assertFalse(bigListA.equals(emptyListA));
        bigListB.add("jump roping");
        assertFalse(bigListA.equals(bigListB));

        // Same content, same size, but reversed
        bigListB.clear();
        assertFalse(bigListA.equals(bigListB));
        for (int i = 100; i > 0; i--) {
            bigListB.add("sport" + i);
        }
        assertFalse(bigListA.equals(bigListB));

        // one a subset of the other but with dups
        bigListB.clear();
        assertFalse(bigListA.equals(bigListB));
        for (int i = 0; i < 50; i++) {
            bigListB.add("sport" + i);
        }
        for (int i = 0; i < 50; i++) {
            bigListB.add("sport" + i);
        }
        assertFalse(bigListA.equals(bigListB));

        // make them equal again
        bigListB.clear();
        assertFalse(bigListA.equals(bigListB));
        for (int i = 0; i < 100; i++) {
            bigListB.add("sport" + i);
        }
        assertEquals(bigListA, bigListB);

    }


    /**
     * Tests the toArray method on an empty list
     */
    public void testToArrayEmpty() {

        Object[] emptyArray = {};
        assertTrue(Arrays.equals(emptyListA.toArray(), emptyArray));
        assertTrue(Arrays.equals(emptyListA.toArray(), emptyListB.toArray()));
        assertFalse(Arrays.equals(emptyListA.toArray(), smallListB.toArray()));
        Object[] oneItemArray = { "one thing" };
        emptyListA.add("one thing");
        assertTrue(Arrays.equals(emptyListA.toArray(), oneItemArray));

    }


    /**
     * Tests the toArray method on a list with items in it
     */
    public void testToArrayContents() {

        Object[] origArray = { "soccer", "swimming", "gymnastics" };
        assertTrue(Arrays.equals(smallListA.toArray(), origArray));
        assertTrue(Arrays.equals(emptyListA.toArray(), emptyListB.toArray()));
        assertFalse(Arrays.equals(smallListA.toArray(), bigListB.toArray()));
    }


    /**
     * 
     */
    public void testEdgeCases() {
        linkedTest.add("one");
        assertEquals(1, linkedTest.size());
        linkedTest.add("two");
        assertEquals("two", linkedTest.get(1));
        assertEquals("one", linkedTest.get(0));
        Exception exception = null;
        try {
            linkedTest.get(2);
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof IndexOutOfBoundsException);
        assertTrue(linkedTest.contains("two"));
        assertFalse(linkedTest.contains(nullObject));
        assertFalse(linkedTest.contains(""));
        linkedTest.add("one");
        linkedTest.add("two");
        linkedTest.add("one");
        assertEquals(3, linkedTest.lastIndexOf("two"));
        assertEquals(4, linkedTest.lastIndexOf("one"));
        assertEquals(-1, linkedTest.lastIndexOf(nullObject));
        assertEquals(-1, linkedTest.lastIndexOf("three"));
        assertEquals("{one, two, one, two, one}", linkedTest.toString());
        assertTrue(linkedTest.remove("two"));
        assertEquals("{one, one, two, one}", linkedTest.toString());
        assertEquals(4, linkedTest.size());
        assertFalse(linkedTest.remove("three"));
        assertEquals(4, linkedTest.size());
        assertFalse(linkedTest.remove(nullObject));
        assertTrue(linkedTest.remove(0));
        assertEquals("{one, two, one}", linkedTest.toString());
        assertTrue(linkedTest.remove(1));
        assertEquals("{one, one}", linkedTest.toString());
        linkedTest.remove(0);
        assertEquals("{one}", linkedTest.toString());
        linkedTest.add("one");
        linkedTest.add("two");
        linkedTest.add("one");
        linkedTest.remove(3);
        assertEquals("{one, one, two}", linkedTest.toString());
        Exception exce02 = null;
        try {
            linkedTest.get(-1);
        }
        catch (Exception e) {
            exce02 = e;
        }
        assertTrue(exce02 instanceof IndexOutOfBoundsException);
        Exception exce03 = null;
        try {
            linkedTest.get(5);
        }
        catch (Exception e) {
            exce03 = e;
        }
        assertTrue(exce03 instanceof IndexOutOfBoundsException);
        Exception exce = null;
        try {
            linkedTest.add(nullObject);
        }
        catch (Exception e) {
            exce = e;
        }
        assertTrue(exce instanceof IllegalArgumentException);
        Exception ex = null;
        try {
            linkedTest.remove(-1);
        }
        catch (Exception e) {
            ex = e;
        }
        assertTrue(ex instanceof IndexOutOfBoundsException);
        linkedTest.clear();
        Exception exc = null;
        try {
            linkedTest.remove(1);
        }
        catch (Exception e) {
            exc = e;
        }

        assertTrue(exc instanceof IndexOutOfBoundsException);
        assertFalse(linkedTest.contains("two"));
        assertEquals(0, linkedTest.size());
        // assertFalse(linkedTest.contains(2));
    }


    /**
     * 
     */
    public void testAddIndex() {
        test.add(0, "zero");
        assertEquals("zero", test.get(0));
        test.add(0, "one");
        assertEquals("one", test.get(0));
        test.add(1, "one");
        test.add(2, "two");
        test.add(3, "three");
        assertEquals("{one, one, two, three, zero}", test.toString());
        test.add(1, "extra");
        assertEquals("{one, extra, one, two, three, zero}", test.toString());
        Exception exception01 = null;
        try {
            test.add(0, nullObject);
        }
        catch (Exception e) {
            exception01 = e;
        }
        assertTrue(exception01 instanceof IllegalArgumentException);
        test.clear();
        exception01 = null;
        try {
            test.add(1, "one");
        }
        catch (Exception e) {
            exception01 = e;
        }
        assertTrue(exception01 instanceof IndexOutOfBoundsException);
        exception01 = null;
        try {
            test.add(-1, "one");
        }
        catch (Exception e) {
            exception01 = e;
        }
        assertTrue(exception01 instanceof IndexOutOfBoundsException);
        test.add("zero");
        assertTrue(test.remove(0));
        assertEquals(0, test.size());
        test.add("zero");
        assertTrue(test.remove("zero"));
        test.add("zero");
        test.add("one");
        test.add("two");
        test.add("three");
        test.add("four");
        test.add("four");
        test.add("zero");
        assertTrue(test.remove(6));
        test.add("zero");
        assertEquals("{zero, one, two, three, four, four, zero}", test
            .toString());
        assertTrue(test.remove("three"));
        assertEquals("{zero, one, two, four, four, zero}", test.toString());
        assertTrue(test.remove("zero"));
        assertEquals("{one, two, four, four, zero}", test.toString());
        assertTrue(test.remove("zero"));
        assertEquals("{one, two, four, four}", test.toString());
        assertTrue(test.remove("one"));
        assertEquals("{two, four, four}", test.toString());
        assertTrue(test.remove("four"));
        assertEquals("{two, four}", test.toString());
        assertTrue(test.remove("four"));
        assertEquals("{two}", test.toString());
        assertTrue(test.remove("two"));
        assertEquals("{}", test.toString());
        assertFalse(test.remove("test"));
        Exception exception = null;
        try {
            test.remove(2);
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof IndexOutOfBoundsException);
        test.clear();
        test.add("zero");
        test.add("one");
        test.add("two");
        assertTrue(test.remove("one"));
        assertTrue(test.remove("zero"));
        assertTrue(test.remove("two"));
    }

}
