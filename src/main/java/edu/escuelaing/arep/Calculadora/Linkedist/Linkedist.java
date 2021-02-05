package edu.escuelaing.arep.Calculadora.Linkedist;

public class Linkedist<E> {
    private Head<E> head;
    private int size;
    /**
     *Contructor de la lista enlazada o LinkedList
     * */

    public Linkedist() {
        head = new Head<E>(null, null);
    }
    /**
     * Se encarga de eliminar el nodo que se eliga
     * @return
     * */
    public Node<E> removeNode(Node<E> value){
        return null;
    }
    /**
     * retorna el anterior nodo
     *
     * @return Node
     */
    public Node<E> priorNode(){
        return head.getFirstNode().getPriorNode();
    }
    /**
     * este metodo se encarga de agregar un nodo a la LinkedList
     * @param value
     * */
    public void addNode(E value) {
        Node<E> nodo = new Node<E>(value, null, null);
        if (head.getFirstNode() == null)
            head.setFirstNode(nodo);
        else {
            Node<E> pos = head.getFirstNode();
            while (pos.getNextNode() != null) {
                pos = pos.getNextNode();
            }
            pos.setNextNode(nodo);
        }
        size++;
        head.setLastNode(nodo);

    }
    /**
     * retorna el siguiente nodo
     *
     * @return Node
     */
    public Node<E> nextNode(){
        return head.getFirstNode().getNextNode();
    }
    /**
     * retorna el longitud de la LinkedList
     *
     * @return int
     */
    public int  getSize(){
        return size;
    }
    /**
     * retorna el primer nodo
     *
     * @return Node
     */
    public Node<E> getFirst(){
        return head.getFirstNode();
    }
    /**
     * Se encarga de convertir la LinkedList en
     * String para poder imprimirla
     * @return String
     * */
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Node<E> pos = head.getFirstNode();
        while (pos != null) {
            stringBuilder.append(pos.getTypeE()).append(" ");
            pos = pos.getNextNode();
        }
        return stringBuilder.toString().trim();

    }
}
