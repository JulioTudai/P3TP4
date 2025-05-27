package ProgramacionIII.tp4;

import java.util.*;

public class TP4EJ7 {
    private GrafoNoDirigido<?> grafo;
    private List<List<Integer>> todosLosCaminos = new ArrayList<>();

    public TP4EJ7(GrafoNoDirigido<?> grafo) {
        this.grafo = grafo;
    }

    public List<List<Integer>> obtenerCaminos(int origen, int destino, int bloqueado1, int bloqueado2) {
        List<Integer> caminoActual = new ArrayList<>();
        Set<Integer> visitados = new HashSet<>();
        dfs(origen, destino, bloqueado1, bloqueado2, caminoActual, visitados);
        return todosLosCaminos;
    }

    private void dfs(int actual, int destino, int bloqueado1, int bloqueado2,
                     List<Integer> caminoActual, Set<Integer> visitados) {
        caminoActual.add(actual);
        visitados.add(actual);

        if (actual == destino) {
            todosLosCaminos.add(new ArrayList<>(caminoActual));
        } else {
            Iterator<Integer> adyacentes = grafo.obtenerAdyacentes(actual);
            while (adyacentes.hasNext()) {
                int vecino = adyacentes.next();

                boolean esTramoBloqueado = (actual == bloqueado1 && vecino == bloqueado2) ||
                        (actual == bloqueado2 && vecino == bloqueado1);

                if (!visitados.contains(vecino) && !esTramoBloqueado) {
                    dfs(vecino, destino, bloqueado1, bloqueado2, caminoActual, visitados);
                }
            }
        }

        caminoActual.remove(caminoActual.size() - 1);
        visitados.remove(actual);
    }
}
