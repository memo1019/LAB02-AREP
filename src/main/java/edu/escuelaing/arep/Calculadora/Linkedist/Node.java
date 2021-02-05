package edu.escuelaing.arep.Calculadora.Linkedist;

public class Node <E> {
    private Node<E> nextNode;
    private Node<E> priorNode;

    private E type;
    /**
     * contructor de los nodos de la LinkedList
     * @param nextNode
     * @param priorNode
     * @param type
     * */
    public Node(E type,Node<E> nextNode,Node<E> priorNode ){
        this.type=type;
        this.nextNode=nextNode;
        this.priorNode=priorNode;
    }
    /**
     *retorna el tipo del nodo
     * @return E tipo de dato
     * */

    public E getTypeE(){
        return type;
    }
    /**
     *retorna el tipo del nodo
     * @return String
     * */
    public String getType() {

        return type.toString();
    }
    /**
     *cambia el tipo del nodo por el parametro
     * @param type
     * */

    public void setType(E type) {
        this.type = type;
    }

    /**
     *cambia el siguiente nodo por el parametro
     * @param node
     * */
    public void setNextNode(Node<E> node) {
        nextNode=node;
    }
    /**
     * retorna el siguiente nodo
     *
     * @return Node
     */
    public Node<E> getNextNode() {
        return nextNode;
    }
    /**
     * retorna el anterior nodo
     *
     * @return Node
     */
    public Node<E> getPriorNode() {
        return priorNode;
    }
    /**
     *cambia el anterior nodo por el parametro
     * @param priorNode
     * */
    public void setPriorNode(Node<E> priorNode) {
        this.priorNode = priorNode;
    }

}
