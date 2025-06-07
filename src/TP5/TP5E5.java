package ProgramacionIII.TP5;

import java.util.*;

public class TP5E5 {


    private int cantidadProcesadores;
    private List<Integer> tareas; // duración de cada tarea
    private List<List<Integer>> mejorAsignacion;
    private int mejorTiempo;
    private HashMap<Integer, List<Integer>> procesadores;

    public TP5E5(int cantidadProcesadores, List<Integer> tareas) {
        this.cantidadProcesadores = cantidadProcesadores;
        this.tareas = new ArrayList<>(tareas);
        this.tareas.sort(Collections.reverseOrder()); // ordenar tareas de mayor a menor (mejora poda)
        this.procesadores = new HashMap<>();
        this.mejorTiempo = Integer.MAX_VALUE;
        this.mejorAsignacion = new ArrayList<>();

        for (int i = 0; i < cantidadProcesadores; i++) {
            procesadores.put(i, new ArrayList<>());
        }
    }

    public void asignarTareas() {
        backtrack(0);
        mostrarMejorSolucion();
    }

    private void backtrack(int indiceTarea) {
        if (indiceTarea == tareas.size()) {
            int tiempoActual = calcularTiempoMaximo();
            if (tiempoActual < mejorTiempo) {
                mejorTiempo = tiempoActual;
                guardarMejorAsignacion();
                System.out.println(" Nueva mejor solución encontrada con tiempo: " + mejorTiempo);
                imprimirProcesadores();
            }
            return;
        }

        int tareaActual = tareas.get(indiceTarea);
        for (int i = 0; i < cantidadProcesadores; i++) {
            procesadores.get(i).add(tareaActual);
            int tiempoParcial = calcularTiempoMaximo();
            System.out.println("→ Asigno tarea " + tareaActual + " al procesador " + i + " | Tiempo parcial: " + tiempoParcial);
            imprimirProcesadores();

            if (tiempoParcial < mejorTiempo) {
                backtrack(indiceTarea + 1); // Sigo con la siguiente tarea
            } else {
                System.out.println("Poda: esta rama supera el mejor tiempo actual (" + mejorTiempo + ")");
            }

            procesadores.get(i).remove(procesadores.get(i).size() - 1); // Backtrack
            System.out.println("↩️  Deshago tarea " + tareaActual + " del procesador " + i);
            imprimirProcesadores();
        }
    }

    private int calcularTiempoMaximo() {
        int max = 0;
        for (List<Integer> lista : procesadores.values()) {
            int suma = lista.stream().mapToInt(Integer::intValue).sum();
            max = Math.max(max, suma);
        }
        return max;
    }

    private void guardarMejorAsignacion() {
        mejorAsignacion.clear();
        for (int i = 0; i < cantidadProcesadores; i++) {
            mejorAsignacion.add(new ArrayList<>(procesadores.get(i)));
        }
    }

    private void imprimirProcesadores() {
        for (int i = 0; i < cantidadProcesadores; i++) {
            System.out.println("  P" + i + ": " + procesadores.get(i));
        }
        System.out.println();
    }

    private void mostrarMejorSolucion() {
        System.out.println(" Mejor asignación encontrada:");
        for (int i = 0; i < mejorAsignacion.size(); i++) {
            List<Integer> tareas = mejorAsignacion.get(i);
            int suma = tareas.stream().mapToInt(Integer::intValue).sum();
            System.out.println("  Procesador " + i + " → Tareas: " + tareas + " | Total: " + suma);
        }
        System.out.println(" Tiempo total (makespan): " + mejorTiempo);
    }

    // Para probar
    public static void main(String[] args) {
        List<Integer> tareas = Arrays.asList(4, 7, 2, 1, 8); // 8 tareas
        TP5E5 asignador = new TP5E5(2, tareas); // 3 procesadores
        asignador.asignarTareas();
    }
}

