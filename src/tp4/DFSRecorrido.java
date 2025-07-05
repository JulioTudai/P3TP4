package ProgramacionIII.tp4;

import java.lang.reflect.Array;
import java.util.*;

///Esta clase realiza un recorrido en profundidad de un grafo dado
/// Ademas de tener al grafo dado como atributo tiene otros atributos como tiempos y colores
/// Por cada vertice del grafo dado en su hasmap de colores la clase DFSrecorrido le da un color a cada vertice


public class DFSRecorrido<T> {

    protected Grafo<T> grafo;
    protected Map<Integer, String> color;
    protected Map<Integer, Integer> tiempoDescubrimiento;
    protected Map<Integer, Integer> tiempoFinalizacion;
    protected int tiempo;
    protected Map<T, Integer> duracionTareas;

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

        Iterator<Integer> itt = grafo.obtenerVertices();
        while (itt.hasNext()) {
            int v = itt.next();
            tiempoDescubrimiento.put(v, 0);
            tiempoFinalizacion.put(v, 0);
        }
        tiempo = 0; // reseteás el contador global también


    }

    public DFSRecorrido(Grafo<T> grafo, Map<T, Integer> duracionTareas) {
        this.grafo = grafo;
        this.color = new HashMap<>();
        this.tiempoDescubrimiento = new HashMap<>();
        this.tiempoFinalizacion = new HashMap<>();
        this.tiempo = 0;
        this.duracionTareas = duracionTareas;

        Iterator<Integer> it = grafo.obtenerVertices();
        while (it.hasNext()) {
            int v = it.next();
            color.put(v, "BLANCO");
        }

        Iterator<Integer> itt = grafo.obtenerVertices();
        while (itt.hasNext()) {
            int v = itt.next();
            tiempoDescubrimiento.put(v, 0);
            tiempoFinalizacion.put(v, 0);
        }
        tiempo = 0; // reseteás el contador global también

    }


    public void dfs() { // complejidad completa  O(V + E)
        ///Al grafo le pide un iterador con todos sus vertices
        Iterator<Integer> it = grafo.obtenerVertices();// Complejidad : O(N)
        while (it.hasNext()) {///  mientras tenga vertices Siguientes Complejidad : O(N)
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

        Iterator<Integer> adyacentes = grafo.obtenerAdyacentes(u);/// le pide los adyacentes Complejidad : O(d(u))
        while (adyacentes.hasNext()) {/// mientras tenga adyacentes siguientes
            int v = adyacentes.next(); //Complejidad : O(d(u))
            if (color.get(v).equals("BLANCO")) {/// Si el adyacente es blanco hay que volver a ejecutar el dfsVisit
                dfsVisit(v);
            }
        }

        color.put(u, "NEGRO");///si ya  termino todas las iteraciones o no tenia adyacentes blancos lo pinto como negro
        tiempo++;
        tiempoFinalizacion.put(u, tiempo);/// sumo tiempo  seteo
    }


     /* TODO: EJERCICIO 4
     Escribir un algoritmo que, dado un grafo dirigido y dos vértices i, j de este grafo, devuelva el
    camino simple (sin ciclos) de mayor longitud del vértice i al vértice j. Puede suponerse que el
    grafo de entrada es acíclico.

     */

    public ArrayList<Integer> caminoMasLargoSinCiclos(Integer origen, Integer destino){
        ArrayList<Integer>resultado = new ArrayList<>();
        ArrayList<Integer>caminoActual = new ArrayList<>();

        /// creo los arreglos para ir guardando los caminos encontrados y comparando
        if(origen != null && destino != null && origen != destino){
            caminoLargo(origen,destino,resultado,caminoActual);
        }

        return resultado;
    }

    private void caminoLargo(Integer actual,Integer destino,ArrayList<Integer> resultado, ArrayList<Integer> caminoActual){
        caminoActual.add(actual);
        color.put(actual,"AMARILLO");

        if(actual.equals(destino)){
            if(caminoActual.size() > resultado.size()){
                resultado.clear();
                resultado.addAll(new ArrayList<>(caminoActual));
            }
        }
        else {
            Iterator<Integer> adyacentes = grafo.obtenerAdyacentes(actual); ///creo un iterador con los adyacentes
            while (adyacentes.hasNext()) {
                Integer v = adyacentes.next();
                if (color.get(v).equals("BLANCO")) {//suponiendo que es aciclico no necesito manejar los colores,
                    //lo puedo resolver con un contains de caminoActual y listo
                    caminoLargo(v, destino, resultado, caminoActual);
                }

            }
        }
        color.put(actual,"BLANCO");
        caminoActual.remove(caminoActual.size()-1);/// esto le va sacando una iteracion a la recursion
        /// asi no se van guardando caminos inecesarios o ya encontrados.

    }

    /*TODO EJERCICO 4 CON TIEMPOS HECHO EN PAPEL
   Escribir un algoritmo que, dado un grafo dirigido y dos vértices i, j de este grafo, devuelva el
    camino simple (sin ciclos) de mayor longitud del vértice i al vértice j.
    y Tambien se lleve un registro de los tiempos de descubrimiento de los vertices.

     */
    public ArrayList<Integer> caminoMasLargo (GrafoDirigido g, int origen, int destino){


        ArrayList<Integer> restulado = new ArrayList<>();
        ArrayList<Integer> camino = new ArrayList<>();

        if(g == null || origen == destino){
            return new ArrayList<>();
        }
        caminoLargo(g,origen,destino,restulado,camino);
     return restulado;
    }

    private void caminoLargo(GrafoDirigido g, int actual, int destino, ArrayList<Integer> resultado , ArrayList<Integer> camino){
        color.put(actual,"AMARILLO");
        tiempo ++;
        tiempoDescubrimiento.put(actual,tiempo);

        camino.add(actual);

        if(actual == destino){

            if (camino.size() > resultado.size()){
                resultado.clear();
                resultado.addAll(new ArrayList<>(camino));
            }

        }
        else{

            Iterator<Integer> ady = g.obtenerAdyacentes(actual);
            while(ady.hasNext()){
                int v = ady.next();

                if(color.get(v).equals("BLANCO")){

                    caminoLargo(g,v,destino,resultado,camino);

                }
                else if (color.get(v).equals("AMARILLO")) {
                    System.out.println("Hay ciclo");
                }


            }

        }
        tiempo ++;
        tiempoFinalizacion.put(actual,tiempo);
        color.put(actual,"BLANCO");
        camino.remove(camino.size()-1);
    }




    /* TODO: EJERCICIO 5
    Escriba un algoritmo que dado un grafo G y un vértice v de dicho grafo, devuelva una lista
    con todos los vértices a partir de los cuales exista un camino en G que termine en v.
     */
    public Set<Integer> buscarOrigenes(Grafo<T> ggrafo, Integer destino){
        Set<Integer> origenes = new HashSet<>();
        Iterator<Integer> it = ggrafo.obtenerVertices();
        while (it.hasNext()){
            Integer posibleOri = it.next();
            Integer esOri = posibleOri;
            boolean encontro = false;
            if(posibleOri!=destino) {
                DFSVisitBsqOrigenes(posibleOri, destino, esOri, origenes, ggrafo);
            }
        }

        return origenes;
    }
    private void DFSVisitBsqOrigenes(Integer v,Integer destino,Integer origen,Set<Integer> origenes,Grafo<T> ggrafo){

        color.put(v,"AMARILLO");
        if(v.equals(destino)){
            origenes.add(origen);
        }else{
            Iterator<Integer> ady = ggrafo.obtenerAdyacentes(v);
            while (ady.hasNext()){
                Integer sig = ady.next();
                if(color.get(sig).equals("BLANCO")){
                    DFSVisitBsqOrigenes(sig,destino,origen,origenes,ggrafo);
                }
            }
        }
        color.put(v,"BLANCO");
    }

    //TODO: EJERCICIO 8:
/// este metodo en un grafo dirigido encuentra el camino mas largo sumando los valores  asignados a cada vertice y a sus arcos
    public Integer DFSCaminoCritico(){
        Integer resultado= 0;
        Integer suma=0;
        Iterator<Integer> it = grafo.obtenerVertices();
        while (it.hasNext()){
            Integer vp = it.next();
            /// cada vez que vuelve a esta parte es porque llego a una hoja
           Integer posibleCamino = encontrarCamino(suma,resultado,vp);
           if(posibleCamino>resultado){
               resultado = posibleCamino;
           }
        }
        return resultado;
    }

    private Integer encontrarCamino(Integer suma, Integer resultado, Integer vp){
        color.put(vp,"AMARILLO");
        suma += duracionTareas.get(vp);
        /// resultado se vuelve suma para en el if de mas abajo poder comparalo con el posible camino
        /// y en el caso que no entre al while es porque esta en una hoja
        /// y al estar en una hoja la suma de ese vertice seria el resultado final de ese recorrido
        resultado = suma;
        Iterator<Integer> it = grafo.obtenerAdyacentes(vp);
        while (it.hasNext()){
            Integer v = it.next();
            Integer tiempoArco = (Integer)grafo.obtenerArco(vp,v).getEtiqueta();
            /// casteamos porque la etiqueta es del tipo T y nos aseguramos de crearla integer
            if(color.get(v).equals("BLANCO")){
                /// ejecutamos el metodo recrusivo y guardamos el valor de ese camino
                /// para que suma se vaya con el valor del tiempo del arco hay que agregarlo antes de entrar al metodo
                Integer posibleCamino = encontrarCamino(suma+tiempoArco,resultado,v);
                if (posibleCamino> resultado){
                    resultado = posibleCamino;
                }
            }
        }

        color.put(vp,"BLANCO");
        return resultado;

    }
    public void iniciarlizarColores(){
        Iterator<Integer> it = grafo.obtenerVertices();
        while (it.hasNext()) {
            int v = it.next();
            color.put(v, "BLANCO");
        }

    }
    public void inicializarTiempos() {
        Iterator<Integer> it = grafo.obtenerVertices();
        while (it.hasNext()) {
            int v = it.next();
            tiempoDescubrimiento.put(v, 0);
            tiempoFinalizacion.put(v, 0);
        }
        tiempo = 0; // reseteás el contador global también
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
