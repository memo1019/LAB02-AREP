package edu.escuelaing.arep.Calculadora.Linkedist;
/**
 *
 * Esta clase crea el primer y ultimo nodo de la LinkedList
 * @author Guillermo Alfonso CAstro Camelo
 *
 *
 * */
public class Head<E> {
    private Node<E> FirstNode;
    private Node<E> LastNode;

    /**
     * Constructor de la clase Head
     *
     * @param First
     * @param Last
     */
    public Head(Node<E> First, Node<E> Last) {
        FirstNode = First;
        LastNode = Last;
    }

    /**
     * retorna el ultimo nodo
     *
     * @return Node
     */
    public Node<E> getLastNode() {
        return LastNode;
    }

    /**
     * cambia el ultimo nodo por el parametro
     *
     * @param lastNode
     */
    public void setLastNode(Node<E> lastNode) {
        LastNode = lastNode;
    }

    /**
     * retorna el primer nodo
     *
     * @return Node
     */
    public Node<E> getFirstNode() {
        return FirstNode;
    }

    /**
     * cambia el primer nodo por el parametro
     *
     * @param firstNode
     */
    public void setFirstNode(Node<E> firstNode) {
        FirstNode = firstNode;
    }

}