package grafo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * Classe que representa o grafo genérico, podendo fazer operações de adicionar nodes e arestas,
 * e algoritmos de busca do menor caminho de um node a outro.
 * 
 * @param <T> é o tipo de dado armazenado nos nodes do grafo.
 * @author Pedro Henrique Damann
 * @version 1.0
 */

public class Graph<T> {
	
    private Map<Node<T>, List<Aresta<T>>> adjacencyList; 
    /*
     * Acima é criado o "Mapa" onde tem todos os nós, lista de arestas e
     * o "adjacencyList" que associa os nós as arestas.
	*/
    
    /**
     * Cria a instância do adjacencyList
     * 
     * @param Cria a instância do adjacencyList que recebe o HashMap.
     */
    public Graph() {
        adjacencyList = new HashMap<>(); // Cria uma nova instância do adjacencyList
    }

    /**
     * Adiciona um node ao grafo
     * 
     * @param value é o valor do node a ser adicionado no grafo
     */
    public void addNode(Node<T> value) { // Cria um novo Nodo
        Node<T> node = value;
        adjacencyList.putIfAbsent(node, new ArrayList<>()); // Faz a confirmação se o nodo já existe antes de criar
    }

    /**
     * Cria a aresta entre os dois nodes inseridos.
     * 
     * @param de node origem da aresta.
     * @param para node de destino da aresta.
     * @param peso peso da aresta.
     */
    public void addAresta(Node<T> de, Node<T> para, double peso) { // Cria uma aresta entre dois Nodos      
        //Caso não exista os Nodos inseridos, eles são criados.
        adjacencyList.putIfAbsent(de, new ArrayList<>());
        adjacencyList.putIfAbsent(para, new ArrayList<>());

        adjacencyList.get(de).add(new Aresta<>(de, para, peso)); // Faz a junção dos nodos na aresta
    }

    /**
     * Pega as arestas conectadas ao node inserido
     * 
     * @param node o node inserido para pegar quais arestas estão conectadas nele.
     * @return quais são as arestas conectadas ao node inserido.
     */
    public List<Aresta<T>> getArestas(Node<T> node) { // Apresenta as arestas conectadas a um nodo específico 
        return adjacencyList.getOrDefault(node, new ArrayList<>());// apresenta as arestas do node inserido ou o valor default passado.
    }

    /**
     * Retorna os nodes do grafo.
     * 
     * @return todos os nodes que estão no grafo.
     */
    public List<Node<T>> getNodes() { // Apresenta todos os nodos do grafo.
        return new ArrayList<>(adjacencyList.keySet());
    }

    /**
     * Retorna o grafo em uma string, mostrando os nodes com suas respectivas arestas e suas informações.
     * 
     * @return uma string representando o grafo atual.
     */
    @Override
    public String toString() {	// Cria a estrutura dos grafos e arestas de uma forma entendivel para o usuário
        
    	StringBuilder sb = new StringBuilder(); // Vai armazenar as informações e apresentar elas formatadas.
        
    	// Entra em um for que roda igual a quantidade de "keys" existente dentro do adjacencyList
        for (Node<T> node : adjacencyList.keySet()) { 
            sb.append(node.toString()).append(": "); // Pega o valor do 1° nodo e apresenta da seguinte forma | A:
            List<Aresta<T>> arestas = adjacencyList.get(node);// Pega as arestas do nodo atual.
            
            if (arestas != null && !arestas.isEmpty()) { // Verifica se existe arestas conectadas no nodo
                for (Aresta<T> aresta : arestas) { // Faz um for igual a quantidade de arestas
                    sb.append(aresta.toString()).append(", "); 
                    /*
                     * Insere no "sb" as informações dos Nodos e as arestas usando o toString da classe "Aresta"
                     * Insere a "," no final para caso exista mais conexões do nodo atual.
                     */
                }
                sb.setLength(sb.length() - 2); // Remove a última vírgula e espaço
            }            
            sb.append("\n"); // Quebra a linha para poder ficar mais organizado.
        }
        return sb.toString(); // Retorna ao usuário as informações 
    }
    
    /**
     * Retorna se o node inserido existe ou não.
     * 
     * @param value é o node que o usuário deseja verificar se existe.
     * @return se o node inserido existe ou não.
     */
    public boolean existeNodo(T value) { // Faz a verificação de o nodo inserido existe ou não
        Node<T> node = new Node<>(value);
        return adjacencyList.containsKey(node);
    }
    
    /**
     * Faz uma busca em largura (BFS) a partir do node inicial inserido.
     * 
     * @param startNode é o node inicial de onde a procura começa.
     * @return a lista de nodes em ordem que foram visitados.
     */
    public List<Node<T>> bfs(Node<T> startNode) { //Cria o metodo BFS, pedindo o Nodo inicial.
        
    	List<Node<T>> nodesVisitados = new ArrayList<>(); // Armazena os nodos que foram visitados.
       
        Queue<Node<T>> queue = new LinkedList<>(); // Salva 
           
        queue.add(startNode); // Adicionam o nodo inicial.
        nodesVisitados.add(startNode);

        while (!queue.isEmpty()) { //Enquanto a "queue" não estiver vazia, continua no loop.
           
        	Node<T> currentNode = queue.poll(); // Salva qual o nodo atual e remove ele da lista até ficar fazia, retornando Null.

            List<Aresta<T>> arestas = adjacencyList.get(currentNode); // Pega as arestas do Node atual.
            
            for (Aresta<T> aresta : arestas) { // Faz um loop de acordo com a quantidade de arestas do Node.
                Node<T> vizinho = aresta.getPara(); // Salva quais as conexões que a aresta atual faz.
                
                if (!nodesVisitados.contains(vizinho)) { // Verifica se o node visitado já foi conferido ou não
                	nodesVisitados.add(vizinho); // Salva na variável quais vizinhos ele tem conexão
                   
                	queue.add(vizinho); 
                 // salva na "queue" o vizinho do Node atual, repetindo o processo até salvar todos os Nodes que estão conectados.
                }
            }
        }
        return nodesVisitados;
    }
    
