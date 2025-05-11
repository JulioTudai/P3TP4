package ProgramacionIII.tp4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

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
		/// prueba dfsRecorrido EJ4
		/*
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
			ArrayList<Integer> camino = dfs.caminoMasLargoSinCiclos(1, 5);

			// Mostramos el resultado
			System.out.println("Camino más largo sin ciclos de 1 a 5:");
			System.out.println(camino);

		 */

		/*/// test tiene ciclo EJ3:
		Grafo<Integer> grafo = new GrafoDirigido<>();

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

		//PROBANDO BFSMascorto EJ6

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
		ArrayList<Integer> camino = bfs.BFSMascorto(1, 4);

		if (camino.isEmpty()) {
			System.out.println("No hay camino desde 1 hasta 3.");
		} else {
			System.out.println("Camino más corto desde 1 hasta 3: " + camino);
		}
	}





}






