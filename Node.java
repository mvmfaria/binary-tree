public class Node<T>{
    private T value;
    private Node<T> leftNode;
    private Node<T> rightNode;

    
    public Node(T value){
        this.value = value;
        this.leftNode = null;
        this.rightNode = null;
    }

    // Methods
    public boolean hasRight(){
        return this.rightNode != null;
    }

    public boolean hasLeft(){
        return this.leftNode != null;
    }

    // Getters and Setters
    public T getValue() {
        return this.value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node<T> getLeftNode() {
        return this.leftNode;
    }

    public void setLeftNode(Node<T> leftNode) {
        this.leftNode = leftNode;
    }

    public Node<T> getRightNode() {
        return this.rightNode;
    }

    public void setRightNode(Node<T> rightNode) {
        this.rightNode = rightNode;
    }
}