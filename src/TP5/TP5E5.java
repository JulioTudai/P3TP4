package ProgramacionIII.TP5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class TP5E5 {
    /*Asignación de tareas a procesadores. Se tienen m procesadores idénticos y n tareas con un tiempo
de ejecución dado. Se requiere encontrar una asignación de tareas a procesadores de manera de
minimizar el tiempo de ejecución del total de tareas.

     */
    private int cantidadProcesadores;
    private List<Integer> tareas; // duración de cada tarea
    private HashMap<Integer, List<Integer>> procesadores;

    public TP5E5(int cantidadProcesadores, List<Integer> tareas) {
        this.cantidadProcesadores = cantidadProcesadores;
        this.tareas = tareas;
        this.procesadores = new HashMap<>();


        // Inicializo los procesadores con listas vacías
        for (int i = 0; i < cantidadProcesadores; i++) {
            procesadores.put(i, new ArrayList<>());
        }
    }


    public void AsignarTareas(){
        Integer tareaMayor = 0;
        for(Integer i: tareas){
            if (tareaMayor < i){
                tareaMayor=i;
            }
        }
        for( int i =0; i< procesadores.size(); i++){
            menorTiempo(tareaMayor,i);

        }

    }

    private void menorTiempo(Integer tareaMayor,Integer procesador){

        if(esSolucion(tareaMayor, Procesador)){


        }
    }




    // Método auxiliar: sumar carga actual de un procesador
    public int cargaDelProcesador(int idProcesador) {
        return procesadores.get(idProcesador)
                .stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    // Método auxiliar: asignar tarea a un procesador
    public void asignarTarea(int idProcesador, int duracionTarea) {
        procesadores.get(idProcesador).add(duracionTarea);
    }

    // Método auxiliar: desasignar última tarea de un procesador (para backtrack)
    public void desasignarUltimaTarea(int idProcesador) {
        List<Integer> tareasDelProcesador = procesadores.get(idProcesador);
        if (!tareasDelProcesador.isEmpty()) {
            tareasDelProcesador.remove(tareasDelProcesador.size() - 1);
        }
    }

    // Getters
    public List<Integer> getTareas() {
        return tareas;
    }

    public HashMap<Integer, List<Integer>> getAsignacionPorProcesador() {
        return procesadores;
    }

    public int getCantidadProcesadores() {
        return cantidadProcesadores;
    }
}
