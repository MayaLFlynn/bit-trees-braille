import java.io.PrintWriter;

public class App {
    public static void main(String[] args) throws Exception {
        BitTree tree1 = new BitTree(1);
        PrintWriter pen = new PrintWriter(System.out, true);
        tree1.dump(pen);
    }
}
