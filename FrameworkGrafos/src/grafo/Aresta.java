package grafo;

/**
 * Classe representando a aresta dos Nodes.
 * 
 * @param <T> o tipo do dado armazenado nessa classe.
 * @author Pedro Henrique Damann
 * @version 1.0
 */
public class Aresta<T> {
	
    private Node<T> de;	
    private Node<T> para;
    private double peso;

	/**
	 * Construtor para criar uma nova aresta.
	 * 
	 * @param de é o node original.
	 * @param para é o node destino que vai ser conectado com o original.
	 * @param peso é o peso da aresta.
	 */
    public Aresta(Node<T> de, Node<T> para, double peso) {
        this.de = de;
        this.para = para;
        this.peso = peso;
    }

    /**
     * Retorna o node original da aresta.
     * 
     * @return o node original.
     */
    public Node<T> getDe() {
        return de;
    }

    /**
     * Retorna o node de destino da aresta.
     * 
     * @return qual o node sera conectado com o node original.
     */
    public Node<T> getPara() {
        return para;
    }

    /**
     * Retorna o peso desta aresta.
     * 
     * @return o peso da aresta entre os nodes.
     */
    public double getPeso() {
        return peso;
    }

    /**
     * Retorna uma representação em String da aresta entre os nodes.
     * 
     * @return a representação da aresta no formato: de -> para [peso].
     */
    @Override
    public String toString() {
        return de.toString() + " -> " + para.toString() + " [ peso = " + peso + " ]";
    }
}