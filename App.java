import java.util.Comparator;

public class App {
    public static void main(String[] args) {
        
        BinaryTreeRecursive<Integer> tree = new BinaryTreeRecursive<Integer>(Comparator.naturalOrder());

        tree.insertNode(61);
        tree.insertNode(61);
        tree.insertNode(43);
        tree.insertNode(89);
        tree.insertNode(16);
        tree.insertNode(66);
        tree.insertNode(51);
        tree.insertNode(79);
        tree.insertNode(61);
        tree.insertNode(77);
        tree.insertNode(11);
        tree.insertNode(32);
        tree.insertNode(55);
        tree.insertNode(80);

        tree.printIndented(tree.getRootNode(), "", true);
        tree.printBreadthFirstSearch();
        System.out.println("\n"+ "menor: ");
        tree.getSmaller(tree.rootNode);
        System.out.println("maior: ");
        tree.getBigger(tree.rootNode);

    }
}
