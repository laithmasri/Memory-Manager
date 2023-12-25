
/**
 * This is the record class
 * 
 * @author laith
 * @author james
 * @version 11/9
 */
public class Record {
    private String title; // Semianar title
    private String date; // Seminar date
    private int length; // Seminar length
    private String[] keywords; // Seminar keywords
    private short x; // Seminar x coord
    private short y; // Seminar y coord
    private String desc; // Seminar description
    private int cost; // Seminar cost
    private int id; // Seminar ID
    private Handle handle; // The handle object

    /**
     * Create a new Record object from the field data
     *
     * @param tin
     *            input title
     * @param datein
     *            input date
     * @param lin
     *            input length
     * @param kin
     *            input keywords
     * @param xin
     *            input x coord
     * @param yin
     *            input y coord
     * @param descin
     *            input description
     * @param cin
     *            input cost
     * @param idin
     *            input ID
     */
    public Record(
        int idin,
        String tin,
        String datein,
        int lin,
        short xin,
        short yin,
        int cin,
        String[] kin,
        String descin) {
        id = idin;
        title = tin;
        date = datein;
        length = lin;
        x = xin;
        y = yin;
        cost = cin;
        keywords = kin;
        desc = descin;
    }


    /**
     * This constructor is used to initialize
     * a tombstone.
     * 
     * @param tombstone
     *            represents a tombstone id
     */
    public Record(int tombstone) {
        id = tombstone;
    }


    /**
     * This is a second constructor for the record class.
     * 
     * @param theId
     *            represents the id value
     * @param theHandle
     *            represents the handle
     */
    public Record(int theId, Handle theHandle) {
        id = theId;
        handle = theHandle;
    }


    /**
     * getter method for the id.
     * 
     * @return the id for the record
     */
    public int getId() {
        return id;
    }


    /**
     * setter method for the id
     * 
     * @param key
     *            id value for the record
     */
    public void setId(int key) {
        id = key;
    }


    /**
     * @return a string representation of the object.
     */
    public String toString() {
        int i;
        String mykeys = "";
        for (i = 0; i < keywords.length; i++) {
            mykeys += keywords[i];
            if (i != keywords.length - 1)
                mykeys += ", ";
        }
        return "ID: " + id + ", Title: " + title + "\nDate: " + date
            + ", Length: " + length + ", X: " + x + ", Y: " + y + ", Cost: "
            + cost + "\nDescription: " + desc + "\nKeywords: " + mykeys;
    }
// public Handle getHandle()
// {
// return theHandle;
// }
}
