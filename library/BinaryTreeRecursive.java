package library;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
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
    
    public Counter<T> searchNode(T value){
        Counter<T> counter = new Counter<>(getRootNode());
        counter.increment();
        return searchNodeRecursive(value, counter);
    }

    private Counter<T> searchNodeRecursive(T value, Counter<T> counter){
        if(counter.getNode() != null){
            if(comparator.compare(value, counter.getNode().getValue()) == 0){
                return counter;
            }else{
                if(comparator.compare(value, counter.getNode().getValue()) > 0){
                    if(!counter.getNode().hasRight()){
                        return null;
                    }else{
                        counter.increment();
                        counter.setNode(counter.getNode().getRightNode());
                        return searchNodeRecursive(value, counter);
                    }
                }else{
                    if(!counter.getNode().hasLeft()){
                        return null;
                    }else{
                        counter.increment();
                        counter.setNode(counter.getNode().getLeftNode());
                        return searchNodeRecursive(value, counter);
                    }
                }
            }
        }return null;
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
            if(parentNode != null){
                if( comparator.compare(currentNode.getValue(), parentNode.getValue()) > 0){
                    parentNode.setRightNode(null);
                }else{
                    parentNode.setLeftNode(null);
                }
            }else{
                this.rootNode = null;
            }
        }

        // Caso 2: Nó com um filho
        if((currentNode.hasLeft() ^ currentNode.hasRight())){
            Node<T> case2Aux;
            if(currentNode.hasLeft()) case2Aux = currentNode.getLeftNode();
            else case2Aux = currentNode.getRightNode();

            if(parentNode != null){
                if(comparator.compare(currentNode.getValue(), parentNode.getValue()) > 0){
                    parentNode.setRightNode(case2Aux);
                }else{
                    parentNode.setLeftNode(case2Aux);
                }
            }else{
                if(currentNode.hasLeft()) this.rootNode = currentNode.getLeftNode();
                else this.rootNode = currentNode.getRightNode();
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
    
    /*Esta função foi criada para fazer a geração da lista de alunos (pois precisávamos dos alunos ordenados em ordem crescente) que será 
     * escrita no arquivo de saída, sua única diferença da de cima é que aqui precisamos passar uma lista como parâmetro e ao invés 
     * de imprimos cada nó, nós adicionamos ele na lista "elements" passada como parâmetro.
     */
    public void createListInOrder(Node<T> node, List<T> elements){
        if(node != null){
            this.createListInOrder(node.getLeftNode(), elements);
            elements.add(node.getValue());
            this.createListInOrder(node.getRightNode(), elements);
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
        if(this.rootNode != null){
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
        }else{
            System.out.println("Árvore está vazia!");
        }
    }

    /*Para percorrer (e printar) a árvore em nível foi necessário utilizar uma pilha.
     * Primeiro criamos a pilha utilizando a própria classe do Java e já adicionamos a raiz da árvore na pilha. Então fazemos um loop 
     * que executa até a pilha estar vazia, ou seja, até todos os elementos serem percorridos. Dentro do loop, removemos o nó adicionado 
     * utilizando o método remove() que retira o elemento da pilha e retorna qual foi o elemento removido. Atribuimos esse retorno
     * à variável "node" para que possamos printá-lo e utilizar seus filhos. Por fim verificamos os nós filhos de "node", sempre da esquerda 
     * para a direita, para saber se eles existem, se sim, adicionamos o filho em questão na pilha.
     */
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
    public T getMin(){
        return getMinRecursive(rootNode);
    }

    public T getMax(){
        return getMaxRecursive(rootNode);
    }

    /*Aqui a ideia é bem simples, sabemos que o menor elemento da árvore é o elemento mais a esquerda. Com isso, basta ir verificando se nó
     *que estamos verificando no momento possui um filho a esquerda, se sim chamamos o método recursivamento para esse filho, se não, o menor
     *elemento é que estivermos verificando no momento.
     */
    private T getMinRecursive(Node<T> parent) {
        if (parent.getLeftNode() != null) {
            return getMinRecursive(parent.getLeftNode());
        } else {
            return parent.getValue();
        }
    }
    /*E para obtermos o maior nó, seguimos a mesma lógica do método acima, porém, verificando os filhos a direita, visto que, agora o maior
     *elemento será o nó mais a direita.
     */
    private T getMaxRecursive(Node<T> parent) {
        if (parent.getRightNode() != null) {
            return getMaxRecursive(parent.getRightNode());
        } else {
            return parent.getValue();
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

    /*Método para auxiliar o clear da tela.*/
    public void clearScreen() {
        try {
           if (System.getProperty("os.name").contains("Windows")) {
              new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
           } else {
              System.out.print("\033[H\033[2J");
              System.out.flush();
           }
        } catch (Exception ex) {
           System.err.println("Error: " + ex.getMessage());
        }
     }

    
}
