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
    /// Este metodo busca por nivel el camino mas corto para llegar desde un origen dado hasta un destino dado

    public ArrayList<Integer> BFSMascorto(Integer origen, Integer destino){
        color.put(origen,"GRIS");
        /// El primero siempre tiene distancia 0 y no tiene padre
        distancia.put(origen,0);
        padre.put(origen,null);

        /// cola queque, maneja en forma de pila inversa sus elementos, el primero en agregarse es el primero en salir
        Queue<Integer> cola = new LinkedList<>();
        cola.add(origen);

        while (!cola.isEmpty()){
            Integer vp = cola.poll();/// Este vertice siempre tomaria el rol de vertice Padre
            Iterator<Integer> ady = grafo.obtenerAdyacentes(vp);

            while(ady.hasNext()){
                Integer vh = ady.next();///Los adyacentes serian sus hijos
                if(color.get(vh).equals("BLANCO")){
                    color.put(vh, "GRIS");
                    distancia.put(vh, distancia.get(vp) + 1);///La distancia de los hijos siempre es la de tu padre +1
                    padre.put(vh, vp);
                    if(vh.equals(destino)){
                        /// Si ya encontre el destino creo un arreglo con los padres.
                        ArrayList<Integer> camino = new ArrayList<>();
                        /// le paso su padre por parametro
                        camino.addAll(getPadres(padre.get(vh)));
                        return camino;
                    }
                    cola.add(vh);
                }

            }
            color.put(vp,"NERGO");

        }
        return new ArrayList<>();
    }

    /// este metodo recorre los padres actualizando la variable vPadre, de padre en padre y devuelve un arreglo con todos
    private ArrayList<Integer> getPadres(Integer vPadre){
        ArrayList<Integer> camino = new ArrayList<>();
        while (vPadre != null){
            camino.add(0,vPadre);
            vPadre = padre.get(vPadre);
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
