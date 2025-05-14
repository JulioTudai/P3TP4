package ProgramacionIII.TP5;

import java.util.ArrayList;

public class TP5E3 {

    public ArrayList<ArrayList<Integer>> sumasCorrectas(ArrayList<Integer>valores,Integer valorBuscado){
        ArrayList<ArrayList<Integer>> solucion = new ArrayList<>();

        backtrankingConjuntos(valores,valorBuscado,new ArrayList<>(),solucion);

        return solucion;
    }

    private void backtrankingConjuntos(ArrayList<Integer> valores, Integer buscado, ArrayList<Integer> camino,ArrayList<ArrayList<Integer>> solucion){

        if (esSolucion(camino,buscado)) {
            solucion.add(new ArrayList<>(camino));
        }
        else{
            for ( Integer i : valores){
               if(!camino.contains(i)) {
                   camino.add(i);
                   backtrankingConjuntos(valores, buscado, camino, solucion);
                   camino.remove(camino.size() - 1);
               }
            }

        }

    }

    private boolean esSolucion(ArrayList<Integer> camino, Integer buscado){
        int suma = 0;
        for (Integer i : camino){
            suma+= i;
        }
        return suma == buscado;

    }
}
