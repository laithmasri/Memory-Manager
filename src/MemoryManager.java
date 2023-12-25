/**
 * This is the memory manager class.
 * 
 * @author laith
 * @author james
 * @version 11/9
 */
public class MemoryManager {

    private byte[] memoryPool;
    private SinglyLinkedList<Block>[] freeBlocks;
    // private HashTable<>;

    /**
     * This is the constructor for the MemoryManager class.
     * 
     * @param poolSize
     *            represents the size of the memory pool
     */
    @SuppressWarnings("unchecked")
    public MemoryManager(int poolSize) {

        memoryPool = new byte[poolSize];
        int size = poolSize;
        int power = 0;
        while (size != 1) {
            size = size / 2;
            power++;
        }
        freeBlocks = new SinglyLinkedList[power];
        for (int x = 0; x < freeBlocks.length; x++) {
            freeBlocks[x] = new SinglyLinkedList<Block>();
        }
        Block newBlock = new Block(0, poolSize);
        freeBlocks[freeBlocks.length - 1].add(newBlock);
    }


    /**
     * This is the insert method.
     * 
     * @param space
     *            the space of the record
     * @param size
     *            the size of the record
     * @return the handle to the record.
     */
    public Handle insert(byte[] space, int size) {
// int position = 0;
// boolean goodToGo = false;
// while(!goodToGo)
// {
// position = (int)(Math.log(size) / Math.log(2));
// int tracer = 1;
// int index = 2;
// while (tracer != position)
// {
// index *= 2;
// tracer++;
// }
// if (index < size)
// {
// position++;
// }
//
// while ((position < freeBlocks.length)
// && freeBlocks[position].isEmpty())
// {
// position ++;
// }
// if ((calculateFreeSpace() < size)
// || (position == freeBlocks.length))
// {
// resize();
// }
// else
// {
// goodToGo = true;
// }
// }
// Block newBlock = freeBlocks[position].getHead();
// while (size <= (int)Math.pow(2, position - 1))
// {
// newBlock = freeBlocks[position].removeHead();
// splitUp(newBlock, position);
// }
// System.arraycopy(space, 0, memoryPool, newBlock.getStart(), size);
// freeBlocks[position].removeHead();
// Handle theHandle = new Handle(newBlock.getStart(), size);
        return null;
    }
//
// private void splitUp(Block block, int position)
// {
// Block newBlock01 = new Block(block.getStart(), block.getSize() / 2);
// Block newBlock02 = new Block(block.getStart()
// + block.getSize() / 2, block.getSize() / 2);
// freeBlocks[position].add(newBlock01);
// freeBlocks[position].add(newBlock02);
// }
// private int calculateFreeSpace() {
// int space = 0;
// for (int x = 0; x < freeBlocks.length; x++) {
// int tracer = 0;
// for (int y = 0; y < freeBlocks[x].size(); y++) {
// space += freeBlocks[x].get(tracer).getSize();
// }
// }
// return space;
// }


    /**
     * This is the length method.
     * 
     * @param theHandle
     *            the handle that stores record info
     * @return length of the record.
     */
    public int length(Handle theHandle) {
        return theHandle.getLength();
    }


    /**
     * This is the remove method.
     * 
     * @param theHandle
     *            the handle that stores record info
     */
    public void remove(Handle theHandle) {

    }


    /**
     * This is the get method
     * 
     * @param space
     *            space for record
     * @param theHandle
     *            handle that stores record info
     * @param size
     *            size for record
     * @return int value for the record.
     */
    public int get(byte[] space, Handle theHandle, int size) {
        if (theHandle == null) {
            return -1; // Handle is invalid
        }

        return 0;

    }


    /**
     * This is the dump method where free blocks
     * are listed.
     */
    public void dump() {

    }

    /**
     * This class represents a block object
     * that has a starting point in the memory
     * and a length.
     */
    private class Block {
        private int startingPoint;
        private int length;

        public Block(int theStart, int theLength) {
            startingPoint = theStart;
            length = theLength;
        }


        public int getStart() {
            return startingPoint;
        }


        public int getLength() {
            return length;
        }


        public void setStart(int x) {
            startingPoint = x;
        }


        public void setLength(int x) {
            length = x;
        }

// /**
// * isBuddy method
// *
// * @param other
// * @return if they are buddies
// */
// public boolean isBuddy(Block other) {
// // uses bitwise XOR (^) to compare the start positions. If the XOR
// // result equals the size of the blocks, they are considered
// // buddies.
// return this.length == other.length && ((this.getStart() ^ other
// .getStart()) == this.length);
// }
    }

    /**
     * This is the resize method
     * 
     * @return the new size of the memory pool.
     */
    public int resize() {
        int newSize = memoryPool.length * 2;
        byte[] newPool = new byte[newSize];
        System.arraycopy(memoryPool, 0, newPool, 0, memoryPool.length);
        memoryPool = newPool;
        System.out.println("Memory pool expanded to " + newSize + " bytes");
        return newSize;
    }
}
