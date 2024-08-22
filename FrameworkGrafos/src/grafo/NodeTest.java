package grafo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Classe de teste para a classe {@link Node}
 * Esta classe possuí testes unitários para verificar o comportamento dos métodos da classe Node.
 * 
 * @author Pedro Henrique Damann
 * @version 1.0
 */

public class NodeTest {

	/**
	 * Faz o teste do método {@link Node#equals(Object)}.
	 * Testa para ver se os nodes com o mesmo valor são iguais.
	 */
	@Test
    public void testeNodeEquals() {
        // Cria dois nodes com o mesmo valor "A"
        Node<String> nodeA1 = new Node<>("A");
        Node<String> nodeA2 = new Node<>("A");

        // Verifica se os nodes são iguais ou não
        assertTrue(nodeA1.equals(nodeA2));
    }

	/**
	 * Faz o teste do método {@link Node#equals(Object)}.
	 * testa se os nodes com valores diferentes são considerados diferentes.
	 */
    @Test
    public void testeNodeNotEquals() {
        // Cria dois nodes com valores diferentes: "A" e "B".
        Node<String> nodeA = new Node<>("A");
        Node<String> nodeB = new Node<>("B");

        // Verifica se os nodes são diferentes ou não.
        assertFalse(nodeA.equals(nodeB));
    }

    /**
     * Faz o teste do método {@link Node#hashCode()}
     * Verifica se dois nodes iguais tem o mesmo código hash.
     */
    @Test
    public void testeNodeHashCode() {
        // Cria dois nodes com o mesmo valor: "A"
        Node<String> nodeA1 = new Node<>("A");
        Node<String> nodeA2 = new Node<>("A");

        // Verifica se os nodes tem o mesmo hashCode
        assertEquals(nodeA1.hashCode(), nodeA2.hashCode());
    }

    /**
     * Faz o teste do método {@link Node#toString()}.
     * Verifica se a representação em string está correta.
     */
    @Test
    public void testeNodeToString() {
        // Cria um node com o valor: "A"
        Node<String> nodeA = new Node<>("A");

        // Verifica se o método toString retorna o valor correto
        assertEquals("A", nodeA.toString());
    }
	
}
