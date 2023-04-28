package library;
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

    public int getHeight(){
        return getHeight(this);
    }

    private int getHeight(Node<T> node){
        if(node == null) return -1;
        else{
            int hr = getHeight(node.getRightNode());
            int hl = getHeight(node.getLeftNode());

            if(hr > hl) return hr + 1;
            else return hl + 1;
        }
    }

    public int balanceFactor(){
        return getHeight(this.getRightNode()) - getHeight(this.getLeftNode());
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