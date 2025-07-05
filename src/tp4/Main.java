package ProgramacionIII.tp4;

import java.util.*;

public class Main {

	public static void main(String[] args) {


		/*GrafoDirigido<String> grafo = new GrafoDirigido<>();

		// Agregar vértices
		grafo.agregarVertice(1);
		grafo.agregarVertice(2);
		grafo.agregarVertice(3);
		grafo.agregarVertice(4);

		// Agregar arcos
		grafo.agregarArco(1, 2, "Arco de 1 a 2");
		grafo.agregarArco(1, 3, "Arco de 1 a 3");
		grafo.agregarArco(2, 4, "Arco de 2 a 4");

		// Mostrar cantidad de vértices
		System.out.println("Cantidad de vértices: " + grafo.cantidadVertices());

		// Mostrar cantidad de arcos
		System.out.println("Cantidad de arcos: " + grafo.cantidadArcos());

		// Mostrar todos los vértices
		System.out.println("Vertices:");
		Iterator<Integer> itVertices = grafo.obtenerVertices();
		while (itVertices.hasNext()) {
			System.out.println(" - " + itVertices.next());
		}

		// Mostrar todos los arcos
		System.out.println("Arcos:");
		Iterator<Arco<String>> itArcos = grafo.obtenerArcos();
		while (itArcos.hasNext()) {
			Arco<String> arco = itArcos.next();
			System.out.println(" - " + arco.getVerticeOrigen() + " -> " + arco.getVerticeDestino() + " : " + arco.getEtiqueta());
		}

		// Mostrar adyacentes de 1
		System.out.println("Adyacentes de 1:");
		Iterator<Integer> itAdy = grafo.obtenerAdyacentes(1);
		while (itAdy.hasNext()) {
			System.out.println(" - " + itAdy.next());
		}

		// Mostrar arcos salientes de 1
		System.out.println("Arcos desde vértice 1:");
		Iterator<Arco<String>> itArcosDesde1 = grafo.obtenerArcos(1);
		while (itArcosDesde1.hasNext()) {
			Arco<String> arco = itArcosDesde1.next();
			System.out.println(" - " + arco.getVerticeOrigen() + " -> " + arco.getVerticeDestino() + " : " + arco.getEtiqueta());
		}

		// Verificar existencia de vértices
		System.out.println("¿Existe el vértice 3? " + grafo.contieneVertice(3));
		System.out.println("¿Existe el vértice 99? " + grafo.contieneVertice(99));

		// Verificar existencia de arcos
		System.out.println("¿Existe arco de 1 a 2? " + grafo.existeArco(1, 2));
		System.out.println("¿Existe arco de 3 a 1? " + grafo.existeArco(3, 1));

		// Obtener un arco específico
		Arco<String> arco12 = grafo.obtenerArco(1, 2);
		System.out.println("Arco de 1 a 2: " + arco12.getEtiqueta());

		// Borrar un arco y verificar
		grafo.borrarArco(1, 2);
		System.out.println("¿Existe arco de 1 a 2 después de borrar? " + grafo.existeArco(1, 2));

		// Borrar vértice y verificar
		grafo.borrarVertice(2);
		System.out.println("¿Existe el vértice 2 después de borrar? " + grafo.contieneVertice(2));
		System.out.println("¿Existe arco de 2 a 4 después de borrar vértice 2? " + grafo.existeArco(2, 4));

		 */
		/*/// prueba dfsRecorrido EJ4

			GrafoDirigido<Integer> grafo = new GrafoDirigido<>();

			// Agregamos vértices
			grafo.agregarVertice(1);
			grafo.agregarVertice(2);
			grafo.agregarVertice(3);
			grafo.agregarVertice(4);
			grafo.agregarVertice(5);

			// Agregamos aristas (el grafo debe ser acíclico)
			grafo.agregarArco(1, 2, null);
			grafo.agregarArco(1, 3, null);
			grafo.agregarArco(2, 4, null);
			grafo.agregarArco(3, 4, null);
			grafo.agregarArco(4, 5, null);

			// Creamos el recorrido DFS
			DFSRecorrido<Integer> dfs = new DFSRecorrido<>(grafo);

			// Buscamos el camino más largo de 1 a 5
			ArrayList<Integer> camino = dfs.caminoMasLargoSinCiclos(1, 3);

			// Mostramos el resultado
			System.out.println("Camino más largo sin ciclos de 1 a 5:");
			System.out.println(camino);



		/*/// test tiene ciclo EJ3:
		/*Grafo<Integer> grafo = new GrafoDirigido<>();

		// Agregamos vértices
		grafo.agregarVertice(1);
		grafo.agregarVertice(2);
		grafo.agregarVertice(3);
		grafo.agregarVertice(4);

		// Agregamos aristas (1 → 2 → 3 → 1 forma un ciclo)
		grafo.agregarArco(1, 2, null);
		grafo.agregarArco(2, 3, null);
		grafo.agregarArco(3, 1, null);

		// Agregamos una rama sin ciclo
		grafo.agregarArco(3, 4, null);

		// Ejecutamos la detección de ciclos
		DFSCiclo<Integer> dfsCiclo = new DFSCiclo<>(grafo);
		boolean tieneCiclo = dfsCiclo.tieneCiclo();

		System.out.println("¿El grafo tiene ciclo? " + tieneCiclo);


		 */
		/// PROBANDO EJ5
		// Crear el grafo dirigido

		/*
		GrafoDirigido<String> grafo = new GrafoDirigido<>();

		// Agregar vértices
		for (int i = 1; i <= 5; i++) {
			grafo.agregarVertice(i);
		}

		// Agregar arcos
		grafo.agregarArco(1, 2, null);
		grafo.agregarArco(1, 4, null);
		grafo.agregarArco(2, 3, null);
		grafo.agregarArco(3, 4, null);
		grafo.agregarArco(4, 5, null);
		grafo.agregarArco(5, 2, null); // forma un ciclo: 2 → 3 → 4 → 5 → 2

		// Instanciar la clase que extiende DFSRecorrido
		DFSRecorrido<String> recorrido = new DFSRecorrido<>(grafo);

		// Suponiendo que implementaste buscarOrigenes en esa clase
		Set<Integer> origenes = recorrido.buscarOrigenes(grafo, 4); // ejemplo: queremos los vértices desde donde se puede llegar a 4

		// Imprimir resultados
		System.out.println("Vértices desde los cuales se puede llegar al vértice 4:");
		for (Integer origen : origenes) {
			System.out.println(origen);
		}

		 */

		///PROBANDO BFSMascorto EJ6
        /*
		GrafoDirigido<String> grafo = new GrafoDirigido<>();

		// Agregar vértices
		for (int i = 1; i <= 5; i++) {
			grafo.agregarVertice(i);
		}

		// Agregar arcos
		grafo.agregarArco(1, 2, null);
		grafo.agregarArco(1, 4, null);
		grafo.agregarArco(2, 3, null);
		grafo.agregarArco(3, 4, null);
		grafo.agregarArco(4, 5, null);
		grafo.agregarArco(5, 2, null);

		// Crear el objeto BFS
		BFSRecorridos<String> bfs = new BFSRecorridos<>(grafo);

		// Buscar camino más corto desde 1 hasta 3
		ArrayList<Integer> camino = bfs.BFSMascorto(1, 3);

		if (camino.isEmpty()) {
			System.out.println("No hay camino desde 1 hasta 3.");
		} else {
			System.out.println("Camino más corto desde 1 hasta 3: " + camino);
		}

         */
		/*
		/// Probando ejercico 8
		GrafoDirigido<Integer> grafo = new GrafoDirigido<>();

		// Crear vértices
		for (int i = 0; i <= 12; i++) {
			grafo.agregarVertice(i);
		}

		// Tiempos de duración de cada tarea (vértices)
		Map<Integer, Integer> duracionTarea = Map.ofEntries(
				Map.entry(0, 0),
				Map.entry(1, 4),
				Map.entry(2, 18),
				Map.entry(3, 4),
				Map.entry(4, 13),
				Map.entry(5, 22),
				Map.entry(6, 18),
				Map.entry(7, 12),
				Map.entry(8, 3),
				Map.entry(9, 2),
				Map.entry(10, 3),
				Map.entry(11, 1),
				Map.entry(12, 5)
		);

		// Agregar arcos con sus pesos (demoras entre tareas)
		grafo.agregarArco(0, 1, 3);
		grafo.agregarArco(0, 2, 1);
		grafo.agregarArco(1, 3, 3);
		grafo.agregarArco(2, 5, 18);
		grafo.agregarArco(2, 7, 18);
		grafo.agregarArco(3, 4, 5);
		grafo.agregarArco(3, 5, 8);
		grafo.agregarArco(4, 11, 3);
		grafo.agregarArco(5, 6, 2);
		grafo.agregarArco(6, 12, 9);
		grafo.agregarArco(6, 10, 6);
		grafo.agregarArco(7, 8, 7);
		grafo.agregarArco(8, 9, 4);
		grafo.agregarArco(9, 10, 1);
		grafo.agregarArco(11, 12, 9);


		DFSRecorrido<Integer> dfs = new DFSRecorrido<>(grafo,duracionTarea);
		System.out.println("Duración del camino crítico: " + dfs.DFSCaminoCritico() + " hs");


	}*/
		/*// Probando ejercicio 7
		GrafoNoDirigido<String> grafo = new GrafoNoDirigido<>();
		grafo.agregarVertice(1); // Buenos Aires
		grafo.agregarVertice(2); // Tandil
		grafo.agregarVertice(3); // Las Flores
		grafo.agregarVertice(4); // Rauch
		grafo.agregarVertice(5); // Azul
// agregar más ciudades...

		grafo.agregarArco(1, 3, null); // Buenos Aires - Las Flores
		grafo.agregarArco(3, 4, null); // Las Flores - Rauch (cortado)
		grafo.agregarArco(4, 2, null); // Rauch - Tandil
		grafo.agregarArco(1, 2, null); // Buenos Aires - Tandil (ruta directa)
		grafo.agregarArco(1, 5, null); // Buenos Aires - Azul
		grafo.agregarArco(5, 2, null); // Azul - Tandil
// más arcos...

		TP4EJ7 caminos = new TP4EJ7(grafo);
		List<List<Integer>> caminosAlternativos = caminos.obtenerCaminos(1, 2, 3, 4); // evitando 3-4

		for (List<Integer> camino : caminosAlternativos) {
			System.out.println(camino);
		}


		 */

		/*
		GrafoNoDirigido<String> grafo = new GrafoNoDirigido<>();

		// Agregamos 9 vértices
		for (int i = 1; i <= 9; i++) {
			grafo.agregarVertice(i);
		}

		// Ciclo de 3 vértices: 1-2-3-1
		grafo.agregarArco(1, 2, "A");
		grafo.agregarArco(2, 3, "B");
		grafo.agregarArco(3, 1, "C");

		// Ciclo de 4 vértices: 4-5-6-7-4
		grafo.agregarArco(4, 5, "D");
		grafo.agregarArco(5, 6, "E");
		grafo.agregarArco(6, 7, "F");
		grafo.agregarArco(7, 4, "G");

		// Los vértices 8 y 9 quedan aislados

		// Ahora armamos el algoritmo sobre el grafo

		EJ4Parcial2023<String> buscador = new EJ4Parcial2023<>(grafo);


		// Antes de ejecutar el algoritmo tenemos que inicializar los mapas de color y padre:
		Iterator<Integer> vertices = grafo.obtenerVertices();
		while (vertices.hasNext()) {
			Integer v = vertices.next();
			buscador.color.put(v, "BLANCO");
			buscador.padre.put(v, null);
		}



		ArrayList<Integer> cicloMasLargo = buscador.cicloMasLargo();

		System.out.println("El ciclo más largo encontrado es:");
		System.out.println(cicloMasLargo);
	}
	*/
	/*
	todo: probando ejercicio hecho en papel
	 */
		// Crear el grafo
		GrafoDirigido<String> grafo = new GrafoDirigido<>();

		// Agregar vértices (del 1 al 6)
		for (int i = 1; i <= 6; i++) {
			grafo.agregarVertice(i);
		}

		// Agregar arcos - incluyendo al menos 1 ciclo
		// Ciclo: 3 -> 4 -> 5 -> 3
		grafo.agregarArco(1, 2, null);
		grafo.agregarArco(1, 3, null);
		grafo.agregarArco(2, 4, null);
		grafo.agregarArco(3, 4, null);
		grafo.agregarArco(4, 5, null);
		grafo.agregarArco(5, 3, null); // <-- ciclo
		grafo.agregarArco(5, 6, null);

		// Crear el objeto DFSRecorrido
		DFSRecorrido<String> dfs = new DFSRecorrido<>(grafo);

		// Buscar el camino más largo de 1 a 6
		ArrayList<Integer> caminoMasLargo = dfs.caminoMasLargo(grafo, 1, 6);

		// Imprimir el camino más largo
		System.out.println("Camino más largo de 1 a 6:");
		for (Integer v : caminoMasLargo) {
			System.out.print(v + " ");
		}
		System.out.println();

		// Imprimir tiempos de descubrimiento y finalización
		System.out.println("\nTiempos de los vértices:");
		for (int i = 1; i <= 6; i++) {
			Integer td = dfs.tiempoDescubrimiento.getOrDefault(i, -1);
			Integer tf = dfs.tiempoFinalizacion.getOrDefault(i, -1);
			System.out.println("Vertice " + i + " → Descubrimiento: " + td + ", Finalización: " + tf);
		}




	}

}






