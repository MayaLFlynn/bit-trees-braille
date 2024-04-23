import java.io.PrintWriter;

public class BitTree {

  // ---------------------------------------------------
  // | Fields |
  // ----------

  BitTreeNode root;


  // ---------------------------------------------------
  // | Constructor |
  // ---------------

  BitTree(int n) {
    this.root = new BitTreeInteriorNode();
  }


  // ---------------------------------------------------
  // | Methods |
  // -----------
  public void dump(PrintWriter pen) {
    pen.println(dump(root));
  }

  public void set(String bits, String value) {
    set(bits, value, root);
  }

  // ---------------------------------------------------
  // | Helper Methods |
  // ------------------
  
  public String dump(BitTreeNode node) {
    if(node instanceof BitTreeLeaf) {
      return "," + ((BitTreeLeaf) node).value + "\n";
    } else if (node instanceof BitTreeInteriorNode) {
      return "0" + dump(((BitTreeInteriorNode) node).childZero) + "1" + dump(((BitTreeInteriorNode) node).childOne);
    }
    return "**";
  } // dump(BitTreeNode)

  public void set(String bits, String value, BitTreeNode root) {
    //STUB
  }
  
} // class BitTree
