package ProgramacionIII.TP5;

import ProgramacionIII.tp4.GrafoDirigido;

import java.util.ArrayList;

public class MainBack {

    public static void main(String[] args) {

/*
        BackTranking back = new BackTranking<>();
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

        /// EJERCICIO 3

        ArrayList<Integer> valores = new ArrayList<>();

        valores.add(3);
        valores.add(1);
        valores.add(7);
        valores.add(4);
        valores.add(9);

        TP5E3 tp = new TP5E3();

        System.out.println(tp.sumasCorrectas(valores, 10));



        /*/// ejercicio 4
        ArrayList<Integer> valores = new ArrayList<>();

        // Cargar valores del 1 al 7
        for (int i = 1; i <= 7; i++) {
            valores.add(i);
        }

        // Crear instancia de la clase que contiene el método
        TP5EJ4 instancia = new TP5EJ4(); // reemplazá "TuClase" por el nombre real de tu clase

        ArrayList<ArrayList<Integer>> soluciones = instancia.conjuntosDeSumas(valores);

        // Mostrar resultados
        if (soluciones.isEmpty()) {
            System.out.println("No se encontraron particiones con suma igual.");
        } else {
            System.out.println("Particiones encontradas:");
            for (int i = 0; i < soluciones.size(); i += 2) {
                System.out.println("A: " + soluciones.get(i));
                System.out.println("B: " + soluciones.get(i + 1));
                System.out.println("------------");
            }
        }

         */
    }
}

