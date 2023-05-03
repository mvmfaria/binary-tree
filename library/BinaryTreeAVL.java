package library;
import java.util.Comparator;

/*
* Eduardo Henrique Próspero Souza e Marcos Mendes Faria
*/

public class BinaryTreeAVL<T> extends BinaryTreeRecursive<T>{
    public BinaryTreeAVL(Comparator<T> comp){
        super(comp);
    }

    @Override
    protected Node<T> insertNodeRecursive(Node<T> currentNode, Node<T> newNode){
        currentNode = super.insertNodeRecursive(currentNode, newNode);

        int balanceFactor = currentNode.balanceFactor();

        if(balanceFactor > 1){
            if((currentNode.getRightNode().balanceFactor() > 0)){
                currentNode = leftRotation(currentNode); 
            }else{
                currentNode = rightLeftRotation(currentNode); 
            }
        } else if(balanceFactor < -1){
            if((currentNode.getLeftNode().balanceFactor() < 0)){
                currentNode = rightRotation(currentNode); 
            }else{
                currentNode = leftRightRotation(currentNode); 
            }
        }

        return currentNode;
    }

    private Node<T> leftRotation(Node<T> node){
        Node <T> auxNode = node.getRightNode();
        node.setRightNode(auxNode.getLeftNode());
        auxNode.setLeftNode(node);

        return auxNode;
    }

    private Node<T> leftRightRotation(Node<T> node){
        node.setLeftNode(leftRotation(node.getLeftNode()));
        return rightRotation(node);
    }

    private Node<T> rightRotation(Node<T> node){
        Node <T> auxNode = node.getLeftNode();
        node.setLeftNode(auxNode.getRightNode());
        auxNode.setRightNode(node);

        return auxNode;
    }

    private Node<T> rightLeftRotation(Node<T> node){
        node.setRightNode(rightRotation(node.getRightNode()));
        return leftRotation(node);
    }
}
