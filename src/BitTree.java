import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Bit Tree is a binary tree
 * 
 * @author Maya Flynn
 */
public class BitTree {

  // ---------------------------------------------------
  // | Fields |
  // ----------
  /**
   * The top node of the tree
   */
  BitTreeNode root;


  // ---------------------------------------------------
  // | Constructor |
  // ---------------
  /**
   * Creates a new bit tree with one node
   * 
   * @param n
   */
  BitTree(int n) {
    this.root = new BitTreeInteriorNode();
  } // BitTree(int)


  // ---------------------------------------------------
  // | Methods |
  // -----------
  /**
   * dump prints all elements of the root. It prints the tree nodes left to right
   * 
   * @param pen
   */
  public void dump(PrintWriter pen) {
    pen.println(dump(root, ""));
  } // dump(PrintWriter)

  /**
   * set adds a value to a leaf of the root. It will change with value if there is one already
   * there. It will add nodes along the way if there are none
   * 
   * @param bits
   * @param value
   */
  public void set(String bits, String value) {
    set(bits, value, root);
  } // set

  /**
   * gets the value found by following the bit path of 0s and 1s down tree
   * 
   * @param bits
   * @pre bits.length() must be the same length as the depth of the tree
   * @pre bits must be made of 0s and 1s
   * @return the value found in the leaf
   * @throws Exception if there is no such element in the tree
   */
  public String get(String bits) throws Exception {
    return get(bits, root);
  } //get(String)

  /**
   * Sets root with the values found in source
   * @param source
   * @pre source must be in the form "(zeros and ones)","String"\n
   */
  public void load(InputStream source) {
    Scanner file = new Scanner(source);
    while (file.hasNextLine()) {
      String line = file.nextLine();
      String bits = line.substring(0, line.indexOf(','));
      String value = line.substring(line.indexOf(',') + 1);
      set(bits, value);
    } // while
    file.close();
  } // load(InputStream)

  // ---------------------------------------------------
  // | Helper Methods |
  // ------------------

  /**
   * dump gives a toString for all elements of the root. It creates a string of the tree nodes left to right with the path of how they were found
   * @param node
   * @param prevBits
   * @return
   */
  public String dump(BitTreeNode node, String prevBits) {
    String toReturn = "";
    if (node instanceof BitTreeLeaf) {
      return toReturn + prevBits + "," + ((BitTreeLeaf) node).value + "\n";
    } else if (node instanceof BitTreeInteriorNode) {
      if (((BitTreeInteriorNode) node).hasChildZero()) {
        toReturn += dump(((BitTreeInteriorNode) node).childZero, prevBits + "0");
      } // for left child
      if (((BitTreeInteriorNode) node).hasChildOne()) {
        toReturn += dump(((BitTreeInteriorNode) node).childOne, prevBits + "1");
      } // for right child
      return toReturn;
    } // if 
    return "";
  } // dump(BitTreeNode)

  /**
   * sets an element in the tree. changes the element if it already exists
   * @param bits
   * @pre bits.length() must be the same length as the depth of the tree
   * @pre bits must be made of 0s and 1s
   * @param value
   * @param node
   */
  public void set(String bits, String value, BitTreeNode node) {
    if (bits.length() == 1) {
      if (bits.charAt(0) == '0') {
        ((BitTreeInteriorNode) node).childZero = new BitTreeLeaf(value);
      } else {
        ((BitTreeInteriorNode) node).childOne = new BitTreeLeaf(value);
      } // if there is one element left in the bits String
    } else if (bits.charAt(0) == '0') {
      if ((node instanceof BitTreeInteriorNode) && ((BitTreeInteriorNode) node).hasChildZero()) {
        set(bits.substring(1), value, ((BitTreeInteriorNode) node).childZero);
      } else {
        ((BitTreeInteriorNode) node).childZero = new BitTreeInteriorNode();
        set(bits.substring(1), value, ((BitTreeInteriorNode) node).childZero);
      } // if child -> set, if no child -> make one then set
    } else if (bits.charAt(0) == '1') {
      if ((node instanceof BitTreeInteriorNode) && ((BitTreeInteriorNode) node).hasChildOne()) {
        set(bits.substring(1), value, ((BitTreeInteriorNode) node).childOne);
      } else {
        ((BitTreeInteriorNode) node).childOne = new BitTreeInteriorNode();
        set(bits.substring(1), value, ((BitTreeInteriorNode) node).childOne);
      } // if child -> set, if no child -> make one then set
    } // if
  } // set(String, String, BitTreeNode)

  /**
   * gets the value found by following the bit path of 0s and 1s down tree
   * @param bits
   * @param node
   * @return
   * @throws Exception
   */
  public String get(String bits, BitTreeNode node) throws Exception {
    if (node instanceof BitTreeLeaf) {
      if (bits.length() == 0) {
        return ((BitTreeLeaf) node).value;
      }
      throw new Exception("Bit String too long");
    } else {
      if (bits.length() == 0) {
        throw new Exception("No such element");
      }
      if (bits.charAt(0) == '0') {
        return get(bits.substring(1), ((BitTreeInteriorNode) node).childZero);
      } else if (bits.charAt(0) == '1') {
        return get(bits.substring(1), ((BitTreeInteriorNode) node).childOne);
      } else {
        throw new Exception("No such element");
      } // if
    } // if
  } // get(String, BitTreeNode)
} // class BitTree
