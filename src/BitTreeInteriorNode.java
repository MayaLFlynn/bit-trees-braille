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
} // class BitTreeInteriorNode
