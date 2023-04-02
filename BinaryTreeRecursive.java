import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeRecursive<T>{
    protected Node<T> rootNode;
    protected Comparator<T> comparator; 
    protected Integer nodesNum;

    public BinaryTreeRecursive(Comparator<T> comp){
        this.comparator = comp;
    }

    // Methods
    public void insertNode(T value){
        
        // Creating node
        Node<T> newNode = new Node<T>(value);
        
        // Testing if the root node is null 
        // if(this.rootNode.getValue() == null){
            //     this.rootNode.setValue(newNode.getValue());
            // } else{
                //     insertNodeRecursive(this.rootNode, newNode);
                // }   
        
        //(foi necessário uma alteração nessa verificação, pois, caso o root não existisse, não conseguiríamos acessar os métodos getValue() and setValue()).
        if(this.rootNode == null){
            this.rootNode = newNode;
        } else{
            insertNodeRecursive(this.rootNode, newNode);
        }
    }

    private void insertNodeRecursive(Node<T> currentNode, Node<T> newNode){       
        // Se encontrar o valor igual, não executa evitando adicionar valor igual
        if(!(comparator.compare(newNode.getValue(), currentNode.getValue()) == 0)){          
            if(comparator.compare(newNode.getValue(), currentNode.getValue()) > 0){
                if(!currentNode.hasRight()){
                    currentNode.setRightNode(newNode);
                }else{
                    insertNodeRecursive(currentNode.getRightNode(), newNode);
                }
            }else{
                if(!currentNode.hasLeft()){
                    currentNode.setLeftNode(newNode);
                }else{
                    insertNodeRecursive(currentNode.getLeftNode(), newNode);
                }
            }
        }
    }
    
    public Node<T> searchNode(T value){
        return searchNodeRecursive(value, getRootNode());
    }

    private Node<T> searchNodeRecursive(T value, Node<T> currentNode){
        if(comparator.compare(value, currentNode.getValue()) == 0){
            return currentNode;
        }else{
            if(comparator.compare(value, currentNode.getValue()) > 0){
                if(!currentNode.hasRight()){
                    return null;
                }else{
                    return searchNodeRecursive(value, currentNode.getRightNode());
                }
            }else{
                if(!currentNode.hasLeft()){
                    return null;
                }else{
                    return searchNodeRecursive(value, currentNode.getLeftNode());
                }
            }
        }
    }

    public void deleteItem(T value){
        Node<T> currentNode = this.rootNode;
        Node<T> parentNode = null;
        Boolean wasFound = false;

        while(!wasFound || currentNode == null){
            if(comparator.compare(value, currentNode.getValue()) == 0)
                wasFound = true;

            if(!wasFound){
                parentNode = currentNode;
                if(comparator.compare(value, currentNode.getValue())  > 0){
                    currentNode = currentNode.getRightNode();
                }else{
                    currentNode = currentNode.getLeftNode();
                }
            }
        }

        // Caso 1: Nó sem filhos
        if(!currentNode.hasLeft() && !currentNode.hasRight()){
            if( comparator.compare(currentNode.getValue(), parentNode.getValue()) > 0){
                parentNode.setRightNode(null);
            }else{
                parentNode.setLeftNode(null);
            }
        }

        // Caso 2: Nó com um filho
        if(currentNode.hasLeft() ^ currentNode.hasRight()){
            Node<T> case2Aux;
            if(currentNode.hasLeft()) case2Aux = currentNode.getLeftNode();
            else case2Aux = currentNode.getRightNode();

            if(comparator.compare(currentNode.getValue(), parentNode.getValue()) > 0){
                parentNode.setRightNode(case2Aux);
            }else{
                parentNode.setLeftNode(case2Aux);
            }
        }

        //Caso 3: Nó com um filho - Pegando o minimo do lado direito
        if(currentNode.hasLeft() && currentNode.hasRight()){
            Node<T> case3Aux = currentNode.getRightNode();
            
            // Finding the minimum value from right tree
            while(case3Aux.hasLeft()){
                case3Aux = case3Aux.getLeftNode();
            }
            
            this.deleteItem(case3Aux.getValue());
            currentNode.setValue(case3Aux.getValue());

        }

    }

    // Print methods
    public void printInOrder(Node<T> node){
        if(node != null){
            this.printInOrder(node.getLeftNode());
            System.out.print(node.getValue() + " ");
            this.printInOrder(node.getRightNode());
        }
    }

    public void printPostOrder(Node<T> node){
        if(node != null){
            this.printPostOrder(node.getLeftNode());
            this.printPostOrder(node.getRightNode());
            System.out.print(node.getValue() + " ");
        }
    }

    public void printPreOrder(Node<T> node){
        if(node != null){
            System.out.print(node.getValue() + " ");
            this.printPreOrder(node.getLeftNode());
            this.printPreOrder(node.getRightNode());
        }
    }
    
    public void printIndented(Node<T> node, String indent, boolean last) {
        System.out.print(indent);
        if (last) {
            System.out.print("└─");
            indent += "  ";
        } else {
            System.out.print("├─");
            indent += "│ ";
        }
        System.out.println(node.getValue());

        if (node.getRightNode() != null) {
            printIndented(node.getRightNode(), indent, node.getLeftNode() == null);
        }

        if (node.getLeftNode() != null) {
            printIndented(node.getLeftNode(), indent, true);
        }
    }

    //Percorrer em nível. Vamos utilizar fila do Java para auxiliar. Dá pra fazer recursivo, só não acho que é necessário.
    //São necessários parâmetros para a função?
    public void printBreadthFirstSearch() {
        Queue<Node<T>> queue = new LinkedList<Node<T>>();
        queue.add(this.rootNode);
        while (!queue.isEmpty()) {
            Node<T> node = queue.remove();
            System.out.print(node.getValue() + " ");
            if (node.getLeftNode() != null) {
                queue.add(node.getLeftNode());
            }
            if (node.getRightNode() != null) {
                queue.add(node.getRightNode());
            }
        }
    }

    //Maior e menor elemento.
    public void getSmaller(Node<T> parent) {
        if (parent.getLeftNode() != null) {
            getSmaller(parent.getLeftNode());
        } else {
            System.out.println(parent.getValue());
        }
    }

    public void getBigger(Node<T> parent) {
        if (parent.getRightNode() != null) {
            getBigger(parent.getRightNode());
        } else {
            System.out.println(parent.getValue());
        }
    }
    
    // Getters and Setters
    public Node<T> getRootNode() {
        return this.rootNode;
    }
    
    public void setRootNode(Node<T> rootNode) {
        this.rootNode = rootNode;
    }

    public int getHeight(Node<T> node) {
        if (node == null) {
            return 0;
        } else {
            int leftHeight = getHeight(node.getLeftNode());
            int rightHeight = getHeight(node.getRightNode());
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    public Integer getNodesNum() {
        this.nodesNum = 0;
        countNodes(this.rootNode);
        return this.nodesNum;
    }

    public void countNodes(Node<T> node){
        if(node != null){
            this.nodesNum++;
            countNodes(node.getLeftNode());
            countNodes(node.getRightNode());
        }
    }

    
}
