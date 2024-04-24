import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * BrailleASCIITables loads values into trees and converts Braille bit and string values
 * 
 *@author Maya Flynn
 */
public class BrailleASCIITables {
  public static String toBraille(char letter) {
    BitTree tree = new BitTree(1);
    try {
      InputStream input = new FileInputStream("../lib/ASCIIToBraille.txt");
      tree.load(input);
    } catch (FileNotFoundException f) {
      try {
        InputStream input = new FileInputStream("lib/ASCIIToBraille.txt");
        tree.load(input);
      } catch (FileNotFoundException e) {
      } // FileNotFoundException
    } // FileNotFoundException
    int ascii = (int) letter;
    StringBuilder binaryVal = new StringBuilder(Integer.toBinaryString(ascii));
    if (binaryVal.length() < 8) {
      for (int i = binaryVal.length(); i < 8; i++) {
        binaryVal.insert(0, "0");
      } // add zeros onto the front of the string until it is the correct length
    } // if
    String path = binaryVal.toString();
    try {
      return tree.get(path);
    } catch (Exception e) {
      return ("letter not found ");
    } // check to see if the letter can be found
  } // toBraille(char)

  public static String toASCII(String bits) {
    BitTree tree = new BitTree(1);
    try {
      InputStream input = new FileInputStream("../lib/BrailleToASCII.txt");
      tree.load(input);
    } catch (FileNotFoundException f) {
      try {
        InputStream input = new FileInputStream("lib/BrailleToASCII.txt");
        tree.load(input);
      } catch (FileNotFoundException e) {
      } // FileNotFoundException
    } // FileNotFoundException
    try {
      return tree.get(bits);
    } catch (Exception e) {
      return ("letter not found ");
    } // check to see if the letter can be found
  } // toASCII(String)

  public static String toUnicode(String bits) {
    BitTree tree = new BitTree(1);
    try {
      InputStream input = new FileInputStream("../lib/BrailleToUnicode.txt");
      tree.load(input);
    } catch (FileNotFoundException f) {
      try {
        InputStream input = new FileInputStream("lib/BrailleToUnicode.txt");
        tree.load(input);
      } catch (FileNotFoundException e) {
      } // FileNotFoundException
    } // FileNotFoundException
    try {
      return tree.get(bits);
    } catch (Exception e) {
      return ("letter not found ");
    } // check to see if the letter can be found
  } // toUnicode(String)

} // class BrailleASCIITables
