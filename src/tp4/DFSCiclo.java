/*package ProgramacionIII.tp4;

import java.awt.*;
import java.util.Iterator;

public class DFSCiclo<T> extends DFSRecorrido{
    private boolean tieneCiclo;

    public DFSCiclo(Grafo<T> grafo){
        super(grafo);
        this.tieneCiclo=false;
    }

    public boolean tieneCiclo() {
        this.dfs();
        boolean resultado = tieneCiclo;
        tieneCiclo = false;
        return resultado;
    }

    public void dfs(){
       if (!tieneCiclo){
            Iterator<Integer> it = grafo.obtenerVertices();
            while (it.hasNext()) {///  mientras tenga vertices Siguientes
                int u = it.next();///extrae el vertice siguiente
                if (color.get(u).equals("BLANCO")) {
                    dfsVisit(u);///Si es blanco empezamos a ejecutar dfsVisit desde ese vertice
                }
            }
       }

    }

    @Override
    protected void dfsVisit(int u) {
        if(!tieneCiclo) {
            this.color.put(u, "AMARILLO");/// al vertice encontrado como blanco le cambia el color
            tiempo++;
            tiempoDescubrimiento.put(u, tiempo);/// suma tiempo y setea a ese vertice

            Iterator<Integer> adyacentes = grafo.obtenerAdyacentes(u);/// le pide los adyacentes
            while (adyacentes.hasNext() && !tieneCiclo) {/// mientras tenga adyacentes siguientes
                int v = adyacentes.next();
                if (color.get(v).equals("BLANCO")) {/// Si el adyacente es blanco hay que volver a ejecutar el dfsVisit
                    dfsVisit(v);
                } else if (color.get(v).equals("AMARILLO")) {
                    tieneCiclo = true;
                }
            }
        }

        color.put(u, "NEGRO");///si ya  termino todas las iteraciones o no tenia adyacentes blancos lo pinto como negro
        tiempo++;
        tiempoFinalizacion.put(u, tiempo);/// sumo tiempo  seteo
    }




}



 */
