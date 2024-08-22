package grafo;

import java.util.Objects;
/**
 * Classe que representa um nó em um grafo.
 *
 * @param <T> é o tipo de dado armazenado no node.
 * @author Pedro Henrique Damann
 * @version 1.0
 */

public class Node<T> {
    
	/**
	 * Armazena o valor que corresponde ao node.
	 */
	private T valor;

	/**
     * Construtor para criar um novo node.
     *
     * @param é o valor a ser armazenado no node.
     */
    public Node(T valor) {
        this.valor = valor;
    }

    /**
     * Retorna o valor armazenado no node.
     *
     * @return o valor do node.
     */
    public T getValor() {
        return valor;
    }
    
    /**
     * Define o valor armazenado no node.
     * 
     * @param o novo valor armazenado no node.
     */
    public void setValor(T valor) {
        this.valor = valor;
    }

    /**
     * Retorna uma representação em String do node.
     * 
     * @return uma string do valor do node.
     */
    @Override
    public String toString() {
        return valor.toString();
    }
    
    /**
     * Retorna se os nodes inseridos são iguais ou não.
     * 
     * @return a verificação de se os nodes inseridos são iguais ou não.
     */
   public boolean equals(Object obj) { // Compara os nós para não repetir na hora de apresentar para o usuário.
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Node<?> node = (Node<?>) obj;
        return Objects.equals(valor, node.valor);
    }

   /**
    * Retorna a informação do valor inserido no hash.
    * 
    * @return o código hash do valor armazenado.
    */
    @Override
    public int hashCode() {
        return Objects.hash(valor);
    }
}