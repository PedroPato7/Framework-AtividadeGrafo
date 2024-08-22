package grafo;

/**
 * Classe auxíliar do algoritmo Dijkstra, onde armazena o node e sua distância associada.
 * 
 * @param <T> é o tipo do dado armazenado no node.
 */

class NodeDistancePair<T> implements Comparable<NodeDistancePair<T>> {
    
	private Node<T> node;
    private double distance;

    /**
     * Construtor para criar um par de node e sua distância.
     * 
     * @param node o node inserido.
     * @param distance distância associada ao node.
     */
    public NodeDistancePair(Node<T> node, double distance) {
        this.node = node;
        this.distance = distance;
    }

    /**
     * Retorna o node armazenado no par.
     * 
     * @return o node.
     */
    public Node<T> getNode() {
        return node;
    }

    /**
     * Retorna a distância associada ao node.
     * 
     * @return a distância.
     */
    public double getDistance() {
        return distance;
    }

    /**
     * Compara um par de node e sua distância com outro par, baseado na sua distância.
     * 
     * @param other é o outro par a ser comparado.
     * @return um valor negativo, positivo ou neutro, dependendo da diferença das distâncias.
     */
    @Override
    public int compareTo(NodeDistancePair<T> outro) {/* Método "compareTo" que garante que a "priorityQueue" 
    ordene pela distância.*/
        return Double.compare(this.distance, outro.distance);//Compara as distâncias para ordenar a fila.
    }
}