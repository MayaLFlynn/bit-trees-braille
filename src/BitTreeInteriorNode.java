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
    }
    return false;
  }

  public boolean hasChildOne() {
    if (this.childOne != null) {
      return true;
    }
    return false;
  }

} // class BitTreeInteriorNode
