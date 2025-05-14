package ProgramacionIII.TP5;

import ProgramacionIII.tp4.Grafo;

import java.util.ArrayList;
import java.util.Iterator;

public class BackTranking<T> {


    public void buscarSalidaMasejos(Grafo<T> grafo,Integer entrada, Integer salida,ArrayList<Integer> actual,ArrayList<Integer> resultado){
        actual.add(entrada);
        if(esSolucion(actual,salida)){
            mejorSolucion(actual,resultado);
        }
        else{
            Iterator<Integer> it = grafo.obtenerAdyacentes(entrada);
            while (it.hasNext()){
                Integer sig = it.next();
                if(!actual.contains(sig)){
                    buscarSalidaMasejos(grafo,sig,salida,actual,resultado);
                }
            }
        }
        actual.remove(actual.size()-1);

    }


    private boolean esSolucion(ArrayList<Integer> prueba,Integer salida){
        return prueba.get(prueba.size()-1)== salida;
    }

    private void mejorSolucion(ArrayList<Integer> actual, ArrayList<Integer> resultado){

        if(resultado.isEmpty() || (actual.size()> resultado.size())){
            resultado.clear();
            resultado.addAll(actual);
        }

    }




}
