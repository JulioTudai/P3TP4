package ProgramacionIII.tp4;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
///Esta clase realiza un recorrido en profundidad de un grafo dado
/// Ademas de tener al grafo dado como atributo tiene otros atributos como tiempos y colores
/// Por cada vertice del grafo dado en su hasmap de colores la clase DFSrecorrido le da un color a cada vertice


public class DFSRecorrido<T> {

    protected Grafo<T> grafo;
    protected Map<Integer, String> color;
    protected Map<Integer, Integer> tiempoDescubrimiento;
    protected Map<Integer, Integer> tiempoFinalizacion;
    protected int tiempo;


    public DFSRecorrido(Grafo<T> grafo) {
        this.grafo = grafo;
        this.color = new HashMap<>();
        this.tiempoDescubrimiento = new HashMap<>();
        this.tiempoFinalizacion = new HashMap<>();
        this.tiempo = 0;

        Iterator<Integer> it = grafo.obtenerVertices();
        while (it.hasNext()) {
            int v = it.next();
            color.put(v, "BLANCO");
        }
    }

    public void dfs() {
        ///Al grafo le pide un iterador con todos sus vertices
        Iterator<Integer> it = grafo.obtenerVertices();
        while (it.hasNext()) {///  mientras tenga vertices Siguientes
            int u = it.next();///extrae el vertice siguiente
            if (color.get(u).equals("BLANCO")) {
                dfsVisit(u);///Si es blanco empezamos a ejecutar dfsVisit desde ese vertice
            }
        }
    }

    protected void dfsVisit(int u) {
        color.put(u, "AMARILLO");/// al vertice encontrado como blanco le cambia el color
        tiempo++;
        tiempoDescubrimiento.put(u, tiempo);/// suma tiempo y setea a ese vertice

        Iterator<Integer> adyacentes = grafo.obtenerAdyacentes(u);/// le pide los adyacentes
        while (adyacentes.hasNext()) {/// mientras tenga adyacentes siguientes
            int v = adyacentes.next();
            if (color.get(v).equals("BLANCO")) {/// Si el adyacente es blanco hay que volver a ejecutar el dfsVisit
                dfsVisit(v);
            }
        }

        color.put(u, "NEGRO");///si ya  termino todas las iteraciones o no tenia adyacentes blancos lo pinto como negro
        tiempo++;
        tiempoFinalizacion.put(u, tiempo);/// sumo tiempo  seteo
    }
     /*Escribir un algoritmo que, dado un grafo dirigido y dos vértices i, j de este grafo, devuelva el
    camino simple (sin ciclos) de mayor longitud del vértice i al vértice j. Puede suponerse que el
    grafo de entrada es acíclico.

     */

    public ArrayList<Integer> caminoMasLargoSinCiclos(Integer origen, Integer destino){
        ArrayList<Integer>resultado = new ArrayList<>();
        ArrayList<Integer>caminoActual = new ArrayList<>();

        if(origen != null && destino != null && origen != destino){
            caminoLargo(origen,destino,resultado,caminoActual);
        }

        return resultado;

    }

    private ArrayList<Integer> caminoLargo(Integer origen,Integer destino,ArrayList<Integer> resultado, ArrayList<Integer> caminoActual){
        caminoActual.add(origen); ///preg esto
        Iterator<Integer> adyacentes = grafo.obtenerAdyacentes(origen);
        while (adyacentes.hasNext()){
            Integer v = adyacentes.next();
            if(color.get(v).equals("BLANCO")&& !v.equals(destino)){
                dfsVisitMasLargo(v,destino,resultado,caminoActual);
            }
        }
        return resultado;

    }

    private void dfsVisitMasLargo(Integer actual,Integer destino,ArrayList<Integer> resultado, ArrayList<Integer> caminoActual){
        caminoActual.add(actual);
        color.put(actual, "AMARILLO");

        if(actual.equals(destino)){
            if (caminoActual.size()> resultado.size() || resultado.isEmpty()){
                resultado.clear();
                resultado.addAll(new ArrayList<>(caminoActual));
            }
        }
        else {
            Iterator<Integer> adyacentes = grafo.obtenerAdyacentes(actual);
            while (adyacentes.hasNext()) {
                Integer v = adyacentes.next();
                if (color.get(v).equals("BLANCO")) {
                    dfsVisitMasLargo(v, destino, resultado, caminoActual);
                }
            }
        }
        /// no los tengo que pintar de negros para que siga iterando ?
        /// Los tiempos no tiene sentido que los vaya actualizando no ?
        color.put(actual,"BLANCO");
        caminoActual.remove(caminoActual.size()-1);/// esto le va sacando una iteracion a la recursion
        /// asi no se van guardando caminos inecesarios o ya encontrados.

    }

    // Métodos para consultar resultados
    public Map<Integer, Integer> getTiempoDescubrimiento() {
        return tiempoDescubrimiento;
    }

    public Map<Integer, Integer> getTiempoFinalizacion() {
        return tiempoFinalizacion;
    }

    public Map<Integer, String> getColores() {
        return color;
    }
}
