package ProgramacionIII.tp4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/*
ENCONTRA EL CICLO DE MAYOR TAMANIO EN UN GRAFO NO DIRIGIDO CON VARIOS CICLOS ; devolver una lista de vertices
 */
public class EJ4Parcial2023<T> {
    private Grafo<T> grafo;
    private Map<Integer, String> color;
    private Map<Integer, Integer> padre;

    public EJ4Parcial2023(Grafo<T> grafo) {
        this.grafo=grafo;
        this.color = new HashMap<>();
        this.padre = new HashMap<>();

        Iterator<Integer> it = grafo.obtenerVertices();
        while (it.hasNext()) {
            int v = it.next();
            color.put(v, "BLANCO");
        }

    }

/*
Es un ciclo siempre que el vertice siguiente este en amarillo y no sea mi padre
 */
    public ArrayList<Integer> cicloMasLargo(){

        ArrayList<Integer> resultado = new ArrayList<>();
        ArrayList<Integer> caminoActual = new ArrayList<>();

        Iterator<Integer> vertices = grafo.obtenerVertices();
        while (vertices.hasNext()){
            Integer vertice = vertices.next();
            padre.put(vertice,null);
            if(color.get(vertice).equals("BLANCO")) {
                DFSCicloMasLargo(vertice, caminoActual, resultado);
            }

        }

        return resultado;
    }

    private void DFSCicloMasLargo(Integer vertice,ArrayList<Integer> CActual,ArrayList<Integer> resultado){
        color.put(vertice,"AMARILLO");
        CActual.add(vertice);


        Iterator<Integer> it = grafo.obtenerAdyacentes(vertice);
        while (it.hasNext()){
            Integer vh = it.next();
             if(color.get(vh).equals("BLANCO")){
                 padre.put(vh,vertice);
                 DFSCicloMasLargo(vh,CActual,resultado);
             } else if (!vh.equals(padre.get(vertice)) && color.get(vh).equals("AMARILLO")) {

                 if(CActual.size() > resultado.size() || resultado.isEmpty()){
                     resultado.clear();
                     resultado.addAll(new ArrayList<>(CActual));
                 }

             }

        }
        color.put(vertice,"NEGRO");
        CActual.remove(CActual.size() -1);
    }


}
