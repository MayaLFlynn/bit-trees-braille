import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

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
    pen.println(dump(root, ""));
  }

  public void set(String bits, String value) {
    set(bits, value, root);
  }

  public String get(String bits) throws Exception {
    return get(bits, root);
  }

  public void load(InputStream source) {
    Scanner file = new Scanner(source);
    while (file.hasNextLine()) {
      String line = file.nextLine();
      String bits = line.substring(0, line.indexOf(','));
      String value = line.substring(line.indexOf(',') + 1);
      set(bits, value);
    }
    file.close();
  }

  // ---------------------------------------------------
  // | Helper Methods |
  // ------------------
  
  public String dump(BitTreeNode node, String prevBits) {
    String toReturn = "";
    if(node instanceof BitTreeLeaf) {
      return toReturn + prevBits + "," + ((BitTreeLeaf) node).value + "\n";
    } else if (node instanceof BitTreeInteriorNode) {
        if(((BitTreeInteriorNode)node).hasChildZero()) {
          toReturn += dump(((BitTreeInteriorNode) node).childZero, prevBits + "0") ;
        }
        if(((BitTreeInteriorNode)node).hasChildOne()) {
          toReturn += dump(((BitTreeInteriorNode) node).childOne, prevBits + "1");
        }
        return toReturn;
    }
    return "**";
  } // dump(BitTreeNode)

  /**
   * Currently assumes that bits and node are very compatable -> must be the same depth and crashes and burns if its not perfect (but I guess not)
   * It should crash and burn if the tree is imperfectly created
   * @param bits
   * @param value
   * @param node
   */
  public void set(String bits, String value, BitTreeNode node) {
    
    if (bits.length() == 1) {
      if(bits.charAt(0) == '0') {
        ((BitTreeInteriorNode)node).childZero = new BitTreeLeaf(value);
      } else {
        ((BitTreeInteriorNode)node).childOne = new BitTreeLeaf(value);
      } // if there is one element left in the bits String
    } else if(bits.charAt(0) == '0') {
      if((node instanceof BitTreeInteriorNode) && ((BitTreeInteriorNode)node).hasChildZero()) {
        set(bits.substring(1), value, ((BitTreeInteriorNode)node).childZero);
      } else {
        ((BitTreeInteriorNode)node).childZero = new BitTreeInteriorNode();
        set(bits.substring(1), value, ((BitTreeInteriorNode)node).childZero);
      } // if child -> set, if no child -> make one then set
    } else if(bits.charAt(0) == '1') {
      if((node instanceof BitTreeInteriorNode) && ((BitTreeInteriorNode)node).hasChildOne()) { 
        set(bits.substring(1), value, ((BitTreeInteriorNode)node).childOne);
      } else {
        ((BitTreeInteriorNode)node).childOne = new BitTreeInteriorNode();
        set(bits.substring(1), value, ((BitTreeInteriorNode)node).childOne);
      } // if child -> set, if no child -> make one then set
    }
  } // set(String, String, BitTreeNode)
  
  public String get(String bits, BitTreeNode node) throws Exception{
    if (node instanceof BitTreeLeaf) {
      if (bits.length() == 0) {
        return ((BitTreeLeaf)node).value;
      }
      throw new Exception("Bit String too long");
    } else {
      if(bits.length() == 0) {
        throw new Exception("No such element");
      }
      if (bits.charAt(0) == '0') {
        return get(bits.substring(1), ((BitTreeInteriorNode)node).childZero);
      } else if (bits.charAt(0) == '1') {
        return get(bits.substring(1), ((BitTreeInteriorNode)node).childOne);
      } else {
        throw new Exception("No such element");
      }
    }
  }
} // class BitTree
