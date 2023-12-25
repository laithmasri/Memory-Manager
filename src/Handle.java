/**
 * Handle class
 * 
 * @author laith
 * @author james
 * @version 11/9
 */
public class Handle {
    private int start;
    private int length;

    /**
     * This is the constructor for the class.
     * 
     * @param theStart
     *            takes start
     * @param theLen
     *            takes end
     */
    public Handle(int theStart, int theLen) {
        start = theStart;
        length = theLen;
    }


    /**
     * This is a getter method for the start
     * of the record.
     * 
     * @return an integer representing
     *         the start of the record.
     */
    public int getStart() {
        return start;
    }


    /**
     * This is a getter method for the length
     * of the record.
     * 
     * @return an integer representing
     *         the length of the record.
     */
    public int getLength() {
        return length;
    }

}
