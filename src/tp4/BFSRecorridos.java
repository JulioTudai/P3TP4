package ProgramacionIII.tp4;
import java.util.*;

public class BFSRecorridos<T> {

    private Grafo<T> grafo;
    private Map<Integer, String> color;
    private Map<Integer, Integer> distancia;
    private Map<Integer, Integer> padre;

    public BFSRecorridos(Grafo<T> grafo) {
        this.grafo = grafo;
        this.color = new HashMap<>();
        this.distancia = new HashMap<>();
        this.padre = new HashMap<>();

        Iterator<Integer> it = grafo.obtenerVertices();
        while (it.hasNext()) {
            int v = it.next();
            color.put(v, "BLANCO");
            distancia.put(v, Integer.MAX_VALUE); // infinito
            padre.put(v, null);
        }
    }

    public void bfs(int origen) {
        color.put(origen, "GRIS");
        distancia.put(origen, 0);
        padre.put(origen, null);/// yo no tengo ningun padre porque soy el primero

        Queue<Integer> cola = new LinkedList<>();
        cola.add(origen);

        while (!cola.isEmpty()) {
            int u = cola.poll();// u siempre va a ser el padre de los adyacentes del while que sigue
            Iterator<Integer> adyacentes = grafo.obtenerAdyacentes(u);
            while (adyacentes.hasNext()) {
                int v = adyacentes.next();
                if (color.get(v).equals("BLANCO")) {
                    color.put(v, "GRIS");
                    distancia.put(v, distancia.get(u) + 1);///Mi distancia es la de mi padre+1
                    padre.put(v, u);
                    cola.add(v);///cuando termina el while que encontro este adyacente, lo guardamos para buscar los adyacentes de este
                /// Asi se logra el recorrido por niveles
                }
            }
            /// cuando se termina la lista de adyacentes de u lo pintamos de negro
            color.put(u, "NEGRO");
        }
    }

    public ArrayList<Integer> BFSMascorto(Integer origen, Integer destino){
        color.put(origen,"GRIS");
        distancia.put(origen,0);
        padre.put(origen,null);

        Queue<Integer> cola = new LinkedList<>();
        cola.add(origen);

        while (!cola.isEmpty()){
            Integer vp = cola.poll();
            Iterator<Integer> ady = grafo.obtenerAdyacentes(vp);

            while(ady.hasNext()){
                Integer vh = ady.next();
                if(color.get(vh).equals("BLANCO")){
                    color.put(vh, "GRIS");
                    distancia.put(vh, distancia.get(vp) + 1);
                    padre.put(vh, vp);
                    if(vh.equals(destino)){
                        ArrayList<Integer> camino = new ArrayList<>();
                        camino.addAll(getPadres(vh));
                        return camino;
                    }
                    cola.add(vh);
                }

            }
            color.put(vp,"NERGO");

        }
        return new ArrayList<>();
    }

    private ArrayList<Integer> getPadres(Integer hijo){
        ArrayList<Integer> camino = new ArrayList<>();
        hijo = padre.get(hijo);//salteo el destino porque ahora hijo es = destino
        while (hijo != null){
            camino.add(0,hijo);
            hijo = padre.get(hijo);
        }
        return camino;
    }

    // Métodos para consultar resultados
    public Map<Integer, Integer> getDistancias() {
        return distancia;
    }

    public Map<Integer, Integer> getPredecesores() {
        return padre;
    }

    public Map<Integer, String> getColores() {
        return color;
    }
}
