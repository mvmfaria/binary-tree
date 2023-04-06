public class Counter<T>{
    protected Node<T> node;
    protected Integer counter;

    public Node<T> getNode() {
        return this.node;
    }

    public void setNode(Node<T> node) {
        this.node = node;
    }

    public Integer getCounter() {
        return this.counter;
    }

    public void setCounter(Integer counter) {
        this.counter = counter;
    }

    public Counter(Node<T> node){
        this.node = node;
        this.counter = 0;
    }

    public void increment(){
        this.counter++;
    }

    public void decrement(){
        this.counter++;
    }
}
