import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class BrailleASCIITables {
  public static String toBraille(char letter) throws Exception {
    BitTree tree = new BitTree(1);
    try {
      InputStream input = new FileInputStream("lib/ASCIIToBraille.txt");
      tree.load(input);
    } catch (FileNotFoundException f) {}
    int ascii = (int) letter;
    StringBuilder binaryVal = new StringBuilder(Integer.toBinaryString(ascii));
    if (binaryVal.length() < 8) {
      for (int i = binaryVal.length(); i < 8; i++) {
        binaryVal.insert(0, "0");
      } // add zeros onto the front of the string until it is the correct length
    }
    String path = binaryVal.toString();
    return tree.get(path);
  } // toBraille(char)

  public static String toASCII(String bits) throws Exception {
    BitTree tree = new BitTree(1);
    try {
      InputStream input = new FileInputStream("lib/BrailleToASCII.txt");
      tree.load(input);
    } catch (FileNotFoundException f) {}
    return tree.get(bits);
  } // toASCII(String)

  public static String toUnicode(String bits) throws Exception {
    BitTree tree = new BitTree(1);
    try {
      InputStream input = new FileInputStream("lib/BrailleToUnicode.txt");
      tree.load(input);
    } catch (FileNotFoundException f) {}
    return tree.get(bits);
  }

} // class BrailleASCIITables