    /**
     * Faz a busca em profundidade (DFS) a partir do node inicial inserido.
     * 
     * @param startNode é o node inicial de onde o algoritmo vai começar a procurar.
     * @return uma lista em ordem dos nodes visitados.
     */
    public List<Node<T>> dfs(Node<T> startNode) { // Método que usa o DFS
       
    	List<Node<T>> nodesVisitados = new ArrayList<>(); //Cria o array que vai salvar os nodes visitados
        
        dfsRecursivo(startNode, nodesVisitados); //Chama a função recursiva para fazer a operação.
        return nodesVisitados;
    }

    /**
     * Operação que realiza a procura em profundidade (DFS) e salva a ordem dos nodes visitados.
     * 
     * @param nodeAtual é o node de onde o algoritmo começa a procurar.
     * @param nodesVisitados salva em ordem os nodes que são visitados.
     */
    private void dfsRecursivo(Node<T> nodeAtual, List<Node<T>> nodesVisitados) {
    	
    	nodesVisitados.add(nodeAtual); // Salva o node atual nos que foram "visitados".

        List<Aresta<T>> arestas = adjacencyList.get(nodeAtual); // Salva as arestas do node atual.
        
        for (Aresta<T> aresta : arestas) { // Faz um for para a quantidade de arestas do Node.
           
        	Node<T> vizinho = aresta.getPara(); // Salva os nodes que a aresta tem conexão.
            
            if (!nodesVisitados.contains(vizinho)) { // Verifica se o node visitado já foi conferido ou não.
                dfsRecursivo(vizinho, nodesVisitados); //Chama a própria função para verificar o vizinho visitado em ordem.
            }
        }
    }
    
    /**
     * Execuxa o algoritmo do Dijkstra a partir do node inserido, para encontrar o caminnho mais curto
     * para todos os outros nodes.
     * 
     * @param startNode é o node onde começa a procura.
     * @return uma lista de todos os nodes e seus respectivos caminhos mínimos para os outros nodes.
     */
    public Map<Node<T>, Double> dijkstra(Node<T> startNode) { // Inicia o metodo Dijkstra
    	
        Map<Node<T>, Double> distances = new HashMap<>(); // armazena as menores distâncias conhecidas.
       
        PriorityQueue<NodeDistancePair<T>> priorityQueue = new PriorityQueue<>(); //Salva o próximo Node a ser processado.
       
        Set<Node<T>> nodesVisitados = new HashSet<>(); // Armazena quais os Nodos que já foram visitados
 
        // Inicializando todas as distâncias como infinito e a distância para o startNode como 0
        for (Node<T> node : adjacencyList.keySet()) {
            distances.put(node, Double.POSITIVE_INFINITY); // Define a distância inicial de todos os Nodos como infinito. 
        }
        distances.put(startNode, 0.0); // Define a distância do primeiro Nodo para 0.0 pois é onde começa.

        // Adicionando o nó inicial na fila de prioridade
        priorityQueue.add(new NodeDistancePair<>(startNode, 0.0));

        while (!priorityQueue.isEmpty()) { // Verifica para que enquanto houver Nodos para verificar, continua no Loop.
            
        	Node<T> nodeAtual = priorityQueue.poll().getNode(); // Remove o Nodo com menor distância entre o Nodo da "priorityQueue".

            if (nodesVisitados.contains(nodeAtual)) {//Verifica se o nodo foi visitado ou não.
                continue;
            }
            nodesVisitados.add(nodeAtual);// Salva o Nodo que foi visitado.

            // Pega as arestas e suas conexões do Nodo atual.
            List<Aresta<T>> arestas = adjacencyList.get(nodeAtual);
           
            for (Aresta<T> aresta : arestas) { // Percorre todas as arestas do Node.
            	
                Node<T> vizinho = aresta.getPara(); // Armazena o Node vizinho do atual.
                
                double novaDistan = distances.get(nodeAtual) + aresta.getPeso(); // Calcula a nova distância a partir do Node Atual.

                // Se a nova distância for menor, atualiza e adiciona na fila
                if (novaDistan < distances.get(vizinho)) {
                	
                    distances.put(vizinho, novaDistan); // Atualiza a distância até o Node vizinho.
                    
                    // Adiciona o novo vizinho a lista de "priorityQueue"
                    priorityQueue.add(new NodeDistancePair<>(vizinho, novaDistan)); 
                }
            }
        }
        return distances;
    }

    //Getters e Setters
	public Map<Node<T>, List<Aresta<T>>> getAdjacencyList() {
		return adjacencyList;
	}

	public void setAdjacencyList(Map<Node<T>, List<Aresta<T>>> adjacencyList) {
		this.adjacencyList = adjacencyList;
	}
}