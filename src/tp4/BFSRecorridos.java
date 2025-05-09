package ProgramacionIII.tp4;
import java.util.*;

public class BFSRecorridos<T> {

    private Grafo<T> grafo;
    private Map<Integer, String> color;
    private Map<Integer, Integer> distancia;
    private Map<Integer, Integer> predecesor;

    public BFSRecorridos(Grafo<T> grafo) {
        this.grafo = grafo;
        this.color = new HashMap<>();
        this.distancia = new HashMap<>();
        this.predecesor = new HashMap<>();

        Iterator<Integer> it = grafo.obtenerVertices();
        while (it.hasNext()) {
            int v = it.next();
            color.put(v, "BLANCO");
            distancia.put(v, Integer.MAX_VALUE); // infinito
            predecesor.put(v, null);
        }
    }

    public void bfs(int origen) {
        color.put(origen, "GRIS");
        distancia.put(origen, 0);
        predecesor.put(origen, null);/// yo no tengo ningun padre porque soy el primero

        Queue<Integer> cola = new LinkedList<>();
        cola.add(origen);

        while (!cola.isEmpty()) {
            int u = cola.poll();
            Iterator<Integer> adyacentes = grafo.obtenerAdyacentes(u);
            while (adyacentes.hasNext()) {
                int v = adyacentes.next();
                if (color.get(v).equals("BLANCO")) {
                    color.put(v, "GRIS");
                    distancia.put(v, distancia.get(u) + 1);///Mi distancia es la de mi padre+1
                    predecesor.put(v, u);
                    cola.add(v);///cuando termina el while que encontro este adyacente, lo guardamos para buscar los adyacentes de este
                /// Asi se logra el recorrido por niveles
                }
            }
            /// cuando se termina la lista de adyacentes de u lo pintamos de negro
            color.put(u, "NEGRO");
        }
    }

    // Métodos para consultar resultados
    public Map<Integer, Integer> getDistancias() {
        return distancia;
    }

    public Map<Integer, Integer> getPredecesores() {
        return predecesor;
    }

    public Map<Integer, String> getColores() {
        return color;
    }
}
