package ProgramacionIII.TP5;

import ProgramacionIII.tp4.GrafoDirigido;

import java.util.ArrayList;

public class MainBack {

    public static void main(String[] args) {


        /*BackTranking back = new BackTranking<>();
        GrafoDirigido<Integer> grafo = new GrafoDirigido<>();

        // Crear vértices
        for (int i = 0; i <= 4; i++) {
            grafo.agregarVertice(i);
        }

        grafo.agregarArco(1,4,null);
        grafo.agregarArco(1,3,null);
        grafo.agregarArco(2,4,null);
        grafo.agregarArco(1,2,null);

        ArrayList<Integer> arr = new ArrayList<>();

        back.buscarSalidaMasejos(grafo,1,4,new ArrayList<>() ,arr);
        System.out.println(arr);

         */

        ArrayList<Integer> valores = new ArrayList<>();

        valores.add(3);
        valores.add(1);
        valores.add(7);
        valores.add(4);
        valores.add(9);

        TP5E3 tp = new TP5E3();

        System.out.println(tp.sumasCorrectas(valores, 10));

    }
}
