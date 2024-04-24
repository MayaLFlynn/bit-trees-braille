/**
 * BitTreeLeaf is a node in a BitTree that has no children, but does have a value attached to it
 * 
 * @author Maya Flynn
 */

public class BitTreeLeaf implements BitTreeNode {
  // ---------------------------------------------------
  // | Fields |
  // ----------

  /**
   * The value at the bottom branch of the tree
   */
  String value;


  // ---------------------------------------------------
  // | Constructor |
  // ---------------

  /**
   * Create a new node
   */
  public BitTreeLeaf(String value) {
    this.value = value;
  } // BitTreeLeaf(String)

} // class BitTreeLeaf
