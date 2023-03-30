public class BinaryTree <T extends Comparable<T>>{
    private Node rootNode;
    private Integer nodesNum;

    public BinaryTree(){
        this.rootNode = new Node(null);
    }

    // Methods
    public void insertNode(Node newNode){
        
        // Testing if the root node is null
        if(this.rootNode.getValue() == null){
            this.rootNode.setValue(newNode.getValue());
        } else{
            // Searching
            Node currentNode = this.rootNode;
            Boolean wasFound = false;
            
            while(!wasFound){
                // Se encontrar o valor igual, executa o break
                if(((Comparable<T>) newNode.getValue()).compareTo((T) currentNode.getValue()) == 0)
                    break;

                if(((Comparable<T>) newNode.getValue()).compareTo((T) currentNode.getValue()) > 0){
                    if(!currentNode.hasRight()){
                        currentNode.setRightNode(newNode);
                        wasFound = true;
                    }else{
                        currentNode = currentNode.getRightNode();
                    }
                }else{
                    if(!currentNode.hasLeft()){
                        currentNode.setLeftNode(newNode);
                        wasFound = true;
                    }else{
                        currentNode = currentNode.getLeftNode();
                    }
                }
            }

        }
    }
    
    public void printInOrder(Node node){
        if(node != null){
            this.printInOrder(node.getLeftNode());
            System.out.print(node.getValue() + " ");
            this.printInOrder(node.getRightNode());
        }
    }

    public void printPostOrder(Node node){
        if(node != null){
            this.printPostOrder(node.getLeftNode());
            this.printPostOrder(node.getRightNode());
            System.out.print(node.getValue() + " ");
        }
    }

    public void printPreOrder(Node node){
        if(node != null){
            System.out.print(node.getValue() + " ");
            this.printPreOrder(node.getLeftNode());
            this.printPreOrder(node.getRightNode());
        }
    }
    
    public void printIndented(Node node, String indent, boolean last) {
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

    public void deleteItem(Object item){
        Node currentNode = this.rootNode;
        Node parentNode = null;
        Boolean wasFound = false;

        while(!wasFound || currentNode == null){
            if(((Comparable<T>) item).compareTo((T) currentNode.getValue()) == 0)
                wasFound = true;

            if(!wasFound){
                parentNode = currentNode;
                if(((Comparable<T>) item).compareTo((T) currentNode.getValue()) > 0){
                    currentNode = currentNode.getRightNode();
                }else{
                    currentNode = currentNode.getLeftNode();
                }
            }
        }

        // Caso 1: Nó sem filhos
        if(!currentNode.hasLeft() && !currentNode.hasRight()){
            if(((Comparable<T>) currentNode.getValue()).compareTo((T) parentNode.getValue()) > 0){
                parentNode.setRightNode(null);
            }else{
                parentNode.setLeftNode(null);
            }
        }

        // Caso 2: Nó com um filho
        if(currentNode.hasLeft() ^ currentNode.hasRight()){
            Node case2Aux;
            if(currentNode.hasLeft()) case2Aux = currentNode.getLeftNode();
            else case2Aux = currentNode.getRightNode();

            if(((Comparable<T>) currentNode.getValue()).compareTo((T) parentNode.getValue()) > 0){
                parentNode.setRightNode(case2Aux);
            }else{
                parentNode.setLeftNode(case2Aux);
            }
        }

        //Caso 3: Nó com um filho - Pegando o minimo do lado direito
        if(currentNode.hasLeft() && currentNode.hasRight()){
            Node case3Aux = currentNode.getRightNode();
            // Finding the minimum value from right tree
            while(case3Aux.hasLeft()){
                case3Aux = case3Aux.getLeftNode();
            }
            
            this.deleteItem(case3Aux.getValue());
            currentNode.setValue(case3Aux.getValue());

        }

    }

    public void countNodes(Node node){
        if(node != null){
            this.nodesNum++;
            countNodes(node.getLeftNode());
            countNodes(node.getRightNode());
        }
    }
    
    // Getters and Setters
    public Node getRootNode() {
        return this.rootNode;
    }
    
    public void setRootNode(Node rootNode) {
        this.rootNode = rootNode;
    }

    public int getHeight(Node node) {
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
}
