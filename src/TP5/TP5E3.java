package ProgramacionIII.TP5;

import java.util.ArrayList;

public class TP5E3 {

    public ArrayList<ArrayList<Integer>> sumasCorrectas(ArrayList<Integer>valores,Integer valorBuscado){
        ArrayList<ArrayList<Integer>> solucion = new ArrayList<>();

        backtrankingConjuntos(valores,valorBuscado,new ArrayList<>(),solucion);

        return solucion;
    }

    private void backtrankingConjuntos(ArrayList<Integer> valores, Integer buscado, ArrayList<Integer> posiblesSumas,ArrayList<ArrayList<Integer>> solucion){

        if (esSolucion(posiblesSumas,buscado)) {
            solucion.add(new ArrayList<>(posiblesSumas));
        }
        else{
            for ( Integer i : valores){
               if(!posiblesSumas.contains(i)) {
                   posiblesSumas.add(i);
                   backtrankingConjuntos(valores, buscado, posiblesSumas, solucion);
                   posiblesSumas.remove(posiblesSumas.size() - 1);
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
