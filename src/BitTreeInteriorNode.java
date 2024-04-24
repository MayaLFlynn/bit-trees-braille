/**
 * BitTreeInteriorNode is a node in a BitTree that has two children, and no value attached to it
 * 
 * @author Maya Flynn
 */

public class BitTreeInteriorNode implements BitTreeNode {
  // ---------------------------------------------------
  // | Fields |
  // ----------
  /**
   * The left subtree
   */
  BitTreeNode childZero;

  /**
   * The right subtree
   */
  BitTreeNode childOne;


  // ---------------------------------------------------
  // | Constructor |
  // ---------------

  /**
   * Create a new node
   */
  public BitTreeInteriorNode() {
    this.childZero = null;
    this.childOne = null;
  } // BitTreeInteriorNode()

  // ---------------------------------------------------
  // | Methods |
  // ---------------
  public boolean hasChildZero() {
    if (this.childZero != null) {
      return true;
    } // if
    return false;
  } // hasChildZero()

  public boolean hasChildOne() {
    if (this.childOne != null) {
      return true;
    } // if
    return false;
  } // hasChildOne()

} // class BitTreeInteriorNode
