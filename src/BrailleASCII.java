import java.io.PrintWriter;

/**
 * BrailleASCII converse ASCII to unicode, ASCII to the bit version of braille, and bit braille to ASCII
 * To use BrailleASCII, give it two arguments. First a command, then the string to convert
 * Valid commands are: "Braille", "ASCII", and "Unicode"
 *    Braille: requires the second string to contain only letters a-z, A-Z and space. Will print the bit braille version of the string
 *    ASCII: requires the second string to contain only the bit braille version of the string. Will print ASCII string
 *    Unicode: requires the second string to contain only the letters a-z, A-Z and space. Will print the unicode images of braille
 * 
 * @author Maya Flynn
 */
public class BrailleASCII {
  /**
   * Turns an ASCII string into a bit braille string
   * @param str
   * @return
   */
  public static String stringToBraille(String str) {
    String toReturn = "";
    for(int i = 0; i < str.length(); i++) {
      toReturn += BrailleASCIITables.toBraille(str.charAt(i));
  } // for every letter in the string
  return toReturn;
  } // stringToBraille


  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);
    if (args.length != 2) {
      pen.println( args.length + "Valid commands are 'braille', 'ascii', or 'unicode' followed by the string to convert");

    } else if (args[0].equals("braille") || args[0].equals("Braille")) {
      pen.println(stringToBraille(args[1]));
    } else if (args[0].equals("ascii") || args[0].equals("ASCII")) {
      for (int i = 0; i < args[1].length(); i+=6) {
        pen.print((BrailleASCIITables.toASCII(args[1].substring(i, i+6))).toLowerCase());
      } // for every set of six bits in the string
      pen.println("");
    } else if (args[0].equals("unicode") || args[0].equals("Unicode")) {
      String braille = stringToBraille(args[1]);
      for (int i = 0; i < braille.length(); i+=6) {
        String unicode = "";
        unicode += (BrailleASCIITables.toUnicode(braille.substring(i, i+6)));
        int j = Integer.decode("0x" + unicode);
        pen.print(Character.toChars(j));
      } // for
      pen.println("");
    } // if
  } // main(String)
} // class BrailleASCII
